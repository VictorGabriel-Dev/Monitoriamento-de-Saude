
package controller;

import model.*;
import controller.*;
import view.AlertaView;
import view.DispositivoView;
import view.MonitoramentoView;

import java.util.*;

public class MonitoramentoController {
    private MonitoramentoView view;
    private MedicoController medicoController;
    private Medico medico;
    private Paciente pacienteSelecionado;
    private AlertaMenuController alertaController;
    private ConsultaController consultaController;

    private Scanner sc = new Scanner(System.in);

    public MonitoramentoController(MonitoramentoView view, MedicoController medicoController) {
        this.view = view;
        this.medicoController = medicoController;
        // Lista alertas
        AlertaView alertaView = new AlertaView();
        List<AlertaModel> alertas = new ArrayList<>();
        this.alertaController = new AlertaMenuController(alertaView,alertas);
        // Lista historico
        List<Consulta> consultas = new ArrayList<>();
        this.consultaController = new ConsultaController(pacienteSelecionado);
        // Lista Medicamentos
        List<Paciente> medicamento = new ArrayList<>();
    }

    public void menuMonitoramento() {
        boolean continuar = true;
        //Selecionar paciente
        String pacienteSelecionado = medicoController.selecionePaciente();
        if (pacienteSelecionado != null) {
            System.out.printf("\nPaciente selecionado: %s",pacienteSelecionado);
            System.out.println();
        }

        while(continuar){
            int escolha = view.exibirMenuMonitoramento();
            switch (escolha) {
                case 1:
                    medicoController.dadosMedico();
                    break;
                case 2:
                    Analise();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    view.exibirMensagem("Valor inválido!");
            }
        }
    }

    //É necessario fazer a integração com as outras classes
    //Menu Analise
    public void Analise() {
        int escolha = 9;
        do {
            System.out.println("\n--- Menu Analise ---");
            System.out.println("1. Historico de consultas");
            System.out.println("2. Medicamentos");
            System.out.println("3. Diagnosticos");
            System.out.println("4. Lista de alertas");
            System.out.println("0. voltar");
            escolha = sc.nextInt();
            sc.nextLine(); // Consumir

            switch (escolha) {
                case 1:
                    try {
                        view.exibirMensagem("\n--- Historico de consultas ---");
                        consultaController.consultarHistorico();
                    } catch (Exception e) {
                        view.exibirMensagem("Método de histórico de consultas não implementado ainda.");
                    }
                    break;
                case 2:
                    try {
                        view.exibirMensagem("\n--- Medicamentos ---");
                        exibirMedicamentos(pacienteSelecionado);
                    } catch (Exception e) {
                        view.exibirMensagem("Método de exibição de medicamentos não implementado ainda.");
                    }
                    break;
                case 3:
                    try {
                        view.exibirMensagem("\n--- Diagnosticos ---");
                        exibirDiagnostico(pacienteSelecionado);
                    } catch (Exception e) {
                        view.exibirMensagem("Método de exibição de diagnósticos não implementado ainda.");
                    }
                    break;
                case 4:
                    try {
                        alertaController.listarAlertas();
                    } catch (Exception e) {
                        view.exibirMensagem("Método de listagem de alertas não implementado ainda.");
                    }
                    break;
                case 0:
                    view.exibirMensagem("Voltando... ");
                    return;
                default:
                    view.exibirMensagem("Valor inválido! Tente novamente.");
            }
        } while (escolha != 0);
    }
    public void exibirMedicamentos(Paciente paciente){
        Medicamento medicamento = paciente.getMedicamentos();
        if(medicamento == null){
            view.exibirMensagem("Nenhum medicamento registrado para esse paciente.");
        } else{
            view.dadosMedicamento(medicamento);
        }
    }
    public void exibirDiagnostico(Paciente paciente){
        List<Consulta> consultas = paciente.getHistoricoMedico();
        if(consultas == null || consultas.isEmpty()){
            view.exibirMensagem("Nenhum diagnostico registrado para esse paciente.");
        } else{
            for(int i=0; i < consultas.size(); i++){
                Consulta consulta = consultas.get(i);
                System.out.printf("[%d] - Diagnóstico: %s%n", i + 1, consulta.getDiagnostico());
            }
        }
    }
}
