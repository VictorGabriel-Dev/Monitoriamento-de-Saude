import controller.LoginController;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Simula os login de usuarios
        ArrayList<UsuarioModel> usuarios = new ArrayList<>();
        usuarios.add(new UsuarioModel("medico@gmail.com", "medico123"));
        usuarios.add(new UsuarioModel("paciente@gmail.com", "paciente123"));

        //Inicializa o Controller e a View
        LoginController controller = new LoginController(usuarios);
        LoginView loginView = new LoginView(controller);

        //Exibe a interface de login
        loginView.imprima();
    }
}
