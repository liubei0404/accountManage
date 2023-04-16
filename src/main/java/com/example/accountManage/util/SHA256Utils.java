package com.example.accountManage.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Utils {

    public static String encrypt(String password) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : bytes) {
                String hexString = Integer.toHexString(b & 0xff);
                if (hexString.length() == 1) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(hexString);
            }
            result = stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
