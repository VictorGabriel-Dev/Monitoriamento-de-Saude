package view;
import model.Paciente;
public class PacienteView extends BaseView<Paciente> {
    @Override
    public int menu() {
        System.out.println("\n********** Menu Paciente **********");
        System.out.println("1. Consultar dados");
        System.out.println("2. Histórico");
        System.out.println("3. Consulta");
        System.out.println("4. Sair");
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
        return ler.nextInt();
    }
}
