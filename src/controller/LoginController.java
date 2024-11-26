package controller;

import java.util.ArrayList;
import model.UsuarioModel;

public class LoginController {
    private ArrayList<UsuarioModel> usuarios;

    public LoginController(ArrayList<UsuarioModel> usuarios){
        this.usuarios = usuarios;
    }

    //verificador de conta
    public boolean validaLogin(String email, String senha){
          for(UsuarioModel usuarioModel : usuarios){
              if (usuarioModel.getEmail().equals(email) && usuarioModel.getSenha().equals(senha)){
                  return true;//conta válida
              }
          }
          return false;// conta inválida
    }
}
