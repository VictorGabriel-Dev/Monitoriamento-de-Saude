package controller;

import model.DispositivoModel;
import utils.Mensagem;
import view.DispositivoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DispositivoController {
    private DispositivoView dispositivoView = new DispositivoView();
    private Scanner sc = new Scanner(System.in);
    private List<DispositivoModel> dispositivos;

    public DispositivoController() {
        this.dispositivoView = new DispositivoView();
        this.sc = new Scanner(System.in);
        this.dispositivos = new ArrayList<>();
    }

    public void menu() {
        int opcao;
        do {
            opcao = dispositivoView.exibirMenu();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarDispositivo();
                    break;
                case 2:
                    consultarDispositivo();
                    break;
                case 3:
                    selecionarDispositivoListadoParaRemover();
                    break;
                case 4:
                    atualizarDispositivo();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    public void cadastrarDispositivo() {
        DispositivoModel dispositivo = dispositivoView.cadastrar();
        dispositivos.add(dispositivo);
    }

    // Metodo para consultar dispositivos cadastrados
    public void consultarDispositivo() {
        Mensagem.mensagemDeLista();
        for (DispositivoModel dispositivo : dispositivos) {
            if (dispositivo != null && dispositivo.getTipo() != null && dispositivo.getMarca() != null
                    && dispositivo.getModelo() != null && dispositivo.getStatus() != null
                    && dispositivo.getValor() != 0.0) {
                dispositivoView.exibirDispositivos(
                        dispositivo.getTipo(),
                        dispositivo.getMarca(),
                        dispositivo.getModelo(),
                        dispositivo.getStatus(),
                        dispositivo.getValor());
            }
        }
    }

    // Metodo remover dispositivo por meio de índice
    public void selecionarDispositivoListadoParaRemover() {
        consultarDispositivo();
       int index = dispositivoView.selecionarParaRemover(0) - 1;

        if (index >= 0 && index < dispositivos.size()) {
            dispositivos.remove(index);
            Mensagem.mensagemDeRemovido();
        } else {
            Mensagem.mensagemNumeroInvalido();
        }
    }

    // Metodo atualizar dados
    public void atualizarDispositivo() {
        int index = dispositivoView.solicitarIndice("Informe o índice do dispositivo para atualizar:");
        if (indexValido(index)) {
            DispositivoModel dispositivo = dispositivos.get(index);
            int campo = dispositivoView.selecionarCampoAtualizacao();

            switch (campo) {
                case 1:
                    String[] tipoUnidade = dispositivoView.selecionarTipo();
                    dispositivo.setTipo(tipoUnidade[0]);
                    break;
                case 2:
                    dispositivo.setMarca(dispositivoView.solicitarEntrada("Nova marca:"));
                    break;
                case 3:
                    dispositivo.setModelo(dispositivoView.solicitarEntrada("Novo modelo:"));
                    break;
                case 4:
                    dispositivo.setStatus(dispositivoView.selecionarStatus());
                    break;
                case 5:
                    dispositivo.setValor(dispositivoView.solicitarValor("Novo valor:"));
                    break;
                default:
                    dispositivoView.exibirMensagem("Opção inválida.");
                    return;
            }
            Mensagem.mensagemDeAtualizado();
        } else {
            Mensagem.mensagemNumeroInvalido();
        }
    }

    private boolean indexValido(int index) {
        return index >= 0 && index < dispositivos.size();
    }
}
