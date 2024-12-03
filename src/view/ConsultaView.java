package view;

import java.util.List;
import java.util.Scanner;
import model.Consulta;
import model.Medico;
import model.Paciente;

public class ConsultaView {

    // Exibe o menu de histórico médico
    public int menuHistorico(Scanner ler) {
        System.out.println("\n********** Menu Histórico Médico **********");
        System.out.println("1. Consultar histórico médico");
        System.out.println("2. Voltar");
        System.out.print("Escolha uma opção: ");
        return ler.nextInt();
    }

    // Exibe o histórico médico
    public void exibirHistoricoMedico(List<Consulta> historicoMedico) {
        if (historicoMedico.isEmpty()) {
            System.out.println("\nNão há histórico médico registrado.");
        } else {
            System.out.println("\n********** Histórico Médico **********");
            for (Consulta consulta : historicoMedico) {
                System.out.printf("\nData da Consulta: %s\n", consulta.getDataConsulta());
                System.out.printf("Hora da Consulta: %s\n", consulta.getHoraConsulta());
                System.out.printf("Paciente: %s\n", consulta.getPaciente().getNome());
                System.out.printf("Médico: %s\n", consulta.getMedico().getNome());
                System.out.printf("Diagnóstico: %s\n", consulta.getDiagnostico());
                System.out.printf("Prescrição: %s\n", consulta.getPrescricao());
                System.out.println("***************************************");
            }
        }
    }

    public Consulta formAddConsulta(Scanner ler, Paciente paciente, List<Medico> medicosDisponiveis) {
        ler.nextLine();
        System.out.println("\n********** Agendar Consulta **********");

        System.out.print("Data da Consulta (dd/MM/yyyy): ");
        String dataConsulta = ler.nextLine();

        System.out.print("Hora da Consulta (HH:mm): ");
        String horaConsulta = ler.nextLine();

        System.out.println("\nEscolha um médico para a consulta:");
        for (int i = 0; i < medicosDisponiveis.size(); i++) {
            Medico medico = medicosDisponiveis.get(i);
            System.out.printf("%d. %s - Especialidade: %s\n", i + 1, medico.getNome(), medico.getEspecialidade());
        }
        System.out.print("Digite o número do médico escolhido: ");
        int escolhaMedico = ler.nextInt();
        Medico medicoEscolhido = medicosDisponiveis.get(escolhaMedico - 1);

        ler.nextLine();

        return new Consulta(dataConsulta, horaConsulta, paciente, medicoEscolhido, null, null);
    }

    public void mensagemSucesso() {
        System.out.println("\nConsulta agendada com sucesso.");
    }

    public void exibirMensagemErro(String mensagem) {
        System.out.println("\nErro: " + mensagem);
    }
}
