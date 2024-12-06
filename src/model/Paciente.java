package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends UsuarioModel {
    private static List<String> nomesCadastrados = new ArrayList<>();
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private LocalDate dataNascimento;
    private List<Consulta> historicoMedico = new ArrayList<>();
    private Medicamento medicamentos;
    private String dispositivos;

    public Paciente(String nome, String email, String telefone, String senha, String cpf, LocalDate dataNascimento,
            String endereco, List<Consulta> historicoMedico, Medicamento medicamentos, String dispositivos) {
        super(email, senha);
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.historicoMedico = (historicoMedico != null) ? historicoMedico : new ArrayList<>();
        this.medicamentos = medicamentos;
        this.dispositivos = dispositivos;

        // Adiciona o nome á lista
        nomesCadastrados.add(nome);
    }
    public static List<String> getNomesCadastrados(){
        return nomesCadastrados;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public List<Consulta> getHistoricoMedico() {
        return historicoMedico;
    }

    public Medicamento getMedicamentos() {
        return medicamentos;
    }

    public String getDispositivos() {
        return dispositivos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento não pode ser futura");
        }
        this.dataNascimento = dataNascimento;
    }

    public void setHistoricoMedico(List<Consulta> historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    @Override
    public String toString() {
        return "\n********** Dados do Paciente **********\n" +
                "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Data de Nascimento: " + dataNascimento + "\n" +
                "Endereço: " + endereco + "\n" +
                "Telefone: " + telefone + "\n" +
                "E-mail: " + getEmail() + "\n";
    }

}
