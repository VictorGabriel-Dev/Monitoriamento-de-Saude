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
        this.consultas.add(consulta);
        view.mensagemSucesso();
    }

    public void editarConsulta(Scanner ler, Consulta consulta) {
        Consulta novaConsulta = view.formAddConsulta(ler, paciente, medicosDisponiveis, consultas);
    
        if (novaConsulta != null) {
            consulta.setDataConsulta(novaConsulta.getDataConsulta());
            consulta.setHoraConsulta(novaConsulta.getHoraConsulta());
            consulta.setMedico(novaConsulta.getMedico());
            view.mensagemSucesso();
        } else {
            view.exibirMensagemErro("Não foi possível editar a consulta devido a um conflito de horário ou erro de entrada.");
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
                    editarConsulta(ler, consulta);
                    return;
                case 3:
                    cancelarConsulta(consulta);
                    return;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
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
