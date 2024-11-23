package view;
import model.AdmModel;

import java.util .*;

public class LoginView {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean verificador = false;
        String a;// valor de comparação
        int b;//valor de comparação
        int x;//senha de entrada
        String z;// email de entrada

        System.out.println("---Cadastro---");
        System.out.println("email: ");
        z = sc.nextLine();
        System.out.println("Senha: ");
        x = sc.nextInt();
        sc.nextLine();

        AdmModel adm = new AdmModel();

        adm.setSenha(x);
        adm.setEmail(z);

        System.out.println();

        System.out.println(adm.getEmail());
        System.out.println(adm.getSenha());

        // login-----------------

        String email = adm.getEmail();
        int senha = adm.getSenha();

        while (verificador != true) {

            System.out.println("email");
            a = sc.nextLine();
            System.out.println("senha");
            b = sc.nextInt();

            //verificador
            if (senha == b & email.equals(a)) {
                System.out.println("login feito");
                verificador = true;
            } else {
                System.out.println("erro");
                System.out.println("----------");
                sc.nextLine();//consumir proxima linha.
            }
        }
        sc.close();
        /* Substituir o uso de variaveis para arrays ou objetos
         * não sei como fazer isso, vou ter que pesquisar
         */
    }
}
