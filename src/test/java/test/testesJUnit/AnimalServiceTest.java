//package test.testesJUnit;
//
//import io.quarkus.test.junit.QuarkusTest;
//import jakarta.inject.Inject;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@QuarkusTest
//@Transactional
//public class AnimalServiceTest {
//
//    @Inject
//    CachorroService cachorroService;
//
//    @Inject
//    AveService aveService;
//
//    @Test
//    @Disabled("Ignorado por enquanto")
//    void deveInserirCachorroNoBanco() {
//        Cachorro rex = new Cachorro();
//        rex.nome = "Rex";
//        rex.raca = "Labrador";
//        rex.peso = 25.0;
//        rex.sexo = "M";
//        rex.manso = true;
//        rex.necessitaFocinheira = false;
//        rex.porte = "Grande";
//        rex.vacinado = true;
//
//        cachorroService.inserir(rex);
//
//        List<Cachorro> resultado = Cachorro.listAll();
//        assertEquals(1, resultado.size());
//        assertEquals("Rex", resultado.get(0).nome);
//    }
//
//    @Test
//    @Disabled("Ignorado por enquanto")
//    void deveEditarCachorro() {
//        Cachorro rex = new Cachorro();
//        rex.nome = "Rex";
//        rex.raca = "Labrador";
//        rex.peso = 25.0;
//        rex.sexo = "M";
//        rex.manso = true;
//        rex.necessitaFocinheira = false;
//        rex.porte = "Grande";
//        rex.vacinado = true;
//        rex.persist();
//
//        rex.necessitaFocinheira = true;
//        cachorroService.editar(rex.id, rex);
//
//        Cachorro salvo = Cachorro.findById(rex.id);
//        assertTrue(salvo.necessitaFocinheira);
//    }
//
//    @Test
//    @Disabled("Ignorado por enquanto")
//    void deveContarSomenteAvesExoticas() {
//        Ave arara = new Ave();
//        arara.nome = "Arara";
//        arara.exotico = true;
//        arara.persist();
//
//        Ave papagaio = new Ave();
//        papagaio.nome = "Papagaio";
//        papagaio.exotico = false;
//        papagaio.persist();
//
//        long count = Ave.count("exotico", true);
//        assertEquals(1, count);
//    }
//}
//
