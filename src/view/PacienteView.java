package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import model.Paciente;
import utils.PacienteInputType;

public class PacienteView extends BaseView<Paciente> {
    @Override
    public int menu() {
        System.out.println("\n********** Menu Paciente **********");
        System.out.println("1. Consultar dados");
        System.out.println("2. Histórico");
        System.out.println("3. Consulta");
        System.out.println("4. Dispositivo");
        System.out.println("5. Sair");
        return ler.nextInt();
    }

    @Override
    public int selecionarQualAlterar() {
        System.out.println("\n********** Alterar Dados **********");
        System.out.println("1 - Nome");
        System.out.println("2 - CPF");
        System.out.println("3 - Data de Nascimento");
        System.out.println("4 - Endereço");
        System.out.println("5 - Telefone");
        System.out.println("6 - E-mail");
        System.out.println("7 - Voltar");
        System.out.print("Escolha o dado a ser alterado: ");

        return validateIntInput("Escolha o dado a ser alterado: ");
    }

    public String solicitarInput(PacienteInputType tipo) {
        switch (tipo) {
            case NOME:
                return solicitarEntrada("Digite o novo nome: ");
            case CPF:
                return solicitarEntrada("Digite o novo CPF: ");
            case DATA_NASCIMENTO:
                return solicitarDataNascimento();
            case ENDERECO:
                return solicitarEntrada("Digite o novo endereço: ");
            case TELEFONE:
                return solicitarEntrada("Digite o novo telefone: ");
            case EMAIL:
                return solicitarEntrada("Digite o novo e-mail: ");
            default:
                return null;
        }
    }

    private String solicitarDataNascimento() {
        while (true) {
            System.out.print("Digite a nova data de nascimento (dd/MM/yyyy): ");
            String dataString = ler.nextLine();
            try {
                LocalDate dataNascimento = parseDataNascimento(dataString);
                return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Por favor, digite novamente.");
            }
        }
    }

    public LocalDate parseDataNascimento(String dataString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataString, formatter);
    }
}
