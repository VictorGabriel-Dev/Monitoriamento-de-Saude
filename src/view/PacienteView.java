package view;

import java.util.Scanner;

public class PacienteView {
    public int menuPaciente(Scanner ler) {
        System.out.println("\n********** Menu Paciente **********");
        System.out.println(
        "\n1. Consultar dados" + 
        "\n2. Histórico médico" + 
        "\n3. Agendar consulta" + 
        "\n4. Sair");
        return ler.nextInt();
    }
}
