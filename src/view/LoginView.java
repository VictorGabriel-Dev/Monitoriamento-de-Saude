package view;

import java.util.List;
import java.util.Scanner;

import model.Medico;
import model.Paciente;
import model.UsuarioModel;
import model.UsuarioRepositorio;

public class LoginView {
    public UsuarioModel imprima(Scanner ler, UsuarioRepositorio repositorio) {
        System.out.println("Digite seu email: ");
        String email = ler.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = ler.nextLine();
        UsuarioModel usuario = validaLogin(repositorio.getUsuario(), email, senha);
        if (usuario == null) {
            System.out.println("Email ou senha inválidos. Tente novamente.");
        }
        return usuario;
    }

    private UsuarioModel validaLogin(List<UsuarioModel> usuarios, String email, String senha) {
        for (UsuarioModel usuario : usuarios) {
            System.out.println("Verificando usuário: " + usuario.getEmail()); // Debug
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                if (usuario instanceof Medico) {
                    System.out.println("Bem-vindo, médico!");
                } else if (usuario instanceof Paciente) {
                    System.out.println("Bem-vindo, paciente!");
                }
                return usuario;
            }
        }
        return null;
    }
    
}