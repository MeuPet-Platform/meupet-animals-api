package com.meupet.api;

import com.meupet.api.dto.cachorro.RequisicaoCachorroDTO;
import com.meupet.api.dto.usuario.RequisicaoUsuarioDTO;
import com.meupet.api.dto.vacina.RequisicaoVacinaDTO;
import com.meupet.api.enums.PorteEnum;
import com.meupet.api.enums.SexoAnimalEnum;
import com.meupet.api.enums.StatusVacinacaoEnum;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnimalCompletoFlowTest {

    private static Long tutorId;
    private static Long animalId;
    private static Long vacinaId;

    @Test
    @Order(1)
    @Transactional
    void deveCriarTutor() {
        RequisicaoUsuarioDTO usuarioDTO = new RequisicaoUsuarioDTO();
        usuarioDTO.setNome("Tutor Flow Test");
        usuarioDTO.setEmail("tutor.flow@exemplo.com");
        usuarioDTO.setSenha("senha123");

        tutorId = given()
                .contentType(ContentType.JSON)
                .body(usuarioDTO)
                .when().post("/usuarios")
                .then()
                .statusCode(201)
                .extract().jsonPath().getLong("id");

        Assertions.assertNotNull(tutorId);
    }

    @Test
    @Order(2)
    @Transactional
    void deveCriarAnimal() {
        Assumptions.assumeTrue(tutorId != null, "O Tutor precisa ter sido criado no passo 1");

        RequisicaoCachorroDTO cachorroDTO = new RequisicaoCachorroDTO();
        cachorroDTO.setNome("Doguinho Flow");
        cachorroDTO.setRaca("Vira-lata");
        cachorroDTO.setPeso(10.5);
        cachorroDTO.setSexo(SexoAnimalEnum.MACHO);
        cachorroDTO.setPorte(PorteEnum.MEDIO);
        cachorroDTO.setIdTutor(tutorId);
        cachorroDTO.setManso(true);
        cachorroDTO.setNecessitaFocinheira(false);

        animalId = given()
                .contentType(ContentType.JSON)
                .body(cachorroDTO)
                .when().post("/animais/cachorro")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("nome", is("Doguinho Flow"))
                .body("vacinado", is(StatusVacinacaoEnum.NAO_VACINADO.getDescricao()))
                .extract().jsonPath().getLong("id");

        Assertions.assertNotNull(animalId);
    }

    @Test
    @Order(3)
    @Transactional
    void deveAdicionarVacinaAoAnimal() {
        Assumptions.assumeTrue(animalId != null, "O Animal precisa ter sido criado no passo 2");

        RequisicaoVacinaDTO vacinaDTO = new RequisicaoVacinaDTO();
        vacinaDTO.setTipoVacina("V10");
        vacinaDTO.setDataVacina(LocalDate.now());
        vacinaDTO.setRevacina(LocalDate.now().plusYears(1));

        vacinaId = given()
                .contentType(ContentType.JSON)
                .body(vacinaDTO)
                .when().post("/animais/" + animalId + "/vacinas")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("tipoVacina", is("V10"))
                .extract().jsonPath().getLong("id");

        Assertions.assertNotNull(vacinaId);
    }

    @Test
    @Order(4)
    void deveVerificarStatusVacinacaoAnimal() {
        Assumptions.assumeTrue(animalId != null && vacinaId != null, "A Vacina precisa ter sido criada no passo 3");

        given()
                .when().get("/animais/" + animalId)
                .then()
                .statusCode(200)
                .body("vacinado", is(StatusVacinacaoEnum.VACINADO.getDescricao()))
                .body("historicoVacinacao", hasSize(1))
                .body("historicoVacinacao[0].id", is(vacinaId.intValue()));
    }

    @Test
    @Order(5)
    @Transactional
    void deveDeletarAnimalETutor() {
        Assumptions.assumeTrue(animalId != null && tutorId != null);

        // Deleta o animal
        given()
                .when().delete("/animais/" + animalId)
                .then().statusCode(204);

        // Deleta o tutor
        given()
                .when().delete("/usuarios/" + tutorId)
                .then().statusCode(204);
    }
}