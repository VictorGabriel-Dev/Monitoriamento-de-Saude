package model;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario{
    private String cpf;
    private String endereco;
    private String dataNascimento;
    private List<Historico> historicoMedico = new ArrayList<>();
    private Medicamento medicamentos;
    private String dispositivos;
    public Paciente(String nome, String cpf, String telefone, String email, String endereco, String dataNascimento, List<Historico> historicoMedico, Medicamento medicamentos, String dispositivos) {
        super(nome, email, telefone);
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.historicoMedico = (historicoMedico != null) ? historicoMedico : new ArrayList<>();
        this.medicamentos = medicamentos;
        this.dispositivos = dispositivos;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getDataNascimento() {
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