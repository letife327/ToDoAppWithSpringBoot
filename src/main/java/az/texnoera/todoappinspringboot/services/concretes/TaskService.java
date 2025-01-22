package az.texnoera.todoappinspringboot.services.concretes;

import az.texnoera.todoappinspringboot.entity.Task;
import az.texnoera.todoappinspringboot.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    public List<Task> getTasks(Integer userId) {
        if(userId == null){
            return taskRepository.findAll();
        }
        return taskRepository.findByUserId(userId);
    }
}
