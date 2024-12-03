package view;

import java.util.Scanner;

public abstract class BaseView<T> {
    public void exibirDados(T entity) {
        System.out.println("\n********** Dados **********");
        System.out.println(entity);
        System.out.println("***************************");
    }

    public int opcoesAlterarEVoltar(Scanner ler) {
        System.out.println("\n1 - Alterar dados");
        System.out.println("2 - Voltar");
        System.out.print("Escolha uma opção: ");
        return ler.nextInt();
    }

    public boolean confirmarAlteracao(Scanner ler) {
        System.out.println("Deseja confirmar a alteração? (1 - Sim, 2 - Não)");
        int opcao = ler.nextInt();
        return opcao == 1;
    }

    protected String solicitarEntrada(Scanner ler, String mensagem) {
        System.out.print(mensagem);
        return ler.nextLine();
    }

    protected void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public abstract int menu(Scanner ler);
    public abstract int selecionarQualAlterar(Scanner ler);
    public abstract void alterarDados(Scanner ler, T entity);
}

