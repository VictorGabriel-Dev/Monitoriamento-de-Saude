package view;

import java.util.Scanner;
import model.Medico;

public class MedicoView extends BaseView<Medico> {

    @Override
    public int menu(Scanner ler) {
        System.out.println("\n********** Menu Medico **********");
        System.out.println("1. Consultar dados");
        System.out.println("2. Plano do paciente");
        System.out.println("3. Consultar Agendamento");
        System.out.println("4. Sair");
        return ler.nextInt();
    }

    @Override
    public int selecionarQualAlterar(Scanner ler) {
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
    public void alterarDados(Scanner ler, Medico medico) {
        int opcao;
        do {
            opcao = selecionarQualAlterar(ler);
            ler.nextLine();
            String dadoAnterior = null;
            boolean confirmacao = false;

            switch (opcao) {
                case 1:
                    dadoAnterior = medico.getNome();
                    medico.setNome(solicitarEntrada(ler, "Digite o novo nome: "));
                    confirmacao = confirmarAlteracao(ler);
                    if (!confirmacao) medico.setNome(dadoAnterior);
                    break;
                case 2:
                    dadoAnterior = medico.getEspecialidade();
                    medico.setEspecialidade(solicitarEntrada(ler, "Digite a nova especialidade: "));
                    confirmacao = confirmarAlteracao(ler);
                    if (!confirmacao) medico.setEspecialidade(dadoAnterior);
                    break;
                case 3:
                    dadoAnterior = medico.getCrm();
                    medico.setCrm(solicitarEntrada(ler, "Digite o novo CRM: "));
                    confirmacao = confirmarAlteracao(ler);
                    if (!confirmacao) medico.setCrm(dadoAnterior);
                    break;
                case 4:
                    dadoAnterior = medico.getTelefone();
                    medico.setTelefone(solicitarEntrada(ler, "Digite o novo telefone: "));
                    confirmacao = confirmarAlteracao(ler);
                    if (!confirmacao) medico.setTelefone(dadoAnterior);
                    break;
                case 5:
                    dadoAnterior = medico.getEmail();
                    medico.setEmail(solicitarEntrada(ler, "Digite o novo e-mail: "));
                    confirmacao = confirmarAlteracao(ler);
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
