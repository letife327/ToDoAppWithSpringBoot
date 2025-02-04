package az.texnoera.todoappinspringboot.adviser;

import az.texnoera.todoappinspringboot.util.ErrorResult;
import az.texnoera.todoappinspringboot.exceptions.BaseException;
import az.texnoera.todoappinspringboot.util.ValidationErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResult> handleBaseException(BaseException ex){
       log.error(ex.getMessage());
       return ResponseEntity.status(ex.getStatus())
               .body(new ErrorResult(ex.getMessage(), ex.getStatusCode().getStatusCode()));
   }
   @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResult> handleRuntimeException(RuntimeException ex){
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResult("BAD REQUEST",1006));
   }
   @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResult> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        log.error(ex.getMessage());
        List<String> errors = new ArrayList<>();
        ex.getAllErrors().forEach(error ->
                errors.add(error.getDefaultMessage()));
        return ResponseEntity.status(ex.getStatusCode())
                .body(new ValidationErrorResult("Fields is not valid",1007,errors));
   }
}
