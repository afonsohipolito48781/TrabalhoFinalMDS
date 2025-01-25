package thehotelv2;

import java.util.List;
import java.util.ArrayList;

public class GerirQuartos {

    List<Quarto> listaQuartos = new ArrayList<>();

    // Issue: Criar Quarto
    public void criarQuarto(Quarto quarto) {
        try {
            listaQuartos.add(quarto);
            System.out.println("Quarto adicionado. ID " + quarto.getId_quarto());
        } catch (Exception e) {
            System.out.println("Erro a adicionar quarto.");
        }
    }

    // Issue: Remover Quarto
    public void removerQuarto(int IDquarto) {
        try {
            for (Quarto quarto : listaQuartos) {
                if (quarto.getId_quarto() == IDquarto){
                    listaQuartos.remove(listaQuartos.indexOf(quarto));
                    System.out.println("Quarto ID "+quarto.getId_utilizador()+" removido. ");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro a remover quarto ID "+IDquarto);
        }
    }

    // Issue: Editar Quarto
    public void editarQuarto(int IDquarto, Quarto quarto) {
        try {
            listaQuartos.set(IDquarto, quarto);
            System.out.println("Quarto ID "+IDquarto+" editado.");
        } catch (Exception e) {
            System.out.println("Erro a editar quarto ID "+IDquarto);
        }
    }

}
