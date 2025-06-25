package test.com.meupet.api;

import com.meupet.api.dto.cachorro.RequisicaoCachorroDTO;
import com.meupet.api.dto.usuario.RequisicaoUsuarioDTO;
import com.meupet.api.dto.vacina.RequisicaoVacinaDTO;
import com.meupet.api.enums.PorteEnum;
import com.meupet.api.enums.SexoAnimalEnum;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Garante a ordem dos testes
public class AnimalCompletoFlowTest {

    static Integer idTutor;
    static Integer idAnimal;
    static Integer idVacinaOk;
    static Integer idVacinaPendente;

    @Test
    @Order(1)
    @TestTransaction
    void testCriarDependenciasIniciais() {
        // ETAPA 1: Criar um tutor
        RequisicaoUsuarioDTO usuarioDTO = new RequisicaoUsuarioDTO();
        usuarioDTO.setNome("Tutor Para Teste de Fluxo");
        usuarioDTO.setEmail("fluxo@teste.com");
        usuarioDTO.setSenha("senha123");

        idTutor = given()
                .contentType(ContentType.JSON)
                .body(usuarioDTO)
                .when().post("/usuarios")
                .then().statusCode(201)
                .extract().path("id");

        // ETAPA 2: Criar um animal para este tutor
        RequisicaoCachorroDTO cachorroDTO = new RequisicaoCachorroDTO();
        cachorroDTO.setNome("Doguinho do Fluxo");
        cachorroDTO.setRaca("Poodle");
        cachorroDTO.setPeso(7.5);
        cachorroDTO.setSexo(SexoAnimalEnum.MACHO);
        cachorroDTO.setPorte(PorteEnum.PEQUENO);
        cachorroDTO.setIdTutor(idTutor.longValue());
        cachorroDTO.setManso(true);
        cachorroDTO.setNecessitaFocinheira(false);

        idAnimal = given()
                .contentType(ContentType.JSON)
                .body(cachorroDTO)
                .when().post("/animais/cachorro")
                .then().statusCode(201)
                .body("vacinado", is("Não Vacinado")) // Verifica o status inicial
                .extract().path("id");
    }

    @Test
    @Order(2)
    @TestTransaction
    void testAdicionarVacinaEVerificarStatusVacinado() {
        // ETAPA 3: Adicionar uma vacina "em dia"
        RequisicaoVacinaDTO vacinaDTO = new RequisicaoVacinaDTO();
        vacinaDTO.setTipoVacina("V10 - 1a Dose");
        vacinaDTO.setDataVacina(LocalDate.now());
        vacinaDTO.setRevacina(LocalDate.now().plusYears(1)); // Revacinação no futuro

        idVacinaOk = given()
                .contentType(ContentType.JSON)
                .body(vacinaDTO)
                .when().post("/animais/" + idAnimal + "/vacinas")
                .then().statusCode(201)
                .extract().path("id");

        // ETAPA 4: Verificar se o status do animal mudou para "Vacinado"
        given()
                .when().get("/animais/" + idAnimal)
                .then().statusCode(200)
                .body("vacinado", is("Vacinado"));
    }

    @Test
    @Order(3)
    @TestTransaction
    void testAdicionarVacinaAtrasadaEVerificarStatusPendente() {
        // ETAPA 5: Adicionar uma vacina com revacinação no passado
        RequisicaoVacinaDTO vacinaAtrasadaDTO = new RequisicaoVacinaDTO();
        vacinaAtrasadaDTO.setTipoVacina("Raiva");
        vacinaAtrasadaDTO.setDataVacina(LocalDate.now().minusYears(2));
        vacinaAtrasadaDTO.setRevacina(LocalDate.now().minusYears(1)); // Revacinação no passado

        idVacinaPendente = given()
                .contentType(ContentType.JSON)
                .body(vacinaAtrasadaDTO)
                .when().post("/animais/" + idAnimal + "/vacinas")
                .then().statusCode(201)
                .extract().path("id");

        // ETAPA 6: Verificar se o status do animal mudou para "Vacinação Pendente"
        given()
                .when().get("/animais/" + idAnimal)
                .then().statusCode(200)
                .body("vacinado", is("Vacinação Pendente"));
    }

    @Test
    @Order(4)
    @TestTransaction
    void testDeletarVacinaEVerificarMudancaDeStatus() {
        // ETAPA 7: Deletar a vacina pendente
        given()
                .when().delete("/vacinas/" + idVacinaPendente)
                .then().statusCode(204);

        // ETAPA 8: Verificar se o status retornou para "Vacinado" (por causa da vacina Ok)
        given()
                .when().get("/animais/" + idAnimal)
                .then().statusCode(200)
                .body("vacinado", is("Vacinado"));
    }
}
