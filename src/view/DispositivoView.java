package view;

import java.util.List;
import java.util.Scanner;

import controller.AlertaMenuController;
import model.DispositivoModel;

public class DispositivoView {
    Scanner sc = new Scanner(System.in);
    //Metodo View menu
    public int exibirMenu(){
        System.out.println("--- Menu Dispostivo ---");
        System.out.println("1. Cadastrar Dispositivo");
        System.out.println("2. Visualizar Dispositivo");
        System.out.println("3. Remover Dispositivo");
        System.out.println("4. Atualizar Dispositivo");
        System.out.println("5. Sair");
        return sc.nextInt();
    }

    //metodo cadastrar dispositivo
    public DispositivoModel cadastrar(Scanner sc) {
        System.out.println("---Cadastro de Dispositivos---");
        System.out.println("Tipo:");//criar um select
        String tipo = sc.nextLine();
        System.out.println("Marca:");
        String marca = sc.nextLine();
        System.out.println("Modelo:");
        String modelo = sc.nextLine();
        System.out.println("Status:");//aqui também pode ser um select
        String status = sc.nextLine();
        System.out.println("Valor apresentado em bpm:");
        double valor = sc.nextDouble();
        System.out.println("Adicionar uma opção ");
        System.out.println();
        System.out.println("-------------------------------");

        //retorna
        return new DispositivoModel(tipo, marca, modelo, status, valor);
    }
    public String[] selecionarTipo() {
        System.out.println("\n--- Seleção de Tipo ---");
        System.out.println("1. Frequência cardíaca");
        System.out.println("2. Pressão sanguínea");
        System.out.println("3. Temperatura");
        System.out.print("Escolha o tipo do dispositivo: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1: return new String[]{"Frequência cardíaca", "bpm"};
            case 2: return new String[]{"Pressão sanguínea", "mmHg"};
            case 3: return new String[]{"Temperatura", "°C"};
            default:
                exibirMensagem("Opção inválida.");
                return selecionarTipo();
        }
    }

    public String selecionarStatus() {
        System.out.println("\n--- Seleção de Status ---");
        System.out.println("1. Ativo");
        System.out.println("2. Desativado");
        System.out.print("Escolha o status do dispositivo: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        return escolha == 1 ? "Ativo" : "Desativado";
    }

    public int selecionarCampoAtualizacao() {
        System.out.println("\n--- Atualização de Dispositivo ---");
        System.out.println("1. Tipo");
        System.out.println("2. Marca");
        System.out.println("3. Modelo");
        System.out.println("4. Status");
        System.out.println("5. Valor");
        System.out.print("Escolha o campo que deseja atualizar: ");
        return sc.nextInt();
    }

    public String solicitarEntrada(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public double solicitarValor(String mensagem) {
        System.out.print(mensagem);
        return sc.nextDouble();
    }

    public int solicitarIndice(String mensagem) {
        System.out.print(mensagem);
        return sc.nextInt();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirDispositivos(List<DispositivoModel> dispositivos) {
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
                AlertaMenuController.verificarLimites(dispositivo.getTipo(), dispositivo.getTipo().equals("Frequência cardiaca") ? "bpm" : (dispositivo.getTipo().equals("Pressão sanguínea") ? "mmHg" : "°C"), dispositivo.getValor());

                System.out.println("-----------------------------");
            }
        }
}

public int mensagemOpcoesAtualizacao() {
    System.out.println("--- Atualização de Dispositivo ---");
    System.out.println("1. Tipo\n2. Marca\n3. Modelo\n4. Status\n5. Valor");
    System.out.print("Escolha o campo que deseja atualizar: ");
    return sc.nextInt();
}
}