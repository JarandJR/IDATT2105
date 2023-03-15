package stud.ntnu.rest.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stud.ntnu.rest.calculator.model.Equation;
import stud.ntnu.rest.calculator.model.LoginRequest;
import stud.ntnu.rest.calculator.model.User;
import stud.ntnu.rest.calculator.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/equations/{username}")
    public List<Equation> getEquations(@PathVariable String username) {
        return service.getEquations(username);
    }

    @GetMapping("/red/equations/{username}")
    public List<Equation> getReducedEquations(@PathVariable String username) {
       return service.getReducedEquations(username);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody LoginRequest user) {
        System.out.println(user.getUsername() + "/" + user.getPassword());
        return service.addUser(user.getUsername(), user.getPassword());
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest user) {
        return service.login(user.getUsername(), user.getPassword());
    }

    @PostMapping(value = "/login/token")
    public String generateToken(final @RequestBody LoginRequest loginRequest) {
        return service.loginAndGetToken(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @PostMapping("/equation/{username}")
    public List<Equation> postEquation(@PathVariable String username, @RequestBody Equation e) {
        return service.postEquation(username, e);
    }

    @DeleteMapping("/delete/{username}")
    public boolean deleteUser(@PathVariable String username) {
        return service.deleteUser(username);
    }

    @DeleteMapping("/delet/equation/{username}")
    public User deleteEquation(@PathVariable String username, @RequestBody Equation e) {
        return service.removeEquation(username, e);
    }

    @DeleteMapping("/clear/{username}")
    public User clearEquations(@PathVariable String username) {
        return service.clearEquations(username);
    }

    @DeleteMapping("/clear/all")
    public void clearAllData() {
        service.clearAllData();
    }
}
