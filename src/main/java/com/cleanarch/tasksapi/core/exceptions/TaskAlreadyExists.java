package com.cleanarch.tasksapi.core.exceptions;

public class TaskAlreadyExists extends RuntimeException{
    private static final String DEFAULT_ERROR_MESSAGE = "Task already exists.";

    public TaskAlreadyExists() {
        super(DEFAULT_ERROR_MESSAGE);
    }
    
}
