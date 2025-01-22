package az.texnoera.todoappinspringboot.repository;

import az.texnoera.todoappinspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
}
