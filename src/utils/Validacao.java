package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Validacao {
    private static final Pattern EMAIL_REGEX = Pattern
            .compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    private static final Pattern TELEFONE_REGEX = Pattern.compile("\\(\\d{2}\\) \\d{5}-\\d{4}");
    private static final Pattern CPF_REGEX = Pattern.compile("\\d{11}");
    private static final Pattern CRM_REGEX = Pattern.compile("\\d{6}");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

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

    public static boolean validarData(String data) {
        try {
            LocalDate dataInserida = LocalDate.parse(data, DATE_FORMATTER);
            return !dataInserida.isBefore(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static LocalDate converterData(String dataStr) {
        return LocalDate.parse(dataStr, DATE_FORMATTER);
    }

    public static boolean validarHora(String hora) {
        try {
            LocalTime horaInserida = LocalTime.parse(hora, TIME_FORMATTER);
            int h = horaInserida.getHour();
            int m = horaInserida.getMinute();
            return !(h < 8 || h > 17 || (h == 17 && m > 0));
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static LocalTime converterHora(String horaStr) {
        return LocalTime.parse(horaStr, TIME_FORMATTER);
    }
}
