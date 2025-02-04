package az.texnoera.todoappinspringboot.model.requests;

import az.texnoera.todoappinspringboot.model.enums.TaskStatus;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateTaskRequest {
    @Size(min = 2, max = 50)
    private String name;
    private String priority;
    private TaskStatus status;
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Due date formatı YYYY-MM-DD olmalıdır")
    private String dueDate;
}
