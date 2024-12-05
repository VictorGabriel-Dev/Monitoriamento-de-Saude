package controller;

import java.util.Scanner;
import model.Paciente;
import view.PacienteView;
import java.time.LocalDate;

public class PacienteController extends BaseController<Paciente> {
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

    @Override
    public void alterarDados(Paciente paciente) {
        int opcao;
        do {
            opcao = pacienteView.selecionarQualAlterar();
            String dadoAnterior = null;
            boolean confirmacao = false;
            switch (opcao) {
                case 1:
                    dadoAnterior = paciente.getNome();
                    paciente.setNome(solicitarEntrada("Digite o novo nome: "));
                    break;
                case 2:
                    dadoAnterior = paciente.getCpf();
                    paciente.setCpf(solicitarEntrada("Digite o novo CPF: "));
                    break;
                case 3:
                    dadoAnterior = paciente.getDataNascimento().toString();
                    paciente.setDataNascimento(LocalDate.parse(solicitarEntrada( "Digite a nova data de nascimento (AAAA-MM-DD): ")));
                    break;
                case 4:
                    dadoAnterior = paciente.getEndereco();
                    paciente.setEndereco(solicitarEntrada("Digite o novo endereço: "));
                case 5:
                    dadoAnterior = paciente.getTelefone();
                    paciente.setTelefone(solicitarEntrada("Digite o novo telefone: "));
                    break;
                case 6:
                    dadoAnterior = paciente.getEmail();
                    paciente.setEmail(solicitarEntrada("Digite o novo e-mail: "));
                    break;
                case 7:
                    return; // Sai do menu
                    default:
                    System.out.println("Opção inválida.");
                    continue;
            }
        confirmacao = confirmarAlteracao();
        if (!confirmacao) {
            if(opcao == 1) paciente.setNome(dadoAnterior);
            if(opcao == 2) paciente.setCpf(dadoAnterior);
            if(opcao == 3) paciente.setDataNascimento(LocalDate.parse(dadoAnterior));
            if(opcao == 4) paciente.setEndereco(dadoAnterior);
            if(opcao == 5) paciente.setTelefone(dadoAnterior);
            if(opcao == 6) paciente.setEmail(dadoAnterior);
            exibirMensagem("Alteração cancelada.");
            }else{
                exibirMensagem("Alteração realizada com sucesso!");
            }
        }while (opcao != 7);
    } 

    public void alterarEVoltar() {
        int opcao;
        do {
            opcao = pacienteView.opcoesAlterarEVoltar();
            switch (opcao) {
                case 1:
                    alterarDados(paciente);
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
