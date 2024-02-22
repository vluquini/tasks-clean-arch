package com.cleanarch.tasksapi.core.usecases;


import com.cleanarch.tasksapi.core.domain.Task;
import com.cleanarch.tasksapi.core.exceptions.NoTasksFound;
import com.cleanarch.tasksapi.core.exceptions.TaskAlreadyExists;
import com.cleanarch.tasksapi.core.exceptions.TaskNotFound;

import java.util.List;

public interface TaskUseCase {
    void createTask(Task task) throws TaskAlreadyExists;
    Task getTaskByTitle(String title) throws TaskNotFound, NoTasksFound;
    List<Task> getAllTasks() throws NoTasksFound;
}
