package model;

public class Medico extends UsuarioModel {
    private String nome;
    private String especialidade;
    private String crm;
    private String telefone;
    public Medico(String nome,String email,String senha,String especialidade, String crm, String telefone) {
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
} 