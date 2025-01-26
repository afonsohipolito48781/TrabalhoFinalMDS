package thehotelv2;

import java.util.ArrayList;
import java.util.List;


public class GestorTest {

    private int id_utilizador;

    private List<Quarto> listaQuartos = new ArrayList<>();

    public GestorTest(int id_utilizador){
        this.id_utilizador = id_utilizador;
    }

    public int getId_utilizador() {
        return id_utilizador;
    }
    public void setId_utilizador(int id_utilizador) {
        this.id_utilizador = id_utilizador;
    }
    public List<Quarto> getListaQuartos() {
        return listaQuartos;
    }
    public void setListaQuartos(List<Quarto> listaQuartos) {
        this.listaQuartos = listaQuartos;
    }

    // Métodos
    public void registarManutencao(){}
    public void verManutencao(){}
    public void getHistoricoHospede(){}  // Não necessário para este trabalho


    // Issue #1: Criar Quarto
    public void criarQuarto(Quarto quarto) {
        try {
            listaQuartos.add(quarto);
            System.out.println("Quarto adicionado. ID " + quarto.getId_quarto());
        } catch (Exception e) {
            System.out.println("Erro a adicionar quarto.");
        }
    }

    // Issue #2: Remover Quarto
    public void removerQuarto(int IDquarto) {
        for (Quarto quarto : listaQuartos) {
            if (quarto.getId_quarto() == IDquarto && !quarto.isOcupado()){
                listaQuartos.remove(listaQuartos.indexOf(quarto));
                return;
            }
        }
        throw new IllegalArgumentException("Quarto não existe.");
    }

    // Issue #3: Editar Quarto
    public void editarQuarto(int IDquarto, Quarto quarto) {
        for (int i = 0; i < listaQuartos.size(); i++) {
            if (listaQuartos.get(i).getId_quarto() == IDquarto) {
                listaQuartos.set(i, quarto);  // Usa o índice correto em vez do ID diretamente
                return;
            }
        }
        throw new IllegalArgumentException("Quarto não existe.");
    }

}
