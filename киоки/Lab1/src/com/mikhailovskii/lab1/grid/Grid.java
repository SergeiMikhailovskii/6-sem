package com.mikhailovskii.lab1.grid;

public class Grid {

    public static void main(String[] args) {
        String m = "ЭТОЛЕКЦИЯПОКРИПТ";
        final int size = 4;

        int sizeTo16 = 16 - m.length() % 16;
        if (m.length() % 16 != 0) {
            for (int i = 0;i<sizeTo16;i++){
                m+='*';
            }
        }

        System.out.println(m);

        final Cell[] fourOnFourGrid = {
                new Cell(0, 0),
                new Cell(1, 3),
                new Cell(3, 1),
                new Cell(2, 2)
        };

        char[][] matrix = new char[size][size];

        int parts = m.length() / size;

        for (int i = 0; i < parts; i++) {
            for (int j = 0; j < size; j++) {
                matrix[fourOnFourGrid[j].getLine()][fourOnFourGrid[j].getColumn()] = m.charAt(i * size + j);
            }
            showMatrix(matrix, size);
            System.out.println();
            matrix = rotateRight(matrix, size);
        }

        showMatrix(matrix, size);

        String output = "";

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                output += matrix[i][j];
            }
        }

        System.out.println(output);

        matrix = new char[size][size];

        for (int i = 0; i < parts; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = output.charAt(i * size + j);
            }
        }

        String encrypted = "";
        for (int i = 0; i<parts;i++) {
            for (int j = 0; j<size;j++) {
                encrypted+=matrix[fourOnFourGrid[j].getLine()][fourOnFourGrid[j].getColumn()];
            }
            matrix = rotateRight(matrix, size);
            System.out.println();
            showMatrix(matrix, size);
        }

        showMatrix(matrix, size);

        System.out.println(encrypted);

    }

    private static char[][] rotateRight(char[][] grid, int gridSize) {
        char[][] arr = new char[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                arr[i][j] = grid[gridSize - j - 1][i];
            }
        }

        return arr;
    }

    private static char[][] rotateLeft(char[][] grid, int gridSize) {
        char[][] arr = new char[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                arr[gridSize - j - 1][i] = grid[i][j];
            }
        }

        return arr;
    }

    private static void showMatrix(char[][] grid, int gridSize) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

}
