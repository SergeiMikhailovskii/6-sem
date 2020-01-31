package com.mikhailovskii.lab1;

public class Keyword {

    public static void main(String[] args) {
        String keyword = "CRYPTOGRAPHY";
        String m = "This is encryption algorithms lecture";

        int length = keyword.length();
        int mLength = m.length();

        System.out.println(length + " " + mLength);

        int addedSymbols = mLength % length;    // Calculate how many symbols should we add to fill the input string
        if (addedSymbols != 0) {
            addedSymbols = length - addedSymbols;
        }

        for (int i = 0; i < addedSymbols; i++) {
            m += " ";
        }

        System.out.println(m.length());

        int rows = m.length() / length;
        String[][] arr = new String[rows][length];

        int curSymbol = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = String.valueOf(m.charAt(curSymbol));
                curSymbol++;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
