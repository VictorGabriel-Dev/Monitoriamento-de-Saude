package utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataHora {
        public static String getDataHoraAtual() {
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return agora.format(formato);
        }
}
