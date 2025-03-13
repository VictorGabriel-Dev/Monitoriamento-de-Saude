package view;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Consulta;
import model.Medicamento;
import model.Medico;
import model.Paciente;
import java.util.stream.IntStream;

public class ConsultaView {

    public int menu(Scanner ler) {
        System.out.println("\n********** Menu Histórico Médico **********");
        System.out.println("1. Consultar histórico médico");
        System.out.println("2. Voltar");
        System.out.print("Escolha uma opção: ");
        return ler.nextInt();
    }

    public void exibirHistoricoMedico(LocalDate dataConsulta, String horaConsulta, String paciente, String medico,
            List<String> diagnostico, List<Medicamento> prescricao) {
        if (dataConsulta == null || horaConsulta == null || paciente == null || medico == null || diagnostico == null
                || prescricao == null) {
            System.out.println("\nNão há histórico médico registrado.");
            return;
        } else {
            System.out.println("\n********** Histórico Médico **********");
            System.out.printf("\nData da Consulta: %s\n", dataConsulta);
            System.out.printf("Hora da Consulta: %s\n", horaConsulta);
            System.out.printf("Paciente: %s\n", paciente);
            System.out.printf("Médico: %s\n", medico);
            System.out.printf("Diagnóstico: %s\n", diagnostico);
            System.out.printf("Prescrição: %s\n", prescricao);
            System.out.println("***************************************");
        }
    }

    public Consulta formAddConsulta(Scanner ler, Paciente paciente, List<Medico> medicosDisponiveis,
            List<Consulta> consultasAgendadas) {
        ler.nextLine();
        System.out.println("\n********** Agendar Consulta **********");

        Date dataConsulta = obterDataConsulta(ler);
        String horaConsulta = obterHoraConsulta(ler);
        Medico medicoEscolhido = escolherMedico(ler, medicosDisponiveis);

        if (verificarConflitoHorario(consultasAgendadas, dataConsulta, horaConsulta, medicoEscolhido)) {
            return null;
        }

        return new Consulta(dataConsulta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), horaConsulta,
                paciente, medicoEscolhido, null, null);
    }

    private Date obterDataConsulta(Scanner ler) {
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
        return dataConsulta;
    }

    private String obterHoraConsulta(Scanner ler) {
        String horaConsulta = null;
        while (horaConsulta == null) {
            System.out.print("Hora da Consulta (HH:mm): ");
            String horaConsultaStr = ler.nextLine();
            if (isHoraValida(horaConsultaStr)) {
                horaConsulta = horaConsultaStr;
            } else {
                System.out.println("Horário inválido. Tente novamente.");
            }
        }
        return horaConsulta;
    }

    private boolean isHoraValida(String horaConsultaStr) {
        try {
            SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
            horaFormat.setLenient(false);
            Date hora = horaFormat.parse(horaConsultaStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(hora);
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            return !(hour < 8 || hour > 17 || (hour == 17 && minute > 0));
        } catch (Exception e) {
            return false;
        }
    }

    private Medico escolherMedico(Scanner ler, List<Medico> medicosDisponiveis) {
        System.out.println("\nEscolha um médico para a consulta:");
        IntStream.range(0, medicosDisponiveis.size())
                .forEach(i -> System.out.printf("%d. %s - Especialidade: %s\n", i + 1,
                        medicosDisponiveis.get(i).getNome(), medicosDisponiveis.get(i).getEspecialidade()));

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
        return medicoEscolhido;
    }

    private boolean verificarConflitoHorario(List<Consulta> consultasAgendadas, Date dataConsulta, String horaConsulta,
            Medico medicoEscolhido) {
        LocalDate dataConsultaLocalDate = dataConsulta.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        for (Consulta consulta : consultasAgendadas) {
            if (consulta.getDataConsulta().isEqual(dataConsultaLocalDate) &&
                    consulta.getHoraConsulta().equals(horaConsulta) &&
                    consulta.getMedico().equals(medicoEscolhido)) {
                System.out.println("Conflito de horário com outra consulta. Tente outro horário.");
                return true;
            }
        }
        return false;
    }

    public void exibirAgendamentos(LocalDate dataConsulta, String horaConsulta, String paciente, String medico) {
        if (dataConsulta == null || horaConsulta == null || paciente == null || medico == null) {
            System.out.println("\nNão há agendamentos de consultas.");
            return;
        }   System.out.println("***************************************");
            System.out.printf("\nData da Consulta: %s\n", dataConsulta);
            System.out.printf("Hora da Consulta: %s\n", horaConsulta);
            System.out.printf("Paciente: %s\n", paciente);
            System.out.printf("Médico: %s\n", medico);
            System.out.println("***************************************");
    }

    public int opcoesAgendarConsultarAgendamento(Scanner ler) {
        System.out.println("\n********** Menu Agendar Consulta **********");
        System.out.println("1. Agendar Consulta");
        System.out.println("2. Consultar Agendamento");
        System.out.println("3. Voltar");
        return ler.nextInt();
    }

    public int opcoesDepoisDeAgendarConsulta(Scanner ler) {
        System.out.println("\n********** Menu Agendar Consulta **********");
        System.out.println("1. Confirmar Consulta");
        System.out.println("2. Cancelar Consulta");
        return ler.nextInt();
    }
}
