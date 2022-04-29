package SDGP.GroupD.CW2.Utilities;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class PasswordHasher {
    private static final Random random = new SecureRandom();
    private static final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#!£&*^";
    private static final int iterations = 100;
    private static final int key_length = 256;


    public static String getSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return new String(returnValue);
    }


    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, key_length);
        Arrays.fill(password, Character.MIN_VALUE);

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
            System.gc();
        }
    }


    public static String generateSecurePassword(String password, String salt) {
        String returnValue = null;

        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
        returnValue = Base64.getEncoder().encodeToString(securePassword);

        return returnValue;
    }


    public static boolean verifyPassword(String providedPassword, String securedPassword, String salt) {
        boolean returnValue = false;

        String newSecurePassword = generateSecurePassword(providedPassword, salt);

        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);

        return returnValue;
    }
}
