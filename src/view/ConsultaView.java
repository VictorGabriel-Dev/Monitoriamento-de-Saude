package view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import model.Diagnostico;
import model.Medicamento;
import utils.Validacao;

public class ConsultaView {
    private Scanner ler = new Scanner(System.in);

    public int menu(Scanner ler) {
        System.out.println("\n********** Menu Histórico Médico **********");
        System.out.println("1. Consultar histórico médico");
        System.out.println("2. Voltar");
        System.out.print("Escolha uma opção: ");
        return ler.nextInt();
    }

    public void exibirHistoricoMedico(LocalDate dataConsulta, LocalTime horaConsulta, String paciente, String medico,
            List<Diagnostico> diagnostico, List<Medicamento> prescricao) {
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

    public LocalDate obterDataConsulta() {
        LocalDate dataConsulta = null;
        while (dataConsulta == null) {
            System.out.print("Data de Consulta (dd/MM/yyyy): ");
            String dataConsultaStr = ler.next();
            ler.nextLine();
            if (Validacao.validarData(dataConsultaStr)) {
                dataConsulta = Validacao.converterData(dataConsultaStr);
            } else {
                System.out.println("Data inválida ou no passado. Tente novamente.");
            }
        }
        return dataConsulta;
    }

    public LocalTime obterHoraConsulta() {
        LocalTime horaConsulta = null;
        while (horaConsulta == null) {
            System.out.print("Hora da Consulta (HH:mm): ");
            String horaConsultaStr = ler.nextLine();
            if (Validacao.validarHora(horaConsultaStr)) {
                horaConsulta = Validacao.converterHora(horaConsultaStr);
            } else {
                System.out.println("Horário inválido. Tente novamente.");
            }
        }
        return horaConsulta;
    }

    public int getMedicoEscolhido() {
        System.out.println("\nEscolha um médico para a consulta: ");
        return ler.nextInt();
    }

    public int escolherMedico(int num, String nome, String especialidade) {

        System.out.printf("Num: %s | Nome: %s | Especialidade: %s |", num, nome, especialidade);
        return num;
    }

    public void exibirAgendamentos(LocalDate dataConsulta, LocalTime horaConsulta, String paciente, String medico) {
        if (dataConsulta == null || horaConsulta == null || paciente == null || medico == null) {
            System.out.println("\nNão há agendamentos de consultas.");
            return;
        }
        System.out.println("***************************************");
        System.out.printf("\nData da Consulta: %s\n", dataConsulta);
        System.out.printf("Hora da Consulta: %s\n", horaConsulta);
        System.out.printf("Paciente: %s\n", paciente);
        System.out.printf("Médico: %s\n", medico);
        System.out.println("***************************************");
    }

    public int opcoesAgendarConsultarAgendamento() {
        System.out.println("\n********** Menu Agendar Consulta **********");
        System.out.println("1. Agendar Consulta");
        System.out.println("2. Consultar Agendamento");
        System.out.println("3. Voltar");
        return ler.nextInt();
    }

    public int opcoesDepoisDeAgendarConsulta() {
        System.out.println("\n********** Menu Agendar Consulta **********");
        System.out.println("1. Confirmar Consulta");
        System.out.println("2. Cancelar Consulta");
        return ler.nextInt();
    }
}
