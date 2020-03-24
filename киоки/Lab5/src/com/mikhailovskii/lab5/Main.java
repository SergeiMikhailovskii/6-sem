package com.mikhailovskii.lab5;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        String m = "БГУИР";

        int p = 17;
        int q = 19;
        int r = p * q;

        int hash = PJW32Hash(m, r);

        int fi_r = (p - 1) * (q - 1);
        int e = 43;

        int d = gcd(e, fi_r)[0];

        Pair<Integer, Integer> openKey = new Pair<>(e, r);
        Pair<Integer, Integer> secretKey = new Pair<>(d, r);

        BigInteger s = new BigInteger(String.valueOf(hash)).pow(secretKey.getFirstKey()).mod(new BigInteger(String.valueOf(secretKey.getSecondKey())));

        Pair sendMessage = new Pair<>(m, s);
        System.out.println("Send message:" + sendMessage.toString());

        // Received message
        Pair<String, Integer> receivedMessage = new Pair<>("БГУИР", 290);

        int receivedHash = PJW32Hash(receivedMessage.getFirstKey(), r);
        BigInteger sReceived = new BigInteger(String.valueOf(receivedMessage.getSecondKey())).pow(openKey.getFirstKey()).mod(new BigInteger(String.valueOf(openKey.getSecondKey())));

        System.out.println("Received message hash: " + receivedHash);
        System.out.println("Received key hash: " + sReceived);

        if (sReceived.equals(new BigInteger(String.valueOf(receivedHash)))) {
            System.out.println("Signature is correct");
        } else {
            System.out.println("Signature is incorrect");
        }

    }

    private static int PJW32Hash(String input, int n) {

        int hash = 100;

        for (int i = 0; i < input.length(); i++) {
            int symbol = (byte) input.charAt(i) - 15;
//            // Тк буквы ё в юникоде нету
//            if (symbol > 6) {
//                symbol++;
//            }
            hash = ((hash + symbol) * (hash + symbol)) % n;
        }

        return hash;
    }

    private static int[] gcd(int p, int q) {
        if (q == 0)
            return new int[]{1, 0};

        int[] vals = gcd(q, p % q);
        int a = vals[1];
        int b = vals[0] - (p / q) * vals[1];
        return new int[]{a, b};
    }

}
