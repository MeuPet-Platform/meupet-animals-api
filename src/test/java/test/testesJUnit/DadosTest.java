//package test.testesJUnit;
//
//import io.quarkus.test.junit.QuarkusTest;
//import com.meupet.api.modelo.Ave;
//import com.meupet.api.modelo.Cachorro;
//import com.meupet.api.modelo.Dados;
//import com.meupet.api.modelo.Vacina;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@QuarkusTest
//public class DadosTest {
//
//    @Test
//    @Disabled("Ignorado por enquanto")
//    void deveEditarCachorroExistente() {
//        Dados dados = new Dados();
//        Cachorro rex = new Cachorro("Rex", "Labrador", 25.0, "M", "sim", "sim", "nao", "Grande");
//        dados.inserirEditarCachorro(rex,0);
//
//        Cachorro rexEditado = new Cachorro("Rex", "Pitbull", 30.0, "M", "sim", "nao", "sim", "Grande");
//
//        dados.inserirEditarCachorro(rexEditado,0);
//
//        assertEquals(1, dados.getQtdCachorros());
//        assertEquals("Pitbull", dados.getCachorros()[0].getRaca());
//        assertTrue(dados.getCachorros()[0].isNecessitaFocinheira());
//    }
//
//    @Test
//    @Disabled("Ignorado por enquanto")
//    void deveContarSomenteAvesExoticas() {
//        Dados dados = new Dados();
//        Ave arara = new Ave("Arara", "Azul", 1.5, "F", "sim", "sim", "sim", "sim");
//        dados.inserirEditarAve(new Ave("Papagaio", "Verde", 0.8, "M", "nao", "nao", "nao", "nao"),0);
//
//        long count = Arrays.stream(dados.getAves())
//                .filter(Ave::isExotico)
//                .count();
//
//        assertEquals(1, count);
//    }
//
//    @Test
//    @Disabled("Ignorado por enquanto")
//    void deveVerificarRevacinaComoTrue() {
//        Dados dados = new Dados();
//        dados.inserirEditarVacina(new Vacina("V10", "2023-08-01", "sim"),0);
//
//        assertTrue(dados.getVacinas()[0].isRevacina());
//    }
//}
//
