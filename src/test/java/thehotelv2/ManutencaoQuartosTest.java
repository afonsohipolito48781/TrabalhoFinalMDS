package thehotelv2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManutencaoQuartosTest {

    @Test
    void testAdicionarManutencao() {
        Manutencao manutencao = new Manutencao(1, 101, 202, "Pintura");

        manutencao.adicionarManutencaoAtiva(manutencao);

        assertTrue(manutencao.quartoEmManutencao(202), "O quarto deve estar em manutenção.");
        assertEquals("Pintura", manutencao.getTipo_manutencao(), "O tipo de manutenção deve ser 'Pintura'.");
    }

    @Test
    void testAdicionarManutencaoExistente() {
        Manutencao manutencao = new Manutencao(2, 102, 303, "Reparação Elétrica");

        manutencao.adicionarManutencaoAtiva(manutencao);
        manutencao.adicionarManutencaoAtiva(manutencao); // Tentar adicionar novamente

        assertEquals(1, manutencao.getManutencoesAtivas().size(),
                "A manutenção duplicada não deve ser adicionada novamente.");
    }

    @Test
    void testRegistarManutencao() {
        Manutencao manutencao = new Manutencao(3, 103, 404, "Canalização");

        manutencao.adicionarManutencaoAtiva(manutencao);
        manutencao.registarManutencao(manutencao);

        assertFalse(manutencao.quartoEmManutencao(404), "O quarto não deve estar em manutenção após registo.");
    }

    @Test
    void testRegistarManutencaoInexistente() {
        Manutencao manutencao = new Manutencao(4, 104, 505, "Limpeza profunda");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            manutencao.registarManutencao(manutencao);
        });

        assertEquals("Manutenção não está registada.", exception.getMessage());
    }

    @Test
    void testRegistarManutencaoPorID() {
        Manutencao manutencao1 = new Manutencao(5, 105, 606, "Troca de mobília");
        Manutencao manutencao = new Manutencao(0, 0, 0, ""); // Instância para gestão de manutenções

        manutencao.adicionarManutencaoAtiva(manutencao1);
        manutencao.registarManutencaoID(5);

        assertFalse(manutencao.quartoEmManutencao(606), "O quarto não deve estar mais em manutenção após registo por ID.");
    }

    @Test
    void testHistoricoManutencoes() {
        Manutencao manutencao = new Manutencao(6, 106, 707, "Pintura");

        manutencao.adicionarManutencaoAtiva(manutencao);
        manutencao.registarManutencao(manutencao);

        assertEquals(0, manutencao.getManutencoesAtivas().size(),
                "A lista de manutenções ativas deve estar vazia após registo.");
    }
}
