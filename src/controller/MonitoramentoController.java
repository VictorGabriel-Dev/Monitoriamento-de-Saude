
package controller;

import model.*;
import view.MonitoramentoView;

import java.util.*;

public class MonitoramentoController {
    private MonitoramentoView view;
    private Paciente paciente;
    ArrayList<Paciente> pacientes = new ArrayList<>();
    private AlertaMenuController alertaController;
    private ConsultaController consultaController;
    private Scanner sc;

    public MonitoramentoController(List<Paciente> pacientes) {
        this.sc = new Scanner(System.in);
        this.pacientes = new ArrayList<>();

    }

    public void menuMonitoramento() {
        System.out.println("--- Menu Monitoramento ---");
        System.out.println("1. Dados de monitoração");
        System.out.println("2. Análise");
        System.out.println("3. Sair");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1://tem um pequeno problema na lista, ela nao esta puxando a lista de pacientes
                exibirPacientes();
                break;
            case 2:
                Analise();
                break;
            case 3:
                return;
            default:
                System.out.println("Valor inválido!");
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
                        exibirMedicamentos(paciente);
                    } catch (Exception e) {
                        view.exibirMensagem("Método de exibição de medicamentos não implementado ainda.");
                    }
                    break;
                case 3:
                    try {
                        view.exibirMensagem("\n--- Diagnosticos ---");
                        exibirDiagnostico(paciente);
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
        List<Medicamento> medicamento = paciente.getMedicamentos();
        if(medicamento == null){
            view.exibirMensagem("Nenhum medicamento registrado para esse paciente.");
        } else{
            view.dadosMedicamento(null);
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
    }
}
