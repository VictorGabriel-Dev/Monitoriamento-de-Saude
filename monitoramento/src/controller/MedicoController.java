package controller;

import model.*;
import view.AlertaView;
import view.MedicoView;
import view.MonitoramentoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicoController {
    private Medico medico;
    private MedicoView medicoView;
    private ConsultaController consultaController;
    private DispositivoController dispositivoController;
    private MonitoramentoView monitoramentoView;
    private Scanner sc = new Scanner(System.in);
    private List<AlertaModel> alertas = new ArrayList<>();

    // Construtor
    public MedicoController(Medico medico) {
        this.medico = medico;
        this.medicoView = new MedicoView();
        this.consultaController = new ConsultaController(null); // Aqui você pode passar a referência adequada
        this.dispositivoController = new DispositivoController();
        this.monitoramentoView = new MonitoramentoView();
        this.alertas = new ArrayList<>();
    }

    public void dadosMedico() {
        medicoView.exibirDados(medico);
    }
    public void alterarEVoltar() {
        int opcao;
        do {
            opcao = medicoView.opcoesAlterarEVoltar();
            switch (opcao) {
                case 1:
                    medicoView.alterarDados(medico);
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
                    AlertaMenuController controller = new AlertaMenuController(view,alertas);
                    controller.alertaMenu();
                    break;
                case 6:
                    MedicoController medicoController = new MedicoController(medico);
                    MonitoramentoController monitoramentoController = new MonitoramentoController(monitoramentoView,medicoController);
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
                System.out.println("Paciente: " + consulta.getPaciente().getNome() + ", Data: " + consulta.getDataConsulta());
            }
        } else {
            System.out.println("Não há consultas agendadas.");
        }
    }


    //metodo lista de paciente
    public String selecionePaciente() {
        List<String> nomes = Paciente.getNomesCadastrados();

        if (nomes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return null;
        }

        System.out.println("\n--- Lista de Pacientes ---");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println((i + 1) + ". " + nomes.get(i));
        }

        System.out.print("Selecione o número do paciente (ou 0 para voltar): ");
        int escolha = sc.nextInt();
        sc.nextLine(); // Limpa o buffer do scanner

        if (escolha == 0) {
            return null; // Voltar sem selecionar
        } else if (escolha > 0 && escolha <= nomes.size()) {
            return nomes.get(escolha - 1); // Retorna o nome do paciente selecionado
        } else {
            System.out.println("Opção inválida!");
            return null;
        }
    }
}
