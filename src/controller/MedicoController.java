package controller;
import java.util.Scanner;
import model.Medico;
import view.MedicoView;
public class MedicoController {
    private Medico medico;
    private MedicoView medicoView;
    private Scanner ler;
    public MedicoController(Medico medico) {
        this.medico = medico;
        this.medicoView = new MedicoView();
        this.ler = new Scanner(System.in);
    }
    public void dadosMedico() {
        medicoView.exibirDados(medico);
    }
    public void alterarEVoltar() {
        int opcao;
        do {
            opcao = medicoView.opcoesAlterarEVoltar(ler);
            switch (opcao) {
                case 1:
                    medicoView.alterarDados(ler, medico);
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
            opcao = medicoView.menu(ler);
            switch (opcao) {
                case 1:
                    dadosMedico();
                    alterarEVoltar();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }
}