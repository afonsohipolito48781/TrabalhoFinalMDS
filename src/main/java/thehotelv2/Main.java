package thehotelv2;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criar uma instância de um gestor
        Gestor gestor = new Gestor(1);

        // Criar um novo quarto e adicionando à lista do gestor
        Quarto quarto1 = new Quarto(101, "Vista Mar", 2, 1, 1, true, true);
        gestor.criarQuarto(quarto1);

        System.out.println("Quarto criado: ID " + quarto1.getId_quarto() + ", Capacidade: " + quarto1.getCapacidade());

        // Criar uma reserva para o quarto
        Reserva reserva1 = new Reserva(1, 1, 101, new Date());
        reserva1.registarReserva(reserva1, quarto1);

        System.out.println("Reserva criada para o quarto " + reserva1.getId_quarto() + " na data " + reserva1.getData());

        // Criar manutenção para o quarto
        Manutencao manutencao1 = new Manutencao(1, 1, 101, "Troca de Ar-condicionado");
        manutencao1.adicionarManutencaoAtiva(manutencao1);

        System.out.println("Manutenção criada para o quarto " + manutencao1.getId_quarto() + " - " + manutencao1.getTipo_manutencao());

        // Marcar manutenção como completa
        manutencao1.registarManutencao(manutencao1);
        System.out.println("Manutenção "+manutencao1.getTipo_manutencao()+" marcada como concluída.");

        // Mostrar todos os quartos
        System.out.println("Lista de quartos existentes:");
        for (Quarto q : gestor.getListaQuartos()) {
            System.out.println("Quarto ID: " + q.getId_quarto() + ", Tipo: " + q.getVista());
        }
    }
}
