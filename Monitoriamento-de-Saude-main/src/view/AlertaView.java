package view;

import controller.AlertaMenuController;

import java.util.Scanner;

public class AlertaView {
    public static void alertaMenu() {
        Scanner sc = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("--- Menu ---");
            System.out.println("1. Criar alerta");
            System.out.println("2. Visualizar alerta");
            System.out.println("3. Excluir alerta");
            System.out.println("0. Sair");
            escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    model.AlertaModel novoAlerta = controller.AlertaMenuController.criarAlerta(sc);
                    AlertaMenuController.adicionarAlerta(novoAlerta);
                    break;
                case 2:
                    AlertaMenuController.listarAlertas();
                    break;
                case 3:
                    boolean sucesso = AlertaMenuController.finalizarAlerta(sc);
                    if (!sucesso) {
                        System.out.println("Índice inválido! Tente novamente.");
                    }
                    break;
                default:
                    System.out.println("Valor inválido!");
            }
        } while (escolha != 0);
    }
}
