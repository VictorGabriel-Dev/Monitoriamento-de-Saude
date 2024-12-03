package view;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import model.Medico;
import model.Paciente;

import java.time.LocalDate;
import java.time.ZoneId;
public class CadastroView{
public Paciente showCadastroPaciente(Scanner ler) {
    System.out.println("=== Cadastro de Paciente ===");
    System.out.print("Nome: ");
    String nome = ler.nextLine();
    System.out.print("Email: ");
    String email = ler.nextLine();
    System.out.print("Telefone: ");
    String telefone = ler.nextLine();
    System.out.print("Senha: ");
    String senha = ler.nextLine();
    System.out.print("CPF: ");
    String cpf = ler.nextLine();
    System.out.print("Data de Nascimento (dd/MM/yyyy): ");
    Date dataNascimento = null;
    while (dataNascimento == null) {
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = ler.nextLine();
        try {
            dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoStr);
            if (dataNascimento.after(new Date())) {
                System.out.println("Data de nascimento não pode ser no futuro.");
                dataNascimento = null;
            }
        } catch (Exception e) {
            System.out.println("Data inválida. Tente novamente.");
        }
    }
    System.out.print("Endereço: ");
    String endereco = ler.nextLine();

    LocalDate dataNascimentoLocalDate = dataNascimento.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();

    return new Paciente(nome, email, telefone, senha, cpf, dataNascimentoLocalDate, endereco, null, null, null);
}

    public Medico showCadastroMedico(Scanner ler) {
        System.out.println("=== Cadastro de Médico ===");
        System.out.print("Nome: ");
        String nome = ler.nextLine();
        System.out.print("Email: ");
        String email = ler.nextLine();
        System.out.print("Senha: ");
        String senha = ler.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = ler.nextLine();
        System.out.print("CRM: ");
        String crm = ler.nextLine();
        System.out.print("Telefone: ");
        String telefone = ler.nextLine();
        return new Medico(nome, email, senha, especialidade, crm, telefone);
    }
    public void mensagemSucesso() {
        System.out.println("Cadastro realizado com sucesso!");
    }
    public void mensagemCpfExistente() {
        System.out.println("CPF já cadastrado!");
    }
    public void mensagemEmailExistente() {
        System.out.println("Email já cadastrado!");
    }
    public void mensagemCrmExistente() {
        System.out.println("CRM já cadastrado!");
    }
}