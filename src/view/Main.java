package view;
import controller.LoginController;
//import LoginView.*;

public class Main {
    public static void main(String[] args) {
        LoginController loginController = new LoginController();

        LoginView.login(loginController);
        loginController.verificadorLogin();

    }
}
