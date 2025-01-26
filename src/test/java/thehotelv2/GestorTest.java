package thehotelv2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GestorTest {

    @Test
    void testCriarQuarto() {
        Gestor gestor = new Gestor(1);
        Quarto quarto = new Quarto(101, "Vista Mar", 2, 1, 1, false, false);

        gestor.criarQuarto(quarto);

        assertEquals(1, gestor.getListaQuartos().size(), "Deve haver um quarto na lista.");
        assertEquals(101, gestor.getListaQuartos().get(0).getId_quarto(), "O ID do quarto deve ser 101.");
    }

    @Test
    void testRemoverQuartoExistente() {
        Gestor gestor = new Gestor(1);
        Quarto quarto = new Quarto(102, "Vista Montanha", 3, 2, 1, false, false);
        gestor.criarQuarto(quarto);

        gestor.removerQuarto(102);

        assertTrue(gestor.getListaQuartos().isEmpty(), "A lista de quartos deve estar vazia após a remoção.");
    }

    @Test
    void testRemoverQuartoInexistente() {
        Gestor gestor = new Gestor(1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.removerQuarto(999);
        });

        assertEquals("Quarto não existe.", exception.getMessage());
    }

    @Test
    void testEditarQuartoExistente() {
        Gestor gestor = new Gestor(1);
        Quarto quarto = new Quarto(103, "Vista Jardim", 2, 1, 1, false, false);
        gestor.criarQuarto(quarto);

        Quarto quartoNovo = new Quarto(103, "Vista Lago", 3, 2, 2, true, true);
        gestor.editarQuarto(103, quartoNovo);

        Quarto quartoEditado = gestor.getListaQuartos().get(0);
        assertEquals("Vista Lago", quartoEditado.getVista(), "A vista do quarto deve ser 'Vista Lago'.");
        assertEquals(3, quartoEditado.getCapacidade(), "A capacidade do quarto deve ser 3.");
        assertEquals(2, quartoEditado.getCamas(), "O número de camas deve ser 2.");
        assertTrue(quartoEditado.temCozinha(), "O quarto deve ter cozinha.");
        assertTrue(quartoEditado.temVaranda(), "O quarto deve ter varanda.");
    }

    @Test
    void testEditarQuartoInexistente() {
        Gestor gestor = new Gestor(1);
        Quarto quartoNovo = new Quarto(104, "Vista Rio", 2, 1, 1, false, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.editarQuarto(999, quartoNovo);
        });

        assertEquals("Quarto não existe.", exception.getMessage());
    }

    @Test
    void testAdicionarMultiplosQuartos() {
        Gestor gestor = new Gestor(1);
        gestor.criarQuarto(new Quarto(201, "Vista Praia", 2, 1, 1, false, false));
        gestor.criarQuarto(new Quarto(202, "Vista Montanha", 4, 2, 1, true, false));

        assertEquals(2, gestor.getListaQuartos().size(), "Devem existir 2 quartos na lista.");
    }

    @Test
    void testRemoverQuartoOcupado() {
        Gestor gestor = new Gestor(1);
        Quarto quarto = new Quarto(203, "Vista Jardim", 2, 1, 1, false, false);
        quarto.setOcupado(true);
        gestor.criarQuarto(quarto);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.removerQuarto(203);
        });

        assertEquals("Quarto não existe.", exception.getMessage());
    }
}
