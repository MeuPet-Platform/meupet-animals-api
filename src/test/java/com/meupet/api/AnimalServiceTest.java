//package com.meupet.api;
//
//import com.meupet.api.entity.AnimalEntity;
//import com.meupet.api.entity.VacinaEntity;
//import com.meupet.api.enums.StatusVacinacaoEnum;
//import com.meupet.api.service.AnimalService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//class AnimalServiceTest {
//
//    private AnimalService animalService;
//
//    @BeforeEach
//    void setUp() {
//        this.animalService = new AnimalService();
//    }
//
//    @Test
//    @DisplayName("Deve definir status como NAO_VACINADO se o histórico for nulo")
//    void historicoNulo() {
//        AnimalEntity animal = new AnimalEntity();
//        animal.setHistoricoVacinacao(null);
//
//        animalService.recalcularEAtualizarStatusVacinacao(animal);
//
//        Assertions.assertEquals(StatusVacinacaoEnum.NAO_VACINADO, animal.getVacinado());
//    }
//
//    @Test
//    @DisplayName("Deve definir status como NAO_VACINADO se o histórico for vazio")
//    void historicoVazio() {
//        AnimalEntity animal = new AnimalEntity();
//        animal.setHistoricoVacinacao(new ArrayList<>());
//
//        animalService.recalcularEAtualizarStatusVacinacao(animal);
//
//        Assertions.assertEquals(StatusVacinacaoEnum.NAO_VACINADO, animal.getVacinado());
//    }
//
//    @Test
//    @DisplayName("Deve definir status como VACINADO se a última vacina não tem data de revacinação")
//    void vacinaSemRevacinacao() {
//        AnimalEntity animal = new AnimalEntity();
//
//        VacinaEntity vacinaAntiga = new VacinaEntity("V8", LocalDate.now().minusYears(1), null, null);
//        VacinaEntity vacinaRecente = new VacinaEntity("Raiva", LocalDate.now(), null, null);
//        animal.setHistoricoVacinacao(List.of(vacinaAntiga, vacinaRecente));
//
//        animalService.recalcularEAtualizarStatusVacinacao(animal);
//
//        Assertions.assertEquals(StatusVacinacaoEnum.VACINADO, animal.getVacinado());
//    }
//
//    @Test
//    @DisplayName("Deve definir status como VACINADO se a data de revacinação for no futuro")
//    void revacinacaoNoFuturo() {
//        AnimalEntity animal = new AnimalEntity();
//
//        VacinaEntity vacinaRecente = new VacinaEntity("Giárdia", LocalDate.now(), LocalDate.now().plusMonths(6), null);
//        animal.setHistoricoVacinacao(List.of(vacinaRecente));
//
//        animalService.recalcularEAtualizarStatusVacinacao(animal);
//
//        Assertions.assertEquals(StatusVacinacaoEnum.VACINADO, animal.getVacinado());
//    }
//
//    @Test
//    @DisplayName("Deve definir status como VACINACAO_PENDENTE se a data de revacinação for no passado")
//    void revacinacaoNoPassado() {
//        AnimalEntity animal = new AnimalEntity();
//
//        VacinaEntity vacinaAntiga = new VacinaEntity("V10", LocalDate.now().minusYears(1), LocalDate.now().minusDays(1), null);
//        animal.setHistoricoVacinacao(List.of(vacinaAntiga));
//
//        animalService.recalcularEAtualizarStatusVacinacao(animal);
//
//        Assertions.assertEquals(StatusVacinacaoEnum.VACINACAO_PENDENTE, animal.getVacinado());
//    }
//}
