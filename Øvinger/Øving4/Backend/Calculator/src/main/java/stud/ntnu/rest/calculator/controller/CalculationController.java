package stud.ntnu.rest.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stud.ntnu.rest.calculator.model.Equation;
import stud.ntnu.rest.calculator.service.CalculationService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
public class CalculationController {

    @Autowired
    CalculationService service;

    @GetMapping("/")
    public String connect() {
        return "Hello world";
    }

   @PostMapping("/calculate")
    public double postCalculation(@RequestBody Equation equation) {
        System.out.println(equation.getEquation());
        return service.solveEquation(equation);
    }
}
