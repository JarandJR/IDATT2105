package stud.ntnu.rest.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stud.ntnu.rest.calculator.model.Equation;
import stud.ntnu.rest.calculator.model.User;
import stud.ntnu.rest.calculator.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Equation> getEquations(String username) {
        Optional<User> u = userRepository.findById(username);
        return u.map(User::getEquations).orElse(null);
    }

    public User postEquation(String username, Equation e) {
        Optional<User> u = userRepository.findById(username);
        if (u.isPresent()) {
            u.get().addEquation(e);
            return updateUser(u.get(), username);
        }
        else
            return null;
    }

    public User updateUser(User updatedUser, String username) {
        return userRepository.findById(username).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setEquations(updatedUser.getEquations());
            return userRepository.save(user);
        }).orElseThrow(() -> new IllegalArgumentException("Could not find user"));
    }
}
