package com.mikhailovskii.lab2;

class SDES {

    private Keys keys;

    private int[][] S1 = {
            {01, 00, 11, 10},
            {11, 10, 01, 00},
            {00, 10, 01, 11},
            {11, 01, 11, 10}
    };

    private int[][] S2 = {
            {00, 01, 10, 11},
            {10, 00, 01, 11},
            {11, 00, 01, 00},
            {10, 01, 00, 11}
    };

    void setKeys(Keys keys) {
        this.keys = keys;
    }

    private byte[] IP(byte[] num) {
        byte[] resultByte = new byte[8];
        resultByte[0] = num[1];
        resultByte[1] = num[5];
        resultByte[2] = num[2];
        resultByte[3] = num[0];
        resultByte[4] = num[3];
        resultByte[5] = num[7];
        resultByte[6] = num[4];
        resultByte[7] = num[6];
        return resultByte;
    }

    private byte[] round(byte[] num, byte[] key) {
        byte[] rightPart = new byte[8];

        rightPart[0] = num[7];
        rightPart[1] = num[4];
        rightPart[2] = num[5];
        rightPart[3] = num[6];
        rightPart[4] = num[5];
        rightPart[5] = num[6];
        rightPart[6] = num[7];
        rightPart[7] = num[4];

        for (int i = 0; i < rightPart.length; i++) {
            rightPart[i] ^= key[i];
        }

        num = F(rightPart, num);

        return num;
    }

    private byte[] F(byte[] numPart, byte[] num) {
        byte[] P4Byte = new byte[4];

        int row = numPart[0] * 2 + numPart[3];
        int column = numPart[1] * 2 + numPart[2];
        P4Byte[3] = (byte) (S1[row][column] / 10);
        P4Byte[0] = (byte) (S1[row][column] % 10);

        row = numPart[4] * 2 + numPart[7];
        column = numPart[5] * 2 + numPart[6];

        P4Byte[2] = (byte) (S2[row][column] / 10);
        P4Byte[1] = (byte) (S2[row][column] % 10);

        num[0] = (byte) (num[0] ^ P4Byte[1]);
        num[1] = (byte) (num[1] ^ P4Byte[3]);
        num[2] = (byte) (num[2] ^ P4Byte[2]);
        num[3] = (byte) (num[3] ^ P4Byte[0]);


        return num;
    }

    private byte[] swapParts(byte[] number) {
        byte[] resByte = new byte[8];
        for (int i = 0; i < 4; i++) {
            resByte[i] = number[i + 4];
            resByte[i + 4] = number[i];
        }
        return resByte;
    }

    private byte[] reverseIP(byte[] text) {
        byte[] result = new byte[8];
        result[0] = text[3];
        result[1] = text[0];
        result[2] = text[2];
        result[3] = text[4];
        result[4] = text[6];
        result[5] = text[1];
        result[6] = text[7];
        result[7] = text[5];
        return result;
    }

    private byte[] encrypt(byte[] num) {
        byte[] encryptArr = IP(num);
        encryptArr = round(encryptArr, keys.getFirstKey());
        encryptArr = swapParts(encryptArr);
        encryptArr = round(encryptArr, keys.getSecondKey());
        encryptArr = reverseIP(encryptArr);
        return encryptArr;
    }

    private void showNum(byte[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        System.out.println();
    }

    private byte[] decrypt(byte[] num) {
        byte[] result = IP(num);
        result = round(result, keys.getSecondKey());
        result = swapParts(result);
        result = round(result, keys.getFirstKey());
        result = reverseIP(result);

        return result;
    }

    private byte[] binaryToArray(int num) {
        byte[] numArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            numArr[7 - i] = (byte) (num % 2);
            num /= 2;
        }
        return numArr;
    }

    private int byteArrayToInt(byte[] text) {
        int index = 0;

        for (int i = text.length; i > 0; i--) {
            index += text[i - 1] * Math.pow(2, text.length - i);

        }
        return index;

    }

    public int decrypt(int num) {
        return byteArrayToInt(decrypt(binaryToArray(num)));
    }

    public int encrypt(int num) {
        return byteArrayToInt(encrypt(binaryToArray(num)));
    }
}
