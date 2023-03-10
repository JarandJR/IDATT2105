package stud.ntnu.rest.calculator.model;


import jakarta.persistence.*;
import org.hibernate.sql.Update;
import stud.ntnu.rest.calculator.asset.EquationSolver;

import java.util.Objects;

@Entity
public class Equation {

    @Id
    @GeneratedValue
    private int id;
    private String equation;
    private double result;
    @ManyToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "user_username")
    private User user;

    public Equation(int id, String equation, double result, User user) {
        this.id = id;
        this.equation = equation;
        this.result = result;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equation equation1 = (Equation) o;
        return id == equation1.id && Double.compare(equation1.result, result) == 0 && Objects.equals(equation, equation1.equation) && Objects.equals(user, equation1.user);
    }

    public String getCompleteEquation() {
        return equation + " = " + result;
    }

    public double solveSelf() {
        result = EquationSolver.solveEquation(equation);
        return result;
    }

    @Override
    public String toString() {
        return  equation +
                " = " + result;
    }
}
