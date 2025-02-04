package az.texnoera.todoappinspringboot.model.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserRequest {

    @NotBlank(message = "Username boş ola bilməz.")
    @Pattern(regexp = "^[a-zA-Z0-9_]{4,16}$",message = "Xəta: Username yalnız 4-16 simvol ola bilər və yalnız hərflər, rəqəmlər, '_' olmalıdır.")
    private String username;
    @NotBlank(message = "Password boş ola bilməz.")
    @Pattern(regexp = "Xəta: Password 6-20 simvol olmalıdır və yalnız hərflər, rəqəmlər, @#$%^&+= simvollarını ehtiva edə bilər.")
    private String password;
}
