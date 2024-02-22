package com.cleanarch.tasksapi.core.exceptions;

// class to standardize exception messages
public class ErrorMessage {
    private String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
