package view;
import java.util.Scanner;
public class AppView {
    public int showMenu(Scanner ler) {
        System.out.println("=== Menu Principal ===");
        System.out.println("1. Login");
        System.out.println("2. Cadastro de Paciente");
        System.out.println("3. Cadastro de Médico");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
        return ler.nextInt();
    }
}
