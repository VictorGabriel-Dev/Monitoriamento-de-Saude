package controller;
import view.LoginView;

import javax.swing.text.View;
import java.util.Scanner;

public class LoginController {
    private boolean passou = false;
    private String teste = "email";
    private String email;
    private int senha;

    public void receber(String email, int senha){
        this.email = email;
        this.senha = senha;
    }
    public void recebaaaa(String email){
        System.out.println(email);
    }

    //loop
    //condicional
    public void verificadorLogin() {

        while (passou != true) {
            if (email == null) {
                System.out.println("Erro! O email não foi fornecido.");
                break;
            }

            if (email.equals(teste) && senha == 123) {
                passou = true;
                System.out.println("Login concluido");
            } else {
                System.out.println("Erro! Tente novamente");
                System.out.println();
                LoginView.login(this);
            }
        }
    }

}
