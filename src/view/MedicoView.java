package view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import utils.MedicoInputType;
import model.Diagnostico;
import model.Medicamento;
import model.Medico;

public class MedicoView extends BaseView<Medico> {
    @Override
    public int menu() {
        System.out.println("\n********** Menu Medico **********");
        System.out.println("1. Consultar dados");
        System.out.println("2. Plano do paciente");
        System.out.println("3. Consultar Agendamento");
        System.out.println("4. Menu dispositivo");
        System.out.println("5. Menu Alerta");// Falta implementar
        System.out.println("6. Menu Monitoramento");// Falta implementar
        System.out.println("7. Sair");
        return ler.nextInt();
    }

    public String solicitarInput(MedicoInputType tipo) {
        switch (tipo) {
            case NOME:
                return solicitarEntrada("Digite o novo nome: ");
            case ESPECIALIDADE:
                return solicitarEntrada("Digite a nova especialidade: ");
            case CRM:
                return solicitarEntrada("Digite o novo CRM: ");
            case TELEFONE:
                return solicitarEntrada("Digite o novo telefone: ");
            case EMAIL:
                return solicitarEntrada("Digite o novo e-mail: ");
            default:
                return null;
        }
    }

    @Override
    public int selecionarQualAlterar() {
        System.out.println("\n********** Alterar Dados **********");
        System.out.println("1 - Nome");
        System.out.println("2 - Especialidade");
        System.out.println("3 - CRM");
        System.out.println("4 - Telefone");
        System.out.println("5 - E-mail");
        System.out.println("6 - Voltar");
        System.out.print("Escolha o dado a ser alterado: ");
        return validateIntInput("Escolha o dado a ser alterado: ");
    }

    public int opcoesDepoisDePlanoPaciente() {
        System.out.println("\n********** Menu Plano do Paciente **********");
        System.out.println("1. Consultar dados do paciente");
        System.out.println("2. Consultar histórico de consultas");
        System.out.println("3. Consultar medicamentos");
        System.out.println("4. Consultar diagnósticos");
        System.out.println("5. Consultar alertas");
        System.out.println("6. Consultar monitoramento");
        System.out.println("7. Voltar");
        return ler.nextInt();
    }

    public void exibirConsultasAgendadas(int num, String nomeMedico,
            String pacientesConsultasMarcadas, LocalDate data, LocalTime hora) {
        System.out.println("\nConsultas agendadas para o médico " + nomeMedico + ":");

        System.out.println(num + ". Paciente: " + pacientesConsultasMarcadas + ", Data: "
                + data + ", Hora: " + hora);
    }

    public int selecionarConsulta() {
        int opcao = -1;
        while (opcao < 0) {
            String entrada = ler.nextLine();
            try {
                opcao = Integer.parseInt(entrada); // Tenta converter a entrada
                if (opcao < 0) {
                    System.out.println("Por favor, escolha um número válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
        }
        return opcao;
    }

    public void exibirDetalhesConsulta(String nomePaciente, LocalDate data, List<Diagnostico> diagnostico,
            List<Medicamento> prescricao) {
        System.out.println("\nDetalhes da consulta:");
        System.out.println("Paciente: " + nomePaciente);
        System.out.println("Data da consulta: " + data);
        System.out.println("Diagnóstico: " + (diagnostico.isEmpty() ? "Não registrado"
                : diagnostico.stream().map(Diagnostico::toString).collect(Collectors.joining(", "))));
        System.out.println("Prescrições: "
                + (prescricao.isEmpty() ? "Não registrada" : prescricao.size() + " medicamentos prescritos"));

    }

    public void exibirMedicamentosPrescritos(String nome, String dosagem, String frequencia, String descricao,
            String dataPrescricao) {
        System.out.println("Nome: " + nome);
        System.out.println("Dosagem: " + dosagem);
        System.out.println("Frequência: " + frequencia);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data de Prescrição: " + dataPrescricao);
        System.out.println("-----------------------------");
    }

    public int mostrarOpcoesConsulta() {
        System.out.println("\nO que deseja fazer?");
        System.out.println("1. Adicionar diagnóstico");
        System.out.println("2. Alterar diagnóstico");
        System.out.println("3. Registrar prescrição");
        System.out.println("4. Voltar");
        return ler.nextInt();
    }

    public void perfilDoPaciente(String nome, String cpf, LocalDate dataNascimento, String endereco, String telefone,
            String email) {
        System.out.println("\n---------- \s" + nome + " ----------");
        System.out.println("CPF: " + cpf);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("E-mail: " + email);
        System.out.println("------------------------------------");
    }

    public int opcoesDoPefilPaciente() {
        ler.nextLine();
        System.out.println("1- Histórico de consultas");
        System.out.println("2- Medicamentos");
        System.out.println("3- Alertas");
        System.out.println("4- Voltar");
        return ler.nextInt();
    }

    public Diagnostico formDiagnostico(String nomePaciente) {
        ler.nextLine();
        System.out.println("Digite o diagnóstico para o paciente " + nomePaciente + ": ");
        String diagnostico = ler.nextLine();
        return new Diagnostico(diagnostico);
    }

    public Diagnostico formAlterarDiagnostico(String nomePaciente) {
        ler.nextLine();
        System.out.println("Digite o novo diagnóstico para o paciente " + nomePaciente + ": ");
        String novoDiagnotico = ler.nextLine();
        return new Diagnostico(novoDiagnotico);
    }
}