package com.animals.api;

import com.animals.api.dto.cachorro.RequisicaoCachorroDTO;
import com.animals.api.enums.PorteEnum;
import com.animals.api.enums.SexoAnimalEnum;
import com.animals.api.util.TestSecurityProfile;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.restassured.http.ContentType;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.Test;
import io.quarkus.test.security.TestSecurity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@TestProfile(TestSecurityProfile.class) // Desabilita a segurança JWT para simplificar o teste
public class AnimalResourceTest {

    @Test
    @TestSecurity(user = "test", roles = {"USER"})
    @Transactional
    void deveCriarAnimalComTutorValido() {
        System.out.println("🔧 CONFIG JDBC URL = " + ConfigProvider.getConfig().getValue("quarkus.datasource.jdbc.url", String.class));


        RequisicaoCachorroDTO dto = new RequisicaoCachorroDTO();
        dto.setNome("Doguinho com Mock");
        dto.setIdTutor(1L); // O ID que o nosso Mock sabe que é válido
        dto.setRaca("SRD");
        dto.setPeso(10.0);
        dto.setSexo(SexoAnimalEnum.MACHO);
        dto.setPorte(PorteEnum.MEDIO);
        dto.setManso(true);
        dto.setNecessitaFocinheira(false);

        given()
                .contentType(ContentType.JSON)
                .body(dto)
                .when().post("/animais/cachorro")
                .then()
                .statusCode(201)
                .body("id", notNullValue());
    }

    @Test
    @TestSecurity(user = "test", roles = {"USER"})
    void deveFalharAoCriarAnimalComTutorInvalido() {
        System.out.println("🔧 CONFIG JDBC URL = " + ConfigProvider.getConfig().getValue("quarkus.datasource.jdbc.url", String.class));

        RequisicaoCachorroDTO dto = new RequisicaoCachorroDTO();
        dto.setNome("Doguinho Fantasma");
        dto.setIdTutor(99L); // O ID que o nosso Mock sabe que é inválido
        dto.setRaca("Fantasma");
        dto.setPeso(5.0);
        dto.setSexo(SexoAnimalEnum.FEMEA);
        dto.setPorte(PorteEnum.PEQUENO);
        dto.setManso(false);
        dto.setNecessitaFocinheira(true);

        given()
                .contentType(ContentType.JSON)
                .body(dto)
                .when().post("/animais/cachorro")
                .then()
                .statusCode(404) // O AnimalResource recebe um 404 do nosso Mock
                .body(containsString("Tutor com ID 99 não encontrado."));
    }
}
