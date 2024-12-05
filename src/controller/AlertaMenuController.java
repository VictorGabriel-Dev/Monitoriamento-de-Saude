package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.AlertaModel;
import utils.DataHora;
import view.AlertaView;

public class AlertaMenuController {
    private Scanner sc = new Scanner(System.in); // Scanner único
    private List<AlertaModel> alertas = new ArrayList<>();
    private AlertaView view;

    public AlertaMenuController(AlertaView view) {
        this.view = view;
    }

    public void alertaMenu() {
        int escolha;
        do {
            escolha = view.mostrarMenu();
            switch (escolha) {
                case 0:
                    view.mensagemSair();
                    break;
                case 1:
                    model.AlertaModel novoAlerta = criarAlerta();
                    adicionarAlerta(novoAlerta);
                    break;
                case 2:
                    listarAlertas();
                    break;
                case 3:
                    boolean sucesso = finalizarAlerta();
                    if (!sucesso) {
                        view.mensagemValorInvalido();
                    }
                    break;
                default:
                    view.mensagemValorInvalido();
            }
        } while (escolha != 0);
    }

    public void adicionarAlerta(AlertaModel alerta) {
        alertas.add(alerta);
        System.out.println("Alerta adicionado com sucesso!");
    }

    public AlertaModel criarAlerta() {
        System.out.print("--- Tipo ---\n1 - Emergência \n2 - Anormalidade\n");
        int escolha = sc.nextInt();
        sc.nextLine();
        String tipo = seletTipo(escolha);
        System.out.print("Mensagem: ");
        String mensagem = sc.nextLine();
        System.out.print("Paciente: ");
        String paciente = sc.nextLine();
        System.out.print("Médico: ");
        String medico = sc.nextLine();
        String data = DataHora.getDataHoraAtual();

        return new AlertaModel(tipo, mensagem, paciente, medico, data);
    }

    public boolean finalizarAlerta() {
        int index = view.mostrarFinalizarAlerta();
        if (index >= 0 && index < alertas.size()) {
            alertas.remove(index);
            System.out.println("Alerta finalizado com sucesso!");
            return true;
        } else {
            view.mensagemValorInvalido();
            return false;
        }
    }

    public void listarAlertas() {
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
    public String seletTipo(int escolha) {
        String tipo = "";
        switch (escolha) {
            case 1:
                tipo = "emergência";
                break;
            case 2:
                tipo = "anormalidade";
                break;
            default:
                view.mensagemValorInvalido();
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
