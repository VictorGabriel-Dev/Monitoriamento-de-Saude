package model;

import java.util.List;

public class Medico extends UsuarioModel {
    private String nome;
    private String especialidade;
    private String crm;
    private String telefone;
    private List<Consulta> consultas;

    public Medico(String nome, String email, String senha, String especialidade, String crm, String telefone) {
        super(email, senha);
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "\n********** Dados do Medico **********\n" +
                "Nome: " + nome + "\n" +
                "Especialidade: " + especialidade + "\n" +
                "CRM: " + crm + "\n" +
                "Telefone: " + telefone + "\n" +
                "Email: " + getEmail() + "\n";
    }
}