package az.texnoera.todoappinspringboot.model.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestUser {
    @NotBlank(message = "Username boş ola bilməz.")
    @Pattern(regexp = "^[a-zA-Z0-9_]{4,16}$",message = "Xəta: Username yalnız 4-16 simvol ola bilər və yalnız hərflər, rəqəmlər, '_' olmalıdır.")
    private String username;
    @NotBlank(message = "Password boş ola bilməz.")
    @Pattern(regexp = "^(?=.*\\d).{6,}$",
            message = "Xəta: Password 6-20 simvol olmalıdır və yalnız hərflər, rəqəmlər, @#$%^&+= simvollarını ehtiva edə bilər.")
    private String password;
    @Email
    private String email;
}
