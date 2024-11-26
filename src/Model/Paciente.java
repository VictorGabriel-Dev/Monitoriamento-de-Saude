package Model;

public class Paciente extends Usuario {
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String historico;
    private String medicamento;

    public Paciente(String nome,String email,String telefone,String cpf, String dataNascimento, String endereco, String historico, String medicamento) {
        super(nome,email,telefone);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.historico = historico;
        this.medicamento = medicamento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getHistorico() {
        return historico;
    }

    public String getMedicamento() {
        return medicamento;
    }
}

