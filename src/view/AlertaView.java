package view;

import java.util.Scanner;

import utils.Mensagem;

public class AlertaView {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("--- Menu ---");
        System.out.println("1. Criar alerta");
        System.out.println("2. Visualizar alerta");
        System.out.println("3. Excluir alerta");
        System.out.println("0. Sair");
        return sc.nextInt();
    }

    public int getTipoAlerta() {
        System.out.print("--- Tipo ---\n1 - Emergência \n2 - Anormalidade\n");
        return sc.nextInt();
    }

    public String tipoEscolhido() {
        int escolha = getTipoAlerta();
        return (escolha == 1) ? "Emergência" : (escolha == 2) ? "Anormalidade" : (Mensagem.mensagemValorInvalido());
    }

    public String getMensagem() {
        sc.nextLine();
        System.out.print("Mensagem: ");
        return sc.nextLine();
    }

    public int getPacienteEscolhido() {
        System.out.print("Escolha o número do paciente: ");
        return sc.nextInt();
    }

    public void escolherPaciente(int num, String nomePaciente, String cpfPaciente) {
        System.out.println(num + " - " + nomePaciente + " - " + cpfPaciente);
    }

    public void mostrarListaAlertas(String tipo, String mensagem, String paciente, String medico, String data) {
        System.out.printf("Tipo: %s | Mensagem: %s | Paciente: %s | Médico: %s | Data: %s%n",
                tipo, mensagem, paciente, medico,
                data);
    }

    public int mostrarFinalizarAlerta() {
        System.out.print("Informe o índice do alerta a ser finalizado: ");
        int index = sc.nextInt();
        return index;
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
