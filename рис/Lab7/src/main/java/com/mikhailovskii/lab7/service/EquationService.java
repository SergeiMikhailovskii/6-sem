package com.mikhailovskii.lab7.service;

import com.mikhailovskii.lab7.generator.EquationSolverIF;

public class EquationService {

    // equationSolver имеет тип интерфейса, чтобы в случае, если для решения будет использован другой класс,
    // то в данном классе не надо будет ничего менять, а новому классу надо будет реализовать интерфейс EquationSolverIF
    private EquationSolverIF equationSolver;

    // если значения переменных не переданы, то они подтягиваются из strings.xml (DI)
    private int[] arguments;

    public EquationService() {
    }

    public EquationService(int[] arguments) {
        this.arguments = arguments;
    }

    public double[] solveEquation() {
        return equationSolver.solveEquation(arguments);
    }

    public EquationSolverIF getEquationSolver() {
        return equationSolver;
    }

    public void setEquationSolver(EquationSolverIF equationSolver) {
        this.equationSolver = equationSolver;
    }

    public int[] getArguments() {
        return arguments;
    }

    public void setArguments(int[] arguments) {
        this.arguments = arguments;
    }

}
