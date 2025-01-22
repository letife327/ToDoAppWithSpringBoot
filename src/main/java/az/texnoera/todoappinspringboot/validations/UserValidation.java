package az.texnoera.todoappinspringboot.validations;

import az.texnoera.todoappinspringboot.entity.User;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class UserValidation {

    public boolean isValidUsername(String username) {
        String username1 = "^[a-z0-9_.]+$";
        return username != null && username.matches(username1);

    }

    public boolean isValidPassword(String password) {
        String password1 = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$";
        return password != null && password.matches(password1);

    }

    public boolean isValidEmail(String email) {
        String email1 = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(email1);

    }
}
