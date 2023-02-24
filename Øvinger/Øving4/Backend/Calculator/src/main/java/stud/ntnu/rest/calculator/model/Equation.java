package stud.ntnu.rest.calculator.model;


import stud.ntnu.rest.calculator.asset.EquationSolver;

public class Equation {
    private String equation;
    private EquationSolver solver;

    public Equation(String equation) {
        this.equation = equation;
        this.solver = new EquationSolver();
    }

    public Equation() {
        this.solver = new EquationSolver();
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public double solveSelf() {
        return solver.solveEquation(equation);
    }
}
