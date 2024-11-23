package view;
import model.AdmModel;

import java.util .*;

public class LoginView {
    public static void main(String[] args) {

        //metodos
        AdmModel adm = new AdmModel();
        Scanner sc = new Scanner(System.in);

        //declaração de variaveis verificadoras
        boolean verificador = false; // não sei se preciso dessa variavel ainda
        String a; //verificar email
        int b; //verificar senha

        //instanciando array
        System.out.println("Quantas Contas você quer registrar?");
        int tamanho = sc.nextInt();//refencia o tamanho do array
        sc.nextLine();//consumidor
        int[] senha = new int[tamanho];
        String[] email = new String[tamanho];

        for(int i=0; i < email.length; i++){
            System.out.println();
            System.out.println("---Cadastro---");
            System.out.println("E-mail: ");
            email[i] = sc.nextLine();
            System.out.println("Senha: ");
            senha[i] = sc.nextInt();
            sc.nextLine();

        }

        adm.setEmail(email);//pronto
        adm.setSenha(senha);//pronto

        System.out.println();
        //Metodo mostrar senhas
        for(int mostrarSenha : adm.getSenha()){
            System.out.println(mostrarSenha);
        }
        //metodo mostrar email
        for(String mostrarEmail : adm.getEmail()){
            System.out.println(mostrarEmail);
        }

        String menu;
        System.out.println("quer fazer login");
        menu = sc.nextLine();
        System.out.println("digite senha: ");
        int valor = sc.nextInt();


        while (menu.equals("sim")){
            for (int x : adm.getSenha()){

                if (x == valor){
                    System.out.println("login");
                    System.exit(0);
                }
            }
        }



        /*
        / login-----------------

        String email = adm.getEmail();
        int senha = adm.getSenha();

        while (verificador != true) {//eu pre
            int mostrarSenha = adm.getSenha();
            for(int i=0; i < mostrarSenha)

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
        * Substituir o uso de variaveis para arrays ou objetos
         * não sei como fazer isso, vou ter que pesquisar
         */
    }
}
