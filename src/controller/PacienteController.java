package controller;

import java.util.Scanner;
import model.Paciente;
import view.PacienteView;

public class PacienteController {
    private Paciente paciente;
    private ConsultaController consultaController;
    private PacienteView pacienteView;
    private Scanner ler;

    public PacienteController(Paciente paciente) {
        this.paciente = paciente;
        this.consultaController = new ConsultaController(paciente);
        this.pacienteView = new PacienteView();
        this.ler = new Scanner(System.in);
    }

    public void dadosPaciente() {
        pacienteView.exibirDados(paciente);
    }

    public void alterarEVoltar() {
        int opcao;
        do {
            opcao = pacienteView.opcoesAlterarEVoltar();
            switch (opcao) {
                case 1:
                    pacienteView.alterarDados(paciente);
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
            opcao = pacienteView.menu();
            switch (opcao) {
                case 1:
                    dadosPaciente();
                    alterarEVoltar();
                    break;
                case 2:
                    consultaController.menuHistoricoMedico(ler);
                    break;
                case 3:
                    consultaController.consultaOpcoes(ler);
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        } while (opcao != 4);
    }
}
