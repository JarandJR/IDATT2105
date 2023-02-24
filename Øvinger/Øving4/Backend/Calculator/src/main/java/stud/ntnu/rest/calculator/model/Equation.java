package stud.ntnu.rest.calculator.model;


import stud.ntnu.rest.calculator.asset.EquationSolver;

public class Equation {
    private String equation;

    public Equation(String equation) {
        this.equation = equation;
    }

    public Equation() {
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public double solveSelf() {
        return EquationSolver.solveEquation(equation);
    }
}
