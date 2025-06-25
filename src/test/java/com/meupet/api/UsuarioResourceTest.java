package com.meupet.api;

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

    // A variável agora é estática para ser compartilhada entre os testes
    private static Long generatedUserId;

    @Test
    @Order(1)
    @Transactional
    public void deveCriarUsuario() {
        RequisicaoUsuarioDTO dto = new RequisicaoUsuarioDTO();
        dto.setNome("Usuario de Teste");
        dto.setEmail("teste.crud@exemplo.com"); // E-mail diferente para evitar conflitos
        dto.setSenha("senha123");

        generatedUserId = given()
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .extract()
                .jsonPath().getLong("id");
    }

    @Test
    @Order(2)
    public void deveBuscarUsuarioPorId() {
        Assumptions.assumeTrue(generatedUserId != null, "O teste de criação precisa ter sucesso primeiro.");

        given()
                .when()
                .get("/usuarios/" + generatedUserId)
                .then()
                .statusCode(200)
                .body("id", is(generatedUserId.intValue()))
                .body("nome", is("Usuario de Teste"));
    }

    @Test
    @Order(3)
    public void deveListarTodosOsUsuarios() {
        Assumptions.assumeTrue(generatedUserId != null, "O teste de criação precisa ter sucesso primeiro.");

        given()
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .body("$", isA(java.util.List.class)) // Confirma que o retorno é uma lista
                .body("size()", greaterThanOrEqualTo(1)); // Confirma que há pelo menos um usuário na lista
    }

    @Test
    @Order(4)
    @Transactional
    public void deveAtualizarUsuario() {
        Assumptions.assumeTrue(generatedUserId != null, "O teste de criação precisa ter sucesso primeiro.");

        RequisicaoUsuarioDTO dtoAtualizado = new RequisicaoUsuarioDTO();
        dtoAtualizado.setNome("Usuario Teste Atualizado");
        dtoAtualizado.setEmail("teste.crud.att@exemplo.com");
        dtoAtualizado.setSenha("novaSenha456");

        given()
                .contentType(ContentType.JSON)
                .body(dtoAtualizado)
                .when()
                .put("/usuarios/" + generatedUserId)
                .then()
                .statusCode(200)
                .body("nome", is("Usuario Teste Atualizado"))
                .body("email", is("teste.crud.att@exemplo.com"));
    }

    @Test
    @Order(5)
    @Transactional
    public void deveDeletarUsuario() {
        Assumptions.assumeTrue(generatedUserId != null, "O teste de criação precisa ter sucesso primeiro.");

        // 1. Deleta o usuário
        given()
                .when()
                .delete("/usuarios/" + generatedUserId)
                .then()
                .statusCode(204);

        // 2. Verifica se o usuário realmente foi deletado (deve retornar 404)
        given()
                .when()
                .get("/usuarios/" + generatedUserId)
                .then()
                .statusCode(404);
    }
}