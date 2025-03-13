package view;

import java.util.Scanner;

import utils.Mensagem;

public abstract class BaseView<T> {
    protected Scanner ler = new Scanner(System.in);

    public void exibirDados(T entity) {
        System.out.println(entity);
        System.out.println("***************************");
    }

    public int opcoesAlterarEVoltar() {
        System.out.println("\n1 - Alterar dados");
        System.out.println("2 - Voltar");
        System.out.print("Escolha uma opção: ");
        return ler.nextInt();
    }

    protected String solicitarEntrada(String mensagem) {
        System.out.print(mensagem);
        return ler.nextLine();
    }

    protected void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    protected int validateIntInput(String promptMessage) {
        while (!ler.hasNextInt()) {
            Mensagem.mensagemOpcaoInvalida();
            ler.next();
            System.out.println(promptMessage);
        }
        return ler.nextInt();
    }

    public abstract int menu();

    public abstract int selecionarQualAlterar();
}
