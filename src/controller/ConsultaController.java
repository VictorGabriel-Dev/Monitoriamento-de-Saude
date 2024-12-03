package controller;

import java.util.List;
import java.util.Scanner;

import model.Consulta;
import model.Medico;
import model.Paciente;
import view.ConsultaView;

public class ConsultaController {
    private ConsultaView view;
    private Paciente paciente;

    public ConsultaController(Paciente paciente) {
        this.view = new ConsultaView();
        this.paciente = paciente;
    }

    public void agendarConsulta(Scanner ler, List<Medico> medicosDisponiveis) {
        Consulta novaConsulta = view.formAddConsulta(ler, paciente, medicosDisponiveis);
        paciente.getHistoricoMedico().add(novaConsulta);
        view.mensagemSucesso();
    }

    public void consultarHistorico() {
        view.exibirHistoricoMedico(paciente.getHistoricoMedico());
    }

    public void menuHistoricoMedico(Scanner ler) {
        int opcao;
        do {
            opcao = view.menuHistorico(ler);
            switch (opcao) {
                case 1:
                    consultarHistorico();
                    break;
                case 2:
                    return;  
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 2);
    }
}
