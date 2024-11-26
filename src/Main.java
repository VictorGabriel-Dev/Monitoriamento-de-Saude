package view;

import model.Usuario;
import controller.LoginController;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Simula um "banco de dados" de usuários
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("medico@gmail.com","medico123"));
        usuarios.add(new Usuario("paciente@gmail.com","paciente321"));

        //inicializa o Controller e a View
        LoginController controller = new LoginController(usuarios);
        LoginView loginView = new LoginView(controller);

        //Exibe a interface de login
        loginView.imprima();
    }
}
