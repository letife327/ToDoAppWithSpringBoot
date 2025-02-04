package az.texnoera.todoappinspringboot.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusCode {
    USER_NOT_FOUND(1004,"User Not Found"),
    TASK_NOT_FOUND(1005,"Task Not Found");
    private final int statusCode;
    private final String message;
}
