package com.meupet.api.service;

import com.meupet.api.entity.AnimalEntity;
import com.meupet.api.entity.VacinaEntity;
import com.meupet.api.enums.StatusVacinacaoEnum;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AnimalService {

    /**
     * Calcula e atualiza o status de vacinação de um animal com base em seu histórico.
     * A lógica é a seguinte:
     * 1. Se não há vacinas, o status é NAO_VACINADO.
     * 2. Se a vacina mais recente não tem data de revacinação ou a data está no futuro, o status é VACINADO.
     * 3. Se a data de revacinação da vacina mais recente está no passado, o status é VACINACAO_PENDENTE.
     * @param animal A entidade Animal a ser atualizada.
     */
    public void recalcularEAtualizarStatusVacinacao(AnimalEntity animal) {
        if (animal == null) {
            return;
        }

        List<VacinaEntity> historico = animal.getHistoricoVacinacao();

        if (historico == null || historico.isEmpty()) {
            animal.setVacinado(StatusVacinacaoEnum.NAO_VACINADO);
            return;
        }

        // Encontra a vacina com a data de aplicação mais recente
        Optional<VacinaEntity> ultimaVacinaOptional = historico.stream()
                .max(Comparator.comparing(VacinaEntity::getDataVacina));

        if (ultimaVacinaOptional.isPresent()) {
            VacinaEntity ultimaVacina = ultimaVacinaOptional.get();
            LocalDate dataRevacina = ultimaVacina.getRevacina();

            if (dataRevacina == null || dataRevacina.isAfter(LocalDate.now())) {
                animal.setVacinado(StatusVacinacaoEnum.VACINADO);
            } else {
                animal.setVacinado(StatusVacinacaoEnum.VACINACAO_PENDENTE);
            }
        }
    }
}