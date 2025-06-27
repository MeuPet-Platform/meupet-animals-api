package com.meupet.api;

import com.meupet.api.dto.usuario.RequisicaoLoginDTO;
import com.meupet.api.dto.usuario.RequisicaoUsuarioDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioResourceTest {

    private static Long generatedUserId;
    private static final String USER_EMAIL = "teste.crud@exemplo.com";
    private static final String USER_PASSWORD = "senha123";

    @Test
    @Order(1)
    @Transactional
    public void deveCriarUsuarioParaTesteDeLogin() {
        RequisicaoUsuarioDTO dto = new RequisicaoUsuarioDTO();
        dto.setNome("Usuario de Teste");
        dto.setEmail(USER_EMAIL);
        dto.setSenha(USER_PASSWORD); // A senha será criptografada no Resource

        generatedUserId = given()
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .extract()
                .jsonPath().getLong("id");
    }

    @Test
    @Order(2)
    public void deveFalharLoginComSenhaIncorreta() {
        RequisicaoLoginDTO loginDTO = new RequisicaoLoginDTO();
        loginDTO.setEmail(USER_EMAIL);
        loginDTO.setSenha("senhaErrada");

        given()
                .contentType(ContentType.JSON)
                .body(loginDTO)
                .when()
                .post("/usuarios/login")
                .then()
                .statusCode(401); // Unauthorized
    }

    @Test
    @Order(3)
    public void deveFazerLoginComSucesso() {
        RequisicaoLoginDTO loginDTO = new RequisicaoLoginDTO();
        loginDTO.setEmail(USER_EMAIL);
        loginDTO.setSenha(USER_PASSWORD);

        given()
                .contentType(ContentType.JSON)
                .body(loginDTO)
                .when()
                .post("/usuarios/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue()); // Verifica se um token foi retornado
    }

    @Test
    @Order(4)
    @Transactional
    public void deveDeletarUsuarioDeTeste() {
        // Limpeza: deleta o usuário criado para não interferir em outros testes
        Assumptions.assumeTrue(generatedUserId != null);
        given()
                .when()
                .delete("/usuarios/" + generatedUserId)
                .then()
                .statusCode(204);
    }
}
