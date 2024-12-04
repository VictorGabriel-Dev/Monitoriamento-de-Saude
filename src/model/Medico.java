package model;

public class Medico extends UsuarioModel {
    private String nome;
    private String especialidade;
    private String crm;
    private String telefone;

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

    @Override
    public String toString() {
        return "\n********** Dados do Paciente **********\n" +
                "Nome: " + nome + "\n" +
                "Especialidade: " + especialidade + "\n" +
                "CRM: " + crm + "\n" +
                "Telefone: " + telefone + "\n" +
                "Email: " + getEmail() + "\n";
    }
}