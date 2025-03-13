package model;

public class AlertaModel {
    private String tipo;
    private String mensagem;
    private Paciente paciente;
    private Medico medico;
    private String data;

    public AlertaModel(String tipo, String mensagem, Paciente paciente, Medico medico, String data) {
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return this.medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}