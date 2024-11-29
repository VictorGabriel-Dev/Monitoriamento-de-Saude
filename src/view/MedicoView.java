package view;
import java.util.Scanner;
public class MedicoView {
    public int menuMedico(Scanner ler) {
        System.out.println("1. Consultar dados");
        System.out.println("2. Consultar histórico");
        System.out.println("3. Agendar consulta");
        System.out.println("4. Sair");
        return ler.nextInt();
    }
}
