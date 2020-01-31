package com.mikhailovskii.lab1;

public class Railway {

    public static void main(String[] args) {
        String m = "Cryptography";  // Input string
        String c = "";  // Encrypted string

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

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = "";
            }
        }

        x = 0;
        isDown = false;

        for (int i = 0; i < length; i++) {
            arr[x][i] = "*";
            if (x == k - 1 || x == 0) {
                isDown = !isDown;
            }
            if (isDown) {
                x++;
            } else {
                x--;
            }
        }

        int current = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < length; j++) {
                if (arr[i][j].equals("*")) {
                    arr[i][j] = String.valueOf(c.charAt(current));
                    current++;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print("[" + i + "]" + "[" + j + "]:" + arr[i][j] + " ");
            }
            System.out.println();
        }

        String out = "";
        for (int i = 0; i < length; i++) {
            out += arr[x][i];
            if (x == k - 1 || x == 0) {
                isDown = !isDown;
            }
            if (isDown) {
                x++;
            } else {
                x--;
            }
        }
        System.out.println(out);

    }
}
