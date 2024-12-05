package controller;
import model.Consulta;
import model.Medico;
import view.MedicoView;
public class MedicoController {
    private Medico medico;
    private MedicoView medicoView;
    private ConsultaController consultaController;
    public MedicoController(Medico medico) {
        this.medico = medico;
        this.medicoView = new MedicoView();
        this.consultaController = new ConsultaController(null);
    }
    public void dadosMedico() {
        medicoView.exibirDados(medico);
    }
    public void alterarEVoltar() {
        int opcao;
        do {
            opcao = medicoView.opcoesAlterarEVoltar();
            switch (opcao) {
                case 1:
                    medicoView.alterarDados(medico);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 2);
    }
    public void menu() {
        int opcao;
        do {
            opcao = medicoView.menu();
            switch (opcao) {
                case 1:
                    dadosMedico();
                    alterarEVoltar();
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal.");
                    break;
                case 3:
                consultarAgendamentos();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }
        public void consultarAgendamentos() {
        // Exibe todas as consultas agendadas para o médico
        if (medico.getConsultas() != null && !medico.getConsultas().isEmpty()) {
            System.out.println("Consultas agendadas para o médico " + medico.getNome() + ":");
            for (Consulta consulta : medico.getConsultas()) {
                System.out.println("Paciente: " + consulta.getPaciente().getNome() + ", Data: " + consulta.getDataConsulta());
            }
        } else {
            System.out.println("Não há consultas agendadas.");
        }
    }
}