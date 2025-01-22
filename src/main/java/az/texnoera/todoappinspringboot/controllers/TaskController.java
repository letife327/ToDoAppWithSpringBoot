package az.texnoera.todoappinspringboot.controllers;

import az.texnoera.todoappinspringboot.entity.Task;
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
    public List<Task> getTasks(@RequestParam(required = false) Integer userId){
        return taskService.getTasks(userId);
    }

}
