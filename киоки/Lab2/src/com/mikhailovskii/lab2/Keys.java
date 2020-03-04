package com.mikhailovskii.lab2;

public class Keys {

    private byte[] firstKey;
    private byte[] secondKey;

    public byte[] getFirstKey() {
        return firstKey;
    }

    public byte[] getSecondKey() {
        return secondKey;
    }

    public void generateKeys(int key) {
        byte[] keyArr = binaryKeyToArray(key);

        keyArr = P10(keyArr);

        byte[] shift = shift(keyArr);

        firstKey = P8(shift);
        shift = shift(shift(keyArr));
        secondKey = P8(shift);
    }

    private byte[] binaryKeyToArray(int num) {
        byte[] key = new byte[10];
        for (int i = 0; i < 10; i++) {
            key[9 - i] = (byte) (num % 2);
            num /= 2;
        }
        return key;
    }

    private byte[] P8(byte[] key) {
        byte[] resultByte = new byte[8];

        resultByte[0] = key[5];
        resultByte[1] = key[2];
        resultByte[2] = key[6];
        resultByte[3] = key[3];
        resultByte[4] = key[7];
        resultByte[5] = key[4];
        resultByte[6] = key[9];
        resultByte[7] = key[8];

        return resultByte;
    }

    private byte[] P10(byte[] key) {
        byte[] resultByte = new byte[10];

        resultByte[0] = key[2];
        resultByte[1] = key[4];
        resultByte[2] = key[1];
        resultByte[3] = key[6];
        resultByte[4] = key[3];
        resultByte[5] = key[9];
        resultByte[6] = key[0];
        resultByte[7] = key[8];
        resultByte[8] = key[7];
        resultByte[9] = key[5];

        return resultByte;
    }

    private byte[] shift(byte[] key) {
        byte temp = key[0];
        for (int i = 1; i < 5; i++) {
            key[i - 1] = key[i];
        }
        key[4] = temp;

        temp = key[5];
        for (int i = 6; i < 10; i++) {
            key[i - 1] = key[i];
        }
        key[9] = temp;

        return key;
    }

}
