package az.texnoera.todoappinspringboot.util;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public class ErrorResult {
    private final String message;
    private final int code;
}
