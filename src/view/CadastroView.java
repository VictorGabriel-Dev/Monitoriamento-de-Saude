package view;

import java.util.Scanner;
import model.Medico;
import model.Paciente;
import utils.Validacao;

import java.time.LocalDate;

public class CadastroView {
    private Scanner ler = new Scanner(System.in);

    public Paciente showCadastroPaciente() {
        System.out.println("=== Cadastro de Paciente ===");
    
        String nome, email, telefone, senha, cpf, endereco;
        LocalDate dataNascimento = null;

        do {
            System.out.print("Nome: ");
            nome = ler.nextLine();
        } while (nome.trim().isEmpty() || nome.length() < 2);
    
        do {
            System.out.print("Email: ");
            email = ler.nextLine();
            if (!Validacao.validarEmail(email)) {
                System.out.println("Email inválido! Certifique-se de que o email contém '@' e termina com '.com'.");
            }
        } while (!Validacao.validarEmail(email));
    
        do {
            System.out.print("Telefone: ");
            telefone = ler.nextLine();
            if (!Validacao.validarTelefone(telefone)) {
                System.out.println("Telefone inválido! Digite um número válido (exemplo: (11) 91234-5678).");
            }
        } while (!Validacao.validarTelefone(telefone));
    
        do {
            System.out.print("Senha: ");
            senha = ler.nextLine();
            if (!Validacao.validarSenha(senha)) {
                System.out.println("Senha inválida! A senha deve ter no mínimo 6 caracteres.");
            }
        } while (!Validacao.validarSenha(senha));
    
        do {
            System.out.print("CPF: ");
            cpf = ler.nextLine();
            if (!Validacao.validarCpf(cpf)) {
                System.out.println("CPF inválido! Digite um CPF válido.");
            }
        } while (!Validacao.validarCpf(cpf));
    
        while (dataNascimento == null) {
            System.out.print("Data de Nascimento (dd/MM/yyyy): ");
            String dataNascimentoStr = ler.nextLine();
            try {
                dataNascimento = LocalDate.parse(dataNascimentoStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (dataNascimento.isAfter(LocalDate.now())) {
                    System.out.println("Data de nascimento não pode ser no futuro.");
                    dataNascimento = null;
                }
            } catch (Exception e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }
    
        System.out.print("Endereço: ");
        endereco = ler.nextLine();
    
        while (true) {
            System.out.println("\n=== Confirmação de Cadastro ===");
            System.out.println("1. Nome: " + nome);
            System.out.println("2. Email: " + email);
            System.out.println("3. Telefone: " + telefone);
            System.out.println("4. Senha: (oculta)");
            System.out.println("5. CPF: " + cpf);
            System.out.println("6. Data de Nascimento: " + dataNascimento.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("7. Endereço: " + endereco);
    
            System.out.print("\nConfirmar cadastro? (S/N) ou editar uma opção (1-7): ");
            String confirmacao = ler.nextLine().trim().toUpperCase();
    
            if (confirmacao.equals("S")) {
                break; // Cadastro confirmado
            } else if (confirmacao.equals("N")) {
                System.out.println("Cadastro cancelado.");
                return null; // Cadastro cancelado
            } else if (confirmacao.matches("[1-7]")) {
                int opcao = Integer.parseInt(confirmacao);
                switch (opcao) {
                    case 1:
                        do {
                            System.out.print("Novo Nome: ");
                            nome = ler.nextLine();
                        } while (nome.trim().isEmpty() || nome.length() < 2);
                        break;
                    case 2:
                        do {
                            System.out.print("Novo Email: ");
                            email = ler.nextLine();
                        } while (!Validacao.validarEmail(email));
                        break;
                    case 3:
                        do {
                            System.out.print("Novo Telefone: ");
                            telefone = ler.nextLine();
                        } while (!Validacao.validarTelefone(telefone));
                        break;
                    case 4:
                        do {
                            System.out.print("Nova Senha: ");
                            senha = ler.nextLine();
                        } while (!Validacao.validarSenha(senha));
                        break;
                    case 5:
                        do {
                            System.out.print("Novo CPF: ");
                            cpf = ler.nextLine();
                        } while (!Validacao.validarCpf(cpf));
                        break;
                    case 6:
                        while (dataNascimento == null) {
                            System.out.print("Nova Data de Nascimento (dd/MM/yyyy): ");
                            String dataNascimentoStr = ler.nextLine();
                            try {
                                dataNascimento = LocalDate.parse(dataNascimentoStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                if (dataNascimento.isAfter(LocalDate.now())) {
                                    System.out.println("Data de nascimento não pode ser no futuro.");
                                    dataNascimento = null;
                                }
                            } catch (Exception e) {
                                System.out.println("Data inválida. Tente novamente.");
                            }
                        }
                        break;
                    case 7:
                        System.out.print("Novo Endereço: ");
                        endereco = ler.nextLine();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Opção inválida. Digite 'S', 'N' ou uma opção válida para editar (1-7).");
            }
        }
    
        return new Paciente(nome, email, telefone, senha, cpf, dataNascimento, endereco, null, null, null);
    }
    

    public Medico showCadastroMedico() {
        System.out.println("=== Cadastro de Médico ===");
    
        String nome, email, senha, especialidade, crm, telefone;
    
        do {
            System.out.print("Nome: ");
            nome = ler.nextLine();
        } while (nome.trim().isEmpty() || nome.length() < 2);
    
        do {
            System.out.print("Email: ");
            email = ler.nextLine();
            if (!Validacao.validarEmail(email)) {
                System.out.println("Email inválido! Certifique-se de que o email contém '@' e termina com '.com'.");
            }
        } while (!Validacao.validarEmail(email));
    
        do {
            System.out.print("Senha: ");
            senha = ler.nextLine();
        } while (!Validacao.validarSenha(senha));
    
        do {
            System.out.print("Especialidade: ");
            especialidade = ler.nextLine();
        } while (especialidade.trim().isEmpty());
    
        do {
            System.out.print("CRM: ");
            crm = ler.nextLine();
        } while (!Validacao.validarCrm(crm));
    
        do {
            System.out.print("Telefone: ");
            telefone = ler.nextLine();
            if (!Validacao.validarTelefone(telefone)) {
                System.out.println("Telefone inválido! Digite um número válido (exemplo: (11) 91234-5678).");
            }
        } while (!Validacao.validarTelefone(telefone));
    
        while (true) {
            System.out.println("\n=== Confirmação de Cadastro ===");
            System.out.println("1. Nome: " + nome);
            System.out.println("2. Email: " + email);
            System.out.println("3. Senha: (oculta)");
            System.out.println("4. Especialidade: " + especialidade);
            System.out.println("5. CRM: " + crm);
            System.out.println("6. Telefone: " + telefone);
    
            System.out.print("\nConfirmar cadastro? (S/N) ou editar uma opção (1-6): ");
            String confirmacao = ler.nextLine().trim().toUpperCase();
    
            if (confirmacao.equals("S")) {
                break;
            } else if (confirmacao.equals("N")) {
                System.out.println("Cadastro cancelado.");
                return null;
            } else if (confirmacao.matches("[1-6]")) {
                int opcao = Integer.parseInt(confirmacao);
                switch (opcao) {
                    case 1:
                        do {
                            System.out.print("Novo Nome: ");
                            nome = ler.nextLine();
                        } while (nome.trim().isEmpty() || nome.length() < 2);
                        break;
                    case 2:
                        do {
                            System.out.print("Novo Email: ");
                            email = ler.nextLine();
                        } while (!Validacao.validarEmail(email));
                        break;
                    case 3:
                        do {
                            System.out.print("Nova Senha: ");
                            senha = ler.nextLine();
                        } while (!Validacao.validarSenha(senha));
                        break;
                    case 4:
                        do {
                            System.out.print("Nova Especialidade: ");
                            especialidade = ler.nextLine();
                        } while (especialidade.trim().isEmpty());
                        break;
                    case 5:
                        do {
                            System.out.print("Novo CRM: ");
                            crm = ler.nextLine();
                        } while (!Validacao.validarCrm(crm));
                        break;
                    case 6:
                        do {
                            System.out.print("Novo Telefone: ");
                            telefone = ler.nextLine();
                        } while (!Validacao.validarTelefone(telefone));
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Opção inválida. Digite 'S', 'N' ou uma opção válida para editar (1-6).");
            }
        }
    
        return new Medico(nome, email, senha, especialidade, crm, telefone);
    }
    
}
