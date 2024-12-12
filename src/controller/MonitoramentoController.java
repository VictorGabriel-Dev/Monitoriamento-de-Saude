
package controller;

import model.*;
import view.MedicoView;
import view.MonitoramentoView;
import java.util.*;

public class MonitoramentoController {
    private MonitoramentoView view;
    private Paciente paciente;
    ArrayList<Paciente> pacientes = new ArrayList<>();
    private AlertaMenuController alertaController;
    private ConsultaController consultaController;
    private Scanner sc;
    private MedicoView medicoView;
    private MedicoController  medicoController;

    public MonitoramentoController() {
        this.sc = new Scanner(System.in);
        this.pacientes = new ArrayList<>();
        this.view = new MonitoramentoView();
        this.alertaController = new AlertaMenuController();
        this.consultaController = new ConsultaController(paciente);
        this.medicoView = new MedicoView();
    }

    public void menuMonitoramento() {
        int escolha = view.exibirMenuMonitoramento();
        sc.nextLine();
        switch (escolha) {
            case 1:
                exibirPacientes();
                break;
            case 2:
                return;
            default:
                System.out.println("Valor inválido!");
        }
    }

    // É necessario fazer a integração com as outras classes
    // Menu Analise
    public void Analise(Paciente paciente) {
        int escolha;
        do {
            escolha = medicoView.opcoesDoPefilPaciente();
            sc.nextLine();
            switch (escolha) {
                case 1:
                    consultaController.consultarHistorico(paciente);
                    break;
                case 2:
                    medicoController.exibirPlanoTratamento(paciente);
                    break;
                case 3:
                    try {
                        alertaController.listarAlertas();
                    } catch (Exception e) {
                        view.exibirMensagem("Método de listagem de alertas não implementado ainda.");
                    }
                    break;
                case 4:
                    return;
                default:
                    view.exibirMensagem("Valor inválido! Tente novamente.");
            }
        } while (escolha != 0);
    }

    public void exibirDiagnostico() {
        List<Consulta> consultas = paciente.getHistoricoMedico();
        if (consultas == null || consultas.isEmpty()) {
            view.exibirMensagem("Nenhum diagnostico registrado para esse paciente.");
        } else {
            for (int i = 0; i < consultas.size(); i++) {
                Consulta consulta = consultas.get(i);
                System.out.printf("[%d] - Diagnóstico: %s%n", i + 1, consulta.getDiagnostico());
            }
        }
    }

    public void exibirPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente para monitorar.");
            return;
        }
        System.out.println("\n--- Lista de Pacientes Monitorados ---");
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente paciente = pacientes.get(i);
            System.out.println((i + 1) + ". " + paciente.getNome() + " (CPF: " + paciente.getCpf() + ")");
        }
        System.out.println("Selecione o número do paciente (ou 0 para voltar): ");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 0:
                menuMonitoramento();
                return;
            default:
                if (escolha < 1 || escolha > pacientes.size()) {
                    System.out.println("Opção inválida! Tente novamente.");
                    return;
                }
                exibirDadosMonitoracao(pacientes.get(escolha - 1));
                break;
        }

        Paciente pacienteSelecionado = pacientes.get(escolha - 1);
        int opcao = view.monitoramentoPaciente(pacienteSelecionado);
        switch (opcao) {
            case 1:
                exibirDadosMonitoracao(pacienteSelecionado);
                break;
            case 2:
                System.out.println("Gerar alerta");
                break;
            case 3:
                System.out.println("Analise");
                break;
            case 4:
                System.out.println("Voltar");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    public void exibirDadosMonitoracao(Paciente paciente) {
        if (paciente == null) {
            view.exibirDadosMonitoracao(null, null);
            return;
        }
        view.exibirDadosMonitoracao(paciente.getNome(), paciente.getCpf());
    }

}
