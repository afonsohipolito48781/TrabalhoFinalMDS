package thehotelv2;

import java.util.ArrayList;
import java.util.List;

public class Manutencao {

    private int id_manutencao;
    private int id_utilizador;
    private int id_quarto;

    private String tipo_manutencao;

    private List<Manutencao> manutencoesAtivas = new ArrayList<>();

    public Manutencao(int id_m, int id_u, int id_q, String tipo){
        this.id_manutencao = id_m;
        this.id_utilizador = id_u;
        this.id_quarto = id_q;
        this.tipo_manutencao = tipo;
    }

    /* Getters e Setters */

    public int getId_utilizador() {
        return id_utilizador;
    }

    public void setId_utilizador(int id_utilizador) {
        this.id_utilizador = id_utilizador;
    }

    public int getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }

    public int getId_manutencao() {
        return id_manutencao;
    }

    public void setId_manutencao(int id_manutencao) {
        this.id_manutencao = id_manutencao;
    }

    public String getTipo_manutencao() {
        return tipo_manutencao;
    }

    public void setTipo_manutencao(String tipo_manutencao) {
        this.tipo_manutencao = tipo_manutencao;
    }

    public List<Manutencao> getManutencoesAtivas() {
        return manutencoesAtivas;
    }
    public void setManutencoesAtivas(List<Manutencao> manutencoesAtivas) {
        this.manutencoesAtivas = manutencoesAtivas;
    }


    // Métodos
    // Issue #4: Manutenção dos Quartos
    public boolean quartoEmManutencao(int id_quarto){
        for (Manutencao m : manutencoesAtivas){
            if (m.getId_quarto() == id_quarto){
                return true;
            }
        }
        return false;
    }

    public boolean manutencaoEstaAtiva(Manutencao m){
        for (Manutencao man : manutencoesAtivas){
            if (man == m){
                return true;
            }
        }
        return false;
    }

    // Issue #5: Adicionar Manutenção
    public void adicionarManutencaoAtiva(Manutencao m){
        try {
            if (!manutencaoEstaAtiva(m))
                manutencoesAtivas.add(m);
            else
                System.out.println("Manutenção já existente.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void registarManutencao(Manutencao m){  // concluir manutenção
        if (manutencaoEstaAtiva(m))
            manutencoesAtivas.remove(m);
        else
            throw new RuntimeException("Manutenção não está registada.");
    }
    public void registarManutencaoID(int id_manutencao) {
         try {
            for (Manutencao m : manutencoesAtivas) {
                if (m.getId_manutencao() == id_manutencao) {
                    registarManutencao(m);
                    return;
                }
            }
            System.out.println("Manutenção não está registada.");
        } catch (Exception e) {
             throw new RuntimeException(e);
         }
    }

}
