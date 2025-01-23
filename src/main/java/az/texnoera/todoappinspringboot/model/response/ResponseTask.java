package az.texnoera.todoappinspringboot.model.response;

import az.texnoera.todoappinspringboot.entity.User;
import az.texnoera.todoappinspringboot.model.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseTask {
    private int id;
    private ResponseUser responseUser;
    private String name;
    private String priority;
    private TaskStatus status;
    private String dueDate;
}
