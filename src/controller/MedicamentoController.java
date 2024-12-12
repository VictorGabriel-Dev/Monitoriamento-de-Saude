package controller;

import model.Medicamento;
import model.Paciente;
import view.MedicamentoView;

import java.util.ArrayList;
import java.util.List;

public class MedicamentoController {

    private MedicamentoView medicamentoView;
    private List<Medicamento> prescricoes;
    private Paciente paciente;

    public MedicamentoController() {
        this.medicamentoView = new MedicamentoView();
        this.prescricoes = new ArrayList<>();
    }

    public void prescreverMedicamento() {
        Medicamento medicamento = medicamentoView.formPrescreverMedicamento();
        if (medicamento != null) {
            prescricoes.add(medicamento);
            medicamentoView.exibirMensagem("Medicamento prescrito com sucesso.");
        }
    }

    public void ajustarDosagem() {
        String nomeMedicamento = medicamentoView.solicitarNomeMedicamento();
        Medicamento medicamento = buscarMedicamento(nomeMedicamento);

        if (medicamento != null) {
            String novaDosagem = medicamentoView.solicitarNovaDosagem();
            medicamento.setDosagem(novaDosagem);
            medicamentoView.exibirMensagem("Dosagem ajustada com sucesso.");
        } else {
            medicamentoView.exibirMensagem("Medicamento não encontrado.");
        }
    }

    public void cancelarPrescricao() {
        String nomeMedicamento = medicamentoView.solicitarNomeMedicamento();
        Medicamento medicamento = buscarMedicamento(nomeMedicamento);

        if (medicamento != null) {
            prescricoes.remove(medicamento);
            medicamentoView.exibirMensagem("Prescrição cancelada com sucesso.");
        } else {
            medicamentoView.exibirMensagem("Medicamento não encontrado.");
        }
    }

    public void exibirMedicamentos() {
        List<Medicamento> medicamentos = paciente.getMedicamentos();
        for (Medicamento medicamento : medicamentos) {
            if (medicamento != null) {
                medicamentoView.dadosMedicamento(
                        medicamento.getNome(),
                        medicamento.getDosagem(),
                        medicamento.getFrequencia(),
                        medicamento.getDescricao(),
                        medicamento.getMedico().getNome(),
                        medicamento.getDataPrescricao());
            }
        }
    }

    public Medicamento buscarMedicamento(String nome) {
        return prescricoes.stream()
                .filter(medicamento -> medicamento.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public void menu() {
        while (true) {
            int opcao = medicamentoView.menuMedicamento();
            switch (opcao) {
                case 1:
                    prescreverMedicamento();
                    break;
                case 2:
                    ajustarDosagem();
                    break;
                case 3:
                    cancelarPrescricao();
                    break;
                case 4:
                    exibirMedicamentos();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
