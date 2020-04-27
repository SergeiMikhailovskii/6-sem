package com.mikhailovskii.lab7.generator;

public class SquareEquationSolver implements EquationSolverIF {

    @Override
    public double[] solveEquation(int[] arguments) {
        int a = arguments[0];
        int b = arguments[1];
        int c = arguments[2];

        double sqrtD = Math.sqrt(b * b - 4 * a * c);

        double[] roots;
        if (sqrtD < 0) {
            return null;
        } else if (sqrtD == 0) {
            roots = new double[1];
            roots[0] = (0 - b + sqrtD) / (2 * a);
        } else {
            roots = new double[2];
            roots[0] = (0 - b - sqrtD) / (2 * a);
            roots[1] = (0 - b + sqrtD) / (2 * a);
        }

        return roots;
    }

}
