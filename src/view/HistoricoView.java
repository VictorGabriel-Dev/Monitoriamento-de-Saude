package view;

import java.util.List;
import java.util.Scanner;

import model.Historico;

public class HistoricoView {
    public int menuPaciente(Scanner ler) {
        System.out.println("1. Consultar dados");
        System.out.println("2. Consultar histórico");
        System.out.println("3. Agendar consulta");
        System.out.println("4. Sair");
        return ler.nextInt();
    }
    public int menuHistorico(Scanner ler) {
        System.out.println("1. Consultar histórico médico");
        System.out.println("2. Adicionar histórico médico");
        System.out.println("3. Voltar");
        return ler.nextInt();
    }
    public void exibirHistoricoMedico(List<Historico> historicoMedico) {
        if (historicoMedico.isEmpty()) {
            System.out.println("Não há histórico médico");
        } else {
            System.out.println("Histórico médico: ");
            for (Historico historico : historicoMedico) {
                System.out.println(
                "\n" + historico.getDataInicio() + 
                "\n" + historico.getDataTermino() +
                "\n" + historico.getDescricao()+
                "\n" + historico.getMedicamento()
                );
            }
        }
    }

    public Historico formAddHistorico(Scanner ler) {
        ler.nextLine();
        System.out.println("Digite a data de início do tratamento: ");
        String dataInicio = ler.nextLine();
        System.out.println("Digite a data de término do tratamento: ");
        String dataTermino = ler.nextLine();
        System.out.println("Digite a descrição do tratamento: ");
        String descricao = ler.nextLine();
        System.out.println("Medicamento usado: ");
        String medicamento = ler.nextLine();
        return new Historico(dataInicio, dataTermino, descricao, medicamento);

    }
}