package az.texnoera.todoappinspringboot.services.concretes;

import az.texnoera.todoappinspringboot.entity.Task;
import az.texnoera.todoappinspringboot.mapper.TaskMapper;
import az.texnoera.todoappinspringboot.model.requests.RequestTask;
import az.texnoera.todoappinspringboot.model.requests.UpdateTaskRequest;
import az.texnoera.todoappinspringboot.model.response.ResponseTask;
import az.texnoera.todoappinspringboot.repository.TaskRepository;
import az.texnoera.todoappinspringboot.services.abstracts.ITaskService;
import az.texnoera.todoappinspringboot.validations.TaskValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;

    public List<ResponseTask> getTasks(Integer userId) {
        if (userId == null) {
            throw new RuntimeException("User id cannot be null");
        }
        return taskRepository.findByUserId(userId).stream().map(task -> {
            return TaskMapper.taskToResponse(task);
        }).toList();
    }

    public ResponseTask getTask(Integer id) {
        if (id == null) {
            throw new RuntimeException("Invalid id");
        }
        Task task = taskRepository.findById(id).get();
        return TaskMapper.taskToResponse(task);
    }

    public ResponseTask addTask(RequestTask newTask) {
        if (!TaskValidation.isValidDate(newTask.getDueDate())
                || !TaskValidation.isValidPriority(newTask.getPriority())
                || !TaskValidation.isValidStatus(String.valueOf(newTask.getStatus()))) {
            throw new RuntimeException("Invalid date or priority or status");
        }
        Task taskResponse = TaskMapper.mapToTask(newTask);
        Task savedTask = taskRepository.save(taskResponse);
        return TaskMapper.taskToResponse(savedTask);
    }

    public ResponseTask updateTask(int id, UpdateTaskRequest newTask) {
        Task task = taskRepository.findById(id).get();
        if (!TaskValidation.isValidDate(newTask.getDueDate())
                || !TaskValidation.isValidPriority(newTask.getPriority())
                || !TaskValidation.isValidStatus(String.valueOf(newTask.getStatus()))) {
            throw new RuntimeException("Invalid date or priority or status");
        }
        task.setDueDate(newTask.getDueDate());
        task.setPriority(newTask.getPriority());
        task.setStatus(newTask.getStatus());
        task.setName(newTask.getName());

        Task savedTask = taskRepository.save(task);
        return TaskMapper.taskToResponse(savedTask);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }


}
