package com.mikhailovskii.lab2;

public class Main {

    public static void main(String[] args) {
        Keys keys = new Keys();
        keys.generateKeys(0b10010_10011);

        for (int i = 0; i < keys.getFirstKey().length; i++) {
            System.out.print(keys.getFirstKey()[i]);
        }
        System.out.println();

        for (int i = 0; i < keys.getSecondKey().length; i++) {
            System.out.print(keys.getSecondKey()[i]);
        }
        System.out.println();

        SDES sdes = new SDES();
        sdes.setKeys(keys);

        int num = sdes.encrypt(0b1011_0110);
        System.out.println(Integer.toBinaryString(num));

        int res = sdes.decrypt(num);
        System.out.println(Integer.toBinaryString(res));
    }

}
