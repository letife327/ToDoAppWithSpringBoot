package az.texnoera.todoappinspringboot.mapper;

import az.texnoera.todoappinspringboot.entity.Task;
import az.texnoera.todoappinspringboot.entity.User;
import az.texnoera.todoappinspringboot.model.requests.RequestTask;
import az.texnoera.todoappinspringboot.model.response.ResponseTask;
import az.texnoera.todoappinspringboot.model.response.ResponseUser;

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
            .responseUser(ResponseUser.builder().id(savedTask.getUser().getId())
                    .username(savedTask.getUser().getUsername())
                    .email(savedTask.getUser().getEmail())
                    .build())
            .name(savedTask.getName())
            .build();
    }
    static ResponseTask taskToResponseV1 (Task savedTask) {
        return ResponseTask.builder()
                .id(savedTask.getId())
                .dueDate(savedTask.getDueDate())
                .status(savedTask.getStatus())
                .priority(savedTask.getPriority())
                .name(savedTask.getName())
                .build();
    }
}
