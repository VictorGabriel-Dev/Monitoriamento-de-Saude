package model;

public class AdmModel {
    private String[] email;
    private int senha;

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }
    /* o login precisa ser capaz, de verificar varias contas,
     * mas para isso, primeiro vou instancia-lo na main
     */

}
