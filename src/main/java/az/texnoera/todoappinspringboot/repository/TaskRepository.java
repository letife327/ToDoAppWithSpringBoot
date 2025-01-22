package az.texnoera.todoappinspringboot.repository;

import az.texnoera.todoappinspringboot.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByUserId(Integer userId);
}
