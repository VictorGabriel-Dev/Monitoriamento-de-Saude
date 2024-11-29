package view;

import java.util.Scanner;
import model.UsuarioModel;

public class LoginView {
    public UsuarioModel formLogin(Scanner ler) {
        System.out.println("Digite seu email: ");
        String email = ler.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = ler.nextLine();
        return new UsuarioModel(email, senha);
    }
    public void mensagemAposLogin(UsuarioModel usuario){
        if (usuario != null) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Credenciais inválidas. Tente novamente.");
        }
    }
}