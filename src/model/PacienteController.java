package model;
import java.util.Scanner;

import controller.HistoricoController;
import view.PacienteView;
public class PacienteController {
    private HistoricoController historico;
    private Scanner ler;
    private PacienteView view;
    private Paciente paciente;

    public PacienteController(Paciente paciente) {
        this.ler = new Scanner(System.in);
        this.historico = new HistoricoController();
        this.view = new PacienteView();
        this.paciente = paciente;
    }
    public void start(){
        int opcao;
        do{
            opcao = view.menuPaciente(ler);
            switch(opcao){
                case 1:
                    //historico.consultarHistorico();
                    break;
                case 2:
                    historico.historicoMedico(ler);
                    break;
                case 3:
                    //agendarConsulta();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(opcao != 4);
    }
}
// Registrar um paciente, consultar histórico do paciente, atualizar dados do paciente, consultar dados do paciente, agendar consulta.