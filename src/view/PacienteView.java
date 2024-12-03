package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import model.Paciente;

public class PacienteView {

    public int menuPaciente(Scanner ler) {
        System.out.println("\n********** Menu Paciente **********");
        System.out.println("1. Consultar dados");
        System.out.println("2. Histórico");
        System.out.println("3. Agendar consulta");
        System.out.println("4. Sair");
        System.out.print("\nEscolha uma opção: ");
        return ler.nextInt();
    }
    public void exibirDadosPaciente(Paciente paciente) {
        System.out.println("\n********** Dados do Paciente **********");
        System.out.println("Nome: " + paciente.getNome());
        System.out.println("CPF: " + paciente.getCpf());
        System.out.println("Data de Nascimento: " + paciente.getDataNascimento());
        System.out.println("Endereço: " + paciente.getEndereco());
        System.out.println("Telefone: " + paciente.getTelefone());
        System.out.println("E-mail: " + paciente.getEmail());
        System.out.println("****************************************");
    }

    public int opcoesAlterarEVoltar(Scanner ler) {
        System.out.println("\n1 - Alterar dados");
        System.out.println("2 - Voltar");
        System.out.print("Escolha uma opção: ");
        return ler.nextInt();
    }

    public int selecionarQualAlterar(Scanner ler) {
        System.out.println("\n********** Alterar Dados **********");
        System.out.println("1 - Nome");
        System.out.println("2 - CPF");
        System.out.println("3 - Data de Nascimento");
        System.out.println("4 - Endereço");
        System.out.println("5 - Telefone");
        System.out.println("6 - E-mail");
        System.out.println("7 - Voltar");
        System.out.print("Escolha o dado a ser alterado: ");
        return ler.nextInt();
    }

    public void alterarDadosPaciente(Scanner ler, Paciente paciente) {
        int opcao;
        do {
            opcao = selecionarQualAlterar(ler);
            ler.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome: ");
                    paciente.setNome(ler.nextLine());
                    System.out.println("Nome alterado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o novo CPF: ");
                    paciente.setCpf(ler.nextLine());
                    System.out.println("CPF alterado com sucesso!");
                    break;
                case 3:
                    atualizarDataNascimento(ler, paciente);
                    break;
                case 4:
                    System.out.print("Digite o novo endereço: ");
                    paciente.setEndereco(ler.nextLine());
                    System.out.println("Endereço alterado com sucesso!");
                    break;
                case 5:
                    System.out.print("Digite o novo telefone: ");
                    paciente.setTelefone(ler.nextLine());
                    System.out.println("Telefone alterado com sucesso!");
                    break;
                case 6:
                    System.out.print("Digite o novo e-mail: ");
                    paciente.setEmail(ler.nextLine());
                    System.out.println("E-mail alterado com sucesso!");
                    break;
                case 7:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);
    }

    private void atualizarDataNascimento(Scanner ler, Paciente paciente) {
        System.out.print("Digite a nova data de nascimento (dd/MM/yyyy): ");
        LocalDate novaDataNascimento = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (novaDataNascimento == null) {
            String dataNascimentoStr = ler.nextLine();
            try {
                novaDataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
                if (novaDataNascimento.isAfter(LocalDate.now())) {
                    System.out.println("Data de nascimento não pode ser no futuro. Tente novamente.");
                    novaDataNascimento = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Tente novamente (dd/MM/yyyy):");
            }
        }
        paciente.setDataNascimento(novaDataNascimento);
        System.out.println("Data de nascimento alterada com sucesso!");
    }
}
