package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.AlertaModel;
import utils.DataHora;

public class AlertaMenuController {
    private static List<AlertaModel> alertas = new ArrayList();

    public AlertaMenuController() {
    }

    public static void adicionarAlerta(AlertaModel alerta) {
        alertas.add(alerta);
        System.out.println("Alerta adicionado com sucesso!");
    }

    public static AlertaModel criarAlerta(Scanner sc) {
        System.out.print("--- Tipo ---\n1 - Emergência \n2 - Anormalidade\n");
        int escolha = sc.nextInt();
        sc.nextLine(); // Limpar o buffer
        String tipo = seletTipo(escolha); // Usando seletTipo para definir o tipo

        System.out.print("Mensagem: ");
        String mensagem = sc.nextLine();
        System.out.print("Paciente: ");
        String paciente = sc.nextLine();
        System.out.print("Médico: ");
        String medico = sc.nextLine();
        String data = DataHora.getDataHoraAtual();

        return new AlertaModel(tipo, mensagem, paciente, medico, data);
    }

    public static boolean finalizarAlerta(Scanner sc) {
        System.out.print("Informe o índice do alerta a ser finalizado: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index >= 0 && index < alertas.size()) {
            alertas.remove(index);
            System.out.println("Alerta finalizado com sucesso!");
            return true;
        } else {
            System.out.println("Índice inválido!");
            return false;
        }
    }

    public static void listarAlertas() {
        if (alertas.isEmpty()) {
            System.out.println("Não há alertas para exibir.");
        } else {
            for (int i = 0; i < alertas.size(); ++i) {
                AlertaModel alerta = alertas.get(i);
                System.out.printf("[%d] - Tipo: %s | Mensagem: %s | Paciente: %s | Médico: %s | Data: %s%n", i, alerta.getTipo(), alerta.getMensagem(), alerta.getPaciente(), alerta.getMedico(), alerta.getData());
            }
        }
    }

    // Método selectTipo que retorna o tipo conforme a escolha
    public static String seletTipo(int escolha) {
        String tipo = "";
        switch (escolha) {
            case 1:
                tipo = "emergência";
                break;
            case 2:
                tipo = "anormalidade";
                break;
            default:
                System.out.println("Valor inválido! Tente novamente.");
                break;
        }
        return tipo;
    }
    // Método para gerar mensagens de alerta com base na unidade de medida
    public static void gerarAlerta(String tipoDispositivo, String unidadeMedida, String mensagem) {
        System.out.println("Alerta no dispositivo: " + tipoDispositivo + " (" + unidadeMedida + ") - " + mensagem);
    }

    // Método para verificar limites e gerar alertas específicos
    public static void verificarLimites(String tipoDispositivo, String unidadeMedida, double valor) {
        switch (tipoDispositivo) {
            case "Frequência cardiaca":
                if (valor < 60) {
                    gerarAlerta(tipoDispositivo, unidadeMedida, "Valor abaixo do limite: " + valor + " bpm");
                } else if (valor > 100) {
                    gerarAlerta(tipoDispositivo, unidadeMedida, "Valor acima do limite: " + valor + " bpm");
                }
                break;

            case "Pressão sanguínea":
                if (valor < 90) {
                    gerarAlerta(tipoDispositivo, unidadeMedida, "Pressão arterial muito baixa: " + valor + " mmHg");
                } else if (valor > 138) {
                    gerarAlerta(tipoDispositivo, unidadeMedida, "Pressão arterial muito alta: " + valor + " mmHg");
                }
                break;

            case "Temperatura":
                if (valor < 36.5) {
                    gerarAlerta(tipoDispositivo, unidadeMedida, "Temperatura abaixo do normal: " + valor + " °C");
                } else if (valor > 37.0) {
                    gerarAlerta(tipoDispositivo, unidadeMedida, "Temperatura acima do normal: " + valor + " °C");
                }
                break;

            default:
                System.out.println("Tipo de dispositivo desconhecido: " + tipoDispositivo);
        }
    }
}
