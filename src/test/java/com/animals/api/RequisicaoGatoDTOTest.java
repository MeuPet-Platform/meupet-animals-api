package com.animals.api;

import com.animals.api.dto.gato.RequisicaoGatoDTO;
import com.animals.api.enums.PorteEnum;
import com.animals.api.enums.SexoAnimalEnum;
import com.animals.api.enums.TamanhoPeloEnum;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Set;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertFalse;

class RequisicaoGatoDTOTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @ParameterizedTest
    @MethodSource("dadosInvalidos")
    void deveDetectarViolacoesDeValidacao(RequisicaoGatoDTO dto) {
        Set<ConstraintViolation<RequisicaoGatoDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }

    private static Stream<RequisicaoGatoDTO> dadosInvalidos() {
        return Stream.of(
                criarDTO(null, true), // unhasCortadas nulo
                criarDTO(true, null)  // gostaDeAgua nulo
        );
    }

    private static RequisicaoGatoDTO criarDTO(Boolean unhasCortadas, Boolean gostaDeAgua) {
        RequisicaoGatoDTO dto = new RequisicaoGatoDTO();
        if (unhasCortadas != null) dto.setUnhasCortadas(unhasCortadas);
        if (gostaDeAgua != null) dto.setGostaDeAgua(gostaDeAgua);
        dto.setNome("Gato de Teste");
        dto.setIdTutor(1L);
        dto.setSexo(SexoAnimalEnum.FEMEA);
        dto.setPorte(PorteEnum.PEQUENO);
        dto.setTamanhoPelo(TamanhoPeloEnum.CURTO);
        return dto;
    }
}
