package controller;

import java.util.Scanner;

import model.Medico;
import model.Paciente;
import model.UsuarioRepositorio;
import view.CadastroView;

public class CadastroController{
    private CadastroView view;
    private Scanner ler;
    private UsuarioRepositorio repositorio;
    
    public CadastroController() {
        this.view = new CadastroView();
        this.ler = new Scanner(System.in);
        this.repositorio = UsuarioRepositorio.getInstance();
    }

    public void cadastrarPaciente() {
        Paciente paciente = view.showCadastroPaciente(ler);
        if(repositorio.verificaSeEmailExiste(paciente.getEmail())){
            view.mensagemEmailExistente();
            return;
        }
        if (repositorio.verificarSeCpfExiste(paciente.getCpf())) {
            view.mensagemCpfExistente();
            return;
        }
        view.mensagemSucesso();
        repositorio.adicionarUsuario(paciente);
    }

    public void cadastrarMedico() {
        Medico medico = view.showCadastroMedico(ler);
        if(repositorio.verificaSeEmailExiste(medico.getEmail())){
            view.mensagemEmailExistente();
            return;
        }
        if(repositorio.verificarSeCrmExiste(medico.getCrm())){
            view.mensagemCrmExistente();
            return;
        }
        view.mensagemSucesso();
        repositorio.adicionarUsuario(medico);
        
    }

    
    // public void exibirDadosMedico() {
    //     UsuarioRepositorio.getInstance().exibirDadosMedico();
    // }

}