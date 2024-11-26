package model;

public class Historico {
    private String dataInicio;
    private String dataTermino;
    private String descricao;
    private String medicamento;

    public Historico(String dataInicio, String dataTermino, String descricao, String medicamento) {
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.descricao = descricao;
        this.medicamento = medicamento;
    }
    public String getDataInicio() {
        return dataInicio;
    }
    public String getDataTermino() {
        return dataTermino;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getMedicamento() {
        return medicamento;
    }
}