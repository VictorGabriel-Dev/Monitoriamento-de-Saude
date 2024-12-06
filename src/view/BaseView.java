package view;

import java.util.Scanner;

public abstract class BaseView<T> {
    protected Scanner ler = new Scanner(System.in); // Inicializando o Scanner

    public void exibirDados(T entity) {
        System.out.println("\n********** Dados **********");
        System.out.println(entity);
        System.out.println("***************************");
    }

    public int opcoesAlterarEVoltar() {
        System.out.println("\n1 - Alterar dados");
        System.out.println("2 - Voltar");
        System.out.print("Escolha uma opção: ");
        return ler.nextInt();
    }

    public boolean confirmarAlteracao() {
        System.out.println("Deseja confirmar? (1 - Sim, 2 - Não)");
        int opcao = ler.nextInt();
        return opcao == 1;
    }

    protected String solicitarEntrada(String mensagem) {
        System.out.print(mensagem);
        return ler.nextLine(); 
    }

    protected void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public abstract int menu();
    public abstract int selecionarQualAlterar();
}
