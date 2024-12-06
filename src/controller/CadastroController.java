package controller;

import model.Medico;
import model.Paciente;
import model.UsuarioRepositorio;
import view.CadastroView;

public class CadastroController{
    private CadastroView view;
    private UsuarioRepositorio repositorio;
    
    public CadastroController() {
        this.view = new CadastroView();
        this.repositorio = UsuarioRepositorio.getInstance();
    }

    public void cadastrarPaciente() {
        Paciente paciente = view.showCadastroPaciente();
        if(paciente == null){
            return;
        }
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
        Medico medico = view.showCadastroMedico();
        if(medico == null){
            return;
        }
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

}