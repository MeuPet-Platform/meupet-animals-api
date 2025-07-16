package com.animals.api;

import com.animals.api.entity.AnimalEntity;
import com.animals.api.entity.VacinaEntity;
import com.animals.api.enums.StatusVacinacaoEnum;
import com.animals.api.service.AnimalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class AnimalServiceTest {

    private AnimalService animalService;

    @BeforeEach
    void setUp() {
        this.animalService = new AnimalService();
    }

    @Test
    @DisplayName("Deve definir status como NAO_VACINADO se histórico for nulo")
    void caso1_historicoNulo() {
        AnimalEntity animal = new AnimalEntity();
        animal.setHistoricoVacinacao(null);
        animalService.recalcularEAtualizarStatusVacinacao(animal);
        Assertions.assertEquals(StatusVacinacaoEnum.NAO_VACINADO, animal.getVacinado());
    }

    @Test
    @DisplayName("Deve definir status como VACINADO se revacinação for no futuro")
    void caso2_revacinacaoNoFuturo() {
        AnimalEntity animal = new AnimalEntity();
        VacinaEntity vacina = new VacinaEntity("V10", LocalDate.now(), LocalDate.now().plusYears(1), animal);
        animal.setHistoricoVacinacao(List.of(vacina));
        animalService.recalcularEAtualizarStatusVacinacao(animal);
        Assertions.assertEquals(StatusVacinacaoEnum.VACINADO, animal.getVacinado());
    }

    @Test
    @DisplayName("Deve definir status como VACINACAO_PENDENTE se revacinação estiver no passado")
    void caso3_revacinacaoNoPassado() {
        AnimalEntity animal = new AnimalEntity();
        VacinaEntity vacinaVencida = new VacinaEntity("Raiva", LocalDate.now().minusYears(2), LocalDate.now().minusYears(1), animal);
        animal.setHistoricoVacinacao(List.of(vacinaVencida));
        animalService.recalcularEAtualizarStatusVacinacao(animal);
        Assertions.assertEquals(StatusVacinacaoEnum.VACINACAO_PENDENTE, animal.getVacinado());
    }
}

