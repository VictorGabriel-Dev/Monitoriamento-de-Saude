package controller;

import model.*;
import view.AlertaView;
import view.MedicoView;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicoController extends BaseController<Medico> {
    private Scanner sc;
    private Medico medico;
    private MedicoView medicoView;
    private ConsultaController consultaController;
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<DispositivoModel> dispositivos = new ArrayList<>();
    private DispositivoController dispositivoController;
    private UsuarioRepositorio repositorio;

    public MedicoController(Medico medico) {
        this.medico = medico;
        this.medicoView = new MedicoView();
        this.consultaController = new ConsultaController(null);
        this.dispositivoController = new DispositivoController();
        this.pacientes = new ArrayList<>();
        this.dispositivos = new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.repositorio = UsuarioRepositorio.getInstance();
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
                if (opcao == 1)
                    medico.setNome(dadoAnterior);
                if (opcao == 2)
                    medico.setEspecialidade(dadoAnterior);
                if (opcao == 3)
                    medico.setCrm(dadoAnterior);
                if (opcao == 4)
                    medico.setTelefone(dadoAnterior);
                if (opcao == 5)
                    medico.setEmail(dadoAnterior);
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
                    selecionarPaciente();
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
                    MonitoramentoController monitoramentoController = new MonitoramentoController(pacientes);
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
        if (medico.getConsultas() != null && !medico.getConsultas().isEmpty()) {
            medicoView.exibirConsultasAgendadas(medico.getNome(), medico.getConsultas());
            int opcao = medicoView.selecionarConsulta();
            if (opcao != 0) {
                Consulta consultaSelecionada = medico.getConsultas().get(opcao - 1);
                medicoView.exibirDetalhesConsulta(consultaSelecionada);
                exibirOpcoesConsulta(consultaSelecionada);
            }
        } else {
            medicoView.naoHaConsultas();
        }
    }

    public void exibirOpcoesConsulta(Consulta consulta) {
        int opcao;

        do {
            opcao = medicoView.exibirOpcoesConsulta();
            switch (opcao) {
                case 1:
                    fazerDiagnostico(consulta);
                    break;
                case 2:
                    alterarDiagnostico(consulta);
                    break;
                case 3:
                    registrarPrescricao(consulta);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }

    public void fazerDiagnostico(Consulta consulta) {
        System.out.println("Digite o diagnóstico para o paciente " + consulta.getPaciente().getNome() + ": ");
        String diagnostico = sc.nextLine();
        consulta.adicionarDiagnostico(diagnostico);
        System.out.println("Diagnóstico registrado!");
    }

    public void alterarDiagnostico(Consulta consulta) {
        System.out.println("Digite o novo diagnóstico para o paciente " + consulta.getPaciente().getNome() + ": ");
        String diagnostico = sc.nextLine();
        consulta.alterarDiagnostico(0, diagnostico);
        System.out.println("Diagnóstico alterado!");
    }

    public void registrarPrescricao(Consulta consulta) {
        System.out.println("Digite a prescrição para o paciente " + consulta.getPaciente().getNome() + ": ");
        String prescricao = sc.nextLine();
        consulta.setPrescricao(prescricao);
        System.out.println("Prescrição registrada!");
    }

    public Paciente selecionarPaciente() {
        List<UsuarioModel> usuarios = repositorio.getUsuarios();
        List<Paciente> pacientes = new ArrayList<>();

        for (UsuarioModel usuario : usuarios) {
            if (usuario instanceof Paciente) {
                pacientes.add((Paciente) usuario);
            }
        }

        if (pacientes.isEmpty()) {
            medicoView.nenhumPaciente();
            return null;
        }

        medicoView.lista();
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente paciente = pacientes.get(i);
            System.out.println((i + 1) + ". " + paciente.getNome() + " (CPF: " + paciente.getCpf() + ")");
        }

        // Selecionar paciente
        System.out.println("Selecione o número do paciente (ou 0 para voltar): ");
        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha == 0) {
            return null; // Voltar
        }

        if (escolha < 1 || escolha > pacientes.size()) {
            System.out.println("Opção inválida! Tente novamente.");
            return null;
        }

        return pacientes.get(escolha - 1);
    }

}
