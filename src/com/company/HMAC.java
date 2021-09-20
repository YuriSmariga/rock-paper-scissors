package com.company;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HMAC {

    private static  final String SHA2 = "HmacSHA256";

    private SecureRandom secureRandom = new SecureRandom();
    private int compMove;
    private byte[] keyBytes = new byte[16];
    HMAC (String[] turns){generateCompMove(turns);}

    public int getCompMove() {return  compMove;}
    private void generateCompMove(String[] turns) {this.compMove = secureRandom.nextInt(turns.length);}


    public String generateHMAC(String[] turns) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException{
        secureRandom.nextBytes(keyBytes);
        Mac s = Mac.getInstance(SHA2);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, SHA2);
        s.init(keySpec);
        byte[] b = s.doFinal(turns[this.compMove].getBytes("utf-8"));
        return this.bytesToHex(b);
    }

    public String bytesToHex(byte[] bytes){
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes){
            sb.append(String.format("%02x",b));
        }
        return sb.toString();
    }

    public  String getKeyHex() {
        return bytesToHex(keyBytes);
    }
}
