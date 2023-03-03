package stud.ntnu.rest.calculator.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_equations",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "equation_id", referencedColumnName = "id")})
    private List<Equation> equations;

    public User(String username, String password, List<Equation> equations) {
        this.username = username;
        this.password = password;
        this.equations = equations;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Equation> getEquations() {
        return equations;
    }

    public void setEquations(List<Equation> equations) {
        this.equations = equations;
    }

    public void addEquation(Equation e) {
        if (!equations.contains(e))
                equations.add(e);
    }
}
