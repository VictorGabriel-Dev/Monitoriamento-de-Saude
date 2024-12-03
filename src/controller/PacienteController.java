package controller;

import java.util.Scanner;
import model.Paciente;
import view.PacienteView;

public class PacienteController {
    private Paciente paciente;
    private ConsultaController historicoController;
    private PacienteView pacienteView;
    private Scanner ler;
    public PacienteController(Paciente paciente) {
        this.paciente = paciente;
        this.historicoController = new ConsultaController(paciente);
        this.pacienteView = new PacienteView();
        this.ler = new Scanner(System.in);
    }

    public void dadosPaciente() {
        pacienteView.exibirDadosPaciente(paciente);
    }
    public void alterarEVoltar(){
        int opcao;
        do {
            opcao = pacienteView.opcoesAlterarEVoltar(ler);
            switch (opcao) {
                case 1:
                    pacienteView.alterarDadosPaciente(ler, paciente);
                break;
                case 2:
                return;
                default:
                System.out.println("Opção inválida.");
                } 
            }while (opcao != 2);
    }


    public void menu() {
        int opcao;
        do {
            opcao = pacienteView.menuPaciente(ler);
            switch (opcao) {
                case 1:
                    dadosPaciente();
                    alterarEVoltar();
                    break;
                case 2:
                    historicoController.menuHistoricoMedico(ler);
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        } while (opcao != 4);
    }
}
