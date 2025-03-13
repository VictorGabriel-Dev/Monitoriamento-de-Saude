package controller;

import java.util.ArrayList;
import java.util.List;

import model.AlertaModel;
import model.Medico;
import model.Paciente;
import model.UsuarioModel;
import model.UsuarioRepositorio;
import utils.DataHora;
import utils.Mensagem;
import view.AlertaView;

public class AlertaController {
    private List<AlertaModel> alertas;
    private AlertaView view;
    private List<Paciente> pacientes;
    private Medico medico;
    private UsuarioRepositorio repositorio;

    public AlertaController(Medico medico) {
        this.view = new AlertaView();
        this.alertas = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.medico = medico;
        this.repositorio = UsuarioRepositorio.getInstance();
    }

    public void alertaMenu() {
        int escolha;
        do {
            escolha = view.mostrarMenu();
            switch (escolha) {
                case 0:
                    Mensagem.mensagemSair();
                    break;
                case 1:
                    adicionarAlerta();
                    break;
                case 2:
                    listarAlertas();
                    break;
                case 3:
                    boolean sucesso = finalizarAlerta();
                    if (!sucesso) {
                        Mensagem.mensagemValorInvalido();
                    }
                    break;
                default:
                    Mensagem.mensagemValorInvalido();
            }
        } while (escolha != 0);
    }

    public void adicionarAlerta() {
        if (pacientes.isEmpty()) {
            carregarPacientes();
        }

        AlertaModel novoAlerta = criarAlerta();
        if (novoAlerta != null) {
            alertas.add(novoAlerta);
            Mensagem.mensagemAlertaSucesso();
        } else {
            Mensagem.mensagemAlertaErro();
        }
    }

    private AlertaModel criarAlerta() {
        String tipo = view.tipoEscolhido();
        String mensagem = view.getMensagem();

        listarPacientesDisponiveis();
        int indexPaciente = view.getPacienteEscolhido() - 1;

        if (indexPaciente < 0 || indexPaciente >= pacientes.size()) {
            return null;
        }

        Paciente pacienteSelecionado = pacientes.get(indexPaciente);
        String data = DataHora.getDataHoraAtual();
        
        return new AlertaModel(tipo, mensagem, pacienteSelecionado, medico, data);
    }

    private void listarPacientesDisponiveis() {
        Mensagem.mensagemLista();
        for (int i = 0; i < pacientes.size(); i++) {
            view.escolherPaciente((i + 1), pacientes.get(i).getNome(), pacientes.get(i).getCpf());
        }
    }

    private void carregarPacientes() {
        for (UsuarioModel usuario : repositorio.getUsuarios()) {
            if (usuario instanceof Paciente) {
                pacientes.add((Paciente) usuario);
            }
        }
    }

    public boolean finalizarAlerta() {
        int index = view.mostrarFinalizarAlerta();
        if (index >= 0 && index < alertas.size()) {
            alertas.remove(index);
            Mensagem.mensagemAlertaFinalizado();
            return true;
        } else {
            Mensagem.mensagemValorInvalido();
            return false;
        }
    }

    public void listarAlertas() {
        if (alertas.isEmpty()) {
            Mensagem.mostrarMensagemSemAlertas();
            return;
        }
        for (AlertaModel alerta : alertas) {
            view.mostrarListaAlertas(alerta.getTipo(), alerta.getMensagem(), alerta.getPaciente().getNome(),
                    alerta.getMedico().getNome(), alerta.getData());
        }
    }

}
