//package com.meupet.api;
//
//import com.meupet.api.dto.usuario.RequisicaoUsuarioDTO;
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import jakarta.validation.Validator;
//import jakarta.validation.ValidatorFactory;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.Set;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//class RequisicaoUsuarioDTOTest {
//
//    private static Validator validator;
//
//    @BeforeAll
//    static void setUp() {
//        // Cria uma fábrica de validadores, que será usada em todos os testes
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }
//
//    private static Stream<RequisicaoUsuarioDTO> casosDeUsuarioInvalido() {
//        return Stream.of(
//                // Caso 1: Nome em branco
//                criarDTO("", "valido@email.com", "senha123"),
//                // Caso 2: E-mail nulo
//                criarDTO("Nome Valido", null, "senha123"),
//                // Caso 3: E-mail em formato inválido
//                criarDTO("Nome Valido", "email-invalido", "senha123"),
//                // Caso 4: Senha em branco
//                criarDTO("Nome Valido", "valido@email.com", " ")
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("casosDeUsuarioInvalido") // Indica que os dados vêm do método acima
//    void deveDetectarCamposInvalidos(RequisicaoUsuarioDTO dto) {
//
//        Set<ConstraintViolation<RequisicaoUsuarioDTO>> violations = validator.validate(dto);
//
//        assertFalse(violations.isEmpty(), "Deveria ter encontrado violações de validação para o DTO inválido.");
//    }
//
//    @Test
//    void deveValidarUsuarioComDadosCorretos() {
//        RequisicaoUsuarioDTO dto = criarDTO("Nome Valido", "valido@email.com", "senha123");
//
//        Set<ConstraintViolation<RequisicaoUsuarioDTO>> violations = validator.validate(dto);
//
//        assertEquals(0, violations.size(), "Não deveria encontrar violações para um DTO válido.");
//    }
//
//
//    // Método auxiliar para facilitar a criação dos DTOs de teste
//    private static RequisicaoUsuarioDTO criarDTO(String nome, String email, String senha) {
//        RequisicaoUsuarioDTO dto = new RequisicaoUsuarioDTO();
//        dto.setNome(nome);
//        dto.setEmail(email);
//        dto.setSenha(senha);
//        return dto;
//    }
//}
//
