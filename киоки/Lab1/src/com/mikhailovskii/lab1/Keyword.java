package com.mikhailovskii.lab1;

public class Keyword {

    public static void main(String[] args) {
        String keyword = "CRYPTOGRAPHY";
        String m = "This is encryption algorithms lecture";

        char[] keywordCharArray = keyword.toCharArray();
        char[] mCharArray = m.toCharArray();

        int rows = m.length() / keyword.length() + (m.length() % keyword.length() == 0 ? 0 : 1);
        char[][] mMatrix = new char[rows][keyword.length()];

        int curElement = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                if (curElement < m.length()) {
                    mMatrix[i][j] = mCharArray[curElement];
                    curElement++;
                } else {
                    mMatrix[i][j] = Character.MIN_VALUE;
                }
            }
        }

        showMatrix(keyword, keywordCharArray, rows, mMatrix);

        for (int i = 0; i < keyword.length() - 1; i++) {
            for (int j = i + 1; j < keyword.length(); j++) {
                if (keywordCharArray[i] > keywordCharArray[j]) {
                    char temp = keywordCharArray[i];
                    keywordCharArray[i] = keywordCharArray[j];
                    keywordCharArray[j] = temp;

                    for (int k = 0; k < rows; k++) {
                        temp = mMatrix[k][i];
                        mMatrix[k][i] = mMatrix[k][j];
                        mMatrix[k][j] = temp;
                    }
                }
            }
        }

        showMatrix(keyword, keywordCharArray, rows, mMatrix);

        String output = "";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                output += mMatrix[i][j];
            }
        }

        System.out.println(output);

    }

    private static void showMatrix(String keyword, char[] keywordCharArray, int rows, char[][] mMatrix) {
        for (int i = 0; i < keyword.length(); i++) {
            System.out.print(keywordCharArray[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                System.out.print(mMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
