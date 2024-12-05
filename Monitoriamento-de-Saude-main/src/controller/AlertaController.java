package controller;

public class AlertaController {

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
