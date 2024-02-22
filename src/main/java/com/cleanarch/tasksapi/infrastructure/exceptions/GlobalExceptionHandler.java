package com.cleanarch.tasksapi.infrastructure.exceptions;

import com.cleanarch.tasksapi.core.exceptions.ErrorMessage;
import com.cleanarch.tasksapi.core.exceptions.NoTasksFound;
import com.cleanarch.tasksapi.core.exceptions.TaskAlreadyExists;
import com.cleanarch.tasksapi.core.exceptions.TaskNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TaskNotFound.class)
    public ResponseEntity<ErrorMessage> handleTaskNotFoundException(TaskNotFound exception) {
        ErrorMessage errorMessage = new ErrorMessage(
                exception.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(NoTasksFound.class)
    public ResponseEntity<ErrorMessage> handleNoTasksFoundException(NoTasksFound exception) {
        ErrorMessage errorMessage = new ErrorMessage(
                exception.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(TaskAlreadyExists.class)
    public ResponseEntity<ErrorMessage> handleTaskAlreadyExistsException(TaskAlreadyExists exception) {
        ErrorMessage errorMessage = new ErrorMessage(
                exception.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
