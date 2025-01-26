package thehotelv2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EditarQuartoTest {

    @Test
    void testEditarQuartoExistente() {
        Gestor gestor = new Gestor(2);
        Quarto quartoAntigo = new Quarto(101, "Vista Mar", 2, 1, 1, false, false);
        gestor.criarQuarto(quartoAntigo);
        Quarto quartoNovo = new Quarto(102, "Vista Montanha", 4, 2, 2, true, true);
        gestor.editarQuarto(101, quartoNovo);

        // Validar atualizaçoes
        assertEquals("Vista Montanha", gestor.getListaQuartos().get(0).getVista());
        assertEquals(4, gestor.getListaQuartos().get(0).getCapacidade());
        assertEquals(2, gestor.getListaQuartos().get(0).getCamas());
        assertEquals(2, gestor.getListaQuartos().get(0).getCasasBanho());
        assertTrue(gestor.getListaQuartos().get(0).temCozinha());
        assertTrue(gestor.getListaQuartos().get(0).temVaranda());
    }

    @Test
    void testEditarQuartoInexistente() {
        Gestor gestor = new Gestor(2);
        Quarto quartoNovo = new Quarto(123, "Vista Lago", 3, 2, 2, true, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.editarQuarto(999, quartoNovo);
        });
        assertEquals("Quarto não existe.", exception.getMessage());
    }


}
