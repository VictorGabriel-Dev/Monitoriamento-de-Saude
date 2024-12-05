package controller;

import model.*;
import view.AlertaView;
import view.MedicoView;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicoController extends BaseController<Medico> {
    private Medico medico;
    private MedicoView medicoView;
    private ConsultaController consultaController;
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<DispositivoModel> dispositivos = new ArrayList<>();
    private DispositivoController dispositivoController;

    public MedicoController(Medico medico) {
        this.medico = medico;
        this.medicoView = new MedicoView();
        this.consultaController = new ConsultaController(null);
        this.dispositivoController = new DispositivoController();

    }

    public void dadosMedico() {
        medicoView.exibirDados(medico);
    }
    @Override
public void alterarDados(Medico medico) {
    int opcao;
    do {
        opcao = medicoView.selecionarQualAlterar();
        String dadoAnterior = null;
        boolean confirmacao = false;

        switch (opcao) {
            case 1:
                dadoAnterior = medico.getNome();
                medico.setNome(solicitarEntrada("Digite o novo nome: "));
                break;
            case 2:
                dadoAnterior = medico.getEspecialidade();
                medico.setEspecialidade(solicitarEntrada("Digite a nova especialidade: "));
                break;
            case 3:
                dadoAnterior = medico.getCrm();
                medico.setCrm(solicitarEntrada("Digite o novo CRM: "));
                break;
            case 4:
                dadoAnterior = medico.getTelefone();
                medico.setTelefone(solicitarEntrada("Digite o novo telefone: "));
                break;
            case 5:
                dadoAnterior = medico.getEmail();
                medico.setEmail(solicitarEntrada("Digite o novo e-mail: "));
                break;
            case 6:
                return; // Sai do menu
            default:
                System.out.println("Opção inválida.");
                continue;
        }

        // Confirmação da alteração
        confirmacao = confirmarAlteracao();
        if (!confirmacao) {
            // Reverte a alteração caso o usuário não confirme
            if (opcao == 1) medico.setNome(dadoAnterior);
            if (opcao == 2) medico.setEspecialidade(dadoAnterior);
            if (opcao == 3) medico.setCrm(dadoAnterior);
            if (opcao == 4) medico.setTelefone(dadoAnterior);
            if (opcao == 5) medico.setEmail(dadoAnterior);
            exibirMensagem("Alteração cancelada.");
        } else {
            exibirMensagem("Alteração confirmada com sucesso!");
        }
    } while (opcao != 6);
}


    public void alterarEVoltar() {
        int opcao;
        do {
            opcao = medicoView.opcoesAlterarEVoltar();
            switch (opcao) {
                case 1:
                    alterarDados(medico);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 2);
    }

    public void menu() {
        int opcao;
        do {
            opcao = medicoView.menu();
            switch (opcao) {
                case 1:
                    dadosMedico();
                    alterarEVoltar();
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal.");
                    break;
                case 3:
                    consultarAgendamentos();
                    break;
                case 4:
                    dispositivoController.menu();
                    break;
                case 5:
                    AlertaView view = new AlertaView();
                    AlertaMenuController controller = new AlertaMenuController(view);
                    controller.alertaMenu();
                    break;
                case 6:
                    MonitoramentoController monitoramentoController = new MonitoramentoController(pacientes); // Certifique-se
                                                                                                              // de que
                                                                                                              // a lista
                                                                                                              // de
                                                                                                              // pacientes
                                                                                                              // foi
                                                                                                              // inicializada
                    monitoramentoController.menuMonitoramento();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 7);
    }

    public void consultarAgendamentos() {
        // Exibe todas as consultas agendadas para o médico
        if (medico.getConsultas() != null && !medico.getConsultas().isEmpty()) {
            System.out.println("Consultas agendadas para o médico " + medico.getNome() + ":");
            for (Consulta consulta : medico.getConsultas()) {
                System.out.println(
                        "Paciente: " + consulta.getPaciente().getNome() + ", Data: " + consulta.getDataConsulta());
            }
        } else {
            System.out.println("Não há consultas agendadas.");
        }
    }

    // metodo lista de paciente
    public static Paciente selecionarPaciente(List<Paciente> pacientes) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Lista de Pacientes ---");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).getNome());
        }

        System.out.println("Selecione o númerio do paciente (ou 0 para voltar)");
        int escolhaPaciente = sc.nextInt();
        sc.nextLine();

        // Voltar ao menu principal
        if (escolhaPaciente == 0) {
            return null;// escolha voltar
        }
        // validando escolha
        if (escolhaPaciente < 1 || escolhaPaciente > pacientes.size()) {
            System.out.println("Opção inválida! Tente novamente.");
            return null;
        }

        // Selecione o paciente com base na escolha
        return pacientes.get(escolhaPaciente - 1);
    }
}