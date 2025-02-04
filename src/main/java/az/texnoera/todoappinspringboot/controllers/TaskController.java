package az.texnoera.todoappinspringboot.controllers;

import az.texnoera.todoappinspringboot.model.requests.RequestTask;
import az.texnoera.todoappinspringboot.model.requests.UpdateTaskRequest;
import az.texnoera.todoappinspringboot.model.response.ResponseTask;
import az.texnoera.todoappinspringboot.services.concretes.TaskService;
import az.texnoera.todoappinspringboot.util.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RequestMapping("tasks")
@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @GetMapping
    public Result<ResponseTask> getTasks(@RequestParam(required = false) Integer userId,
                                         @RequestParam(defaultValue = "0") Integer page,
                                         @RequestParam(defaultValue = "10") Integer size) {
        return taskService.getTasks(userId,page,size);
    }
    @GetMapping("/{id}")
    public ResponseTask getTask(@PathVariable Integer id){
        return taskService.getTask(id);
    }
    @PostMapping
    public void addTask(@RequestBody @Valid RequestTask newTask){
         taskService.addTask(newTask);
    }
    @PutMapping("/{id}")
    public ResponseTask updateTask(@PathVariable int id,
                                   @RequestBody @Valid UpdateTaskRequest newTask){
        return taskService.updateTask(id,newTask);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
    }

}
