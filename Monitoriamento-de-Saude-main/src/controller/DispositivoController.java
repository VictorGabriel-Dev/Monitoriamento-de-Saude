package controller;

import model.DispositivoModel;
import view.DispositivoView;
import controller.AlertaController;

import java.util.ArrayList;
import java.util.Scanner;

public class DispositivoController {
    public static void menu(ArrayList<DispositivoModel> dispositivos) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            DispositivoView.exibirMenu();
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    dispositivos.add(DispositivoController.cadastrarDispositivo(sc));
                    break;
                case 2:
                    DispositivoController.consultarDispositivo(dispositivos);
                    break;
                case 3:
                    System.out.print("Informe o índice do dispositivo para remover: ");
                    int indexRemover = sc.nextInt();
                    sc.nextLine();
                    DispositivoController.removerDispositivo(dispositivos, indexRemover - 1);
                    break;
                case 4:
                    System.out.print("Informe o índice do dispositivo para atualizar: ");
                    int indexAtualizar = sc.nextInt();
                    sc.nextLine();
                    DispositivoController.atualizarDispositivo(dispositivos, indexAtualizar - 1, sc);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // Metodo para cadastrar novo Dispositivo
    public static DispositivoModel cadastrarDispositivo(Scanner sc) {
        // Passando a unidadeMedida para o selectTipo
        String[] tipoUnidade = DispositivoController.selectTipo(sc);
        String tipo = tipoUnidade[0];
        String unidadeMedida = tipoUnidade[1];

        String status = DispositivoController.selectStatus(sc);

        System.out.println("Marca:");
        String marca = sc.nextLine();

        System.out.println("Modelo:");
        String modelo = sc.nextLine();

        double valor;

        //condicional com base no Status
        if(status.equals("Ativo")){
            System.out.printf("\nValor apresentado em %s:", unidadeMedida);
            valor = sc.nextInt();
        } else {
            valor = 0.0;
        }


        // Criando o dispositivo
        DispositivoModel dispositivo = new DispositivoModel(tipo, marca, modelo, status, valor);

        // Verificando os limites
        AlertaController.verificarLimites(tipo, unidadeMedida, valor);

        return dispositivo;
    }

    // Metodo para consultar dispositivos cadastrados
    public static void consultarDispositivo(ArrayList<DispositivoModel> dispositivos) {
        if (dispositivos.isEmpty()) {
            System.out.println("Nenhum dispositivo cadastrado.");
        } else {
            System.out.println("--- Lista de Dispositivos ---");
            for (int i = 0; i < dispositivos.size(); i++) {
                DispositivoModel dispositivo = dispositivos.get(i);
                System.out.printf("Dispositivo %d:\n", i + 1);
                System.out.printf("Tipo: %s\n", dispositivo.getTipo());
                System.out.printf("Marca: %s\n", dispositivo.getMarca());
                System.out.printf("Modelo: %s\n", dispositivo.getModelo());
                System.out.printf("Status: %s\n", dispositivo.getStatus());
                System.out.printf("Valor: %s\n", dispositivo.getValor());

                // Verificando os limites para cada dispositivo
                AlertaController.verificarLimites(dispositivo.getTipo(), dispositivo.getTipo().equals("Frequência cardiaca") ? "bpm" : (dispositivo.getTipo().equals("Pressão sanguínea") ? "mmHg" : "°C"), dispositivo.getValor());

                System.out.println("-----------------------------");
            }
        }
    }

    // Metodo remover dispositivo por meio de índice
    public static void removerDispositivo(ArrayList<DispositivoModel> dispositivos, int index) {
        if (index >= 0 && index < dispositivos.size()) {
            dispositivos.remove(index);
            System.out.println("Dispositivo removido com sucesso!");
        } else {
            System.out.println("Índece inválido. Nenhum dispositivo foi removido.");
        }
    }

    // Metodo atualizar dados
    public static void atualizarDispositivo(ArrayList<DispositivoModel> dispositivos, int index, Scanner sc) {
        if (index >= 0 && index < dispositivos.size()) {
            DispositivoModel dispositivo = dispositivos.get(index);

            System.out.println("--- Atualização de Dispositivo ---");
            System.out.println("1. Tipo\n2. Marca\n3. Modelo\n4. Status\n5. Valor");
            System.out.print("Escolha o campo que deseja atualizar: ");
            int escolha = sc.nextInt(); // Recebe a escolha do campo a ser atualizado
            sc.nextLine();

            switch (escolha) {
                case 1:
                    // Passando a unidadeMedida para o selectTipo
                    String[] tipoUnidade = DispositivoController.selectTipo(sc);
                    dispositivo.setTipo(tipoUnidade[0]);
                    break;
                case 2:
                    System.out.print("Nova marca: ");
                    dispositivo.setMarca(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Novo modelo: ");
                    dispositivo.setModelo(sc.nextLine());
                    break;
                case 4:
                    dispositivo.setStatus(DispositivoController.selectStatus(sc));
                    break;
                case 5:
                    System.out.print("Novo valor: ");
                    dispositivo.setValor(sc.nextDouble());
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("Dispositivo atualizado com sucesso!");
        } else {
            System.out.println("Índice inválido. Nenhuma atualização foi realizada.");
        }
    }

    // Metodo para selecionar o tipo do dispositivo e retornar unidadeMedida
    public static String[] selectTipo(Scanner sc) {
        String tipo = "";
        String unidadeMedida = "";

        do {
            System.out.println("--- Tipo ---");
            System.out.println("1. FREQUÊNCIA CARDÍACA");
            System.out.println("2. PRESSÃO ARTERIAL");
            System.out.println("3. TEMPERATURA");
            int escolhaTipo = sc.nextInt();
            sc.nextLine();

            switch (escolhaTipo) {
                case 1:
                    tipo = "Frequência cardiaca";
                    unidadeMedida = "bpm";
                    break;
                case 2:
                    tipo = "Pressão sanguínea";
                    unidadeMedida = "mmHg";
                    break;
                case 3:
                    tipo = "Temperatura";
                    unidadeMedida = "°C";
                    break;
                default:
                    System.out.println("Valor inválido! Tente novamente.");
                    continue;
            }
            break;
        } while (true);

        return new String[]{tipo, unidadeMedida}; // Retorna tipo e unidadeMedida
    }

    // Metodo para selecionar o status
    public static String selectStatus(Scanner sc) {
        String status = "";
        do {
            System.out.println("--- Status ---");
            System.out.println("1. Ativo");
            System.out.println("2. Desativado");
            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    status = "Ativo";
                    break;
                case 2:
                    //caso o status for desativado, não poe valor
                    status = "Desativado";
                    break;
                default:
                    System.out.println("Valor inválido! Tente novamente.");
                    continue;
            }
            break;
        } while (true);
        return status;
    }
}
