package view;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
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

public Consulta formAddConsulta(Scanner ler, Paciente paciente, List<Medico> medicosDisponiveis, List<Consulta> consultasAgendadas) {
    ler.nextLine();
    System.out.println("\n********** Agendar Consulta **********");

    Date dataConsulta = null;
    while (dataConsulta == null) {
        System.out.print("Data de Consulta (dd/MM/yyyy): ");
        String dataConsultaStr = ler.nextLine();
        try {
            dataConsulta = new SimpleDateFormat("dd/MM/yyyy").parse(dataConsultaStr);
            if (dataConsulta.before(new Date())) {
                System.out.println("Data da consulta não pode ser no passado.");
                dataConsulta = null;
            }
        } catch (Exception e) {
            System.out.println("Data inválida. Tente novamente.");
        }
    }

    String horaConsulta = null;
    while (horaConsulta == null) {
        System.out.print("Hora da Consulta (HH:mm): ");
        String horaConsultaStr = ler.nextLine();
        try {
            SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
            horaFormat.setLenient(false);
            Date hora = horaFormat.parse(horaConsultaStr);

            Calendar cal = Calendar.getInstance();
            cal.setTime(hora);
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);

            if (hour < 8 || hour > 17 || (hour == 17 && minute > 0)) {
                System.out.println("Horário fora do intervalo permitido (08:00 - 17:00).");
            } else {
                horaConsulta = horaConsultaStr;
            }
        } catch (Exception e) {
            System.out.println("Horário inválido. Tente novamente.");
        }
    }

    System.out.println("\nEscolha um médico para a consulta:");
    for (int i = 0; i < medicosDisponiveis.size(); i++) {
        Medico medico = medicosDisponiveis.get(i);
        System.out.printf("%d. %s - Especialidade: %s\n", i + 1, medico.getNome(), medico.getEspecialidade());
    }

    Medico medicoEscolhido = null;
    while (medicoEscolhido == null) {
        System.out.print("Digite o número do médico escolhido: ");
        int escolhaMedico = ler.nextInt();
        ler.nextLine();
        if (escolhaMedico > 0 && escolhaMedico <= medicosDisponiveis.size()) {
            medicoEscolhido = medicosDisponiveis.get(escolhaMedico - 1);
        } else {
            System.out.println("Escolha inválida. Tente novamente.");
        }
    }

    LocalDate dataConsultaLocalDate = dataConsulta.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();
    for (Consulta consulta : consultasAgendadas) {
        if (consulta.getDataConsulta().isEqual(dataConsultaLocalDate) &&
                consulta.getHoraConsulta().equals(horaConsulta) &&
                consulta.getMedico().equals(medicoEscolhido)) {
            System.out.println("Conflito de horário com outra consulta. Tente outro horário.");
            return null;
        }
    }

    return new Consulta(dataConsultaLocalDate, horaConsulta, paciente, medicoEscolhido, null, null);
}

    public int opcoesAgendarConsultarAgendamento(Scanner ler) {
        System.out.println("\n********** Menu Agendar Consulta **********");
        System.out.println("1. Agendar Consulta");
        System.out.println("2. Consultar Agendamento");
        System.out.println("3. Voltar");
        return ler.nextInt();
    }

    public void mensagemSucesso() {
        System.out.println("\nConsulta agendada com sucesso.");
    }

    public void exibirMensagemErro(String mensagem) {
        System.out.println("\nErro: " + mensagem);
    }
}
