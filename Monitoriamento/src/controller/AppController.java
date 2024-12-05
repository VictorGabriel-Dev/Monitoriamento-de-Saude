package controller;

import java.util.Scanner;
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
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 4);
    }
}