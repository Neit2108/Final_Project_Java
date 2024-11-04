package com.epu.QuanLyNhaTro.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtils {

    private static final int ITERATIONS = 10000; //số vòng lặp mã hóa
    private static final int KEY_LENGTH = 256; //độ dài của key
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256"; //Thuật toán mã hóa

    //Hàm mã hóa mật khẩu
    public static String hashPassword(String password) {
        byte[] salt = getSalt();
        byte[] hash = hashPassword(password.toCharArray(), salt);
        return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hash);
    }

    //Hàm kiểm tra mật khẩu
    public static boolean verifyPassword(String password, String hashedPassword) {
        String[] parts = hashedPassword.split(":");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] hash = Base64.getDecoder().decode(parts[1]);
        byte[] calculatedHash = hashPassword(password.toCharArray(), salt);
        return MessageDigest.isEqual(calculatedHash, hash);
    }

    //Hàm tạo salt
    private static byte[] getSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    //Hàm mã hóa mật khẩu
    private static byte[] hashPassword(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}