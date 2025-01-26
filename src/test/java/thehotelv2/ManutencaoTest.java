package thehotelv2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManutencaoTest {

    @Test
    void testAdicionarManutencaoAtiva() {
        Manutencao manutencao = new Manutencao(1, 101, 202, "Pintura");
        Manutencao gestorManutencao = new Manutencao(0, 0, 0, "");

        gestorManutencao.adicionarManutencaoAtiva(manutencao);

        assertTrue(gestorManutencao.quartoEmManutencao(202), "O quarto deve estar em manutenção.");
        assertEquals(1, gestorManutencao.getManutencoesAtivas().size(),
                "Deve haver uma manutenção ativa.");
    }

    @Test
    void testAdicionarManutencaoDuplicada() {
        Manutencao manutencao = new Manutencao(2, 102, 303, "Reparação Elétrica");
        Manutencao gestorManutencao = new Manutencao(0, 0, 0, "");

        gestorManutencao.adicionarManutencaoAtiva(manutencao);
        gestorManutencao.adicionarManutencaoAtiva(manutencao);

        assertEquals(1, gestorManutencao.getManutencoesAtivas().size(),
                "Manutenção duplicada não deve ser adicionada.");
    }

    @Test
    void testRemoverManutencaoExistente() {
        Manutencao manutencao = new Manutencao(3, 103, 404, "Canalização");
        Manutencao gestorManutencao = new Manutencao(0, 0, 0, "");

        gestorManutencao.adicionarManutencaoAtiva(manutencao);
        gestorManutencao.registarManutencao(manutencao);

        assertFalse(gestorManutencao.quartoEmManutencao(404),
                "O quarto não deve estar em manutenção após remoção.");
    }

    @Test
    void testRemoverManutencaoInexistente() {
        Manutencao manutencao = new Manutencao(4, 104, 505, "Limpeza profunda");
        Manutencao gestorManutencao = new Manutencao(0, 0, 0, "");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            gestorManutencao.registarManutencao(manutencao);
        });

        assertEquals("Manutenção não está registada.", exception.getMessage());
    }

    @Test
    void testRegistarManutencaoPorID() {
        Manutencao manutencao1 = new Manutencao(5, 105, 606, "Troca de mobília");
        Manutencao gestorManutencao = new Manutencao(0, 0, 0, "");

        gestorManutencao.adicionarManutencaoAtiva(manutencao1);
        gestorManutencao.registarManutencaoID(5);

        assertFalse(gestorManutencao.quartoEmManutencao(606),
                "O quarto não deve estar mais em manutenção após registo por ID.");
    }

    @Test
    void testAdicionarManutencaoSemFalhas() {
        Manutencao manutencao = new Manutencao(6, 106, 707, "Inspeção geral");
        Manutencao gestorManutencao = new Manutencao(0, 0, 0, "");

        assertDoesNotThrow(() -> gestorManutencao.adicionarManutencaoAtiva(manutencao),
                "A adição de uma nova manutenção não deve gerar exceção.");
    }

    @Test
    void testGettersAndSetters() {
        Manutencao manutencao = new Manutencao(7, 107, 808, "Teste");

        manutencao.setId_manutencao(8);
        manutencao.setId_utilizador(108);
        manutencao.setId_quarto(809);
        manutencao.setTipo_manutencao("Reparação elétrica");

        assertEquals(8, manutencao.getId_manutencao());
        assertEquals(108, manutencao.getId_utilizador());
        assertEquals(809, manutencao.getId_quarto());
        assertEquals("Reparação elétrica", manutencao.getTipo_manutencao());
    }
}
