package view;
import java.util.Scanner;

import model.AlertaModel;
import utils.DataHora;
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
    public AlertaModel formCriarAlerta(){
        System.out.print("--- Tipo ---\n1 - Emergência \n2 - Anormalidade\n");
        int escolha = sc.nextInt();
        sc.nextLine();
        String tipo;
        if(escolha == 1){
            tipo = "Emergência";
        } else if(escolha == 2){
            tipo = "Anormalidade";
        }else{
            Mensagem.mensagemValorInvalido();
            return null;
        }
        System.out.print("Mensagem: ");
        String mensagem = sc.nextLine();
        System.out.print("Paciente: ");
        String paciente = sc.nextLine();
        System.out.print("Médico: ");
        String medico = sc.nextLine();
        String data = DataHora.getDataHoraAtual();

        return new AlertaModel(tipo, mensagem, paciente, medico, data);
    }


    public int mostrarFinalizarAlerta(){
        System.out.print("Informe o índice do alerta a ser finalizado: ");
        int index = sc.nextInt();
        return index;
    }
}
