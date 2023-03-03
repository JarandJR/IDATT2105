package stud.ntnu.rest.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stud.ntnu.rest.calculator.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
