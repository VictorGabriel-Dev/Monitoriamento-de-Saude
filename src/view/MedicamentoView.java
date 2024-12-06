package view;

import model.Medicamento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MedicamentoView {
    private Scanner scanner = new Scanner(System.in);

    public int menuMedicamento() {
        System.out.println("\n*** Menu de Prescrição de Medicamentos ***");
        System.out.println("1. Prescrever Medicamento");
        System.out.println("2. Ajustar Dosagem");
        System.out.println("3. Cancelar Prescrição");
        System.out.println("4. Consultar Medicamento");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public Medicamento formPrescreverMedicamento() {
        System.out.print("Informe o nome do medicamento: ");
        String nome = scanner.nextLine();
        System.out.print("Informe a dosagem (ex: 500mg): ");
        String dosagem = scanner.nextLine();
        System.out.print("Informe a frequência: ");
        String frequencia = scanner.nextLine();
        System.out.print("Informe a descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Informe a data da prescrição (dd/MM/yyyy): ");
        String dataPrescricao = scanner.nextLine();
        LocalDate data;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            data = LocalDate.parse(dataPrescricao, formatter);
            if (data.isBefore(LocalDate.now())) {
                System.out.println("Erro: A data de prescrição não pode estar no passado.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Data inválida! Certifique-se de usar o formato dd/MM/yyyy.");
            return null;
        }

        return new Medicamento(nome, dosagem, frequencia, descricao, null, data.toString());
    }

    public String solicitarNomeMedicamento() {
        System.out.print("Informe o nome do medicamento: ");
        return scanner.nextLine();
    }

    public String solicitarNovaDosagem() {
        System.out.print("Informe a nova dosagem: ");
        return scanner.nextLine();
    }

    public void exibirMedicamento(Medicamento medicamento) {
        if (medicamento == null) {
            System.out.println("Medicamento não encontrado.");
        } else {
            System.out.println("\n--- Detalhes do Medicamento ---");
            System.out.println("Nome: " + medicamento.getNome());
            System.out.println("Dosagem: " + medicamento.getDosagem());
            System.out.println("Frequência: " + medicamento.getFrequencia());
            System.out.println("Descrição: " + medicamento.getDescricao());
            System.out.println("Prescrito por: " + (medicamento.getMedico() != null ? medicamento.getMedico().getNome() : "Desconhecido"));
            System.out.println("Data da Prescrição: " + medicamento.getDataPrescricao());
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
