package com.cleanarch.tasksapi.core.domain;

import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private LocalDate creationDate;
    private LocalDate dueDate;
    private TaskCategory taskCategory;

    public Task(){
    }

    public Task(String title, String description, LocalDate creationDate, LocalDate dueDate, TaskCategory taskCategory) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.taskCategory = taskCategory;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskCategory getTaskCategory() {
        return taskCategory;
    }

}
