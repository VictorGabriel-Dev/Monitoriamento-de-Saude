package controller;

import model.DispositivoModel;
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
                    removerDispositivo();
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
        String[] tipoUnidade = dispositivoView.selecionarTipo();
        String tipo = tipoUnidade[0];
        String unidadeMedida = tipoUnidade[1];

        String status = dispositivoView.selecionarStatus();

        String marca = dispositivoView.solicitarEntrada("Marca:");
        String modelo = dispositivoView.solicitarEntrada("Modelo:");

        double valor = status.equals("Ativo")
                ? dispositivoView.solicitarValor("Valor apresentado em " + unidadeMedida + ":")
                : 0.0;

        DispositivoModel dispositivo = new DispositivoModel(tipo, marca, modelo, status, valor);
        dispositivos.add(dispositivo);

        dispositivoView.exibirMensagem("Dispositivo cadastrado com sucesso!");
    }

    // Metodo para consultar dispositivos cadastrados
    public void consultarDispositivo() {
        dispositivoView.exibirDispositivos(dispositivos);
    }

    // Metodo remover dispositivo por meio de índice
    public void removerDispositivo() {
        System.out.print("Informe o índice do dispositivo para remover: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index >= 0 && index < dispositivos.size()) {
            dispositivos.remove(index);
            System.out.println("Dispositivo removido com sucesso!");
        } else {
            System.out.println("Índece inválido. Nenhum dispositivo foi removido.");
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
            dispositivoView.exibirMensagem("Dispositivo atualizado com sucesso!");
        } else {
            dispositivoView.exibirMensagem("Índice inválido. Nenhuma atualização foi realizada.");
        }
    }

    private boolean indexValido(int index) {
        return index >= 0 && index < dispositivos.size();
    }
}
