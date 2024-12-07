package view;

import model.Medicamento;
import model.Paciente;
import java.util.Scanner;

public class MonitoramentoView {
    private Scanner sc = new Scanner(System.in);
    public int monitoramentoPaciente(Paciente paciente) {
        System.out.println("\n--- Monitoramento de " + paciente.getNome() + " ---");
        System.out.println("1. Visualizar dados de monitoração");//testanto esse metodo
        System.out.println("2. Gerar alerta do paciente");
        System.out.println("3. Analisar");//historico de consulta, sintomas, medicamentos
        System.out.println("0. Voltar");
        System.out.println("Escolha uma opção: ");
        int escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }

    // View do menu monitoramento
    public int exibirMenuMonitoramento() {
        System.out.println("--- Menu Monitoramento ---");
        System.out.println("1. Dados de monitoração");
        System.out.println("2. Análise");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
        return sc.nextInt();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
    public void dadosMedicamento(Medicamento medicamento) {
        if(medicamento != null){
        System.out.println("\n--- Dados do Medicamento ---");
        System.out.println("Nome: " + medicamento.getNome());
        System.out.println("Dosagem: " + medicamento.getDosagem());
        System.out.println("Frequência: " + medicamento.getFrequencia());
        System.out.println("Descrição: " + medicamento.getDescricao());
        System.out.println("Médico responsavel: " + medicamento.getMedico());
        System.out.println("Data da prescrição: " + medicamento.getDataPrescricao()); 
        }else{
            System.out.println("Medicamento não encontrado.");
        }
        
    }
}
