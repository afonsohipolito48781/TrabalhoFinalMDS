package thehotelv2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class ReservaTest {

    @Test
    void testCriarReservaComDataAtual() {
        Reserva reserva = new Reserva(1, 1001, 2001);

        assertEquals(1, reserva.getId_utilizador());
        assertEquals(1001, reserva.getId_estadia());
        assertEquals(2001, reserva.getId_quarto());
        assertNotNull(reserva.getData());
    }

    @Test
    void testCriarReservaComDataEspecifica() {
        Date data = new Date();
        Reserva reserva = new Reserva(2, 1002, 2002, data);

        assertEquals(2, reserva.getId_utilizador());
        assertEquals(1002, reserva.getId_estadia());
        assertEquals(2002, reserva.getId_quarto());
        assertEquals(data, reserva.getData());
    }

    @Test
    void testRegistarReservaComSucesso() {
        Reserva reserva = new Reserva(3, 1003, 2003);
        Quarto quarto = new Quarto(2003, "Vista Mar", 2, 1, 1, false, false);

        reserva.registarReserva(reserva, quarto);

        assertEquals(1, reserva.getListaReservas().size());
        assertEquals(2003, reserva.getListaReservas().get(0).getId_quarto());
    }

    @Test
    void testRegistarReservaDuplicada() {
        Reserva reserva = new Reserva(4, 1004, 2004);
        Quarto quarto = new Quarto(2004, "Vista Jardim", 2, 1, 1, false, false);

        reserva.registarReserva(reserva, quarto);
        reserva.registarReserva(reserva, quarto);

        assertEquals(1, reserva.getListaReservas().size());
    }

    @Test
    void testRegistarReservaQuartoOcupado() {
        Reserva reserva = new Reserva(5, 1005, 2005);
        Quarto quarto = new Quarto(2005, "Vista Piscina", 3, 2, 1, false, false);
        quarto.setOcupado(true);  // Certificar que o quarto está ocupado

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            reserva.registarReserva(reserva, quarto);
        });

        assertEquals("Reserva indisponível.", exception.getMessage(),
                "Deve lançar exceção ao tentar reservar um quarto ocupado.");
    }

    @Test
    void testRegistarReservaQuartoEmManutencao() {
        Reserva reserva = new Reserva(6, 1006, 2006);
        Quarto quarto = new Quarto(2006, "Vista Montanha", 2, 1, 1, false, false);
        quarto.setEmManutencao(true);  // Certificar que o quarto está em manutenção

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            reserva.registarReserva(reserva, quarto);
        });

        assertEquals("Reserva indisponível.", exception.getMessage(),
                "Deve lançar exceção ao tentar reservar um quarto em manutenção.");
    }



    @Test
    void testSettersAndGetters() {
        Reserva reserva = new Reserva(7, 1007, 2007);

        reserva.setId_utilizador(8);
        reserva.setId_estadia(1008);
        reserva.setId_quarto(2008);
        Date novaData = new Date();
        reserva.setData(novaData);

        assertEquals(8, reserva.getId_utilizador());
        assertEquals(1008, reserva.getId_estadia());
        assertEquals(2008, reserva.getId_quarto());
        assertEquals(novaData, reserva.getData());
    }
}
