package thehotelv2;

public class QuartoTest {

    private int id_quarto;
    private int id_utilizador;
    private int id_manutencao;

    private String tipoVista;
    private int capacidade;
    private int camas;
    private int wcs;
    private boolean cozinha;
    private boolean varanda;
    private boolean ocupado;

    // Construtores
    public QuartoTest(){};
    public QuartoTest(String tipoVista, int capacidade, int camas, int wcs, boolean cozinha, boolean varanda) {
        // Restrições
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade inválida.");
        }
        if (camas <= 0) {
            throw new IllegalArgumentException("Número de camas inválido.");
        }
        if (wcs <= 0) {
            throw new IllegalArgumentException("Número de WC's inválido.");
        }
        this.tipoVista = tipoVista;
        this.capacidade = capacidade;
        this.camas = camas;
        this.wcs = wcs;
        this.cozinha = cozinha;
        this.varanda = varanda;
    }
    public QuartoTest(int id_quarto, String tipoVista, int capacidade, int camas, int wcs, boolean cozinha, boolean varanda) {
        // Restrições
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade inválida.");
        }
        if (camas <= 0) {
            throw new IllegalArgumentException("Número de camas inválido.");
        }
        if (wcs <= 0) {
            throw new IllegalArgumentException("Número de WC's inválido.");
        }
        this.id_quarto = id_quarto;
        this.tipoVista = tipoVista;
        this.capacidade = capacidade;
        this.camas = camas;
        this.wcs = wcs;
        this.cozinha = cozinha;
        this.varanda = varanda;
    }

    // Métodos
    public boolean isOcupado() {
        return ocupado;
    }
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    public String getVista() {
        return tipoVista;
    }
    public void setTipoVista(String tipoVista) {
        this.tipoVista = tipoVista;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    public int getCamas() {
        return camas;
    }
    public void setCamas(int camas) {
        this.camas = camas;
    }
    public int getCasasBanho() {
        return wcs;
    }
    public void setCasasBanho(int wcs) {
        this.wcs = wcs;
    }
    public boolean temCozinha() {
        return cozinha;
    }
    public void setCozinha(boolean cozinha) {
        this.cozinha = cozinha;
    }
    public boolean temVaranda() {
        return varanda;
    }
    public void setVaranda(boolean varanda) {
        this.varanda = varanda;
    }

    public int getId_quarto() {
        return id_quarto;
    }
    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }
    public int getId_utilizador() {
        return id_utilizador;
    }
    public void setId_utilizador(int id_utilizador) {
        this.id_utilizador = id_utilizador;
    }
    public int getId_manutencao() {
        return id_manutencao;
    }
    public void setId_manutencao(int id_manutencao) {
        this.id_manutencao = id_manutencao;
    }


}