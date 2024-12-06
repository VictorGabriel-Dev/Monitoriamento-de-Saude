package view;

import java.util.List;

import model.Consulta;
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
        return ler.nextInt();
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
    public void lista(){
        System.out.println("\n--- Lista de Pacientes ---");
    }
    public void naoHaConsultas() {
        System.out.println("Não há consultas agendadas.");
    }
    public void nenhumPaciente(){
        System.out.println("Nenhum paciente cadastrado.");
    }
        public void exibirConsultasAgendadas(String nomeMedico, List<Consulta> consultas) {
        System.out.println("\nConsultas agendadas para o médico " + nomeMedico + ":");
        if (consultas != null && !consultas.isEmpty()) {
            for (int i = 0; i < consultas.size(); i++) {
                Consulta consulta = consultas.get(i);
                System.out.println((i + 1) + ". Paciente: " + consulta.getPaciente().getNome() + ", Data: " + consulta.getDataConsulta());
            }
        } else {
            naoHaConsultas();
        }
    }


    public int selecionarConsulta() {
        int opcao = -1;
        while (opcao < 0) {
            String entrada = ler.nextLine();
            try {
                opcao = Integer.parseInt(entrada);  // Tenta converter a entrada
                if (opcao < 0) {
                    System.out.println("Por favor, escolha um número válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
        }
        return opcao;
    }
    

    public void exibirDetalhesConsulta(Consulta consulta) {
        System.out.println("\nDetalhes da consulta:");
        System.out.println("Paciente: " + consulta.getPaciente().getNome());
        System.out.println("Data da consulta: " + consulta.getDataConsulta());
        System.out.println("Diagnóstico: " + String.join(", ", consulta.getDiagnostico()));
        System.out.println("Prescrição: " + consulta.getPrescricao());
    }
    
    public int exibirOpcoesConsulta() {
        System.out.println("\nO que deseja fazer?");
        System.out.println("1. Adicionar diagnóstico");
        System.out.println("2. Alterar diagnóstico");
        System.out.println("3. Registrar prescrição");
        System.out.println("4. Voltar");
        return ler.nextInt();
    }
}
