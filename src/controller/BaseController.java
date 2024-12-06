package controller;
import java.util.Scanner;
public abstract class BaseController<T> {
    protected Scanner ler = new Scanner(System.in);
    public abstract void alterarDados(T entity);
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
}
