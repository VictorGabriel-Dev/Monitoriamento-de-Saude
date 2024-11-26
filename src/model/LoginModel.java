package model;

public class LoginModel {
    private String[] email= {"paciente","medico"};
    private int[] senha = {123,321};

    public int[] getSenha() {
        return senha;
    }

    public void setSenha(int[] senha) {
        this.senha = senha;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }
    /* Vou utilizar unicamente para armazenar.
     * Pode estar errado, mas depois troco.
     *
     * tenho que integrar o model com o controller
     *
     */

}
