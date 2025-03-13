package view;

import java.util.Map;
import java.util.Scanner;
import model.DispositivoModel;

public class DispositivoView {
    Scanner sc = new Scanner(System.in);
    private int numerico = 1;

    // Metodo View menu
    public int exibirMenu() {
        System.out.println("--- Menu Dispostivo ---");
        System.out.println("1. Configurar");
        System.out.println("2. Voltar");
        return sc.nextInt();
    }
    public int opcoesConfigurar(){
        System.out.println("1. Cadastrar Dispositivo");
        System.out.println("2. Remover Dispositivo");
        System.out.println("3. Atualizar Dispositivo");
        System.out.println("4. Voltar");
        return sc.nextInt();
    }
    public DispositivoModel cadastrar() {
        System.out.println("---Cadastro de Dispositivos---");
        String[] tipo = selecionarTipo();
        String[] marcaModelo = selecionarMarcaModelo(tipo[0]);
        String status = selecionarStatus();
        double valor = 0.0;

        if (status.equals("Ativo")) {
            valor = validarValorPorTipo(tipo[0]);
        }
        System.out.println("-------------------------------");
        exibirMensagem("Dispositivo cadastrado com sucesso!");
        return new DispositivoModel(tipo[0], marcaModelo[0], marcaModelo[1], status, valor);
    }

   private String[] selecionarMarcaModelo(String tipo) {
    System.out.println("--- Seleção de Marca ---");
    
    Map<String, String[][]> dispositivosConfig = Map.of(
        "Frequência cardíaca", new String[][] {
            {"Apple", "Apple Watch"},
            {"Garmin", "Garmin Vivoactive 4"},
            {"Polar", "Polar Vantage V"}
        },
        "Pressão sanguínea", new String[][] {
            {"Omron", "Omron HEM-7122"},
            {"Beurer", "Beurer BM 300"},
            {"Microlife", "Microlife BP 780"}
        },
        "Temperatura", new String[][] {
            {"Iheath", "Iheath iHealth"},
            {"Braun", "Braun ThermoScan"},
            {"Exergen", "Exergen D50"}
        }
    );

    String[][] opcoes = dispositivosConfig.get(tipo);
    for (int i = 0; i < opcoes.length; i++) {
        System.out.println((i + 1) + ". " + opcoes[i][0]);
    }

    int escolha = sc.nextInt();
    sc.nextLine();

    if (escolha >= 1 && escolha <= opcoes.length) {
        return opcoes[escolha - 1];
    }

    exibirMensagem("Opção inválida.");
    return selecionarMarcaModelo(tipo);
}


    public String[] selecionarTipo() {
        System.out.println("\n--- Seleção de Tipo ---");
        System.out.println("1. Frequência cardíaca");
        System.out.println("2. Pressão sanguínea");
        System.out.println("3. Temperatura");
        System.out.print("Escolha o tipo do dispositivo: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                return new String[] { "Frequência cardíaca", "bpm" };
            case 2:
                return new String[] { "Pressão sanguínea", "mmHg" };
            case 3:
                return new String[] { "Temperatura", "°C" };
            default:
                exibirMensagem("Opção inválida.");
                return selecionarTipo();
        }
    }

    public String selecionarStatus() {
        System.out.println("\n--- Seleção de Status ---");
        System.out.println("1. Ativo");
        System.out.println("2. Desativado");
        System.out.print("Escolha o status do dispositivo: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        return escolha == 1 ? "Ativo" : "Desativado";
    }

    private double validarValorPorTipo(String tipo) {
        double valor;
        while (true) {
            try {
                switch (tipo) {
                    case "Frequência cardíaca":
                        System.out.print("Digite o valor em bpm (40-200): ");
                        valor = sc.nextDouble();
                        if (valor >= 40 && valor <= 200)
                            return valor;
                        break;

                    case "Pressão sanguínea":
                        System.out.print("Digite o valor em mmHg (60-180): ");
                        valor = sc.nextDouble();
                        if (valor >= 60 && valor <= 180)
                            return valor;
                        break;

                    case "Temperatura":
                        System.out.print("Digite o valor em °C (35-42): ");
                        valor = sc.nextDouble();
                        if (valor >= 35 && valor <= 42)
                            return valor;
                        break;
                }
                System.out.println("Valor fora do intervalo permitido. Tente novamente.");
            } catch (Exception e) {
                System.out.println("Valor inválido. Digite um número.");
                sc.nextLine();
            }
        }
    }

    public int selecionarCampoAtualizacao() {
        System.out.println("\n--- Atualização de Dispositivo ---");
        System.out.println("1. Tipo");
        System.out.println("2. Marca");
        System.out.println("3. Modelo");
        System.out.println("4. Status");
        System.out.println("5. Valor");
        System.out.print("Escolha o campo que deseja atualizar: ");
        return sc.nextInt();
    }

    public String solicitarEntrada(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public double solicitarValor(String mensagem) {
        System.out.print(mensagem);
        return sc.nextDouble();
    }

    public int solicitarIndice(String mensagem) {
        System.out.print(mensagem);
        return sc.nextInt();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirDispositivos(String tipo, String marca, String modelo, String status, double valor) {
        if (tipo == null || marca == null || modelo == null || status == null || valor == 0) {
            System.out.println("Nenhum dispositivo cadastrado.");
        } else {
            System.out.println("╔════════════════════════════════════╗");
            System.out.println("║         DISPOSITIVO " + numerico++ + "              ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.printf("║  Tipo: %-27s║\n", tipo);
            System.out.printf("║  Marca: %-26s║\n", marca);
            System.out.printf("║  Modelo: %-25s║\n", modelo);
            System.out.printf("║  Status: %-25s║\n", status);
            System.out.printf("║  Valor: %-26.1f║\n", valor);
            System.out.println("╚════════════════════════════════════╝");
    
            AlertaView.verificarLimites(tipo,
                    tipo.equals("Frequência cardiaca") ? "bpm"
                            : (tipo.equals("Pressão sanguínea") ? "mmHg" : "°C"),
                    valor);
    
            System.out.println();
        }
    }
    

    public int mensagemOpcoesAtualizacao() {
        System.out.println("--- Atualização de Dispositivo ---");
        System.out.println("1. Tipo\n2. Marca\n3. Modelo\n4. Status\n5. Valor");
        System.out.print("Escolha o campo que deseja atualizar: ");
        return sc.nextInt();
    }

    public int selecionarParaRemover(int numero) {
        System.out.print("Digite o número do dispositivo que deseja remover: ");
        return numero = sc.nextInt();
    }
}