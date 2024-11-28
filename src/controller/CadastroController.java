package controller;

import java.util.Scanner;

import model.Medico;
import model.Paciente;
import model.UsuarioRepositorio;
import view.CadastroView;

public class CadastroController{
    private CadastroView view;
    private Scanner ler;
    
    public CadastroController() {
        this.view = new CadastroView();
        this.ler = new Scanner(System.in);
    }

    public void cadastrarPaciente() {
        Paciente paciente = view.showCadastroPaciente(ler);
        if(paciente != null){
            UsuarioRepositorio.getInstance().adicionarUsuario(paciente);
        }
  
    }

    public void cadastrarMedico() {
        Medico medico = view.showCadastroMedico(ler);
        if(medico != null){
            UsuarioRepositorio.getInstance().adicionarUsuario(medico); 
        }
        
    }
    public void exibirDadosMedico() {
        UsuarioRepositorio.getInstance().exibirDadosMedico();
    }

}