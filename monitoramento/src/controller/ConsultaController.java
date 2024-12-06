package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.UsuarioRepositorio;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.UsuarioModel;
import view.ConsultaView;

public class ConsultaController {
    private ConsultaView view;
    private Paciente paciente;
    private List<Consulta> consultas;
    private List<Medico> medicosDisponiveis;
    private UsuarioRepositorio repositorio;

    public ConsultaController(Paciente paciente) {
        this.view = new ConsultaView();
        this.paciente = paciente;
        this.consultas = new ArrayList<>();
        this.repositorio = UsuarioRepositorio.getInstance();
        this.medicosDisponiveis = new ArrayList<>();
    }

    public void agendarConsulta(Scanner ler, List<Medico> medicosDisponiveis) {
        if (medicosDisponiveis == null || medicosDisponiveis.isEmpty()) {
            medicosDisponiveis = new ArrayList<>();
            for (UsuarioModel usuario : repositorio.getUsuarios()) {
                if (usuario instanceof Medico) {
                    medicosDisponiveis.add((Medico) usuario);
                }
            }
        }

        if (medicosDisponiveis.isEmpty()) {
            System.out.println("Não há médicos disponíveis para agendamento.");
            return;
        }
        Consulta novaConsulta = view.formAddConsulta(ler, paciente, medicosDisponiveis, consultas);
        if (novaConsulta != null) {
            confirmarEditarCancelarConsulta(ler, novaConsulta);
        }
    }

    public void confirmarConsulta(Consulta consulta) {
        // Adiciona a consulta ao histórico do paciente
        this.consultas.add(consulta);
        view.mensagemSucesso();

        // Aqui, você pode adicionar a consulta ao histórico do médico
        Medico medico = consulta.getMedico();
        if (medico != null) {
            // Se o médico não tiver um histórico de consultas, inicialize a lista
            if (medico.getConsultas() == null) {
                medico.setConsultas(new ArrayList<>());
            }
            medico.getConsultas().add(consulta);
            System.out.println("Consulta agendada com sucesso para o médico " + medico.getNome());
        }
    }


    public void cancelarConsulta(Consulta consulta) {
        this.consultas.remove(consulta);
        System.out.println("Consulta cancelada com sucesso.");
    }

    public void confirmarEditarCancelarConsulta(Scanner ler, Consulta consulta) {
        int opcao;
        do {
            opcao = view.opcoesDepoisDeAgendarConsulta(ler);
            switch (opcao) {
                case 1:
                    confirmarConsulta(consulta);
                    return;
                case 2:
                    cancelarConsulta(consulta);
                    return;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);
    }
    public void consultarAgendamentos() {
        view.exibirAgendamentos(consultas);
    }
    public void consultaOpcoes(Scanner ler) {
        int opcao;
        do {
            opcao = view.opcoesAgendarConsultarAgendamento(ler);
            switch (opcao) {
                case 1:
                    agendarConsulta(ler, medicosDisponiveis);
                    break;
                case 2:
                    consultarAgendamentos();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);

    }

    public void consultarHistorico() {
        view.exibirHistoricoMedico(paciente.getHistoricoMedico());
    }

    public void menuHistoricoMedico(Scanner ler) {
        int opcao;
        do {
            opcao = view.menu(ler);
            switch (opcao) {
                case 1:
                    consultarHistorico();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 2);
    }
}
