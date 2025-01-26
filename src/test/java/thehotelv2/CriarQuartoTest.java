package thehotelv2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class CriarQuartoTest {

    @Test
    void testCriarQuartoValido() {
        Quarto quarto = new Quarto("Vista Mar", 2, 1, 1, false, false);
        Gestor gestor = new Gestor(1);
        gestor.criarQuarto(quarto);
        assertEquals("Vista Mar", gestor.getListaQuartos().get(0).getVista());
        assertEquals(2, gestor.getListaQuartos().get(0).getCapacidade());
        assertEquals(1, gestor.getListaQuartos().get(0).getCamas());
        assertEquals(1, gestor.getListaQuartos().get(0).getCasasBanho());
        assertFalse(gestor.getListaQuartos().get(0).temCozinha());
        assertFalse(gestor.getListaQuartos().get(0).temVaranda());
    }

    // Test zeros
    @Test
    void testZeroWCs(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Quarto("Vista Mar", 2, 2, 0, false, false);
        });
        assertEquals("Número de WC's inválido.", exception.getMessage());
    }

    @Test
    void testZeroCamas(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Quarto("Vista Montanha", 2, 0, 1, true, true);
        });
        assertEquals("Número de camas inválido.", exception.getMessage());
    }

    @Test
    void testZeroCapacidade(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Quarto("Vista Montanha", 0, 2, 2, true, true);
        });
        assertEquals("Capacidade inválida.", exception.getMessage());
    }

    @Test
    void testVistaNull(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Quarto(null, 2, 1, 1, true, true);
        });
        assertEquals("Tipo de vista nulo.", exception.getMessage());
    }

    @Test
    void testIDquarto() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Quarto(0, "Vista Montanha", 2, 0, 1, true, true);
        });
        assertEquals("Quarto não existente.", exception.getMessage());
    }


}
