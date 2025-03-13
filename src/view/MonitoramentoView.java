package view;

import model.Paciente;
import java.util.Scanner;

public class MonitoramentoView {
    private Scanner sc = new Scanner(System.in);

    public int monitoramentoPaciente(Paciente paciente) {
        System.out.println("\n--- Monitoramento de " + paciente.getNome() + " ---");
        System.out.println("1. Visualizar dados de monitoração");// testanto esse metodo
        System.out.println("2. Gerar alerta do paciente");
        System.out.println("3. Analisar");// historico de consulta, sintomas, medicamentos
        System.out.println("4. Voltar");
        System.out.println("Escolha uma opção: ");
        int escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }

    // View do menu monitoramento
    public int exibirMenuMonitoramento() {
        System.out.println("--- Menu Monitoramento ---");
        System.out.println("1. Dados de monitoração");
        System.out.println("2. Sair");
        System.out.print("Escolha uma opção: ");
        return sc.nextInt();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }


    public int showMenuAnalise() {
        System.out.println("\n--- Menu Analise ---");
        System.out.println("1. Historico de consultas");
        System.out.println("2. Medicamentos");
        System.out.println("3. Diagnosticos");
        System.out.println("4. Lista de alertas");
        System.out.println("0. voltar");
        System.out.println("Escolha uma opção: ");
        return sc.nextInt();
    }
    public void exibirDadosMonitoracao(String nome, String cpf) {
        if (nome == null || cpf == null) {
            System.out.println("Nenhum paciente selecionado.");
            return;
        }
        
        System.out.println("\n--- Dados de Monitoração do Paciente ---");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }
}
