package utils;

import java.util.regex.Pattern;

public class Validacao {
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    private static final Pattern TELEFONE_REGEX = Pattern.compile("\\(\\d{2}\\) \\d{5}-\\d{4}");
    private static final Pattern CPF_REGEX = Pattern.compile("\\d{11}");
    private static final Pattern CRM_REGEX = Pattern.compile("\\d{6}");

    public static boolean validarEmail(String email) {
        return EMAIL_REGEX.matcher(email).matches();
    }

    public static boolean validarTelefone(String telefone) {
        return TELEFONE_REGEX.matcher(telefone).matches();
    }

    public static boolean validarSenha(String senha) {
        return senha != null && senha.length() >= 6;
    }

    public static boolean validarCpf(String cpf) {
        return CPF_REGEX.matcher(cpf).matches();
    }

    public static boolean validarCrm(String crm) {
        return CRM_REGEX.matcher(crm).matches();
    }
}
