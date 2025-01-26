package thehotelv2;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RemoverQuartoTest {

    @Test
    void testRemoverQuartoExistente() {
        Quarto quarto1 = new Quarto(101, "Vista Mar", 2, 1, 1, true, false);
        Gestor gestor = new Gestor(1);
        gestor.criarQuarto(quarto1);
        gestor.removerQuarto(101);

        assertEquals(0, gestor.getListaQuartos().size(), "O quarto deve ser removido da lista.");
    }

    @Test
    void testRemoverQuartoInexistente() {
        Quarto quarto1 = new Quarto(202,"Vista Montanha", 3, 2, 2, true, true);
        Gestor gestor = new Gestor(1);
        gestor.criarQuarto(quarto1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.removerQuarto(999);
        });

        assertEquals("Quarto não existe.", exception.getMessage());
    }


    @Test
    void testIsOcupado() {
        Quarto quarto1 = new Quarto(303, "Vista Mar", 2, 1, 2, true, true);
        Gestor gestor = new Gestor(2);
        gestor.criarQuarto(quarto1);
        gestor.removerQuarto(quarto1.getId_quarto());

        // Verifica se o quarto foi removido corretamente
        assertTrue(gestor.getListaQuartos().isEmpty(), "A lista de quartos deve estar vazia após remoção.");
    }


}
