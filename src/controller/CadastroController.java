package controller;

import model.Medico;
import model.Paciente;
import model.UsuarioRepositorio;
import utils.Mensagem;
import view.CadastroView;

public class CadastroController{
    private CadastroView view;
    private UsuarioRepositorio repositorio;
    
    public CadastroController() {
        this.view = new CadastroView();
        this.repositorio = UsuarioRepositorio.getInstance();
    }

    public boolean cadastrarPaciente() {
        Paciente paciente = view.showCadastroPaciente();
        if(paciente == null){
            return false;
        }
        if(repositorio.verificaSeEmailExiste(paciente.getEmail())){
            Mensagem.mensagemEmailExistente();
            return false;
        }
        if (repositorio.verificarSeCpfExiste(paciente.getCpf())) {
            Mensagem.mensagemCpfExistente();
            return false;
        }
        Mensagem.mensagemSucesso();
        repositorio.adicionarUsuario(paciente);
        return true;
    }

    public boolean cadastrarMedico() {
        Medico medico = view.showCadastroMedico();
        if(medico == null){
            return false;
        }
        if(repositorio.verificaSeEmailExiste(medico.getEmail())){
            Mensagem.mensagemEmailExistente();
            return false;
        }
        if(repositorio.verificarSeCrmExiste(medico.getCrm())){
            Mensagem.mensagemCrmExistente();
            return false;
        }
        Mensagem.mensagemSucesso();
        repositorio.adicionarUsuario(medico);
        return true;
        
    }
}