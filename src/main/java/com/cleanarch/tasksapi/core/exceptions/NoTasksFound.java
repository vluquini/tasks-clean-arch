package com.cleanarch.tasksapi.core.exceptions;

public class NoTasksFound extends RuntimeException{
    private static final String DEFAULT_ERROR_MESSAGE = "No tasks found.";

    public NoTasksFound() {
        super(DEFAULT_ERROR_MESSAGE);
    }

}
