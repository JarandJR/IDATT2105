package stud.ntnu.backend.calculator.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
public class CalculationController {

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }
}
