package stud.ntnu.rest.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stud.ntnu.rest.calculator.model.Equation;
import stud.ntnu.rest.calculator.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/{username}/equations")
    public List<Equation> getEquations(@PathVariable String username) {
        return service.getEquations(username);
    }

    @PostMapping("/{username}/equation")
    public List<Equation> postEquation(@PathVariable String username, @RequestBody Equation e) {
        return service.postEquation(username, e).getEquations();
    }
}
