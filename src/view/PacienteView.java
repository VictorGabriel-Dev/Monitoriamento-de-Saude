package view;
import model.Paciente;
import java.time.LocalDate;
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

    @Override
    public void alterarDados(Paciente paciente) {
        int opcao;
        do {
            opcao = selecionarQualAlterar();
            ler.nextLine();
            String dadoAnterior = null;
            boolean confirmacao = false;

            switch (opcao) {
                case 1:
                    dadoAnterior = paciente.getNome();
                    paciente.setNome(solicitarEntrada("Digite o novo nome: "));
                    confirmacao = confirmarAlteracao();
                    if (!confirmacao) paciente.setNome(dadoAnterior);
                    break;
                case 2:
                    dadoAnterior = paciente.getCpf();
                    paciente.setCpf(solicitarEntrada("Digite o novo CPF: "));
                    confirmacao = confirmarAlteracao();
                    if (!confirmacao) paciente.setCpf(dadoAnterior);
                    break;
                case 3:
                    dadoAnterior = paciente.getDataNascimento().toString();
                    paciente.setDataNascimento(LocalDate.parse(solicitarEntrada( "Digite a nova data de nascimento (AAAA-MM-DD): ")));
                    confirmacao = confirmarAlteracao();
                    if (!confirmacao) paciente.setDataNascimento(LocalDate.parse(dadoAnterior));
                    break;
                case 4:
                    dadoAnterior = paciente.getEndereco();
                    paciente.setEndereco(solicitarEntrada("Digite o novo endereço: "));
                    confirmacao = confirmarAlteracao();
                    if (!confirmacao) paciente.setEndereco(dadoAnterior);
                    break;
                case 5:
                    dadoAnterior = paciente.getTelefone();
                    paciente.setTelefone(solicitarEntrada("Digite o novo telefone: "));
                    confirmacao = confirmarAlteracao();
                    if (!confirmacao) paciente.setTelefone(dadoAnterior);
                    break;
                case 6:
                    dadoAnterior = paciente.getEmail();
                    paciente.setEmail(solicitarEntrada("Digite o novo e-mail: "));
                    confirmacao = confirmarAlteracao();
                    if (!confirmacao) paciente.setEmail(dadoAnterior);
                    break;
                case 7:
                    return;
                default:
                    exibirMensagem("Opção inválida!");
            }

            if (confirmacao) exibirMensagem("Alteração confirmada com sucesso!");
            else exibirMensagem("Alteração cancelada.");

        } while (opcao != 7);
    }
}
