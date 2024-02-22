package com.cleanarch.tasksapi.application.gateway;

import com.cleanarch.tasksapi.core.domain.Task;

import java.util.List;

public interface TaskGateway {
    void createTask(Task task);
    Task getTaskByTitle(String title);
    List<Task> getAllTasks();
}
