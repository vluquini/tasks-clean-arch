package com.cleanarch.tasksapi.core.exceptions;

public class TaskNotFound extends RuntimeException{
    private static final String DEFAULT_ERROR_MESSAGE = "Task not found.";

    public TaskNotFound() {
        super(DEFAULT_ERROR_MESSAGE);
    }

}
