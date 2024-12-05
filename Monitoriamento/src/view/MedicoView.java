package view;
import model.Medico;

public class MedicoView extends BaseView<Medico> {
    @Override
    public int menu() {
        System.out.println("\n********** Menu Medico **********");
        System.out.println("1. Consultar dados");
        System.out.println("2. Plano do paciente");
        System.out.println("3. Consultar Agendamento");
        System.out.println("4. Menu dispositivo");
        System.out.println("5. Menu Alerta");//Falta implementar
        System.out.println("6. Menu Monitoramento");//Falta implementar
        System.out.println("7. Sair");
        return ler.nextInt();
    }

    @Override
    public int selecionarQualAlterar() {
        System.out.println("\n********** Alterar Dados **********");
        System.out.println("1 - Nome");
        System.out.println("2 - Especialidade");
        System.out.println("3 - CRM");
        System.out.println("4 - Telefone");
        System.out.println("5 - E-mail");
        System.out.println("6 - Voltar");
        System.out.print("Escolha o dado a ser alterado: ");
        return ler.nextInt();
    }

    @Override
    public void alterarDados(Medico medico) {
        int opcao;
        do {
            opcao = selecionarQualAlterar();
            ler.nextLine();
            String dadoAnterior = null;
            boolean confirmacao = false;

            switch (opcao) {
                case 1:
                    dadoAnterior = medico.getNome();
                    medico.setNome(solicitarEntrada("Digite o novo nome: "));
                    confirmacao = confirmarAlteracao();
                    if (!confirmacao) medico.setNome(dadoAnterior);
                    break;
                case 2:
                    dadoAnterior = medico.getEspecialidade();
                    medico.setEspecialidade(solicitarEntrada("Digite a nova especialidade: "));
                    confirmacao = confirmarAlteracao();
                    if (!confirmacao) medico.setEspecialidade(dadoAnterior);
                    break;
                case 3:
                    dadoAnterior = medico.getCrm();
                    medico.setCrm(solicitarEntrada( "Digite o novo CRM: "));
                    confirmacao = confirmarAlteracao();
                    if (!confirmacao) medico.setCrm(dadoAnterior);
                    break;
                case 4:
                    dadoAnterior = medico.getTelefone();
                    medico.setTelefone(solicitarEntrada( "Digite o novo telefone: "));
                    confirmacao = confirmarAlteracao();
                    if (!confirmacao) medico.setTelefone(dadoAnterior);
                    break;
                case 5:
                    dadoAnterior = medico.getEmail();
                    medico.setEmail(solicitarEntrada( "Digite o novo e-mail: "));
                    confirmacao = confirmarAlteracao();
                    if (!confirmacao) medico.setEmail(dadoAnterior);
                    break;
                case 6:
                    return;
                default:
                    exibirMensagem("Opção inválida!");
            }

            if (confirmacao) exibirMensagem("Alteração confirmada com sucesso!");
            else exibirMensagem("Alteração cancelada.");

        } while (opcao != 6);
    }

}
