package com.mikhailovskii.lab7.generator;

public class LinearEquationSolver implements EquationSolverIF {

    @Override
    public double[] solveEquation(int[] arguments) {
        // ax + b = y         x = (y-b)/a
        int a = arguments[0];
        int b = arguments[1];
        int y = arguments[2];

        double[] root = new double[1];

        root[0] = (double) (y - b) / a;

        return root;
    }

}
