package controller;

import java.util.Scanner;

import model.Historico;
import model.Paciente;
import view.HistoricoView;

public class HistoricoController {
    private HistoricoView view;
    private Scanner ler;
    private Paciente paciente;

    public HistoricoController() {
        this.view = new HistoricoView();
        this.ler = new Scanner(System.in);
    }

    public void addHistoricoMedico(Scanner ler) {
        Historico novoHistorico = view.formAddHistorico(ler);
        paciente.addHistoricoMedico(novoHistorico);
        view.mensagemSucesso();
    }

    public void consultarHistorico() {
        view.exibirHistoricoMedico(paciente.getHistoricoMedico());
    }

    public void historicoMedico(Scanner ler) {
        while (true) {
            int opcao = view.menuHistorico(ler);
            switch (opcao) {
                case 1:
                    consultarHistorico();
                    break;
                case 2:
                    addHistoricoMedico(ler);
                    break;
                case 3:
                return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public void start() {
        int opcao;
        do {
            opcao = view.menuHistorico(ler);
            switch (opcao) {
                case 1:
                    view.exibirHistoricoMedico(paciente.getHistoricoMedico());
                    break;
                case 2:
                    historicoMedico(ler);
                    break;
                case 3:
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 4);
    }
} 