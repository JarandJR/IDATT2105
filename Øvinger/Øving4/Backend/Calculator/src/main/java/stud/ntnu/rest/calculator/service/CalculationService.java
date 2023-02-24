package stud.ntnu.rest.calculator.service;

import org.springframework.stereotype.Service;
import stud.ntnu.rest.calculator.model.Equation;

@Service
public class CalculationService {

    public double solveEquation(Equation e) {
        return e.solveSelf();
    }
}
