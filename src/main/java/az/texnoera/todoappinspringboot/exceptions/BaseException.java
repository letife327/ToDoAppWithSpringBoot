package az.texnoera.todoappinspringboot.exceptions;

import az.texnoera.todoappinspringboot.model.enums.StatusCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {
    private final HttpStatus status;
    private final StatusCode statusCode;

    public BaseException(StatusCode statusCode, HttpStatus status) {
        super(statusCode.getMessage());
        this.status = status;
        this.statusCode = statusCode;
    }
}
