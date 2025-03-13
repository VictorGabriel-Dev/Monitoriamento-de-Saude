package controller;

import java.util.Scanner;

import utils.Mensagem;

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
        System.out.println(Mensagem.mensagemParaConfirmar());
        while (true) {
            String input = ler.nextLine().trim();
            if (input.equals(Mensagem.mensagemDigitaUm()) ||
                    input.equalsIgnoreCase(Mensagem.mensagemDigitaS()) ||
                    input.equalsIgnoreCase(Mensagem.mensagemDigitaSim())) {
                return true;
            } else if (input.equals(Mensagem.mensagemDigitaDois()) ||
                    input.equalsIgnoreCase(Mensagem.mensagemDigitaN()) ||
                    input.equalsIgnoreCase(Mensagem.mensagemDigitaNaoSemAU()) ||
                    input.equalsIgnoreCase(Mensagem.mensagemDigitaNao())) {
                return false;
            }
            System.out.println(Mensagem.mensagemInvalidaDigUmOuDois());
        }
    }
}
