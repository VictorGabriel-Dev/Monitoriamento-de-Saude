package view;

import model.MonitoramentoModel;
import model.Paciente;

import java.util.Scanner;

public class MonitoramentoView {

    // Menu monitoramento
    public static int monitoramentoMenu(Scanner sc, Paciente paciente) {
        System.out.println("\n--- Monitoramento de " + paciente.getNome() + " ---");
        System.out.println("1. Visualizar dados de monitoração");//testanto esse metodo
        System.out.println("2. Gerar alerta do paciente");
        System.out.println("3. Analisar");//historico de consulta, sintomas, medicamentos
        System.out.println("0. Voltar");
        System.out.println("Escolha uma opção: ");
        int escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }
}
