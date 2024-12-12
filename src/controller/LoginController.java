package controller;
import java.util.Scanner;

import model.Paciente;
import model.Medico;
import model.UsuarioModel;
import model.UsuarioRepositorio;
import utils.Mensagem;
import view.LoginView;

public class LoginController {
    private Scanner ler;
    private LoginView view;
    private UsuarioRepositorio repositorio;
    private UsuarioModel usuarioLogado;


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
        Mensagem.mensagemAposLogin(usuarioAutenticado);
        
        if (usuarioAutenticado instanceof Paciente) {
            Paciente pacienteLogado = (Paciente) usuarioAutenticado;
            PacienteController pacienteController = new PacienteController(pacienteLogado);
            pacienteController.menu();
        } else if (usuarioAutenticado instanceof Medico) {
            MedicoController medicoController = new MedicoController((Medico) usuarioAutenticado);
            medicoController.menu();
        }
    }
    

    private UsuarioModel autenticarUsuario(String email, String senha) {
        for (UsuarioModel usuario : repositorio.getUsuarios()) {
            if (usuario.getEmail().trim().equals(email) && usuario.getSenha().trim().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public void exibirMenu() {
        if (usuarioLogado instanceof Paciente) {
            PacienteController pacienteController = new PacienteController((Paciente) usuarioLogado);
            pacienteController.menu();
        } else if (usuarioLogado instanceof Medico) {
            MedicoController medicoController = new MedicoController((Medico) usuarioLogado);
            medicoController.menu();
        }
    }

    public UsuarioModel getUsuarioLogado() {
        return usuarioLogado;
    }
}