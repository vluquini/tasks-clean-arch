package com.cleanarch.tasksapi.application.services;


import com.cleanarch.tasksapi.application.gateway.TaskGateway;
import com.cleanarch.tasksapi.core.domain.Task;
import com.cleanarch.tasksapi.core.exceptions.NoTasksFound;
import com.cleanarch.tasksapi.core.exceptions.TaskAlreadyExists;
import com.cleanarch.tasksapi.core.exceptions.TaskNotFound;
import com.cleanarch.tasksapi.core.usecases.TaskUseCase;

import java.util.List;

public class TaskUseCaseImpl implements TaskUseCase {
    private final TaskGateway taskGateway;

    public TaskUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @Override
    public void createTask(Task task) throws TaskAlreadyExists{
        List<Task> taskList = taskGateway.getAllTasks();
        if (taskList.isEmpty()) {
            this.taskGateway.createTask(task);
        }else{
            for(Task t : taskList){
                if (task.getTitle().equals(t.getTitle()))
                    throw new TaskAlreadyExists();
            }
        }
        this.taskGateway.createTask(task);
    }

    @Override
    public Task getTaskByTitle(String title) throws TaskNotFound, NoTasksFound {
        List<Task> taskList = taskGateway.getAllTasks();
        if (taskList.isEmpty())
            throw new NoTasksFound();

        for(Task task : taskList){
            if (task.getTitle().equals(title))
                return this.taskGateway.getTaskByTitle(title);
        }
        throw new TaskNotFound();
    }

    @Override
    public List<Task> getAllTasks() throws NoTasksFound {
        List<Task> taskList = taskGateway.getAllTasks();
        if (taskList.isEmpty())
            throw new NoTasksFound();
        return this.taskGateway.getAllTasks();
    }
}
