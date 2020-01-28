package com.mikhailovskii.lab1;

public class Main {

    public static void main(String[] args) {
        String m = "Cryptography";
        String c = "";

        int length = m.length();
        int k = 3;

        String[][] arr = new String[k][length];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = "";
            }
        }

        int x = 0;
        boolean isDown = false;
        for (int i = 0; i < length; i++) {
            arr[x][i] = String.valueOf(m.charAt(i));
            if (x == k - 1 || x == 0) {
                isDown = !isDown;
            }
            if (isDown) {
                x++;
            } else {
                x--;
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < length; j++) {
                c += arr[i][j];
            }
        }

        System.out.println(c);

    }
}
