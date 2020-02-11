package com.mikhailovskii.lab1.keyword;

public class Keyword {

    public static void main(String[] args) {
        encrypt();

        decrypt();

    }

    private static void decrypt() {
        String m = "eTscins h irly ongiapotrcilu tmetshr e";
        String keyword = "CRYPTOGRAPHY";

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

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                System.out.print(mMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        int[] indexesArr = new int[keyword.length()];
        for (int i = 0; i < keyword.length(); i++) {
            indexesArr[i] = i;
        }

        for (int i = 0; i < keyword.length(); i++) {
            System.out.print(indexesArr[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < keyword.length() - 1; i++) {
            for (int j = i + 1; j < keyword.length(); j++) {
                if (keywordCharArray[i] > keywordCharArray[j]) {
                    int temp = indexesArr[i];
                    indexesArr[i] = indexesArr[j];
                    indexesArr[j] = temp;

                    char temp1 = keywordCharArray[i];
                    keywordCharArray[i] = keywordCharArray[j];
                    keywordCharArray[j] = temp1;
                }
            }
        }

        for (int i = 0; i < keyword.length(); i++) {
            System.out.print(indexesArr[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < keyword.length() - 1; i++) {
            for (int j = i + 1; j < keyword.length(); j++) {
                if (indexesArr[i] > indexesArr[j]) {
                    int tempInt = indexesArr[i];
                    indexesArr[i] = indexesArr[j];
                    indexesArr[j] = tempInt;

                    for (int k = 0; k < rows; k++) {
                        char temp = mMatrix[k][i];
                        mMatrix[k][i] = mMatrix[k][j];
                        mMatrix[k][j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                System.out.print(mMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        String output = "";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                output += mMatrix[i][j];
            }
        }

        output = output.trim();

        System.out.println("OUTPUT: " + output);

    }

    private static void encrypt() {
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

        output = output.trim();

        System.out.println("OUTPUT: " + output);

        System.out.println();
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
