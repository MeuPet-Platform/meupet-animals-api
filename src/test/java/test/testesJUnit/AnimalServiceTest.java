//package test.testesJUnit;
//
//import main.modelo.Animal;
//import main.modelo.Ave;
//import main.modelo.Cachorro;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class AnimalServiceTest {
//
//
//    @Test
//    @Disabled("Ignorado por enquanto")
//    void deveRetornarQueAveEhExotica(){
//
//        Ave arara = new Ave();
//        arara.exotico = true;
//
//        assertTrue(arara.isExotico());
//    }
//
//    @Test
//    @Disabled("Ignorado por enquanto")
//    void deveRetornarQueCachorroEhManso() {
//        Cachorro rex = new Cachorro();
//        rex.manso = true;
//
//        assertTrue(rex.isManso());
//    }
//
//    @Test
//    @Disabled("Ignorado por enquanto")
//    void deveCalcularPesoIdealCorretamente() {
//        Animal animal = new Animal();
//        animal.peso = 20.0;
//
//        double pesoIdeal = animal.calcularPesoIdeal();
//
//        assertEquals(19.0, pesoIdeal, 0.01);
//    }
//
//
//}
//
