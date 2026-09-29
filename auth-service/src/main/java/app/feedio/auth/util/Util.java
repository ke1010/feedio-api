package app.feedio.auth.util;

import java.security.SecureRandom;

public class Util {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String generateOtp() {
        int number = SECURE_RANDOM.nextInt(1_000_000);
        return String.format("%06d", number);
    }
}
