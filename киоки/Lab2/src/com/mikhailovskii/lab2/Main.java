package com.mikhailovskii.lab2;

public class Main {

    public static void main(String[] args) {
        Keys keys = new Keys();
        keys.generateKeys(0b10010_10011);

        SDES sdes = new SDES();
        sdes.setKeys(keys);

        int num = sdes.encrypt(0b1011_0110);
        System.out.println(Integer.toBinaryString(num));

        int res = sdes.decrypt(num);
        System.out.println(Integer.toBinaryString(res));
    }

}
