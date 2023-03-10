package stud.ntnu.rest.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stud.ntnu.rest.calculator.model.Equation;
import stud.ntnu.rest.calculator.model.User;
import stud.ntnu.rest.calculator.repository.EquationsRepository;
import stud.ntnu.rest.calculator.repository.UserRepository;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.*;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EquationsRepository equationsRepository;

    public List<Equation> getEquations(String username) {
        Optional<User> u = userRepository.findById(username);
        return u.map(this::getEquations).orElse(null);
    }

    public List<Equation> getReducedEquations(String username) {
        Optional<User> user = userRepository.findById(username);
        List<Equation> equations = null;
        if (user.isPresent())
            equations = getEquations(user.get());

        var newList = new ArrayList<Equation>();
        int ten = Objects.requireNonNull(equations).size() - 10;
        for (int i = equations.size() - 1; i > 0; i--) {
            newList.add(equations.get(i));
            if (i == ten)
                break;
        }
        return newList;
    }

    public List<Equation> postEquation(String username, Equation e) {
        Optional<User> optionalUser = userRepository.findById(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            e.setUser(user);
            equationsRepository.save(e);
            return getEquations(user);
        }
        return null;
    }

    private List<Equation> getEquations(User user) {
        List<Equation> equations = equationsRepository.findAll();
        List<Equation> es = new ArrayList<>();
        for (Equation e : equations) {
            if (e.getUser().equals(user))
                es.add(e);
        }
        return es;
    }

    public User removeEquation(String username, Equation e) {
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()){
            user.get().removeEquation(e);
            return user.get();
        }
        return null;
    }

    public User clearEquations(String username) {
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()) {
            User updatedUser = user.get();
            List<Equation> list  = updatedUser.getEquations();
            list.clear();
            updatedUser.setEquations(list);
            return userRepository.save(updatedUser);
        }
        return null;
    }

    public User addUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        user.setSalt(salt);
        try {
            byte[] hashedPassword = hashPassword(password, salt);
            user.setPassword(hashedPassword);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        if (user.getUsername() == null || user.getSalt() == null || user.getPassword() == null)
            return null;
       return userRepository.save(user);
    }

    public boolean login(String username, String password) {
        Optional<User> user = userRepository.findById(username);
        System.out.println(username + "/ " + password);
        return user.map(value -> {
            try {
                return Arrays.equals(value.getPassword(), hashPassword(password, user.get().getSalt()));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                e.printStackTrace();
            }
            return false;
        }).orElse(false);
    }

    private byte[] hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return factory.generateSecret(spec).getEncoded();
    }

    public boolean deleteUser(String username) {
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }

    public void clearAllData() {
        equationsRepository.deleteAll();
        userRepository.deleteAll();
    }
}
