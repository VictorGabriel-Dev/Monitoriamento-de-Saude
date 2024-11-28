package model;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends UsuarioModel{
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private Date dataNascimento;
    private List<Historico> historicoMedico = new ArrayList<>();
    private Medicamento medicamentos;
    private String dispositivos;
    public Paciente(String nome, String cpf, String telefone, String email, String senha,String endereco,Date dataNascimento, List<Historico> historicoMedico, Medicamento medicamentos, String dispositivos) {
        super(email, senha);
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.historicoMedico = (historicoMedico != null) ? historicoMedico : new ArrayList<>();
        this.medicamentos = medicamentos;
        this.dispositivos = dispositivos;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public List<Historico> getHistoricoMedico() {
        return historicoMedico;
    }
    public Medicamento getMedicamentos() {
        return medicamentos;
    }
    public String getDispositivos() {
        return dispositivos;
    }

    public void addHistoricoMedico(Historico historico) {
        if(historico != null)
        historicoMedico.add(historico);
    }
    
}