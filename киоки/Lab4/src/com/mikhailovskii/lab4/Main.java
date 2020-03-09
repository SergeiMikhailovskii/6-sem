package com.mikhailovskii.lab4;

public class Main {

    public static int PJW32Hash(String input) {
        int hash = 0;

        for (int i = 0; i < input.length(); i++) {
            byte byteOfData = (byte) input.charAt(i);
            hash = (hash << 4) + byteOfData;
            int h1 = hash & 0xF0000000;

            if (h1 != 0) {
                hash ^= h1 >> 24;
            }
        }

        return hash;
    }

    public static void main(String[] args) {
        int hash = PJW32Hash("BSUIR");
        System.out.println(Integer.toHexString(hash));
    }

}