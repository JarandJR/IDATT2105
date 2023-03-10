package stud.ntnu.rest.calculator.model;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
public class User {

    @Id
    private String username;
    private byte[] password;
    private byte[] salt;
    @OneToMany(mappedBy = "equation", cascade = CascadeType.ALL)
    private List<Equation> equations;

    public User(String username, byte[] password, List<Equation> equations, byte[] salt) {
        this.username = username;
        this.password = password;
        this.equations = equations;
        this.salt = salt;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public List<Equation> getEquations() {
        return equations;
    }

    public void setEquations(List<Equation> equations) {
        this.equations = equations;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public void addEquation(Equation e) {
        if (!equations.contains(e))
                equations.add(e);
    }

    public void removeEquation(Equation e) {
        equations.removeIf(eq -> eq.equals(e));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Arrays.equals(password, user.password) && Arrays.equals(salt, user.salt) && Objects.equals(equations, user.equations);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(username, equations);
        result = 31 * result + Arrays.hashCode(password);
        result = 31 * result + Arrays.hashCode(salt);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password=" + Arrays.toString(password) +
                ", salt=" + Arrays.toString(salt) +
                ", equations=" + equations +
                '}';
    }
}
