package az.texnoera.todoappinspringboot.services.concretes;

import az.texnoera.todoappinspringboot.entity.Task;
import az.texnoera.todoappinspringboot.exceptions.BaseException;
import az.texnoera.todoappinspringboot.mapper.TaskMapper;
import az.texnoera.todoappinspringboot.model.enums.StatusCode;
import az.texnoera.todoappinspringboot.model.requests.RequestTask;
import az.texnoera.todoappinspringboot.model.requests.UpdateTaskRequest;
import az.texnoera.todoappinspringboot.model.response.ResponseTask;
import az.texnoera.todoappinspringboot.model.response.ResponseUser;
import az.texnoera.todoappinspringboot.repository.TaskRepository;
import az.texnoera.todoappinspringboot.services.abstracts.ITaskService;
import az.texnoera.todoappinspringboot.util.Result;
import az.texnoera.todoappinspringboot.validations.TaskValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;

    public Result<ResponseTask>   getTasks(Integer userId,
                                         Integer page,
                                         Integer size) {
        if (userId == null) {
            Sort sort = Sort.by(Sort.Direction.ASC, "id");
           Pageable pageable = PageRequest.of(page, size, sort);
           Page<Task> tasks =  taskRepository.findAll(pageable);
           List<ResponseTask> rpTask = taskRepository.findAll(pageable).stream().map(task->{
               return TaskMapper.taskToResponse(task);
           }).toList();
           return new Result<>(rpTask,page,size,tasks.getTotalPages());
        }
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Task> tasks =  taskRepository.findAll(pageable);
        List<ResponseTask> rpTask = tasks.stream().map(task->{
            return TaskMapper.taskToResponse(task);
        }).toList();
        return new Result<>(rpTask,page,size,tasks.getTotalPages());
    }

    public ResponseTask getTask(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(()->{
            return new BaseException(StatusCode.TASK_NOT_FOUND,HttpStatus.NOT_FOUND);
        });
        return TaskMapper.taskToResponse(task);
    }

    public void addTask(RequestTask newTask) {
        Task task = TaskMapper.mapToTask(newTask);
        Task savedTask = taskRepository.save(task);
        TaskMapper.taskToResponse(savedTask);
    }

    public ResponseTask updateTask(int id, UpdateTaskRequest newTask) {
        Task task = taskRepository.findById(id).orElseThrow(()->{
            return new BaseException(StatusCode.TASK_NOT_FOUND,HttpStatus.NOT_FOUND);
        });
        task.setDueDate(newTask.getDueDate());
        task.setPriority(newTask.getPriority());
        task.setStatus(newTask.getStatus());
        task.setName(newTask.getName());

        Task savedTask = taskRepository.save(task);
        return TaskMapper.taskToResponse(savedTask);
    }

    public void deleteTask(int id) {
        ResponseTask responseTask = getTask(id);
        taskRepository.deleteById(responseTask.getId());
    }


}
