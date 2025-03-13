package controller;
import java.util.Scanner;
public abstract class BaseController<T> {
    protected Scanner ler = new Scanner(System.in);
    public abstract void alterarDados(T entity);
    protected String solicitarEntrada(String mensagem) {
        System.out.print(mensagem);
        return ler.nextLine(); 
    }
    protected void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
    public boolean confirmarAlteracao() {
        while (true) {
            System.out.println("Deseja confirmar? (1 - Sim, 2 - Não)");
            String input = ler.nextLine().trim();
            
            if (input.equals("1") || input.equalsIgnoreCase("s") || input.equalsIgnoreCase("sim")) {
                return true;
            } else if (input.equals("2") || input.equalsIgnoreCase("n") || input.equalsIgnoreCase("nao") || input.equalsIgnoreCase("não")) {
                return false;
            }
            System.out.println("Entrada inválida. Por favor digite 1 para Sim ou 2 para Não");
        }
    }
}
