package model;

public class Medicamento {
    private String nome;
    private String dosagem;
    private String frequencia;
    private String descricao;
    private Medico medico;
    private String dataPrescricao;

    public Medicamento(String nome, String dosagem, String frequencia, String descricao, Medico medico, String dataPrescricao) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.frequencia = frequencia;
        this.descricao = descricao;
        this.medico = medico;
        this.dataPrescricao = dataPrescricao;
    }
    public String getNome() {
        return nome;
    }
    public String getDosagem() {
        return dosagem;
    }
    public String getFrequencia() {
        return frequencia;
    }
    public String getDescricao() {
        return descricao;
    }
    public Medico getMedico() {
        return medico;
    }
    public String getDataPrescricao() {
        return dataPrescricao;
    }
}