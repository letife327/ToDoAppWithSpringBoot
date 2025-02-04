package az.texnoera.todoappinspringboot.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class ValidationErrorResult {
    private final String message;
    private final int code;
    private final List<String> errors;
}
