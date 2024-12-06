package controller;

import model.*;
import java.util.*;

public class MonitoramentoController {
    ArrayList<Paciente> pacientes = new ArrayList<>();
    private UsuarioRepositorio repositorio;
    private Scanner sc;

    public MonitoramentoController(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
        this.repositorio = UsuarioRepositorio.getInstance();
        this.sc = new Scanner(System.in);
    }

    public void menuMonitoramento() {
        System.out.println("--- Menu Monitoramento ---");
        System.out.println("1. Dados de monitoração");
        System.out.println("2. Análise");
        System.out.println("3. Sair");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1://tem um pequeno problema na lista, ela nao esta puxando a lista de pacientes
                exibirPacientes();
                break;
            case 2:
                Analise();
                break;
            case 3:
                return;
            default:
                System.out.println("Valor inválido!");
        }
    }

//É necessario fazer a integração com as outras classes
    //Menu Analise
    public void Analise() {
        int escolha = 9;
        do {
            System.out.println("\n--- Menu Analise ---");
            System.out.println("1. Historico de consultas");
            System.out.println("2. Medicamentos");
            System.out.println("3. Diagnosticos");
            System.out.println("4. Lista de alertas... implementar método");
            System.out.println("0. voltar");
            escolha = sc.nextInt();
            sc.nextLine(); // Consumir

            switch (escolha) {
                case 1:
                    System.out.println("\n--- Historico de consultas ---");// falta implementar metodo

                    break;
                case 2:
                    System.out.println("\n--- Medicamentos ---");// falta implementar metodo
                    break;
                case 3:
                    System.out.println("\n--- Diagnosticos ---");// falta implementar metodo
                    break;
                case 0:
                    System.out.println("Voltando...");
                    return;
                default:
                    System.out.println("Valor inválido! Tente novamente.");
            }
        } while (escolha != 0);
    }
    public void exibirPacientes() {
    if (pacientes.isEmpty()) {
        System.out.println("Nenhum paciente para monitorar.");
        return;
    }

    System.out.println("\n--- Lista de Pacientes Monitorados ---");
    for (int i = 0; i < pacientes.size(); i++) {
        Paciente paciente = pacientes.get(i);
        System.out.println((i + 1) + ". " + paciente.getNome() + " (CPF: " + paciente.getCpf() + ")");
    }
}

}
