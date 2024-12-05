package view;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import model.Medico;
import model.Paciente;

import java.time.LocalDate;
import java.time.ZoneId;


public class CadastroView {

    public Paciente showCadastroPaciente(Scanner ler) {
        System.out.println("=== Cadastro de Paciente ===");

        System.out.print("Nome: ");
        String nome = ler.nextLine();

        String email = "";
        boolean emailValido = false;
        while (!emailValido) {
            System.out.print("Email: ");
            email = ler.nextLine();
            if (validarEmail(email)) {
                emailValido = true;
            } else {
                System.out.println("Email inválido! Certifique-se de que o email contém '@' e termina com '.com'.");
            }
        }

        System.out.print("Telefone: ");
        String telefone = ler.nextLine();
        while (!validarTelefone(telefone)) {
            System.out.println("Telefone inválido! Digite um número válido (exemplo: (11) 91234-5678).");
            System.out.print("Telefone: ");
            telefone = ler.nextLine();
        }

        System.out.print("Senha: ");
        String senha = ler.nextLine();
        while (!validarSenha(senha)) {
            System.out.println("Senha inválida! A senha deve ter no mínimo 6 caracteres.");
            System.out.print("Senha: ");
            senha = ler.nextLine();
        }

        System.out.print("CPF: ");
        String cpf = ler.nextLine();
        while (!validarCpf(cpf)) {
            System.out.println("CPF inválido! Digite um CPF válido.");
            System.out.print("CPF: ");
            cpf = ler.nextLine();
        }

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

        String email = "";
        boolean emailValido = false;
        while (!emailValido) {
            System.out.print("Email: ");
            email = ler.nextLine();
            if (validarEmail(email)) {
                emailValido = true;
            } else {
                System.out.println("Email inválido! Certifique-se de que o email contém '@' e termina com '.com'.");
            }
        }

        System.out.print("Senha: ");
        String senha = ler.nextLine();
        while (!validarSenha(senha)) {
            System.out.println("Senha inválida! A senha deve ter no mínimo 6 caracteres.");
            System.out.print("Senha: ");
            senha = ler.nextLine();
        }

        System.out.print("Especialidade: ");
        String especialidade = ler.nextLine();

        System.out.print("CRM: ");
        String crm = ler.nextLine();

        while (!validarCrm(crm)) {
            System.out.println("CRM inválido! Digite um CRM válido.");
            System.out.print("CRM: ");
            crm = ler.nextLine();
        }

        System.out.print("Telefone: ");
        String telefone = ler.nextLine();
        while (!validarTelefone(telefone)) {
            System.out.println("Telefone inválido! Digite um número válido (exemplo: (11) 91234-5678).");
            System.out.print("Telefone: ");
            telefone = ler.nextLine();
        }

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

    private boolean validarEmail(String email) {
        return email.contains("@") && email.endsWith(".com");
    }

    private boolean validarTelefone(String telefone) {
        String regex = "\\(\\d{2}\\) \\d{5}-\\d{4}";
        return telefone.matches(regex);
    }

    private boolean validarSenha(String senha) {
        return senha.length() >= 6;
    }

    private boolean validarCpf(String cpf) {
        return cpf.matches("\\d{11}");
    }

    private boolean validarCrm(String crm) {
        return crm.matches("\\d{6}");
    }
}
