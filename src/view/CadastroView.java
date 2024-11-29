package view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import model.Historico;
import model.Medico;
import model.Paciente;

public class CadastroView {
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
        List<Historico> historicoMedico = new ArrayList<>();
        System.out.println("Deseja adicionar um histórico médico? (1 - Sim, 2 - Não)");
        int opcao = ler.nextInt();
        ler.nextLine();
        if (opcao == 1) {
            while (true) {
                System.out.println("Adicionando histórico médico...");
                System.out.print("Data de início do tratamento: ");
                String dataInicio = ler.nextLine();
                System.out.print("Data de término do tratamento: ");
                String dataTermino = ler.nextLine();
                System.out.print("Descrição do tratamento: ");
                String descricao = ler.nextLine();
                System.out.print("Medicamento usado: ");
                String medicamento = ler.nextLine();
                historicoMedico.add(new Historico(dataInicio, dataTermino, descricao, medicamento));

                System.out.println("Deseja adicionar outro histórico? (1 - Sim, 2 - Não)");
                int continuar = ler.nextInt();
                ler.nextLine();
                if (continuar != 1)
                    break;
            }
        }
        return new Paciente(nome, email, telefone, senha, cpf, null, endereco, historicoMedico, null, null);

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