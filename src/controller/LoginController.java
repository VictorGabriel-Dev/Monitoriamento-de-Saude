package controller;

import java.util.Scanner;

import model.UsuarioRepositorio;
import view.LoginView;

public class LoginController {
    private Scanner ler;
    private LoginView view;
    private UsuarioRepositorio repositorio;

    public LoginController(){
        this.ler = new Scanner(System.in);
        this.view = new LoginView();
        this.repositorio = UsuarioRepositorio.getInstance();
    }

    public void login(){
        view.imprima(ler, repositorio);
    }
}