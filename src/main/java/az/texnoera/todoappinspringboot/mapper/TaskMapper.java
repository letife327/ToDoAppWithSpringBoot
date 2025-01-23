package az.texnoera.todoappinspringboot.mapper;

import az.texnoera.todoappinspringboot.entity.Task;
import az.texnoera.todoappinspringboot.entity.User;
import az.texnoera.todoappinspringboot.model.requests.RequestTask;
import az.texnoera.todoappinspringboot.model.response.ResponseTask;

public interface TaskMapper {
    static Task mapToTask(RequestTask newTask) {


    return Task.builder()
            .name(newTask.getName())
            .user(User.builder().id(newTask.getUserId()).build())
            .status(newTask.getStatus())
            .dueDate(newTask.getDueDate())
            .priority(newTask.getPriority())
            .build();
    }
    static ResponseTask taskToResponse (Task savedTask) {
    return ResponseTask.builder()
            .id(savedTask.getId())
            .dueDate(savedTask.getDueDate())
            .status(savedTask.getStatus())
            .priority(savedTask.getPriority())
            .user(savedTask.getUser())
            .name(savedTask.getName())
            .build();
    }
}
