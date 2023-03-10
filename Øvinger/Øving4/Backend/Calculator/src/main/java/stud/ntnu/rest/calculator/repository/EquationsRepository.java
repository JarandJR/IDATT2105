package stud.ntnu.rest.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stud.ntnu.rest.calculator.model.Equation;

public interface EquationsRepository extends JpaRepository <Equation, Integer> {
}
