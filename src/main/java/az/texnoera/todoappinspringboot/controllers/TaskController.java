package az.texnoera.todoappinspringboot.controllers;

import az.texnoera.todoappinspringboot.entity.Task;
import az.texnoera.todoappinspringboot.model.requests.RequestTask;
import az.texnoera.todoappinspringboot.model.requests.UpdateTaskRequest;
import az.texnoera.todoappinspringboot.model.response.ResponseTask;
import az.texnoera.todoappinspringboot.services.concretes.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("tasks")
@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @GetMapping
    public List<ResponseTask> getTasks(@RequestParam(required = false) Integer userId){
        return taskService.getTasks(userId);
    }
    @GetMapping("/{id}")
    public ResponseTask getTask(@PathVariable Integer id){
        return taskService.getTask(id);
    }
    @PostMapping
    public ResponseTask addTask(@RequestBody RequestTask newTask){
        return taskService.addTask(newTask);
    }
    @PutMapping("/{id}")
    public ResponseTask updateTask(@PathVariable int id, @RequestBody UpdateTaskRequest newTask){
        return taskService.updateTask(id,newTask);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
    }

}
