package az.texnoera.todoappinspringboot.model.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserRequest {
    private String password;
    private String username;
}
