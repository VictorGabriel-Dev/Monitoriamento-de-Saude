package view;

import java.util.Scanner;
import controller.LoginController;

public class LoginView {
    private LoginController controller;

    public LoginView(LoginController controller) {
        this.controller = controller;
    }

    //metodo imprimir
    public void imprima() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu email: ");
        String email = sc.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = sc.nextLine();

        if (controller.validaLogin(email, senha)) {
            System.out.println("Bem-vindo! ");
        } else {
            System.out.println("Login inválido. Tente novamente. ");
        }
        sc.close();
    }
}