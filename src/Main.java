
import controller.LoginController;
//import LoginView.*;
import view.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginController loginController = new LoginController();

        LoginView.login(loginController);
        loginController.verificadorLogin();
        // a main deve ficar fora da view o baiano
    }
}
