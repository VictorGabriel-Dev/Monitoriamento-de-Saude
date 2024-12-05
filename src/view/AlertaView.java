package view;
import java.util.Scanner;

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

    public String mensagemSair() {
        return "Saindo...";
    }

    public String mensagemValorInvalido(){
        return "Índice inválido! Tente novamente.";
    }

    public int mostrarFinalizarAlerta(){
        System.out.print("Informe o índice do alerta a ser finalizado: ");
        int index = sc.nextInt();
        return index;
    }
}
