package controller;

import model.*;
import controller.*;

import java.util.*;

public class MonitoramentoController {
    ArrayList<Paciente> pacientes = new ArrayList<>();

    public MonitoramentoController(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void menuMonitoramento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Menu Monitoramento ---");
        System.out.println("1. Dados de monitoração");
        System.out.println("2. Análise");
        System.out.println("3. Sair");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1://tem um pequeno problema na lista, ela nao esta puxando a lista de pacientes
                MedicoController.selecionarPaciente(pacientes);
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
        Scanner sc = new Scanner(System.in);
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
                    System.out.println("\n--- Historico de consultas ---");

                    break;
                case 2:
                    System.out.println("\n--- Medicamentos ---");//classe medicamento
                    break;
                case 3:
                    System.out.println("\n--- Diagnosticos ---");//pegar da classe consulta
                    break;
                case 0:
                    System.out.println("Voltando...");
                    return;
                default:
                    System.out.println("Valor inválido! Tente novamente.");
            }
        } while (escolha != 0);
    }
}
