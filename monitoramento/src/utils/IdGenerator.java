package utils;

import java.security.SecureRandom;

public class IdGenerator {
    SecureRandom random = new SecureRandom();
    public String gerarIdConsulta() {
        int randomNumber = random.nextInt(0xFFFFFFF);
        return String.format("%06x", randomNumber);
    }
}
