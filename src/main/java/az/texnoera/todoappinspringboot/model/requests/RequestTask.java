package az.texnoera.todoappinspringboot.model.requests;

import az.texnoera.todoappinspringboot.entity.User;
import az.texnoera.todoappinspringboot.model.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestTask {
    private int userId;
    private String name;
    private String priority;
    private TaskStatus status;
    private String dueDate;
}
