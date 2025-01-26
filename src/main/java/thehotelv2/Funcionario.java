package thehotelv2;

// Issue #?: Criar Classe Funcionário
public class Funcionario {

    private int id_utilizador;

    // Lista de quartos?
    // Lista de manutençao?

    public Funcionario(int id) {
        this.id_utilizador = id;
    }

    public int getId_utilizador() {
        return id_utilizador;
    }
    public void setId_utilizador(int id_utilizador) {
        this.id_utilizador = id_utilizador;
    }

    // Métodos
    public void registarManutencao(){}
    public void verManutencao(){}
    public void getHistoricoManutencao(){}; // não necessário para este trabalho
}
