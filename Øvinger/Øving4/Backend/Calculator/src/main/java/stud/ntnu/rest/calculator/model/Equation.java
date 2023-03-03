package stud.ntnu.rest.calculator.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import stud.ntnu.rest.calculator.asset.EquationSolver;

@Entity
public class Equation {

    @Id
    @GeneratedValue
    private int id;
    private String equation;
    private double result;

    public Equation(int id, String equation, double result) {
        this.id = id;
        this.equation = equation;
        this.result = result;
    }

    public Equation() {
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double solveSelf() {
        result = EquationSolver.solveEquation(equation);
        return result;
    }
}
