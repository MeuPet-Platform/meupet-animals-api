//package com.meupet.api;
//
//import com.meupet.api.dto.cachorro.RequisicaoCachorroDTO;
//import com.meupet.api.dto.usuario.RequisicaoLoginDTO;
//import com.meupet.api.dto.usuario.RequisicaoUsuarioDTO;
//import com.meupet.api.enums.PorteEnum;
//import com.meupet.api.enums.SexoAnimalEnum;
//import io.quarkus.test.junit.QuarkusTest;
//import io.restassured.http.ContentType;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.*;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.*;
//
//@QuarkusTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class AnimalCompletoFlowTest {
//
//    // IDs e Token são estáticos para serem compartilhados entre os testes
//    private static Long tutorId;
//    private static Long animalId;
//    private static String authToken;
//
//    private static final String TUTOR_EMAIL = "tutor.completo.flow@exemplo.com";
//    private static final String TUTOR_PASSWORD = "senhaMuitoForte123";
//
//
//    @Test
//    @Order(1)
//    @Transactional
//    void deveCriarTutor() {
//        RequisicaoUsuarioDTO usuarioDTO = new RequisicaoUsuarioDTO();
//        usuarioDTO.setNome("Tutor Completo Flow Test");
//        usuarioDTO.setEmail(TUTOR_EMAIL);
//        usuarioDTO.setSenha(TUTOR_PASSWORD);
//
//        tutorId = given()
//                .contentType(ContentType.JSON)
//                .body(usuarioDTO)
//                .when().post("/usuarios")
//                .then()
//                .statusCode(201)
//                .extract().jsonPath().getLong("id");
//
//        Assertions.assertNotNull(tutorId);
//    }
//
//    @Test
//    @Order(2)
//    void deveFazerLoginEObterToken() {
//        Assumptions.assumeTrue(tutorId != null, "O Tutor precisa ter sido criado no passo 1");
//
//        RequisicaoLoginDTO loginDTO = new RequisicaoLoginDTO();
//        loginDTO.setEmail(TUTOR_EMAIL);
//        loginDTO.setSenha(TUTOR_PASSWORD);
//
//        authToken = given()
//                .contentType(ContentType.JSON)
//                .body(loginDTO)
//                .when().post("/usuarios/login")
//                .then()
//                .statusCode(200)
//                .extract().path("token");
//
//        Assertions.assertNotNull(authToken);
//        Assertions.assertFalse(authToken.isBlank());
//    }
//
//    @Test
//    @Order(3)
//    void deveFalharAoAcessarRecursoSemToken() {
//        given()
//                // NENHUM cabeçalho de autorização
//                .when().get("/animais")
//                .then()
//                .statusCode(401); // Unauthorized
//    }
//
//    @Test
//    @Order(4)
//    @Transactional
//    void deveCriarAnimalComAutenticacao() {
//        Assumptions.assumeTrue(authToken != null, "O Login precisa ter sido feito no passo 2");
//
//        RequisicaoCachorroDTO cachorroDTO = new RequisicaoCachorroDTO();
//        cachorroDTO.setNome("Doguinho Autenticado");
//        cachorroDTO.setRaca("Vira-lata Caramelo");
//        cachorroDTO.setPeso(12.5);
//        cachorroDTO.setSexo(SexoAnimalEnum.MACHO);
//        cachorroDTO.setPorte(PorteEnum.MEDIO);
//        cachorroDTO.setIdTutor(tutorId);
//        cachorroDTO.setManso(true);
//        cachorroDTO.setNecessitaFocinheira(false);
//
//        animalId = given()
//                .header("Authorization", "Bearer " + authToken)
//                .contentType(ContentType.JSON)
//                .body(cachorroDTO)
//                .when().post("/animais/cachorro")
//                .then()
//                .statusCode(201)
//                .extract().jsonPath().getLong("id");
//
//        Assertions.assertNotNull(animalId);
//    }
//
//    @Test
//    @Order(5)
//    void deveBuscarAnimalCriado() {
//        Assumptions.assumeTrue(authToken != null && animalId != null);
//
//        given()
//                .header("Authorization", "Bearer " + authToken)
//                .when().get("/animais/" + animalId)
//                .then()
//                .statusCode(200)
//                .body("id", is(animalId.intValue()))
//                .body("nome", is("Doguinho Autenticado"))
//                .body("raca", is("Vira-lata Caramelo"));
//    }
//
//    @Test
//    @Order(6)
//    @Transactional
//    void deveAtualizarAnimalCriado() {
//        Assumptions.assumeTrue(authToken != null && animalId != null);
//
//        // Usamos o mesmo DTO, apenas alterando o nome
//        RequisicaoCachorroDTO cachorroDTO = new RequisicaoCachorroDTO();
//        cachorroDTO.setNome("Doguinho Caramelo Atualizado");
//        cachorroDTO.setRaca("Vira-lata Caramelo");
//        cachorroDTO.setPeso(13.0);
//        cachorroDTO.setSexo(SexoAnimalEnum.MACHO);
//        cachorroDTO.setPorte(PorteEnum.MEDIO);
//        cachorroDTO.setIdTutor(tutorId);
//        cachorroDTO.setManso(true);
//        cachorroDTO.setNecessitaFocinheira(false);
//
//        given()
//                .header("Authorization", "Bearer " + authToken)
//                .contentType(ContentType.JSON)
//                .body(cachorroDTO)
//                .when().put("/animais/cachorro/" + animalId)
//                .then()
//                .statusCode(200)
//                .body("nome", is("Doguinho Caramelo Atualizado"))
//                .body("peso", is(13.0f)); // JSON trata número decimal como float
//    }
//
//    @Test
//    @Order(7)
//    @Transactional
//    void deveDeletarAnimalCriado() {
//        Assumptions.assumeTrue(authToken != null && animalId != null);
//
//        // Deleta o animal
//        given()
//                .header("Authorization", "Bearer " + authToken)
//                .when().delete("/animais/" + animalId)
//                .then().statusCode(204);
//
//        // Verifica se o animal foi mesmo deletado
//        given()
//                .header("Authorization", "Bearer " + authToken)
//                .when().get("/animais/" + animalId)
//                .then().statusCode(404);
//    }
//
//    @Test
//    @Order(8)
//    @Transactional
//    void deveDeletarTutor() {
//        // Limpeza final do usuário
//        Assumptions.assumeTrue(authToken != null && tutorId != null);
//
//        given()
//                .header("Authorization", "Bearer " + authToken)
//                .when().delete("/usuarios/" + tutorId)
//                .then().statusCode(204);
//    }
//}
