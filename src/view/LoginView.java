package view;

import java.util.*;

public class LoginView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean passou = false;
        String teste = "email";

        //isso é o VIEW DO LOGIN
        while (passou != true) {
            System.out.println("---Login---");
            System.out.println("Digite seu E-mail: ");
            String email = sc.nextLine();
            System.out.println("Digite sua Senha: ");
            int senha = sc.nextInt();
            sc.nextLine();//consumidor

            //condicional
            if (email.equals(teste) & senha == 123) {
                passou = true;
                System.out.println("Login concluido");
            } else {
                System.out.println("Erro! Tente novamente");
            }
            System.out.println();
        }
    }
}
