package stud.ntnu.rest.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import stud.ntnu.rest.calculator.model.Equation;

@Service
public class CalculationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculationService.class);

    public double solveEquation(Equation e) {
        LOGGER.info("Equation received: " + e.getEquation());
        double result = e.solveSelf();
        LOGGER.info("Result from calculation: " + result);
        return result;
    }
}
