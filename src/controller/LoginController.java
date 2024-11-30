package controller;
import java.util.Scanner;

import model.Paciente;
import model.PacienteController;
import model.Medico;
import model.UsuarioModel;
import model.UsuarioRepositorio;
import view.LoginView;
import view.MedicoView;
import view.PacienteView;

public class LoginController {
    private Scanner ler;
    private LoginView view;
    private UsuarioRepositorio repositorio;
    private UsuarioModel usuarioLogado;
    private PacienteView pacienteView;
    private MedicoView medicoView;

    public LoginController() {
        this.ler = new Scanner(System.in);
        this.view = new LoginView();
        this.repositorio = UsuarioRepositorio.getInstance();
        this.usuarioLogado = null;
    }
    public void entrar() {
        UsuarioModel usuario = view.formLogin(ler);
        UsuarioModel usuarioAutenticado = autenticarUsuario(usuario.getEmail(), usuario.getSenha());
        this.usuarioLogado = usuarioAutenticado;
        view.mensagemAposLogin(usuarioAutenticado);
        exibirMenu();
    }
    private UsuarioModel autenticarUsuario(String email, String senha) {
        for (UsuarioModel usuario : repositorio.getUsuarios()) {
            if (usuario.getEmail().trim().equals(email)&& usuario.getSenha().trim().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }
    public void exibirMenu() {
    if (usuarioLogado instanceof Paciente) {
        pacienteView = new PacienteView();
        pacienteView.menuPaciente(ler);
        PacienteController pacienteController = new PacienteController((Paciente) usuarioLogado);
    } else if (usuarioLogado instanceof Medico) {
        medicoView = new MedicoView();
        medicoView.menuMedico(ler);
    }
}

    public UsuarioModel getUsuarioLogado() {
        return usuarioLogado;
    }

}