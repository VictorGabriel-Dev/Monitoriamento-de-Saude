package view;

import java.util.Scanner;

public class DispositivoView {
    //Metodo View menu
    public static void exibirMenu(){
        System.out.println("--- Menu Dispostivo ---");
        System.out.println("1. Cadastrar Dispositivo");
        System.out.println("2. Visualizar Dispositivo");
        System.out.println("3. Remover Dispositivo");
        System.out.println("4. Atualizar Dispositivo");
        System.out.println("5. Sair");
    }

    //metodo cadastrar dispositivo
    public static String[] cadastrar(Scanner sc) {
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
        return new String[]{
                tipo, marca, modelo, status, String.valueOf(valor)
        };
    }
}
