package thehotelv2;

import java.sql.Time;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

// Issue #6: Criar Classe Reserva
public class Reserva {

    private int id_utilizador; // ID do gestor ou funcionário que criou reserva
    private int id_quarto; // ID do quarto reservado
    private int id_estadia; // Não necessário neste trabalho

    private Date data;

    private List<Reserva> listaReservas = new ArrayList<>();

    // Construtores
    public Reserva(int id_utilizador, int id_estadia, int id_quarto){
        this.id_utilizador = id_utilizador;
        this.id_estadia = id_estadia;
        this.id_quarto = id_quarto;
        this.data = new Date();
    }
    public Reserva(int id_utilizador, int id_estadia, int id_quarto, Date data) {
        this.id_utilizador = id_utilizador;
        this.id_estadia = id_estadia;
        this.id_quarto = id_quarto;
        this.data = data;
    }

    // Getters e Setters
    public int getId_utilizador() {
        return id_utilizador;
    }
    public void setId_utilizador(int id_utilizador) {
        this.id_utilizador = id_utilizador;
    }
    public int getId_estadia() {
        return id_estadia;
    }
    public void setId_estadia(int id_estadia) {
        this.id_estadia = id_estadia;
    }
    public int getId_quarto() {
        return id_quarto;
    }
    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public List<Reserva> getListaReservas() {
        return listaReservas;
    }
    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    // Métodos
    public void registarReserva(Reserva reserva, Quarto quarto) {
        try {
            if (listaReservas.contains(reserva)){
                System.out.println("Já reservado.");
                return;
            }
            // verificar se o quarto está ocupado
            if (quarto.isOcupado() || quarto.isEmManutencao()){
                throw new IllegalArgumentException("Reserva indisponível.");
            }

            // TODO verificar se ids existem?

            listaReservas.add(reserva);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }



}
