package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.Mensagem;
import view.AppView;

public class AppController {
    private Scanner ler;
    private AppView view;
    private LoginController loginController;
    private CadastroController cadastroController;

    public AppController() {
        this.ler = new Scanner(System.in);
        this.view = new AppView();
        this.loginController = new LoginController();
        this.cadastroController = new CadastroController();
    }

    public void run() {
        int opcao;
        do {
            try {
                opcao = view.showMenu(ler);
                switch (opcao) {
                    case 1:
                        loginController.entrar();
                        break;
                    case 2:
                        cadastroController.cadastrarPaciente();
                        break;
                    case 3:
                        cadastroController.cadastrarMedico();
                        break;
                    case 4:
                        Mensagem.mensagemSair();
                        break;
                    default:
                        Mensagem.mensagemOpcaoInvalida();
                        break;
                }
            } catch (InputMismatchException e) {
                Mensagem.mensagemOpcaoInvalida();
                ler.nextLine();
                opcao = 0;
            }
        } while (opcao != 4);
    }
}