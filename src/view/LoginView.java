package view;

import java.util.*;
import controller.LoginController;

public class LoginView {

    //isso é o VIEW DO LOGIN

    public static void login(LoginController loginController){
        Scanner sc = new Scanner(System.in);

        System.out.println("---Login---");
        System.out.println("Digite seu E-mail: ");
        String email = sc.nextLine();
        System.out.println("Digite sua Senha: ");
        int senha = 0;

        try {
            senha = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Senha inválida. Tente novamente.");
            return;
        }

        loginController.receber(email,senha);
    }

}
