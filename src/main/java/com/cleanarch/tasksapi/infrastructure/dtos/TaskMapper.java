package com.cleanarch.tasksapi.infrastructure.dtos;

import com.cleanarch.tasksapi.core.domain.Task;
import com.cleanarch.tasksapi.infrastructure.entities.TaskEntity;
import org.springframework.stereotype.Component;

//@Component
public class TaskMapper {
    public Task entityToDomain(TaskEntity entity){
        return new Task(entity.getTitle(), entity.getDescription(), entity.getCreationDate(),
                entity.getDueDate(), entity.getTaskCategory());
    }

    public TaskEntity domainToEntity(Task task){
        return new TaskEntity(task.getTitle(), task.getDescription(),
                              task.getCreationDate(), task.getDueDate(), task.getTaskCategory());
    }

    public TaskEntity dtoToEntity(TaskEntityDto request){
        return new TaskEntity(request.title(), request.description(), request.creationDate(),
                request.dueDate(), request.taskCategory());
    }

    public TaskEntityDto domainToDto(Task task){
        return new TaskEntityDto(task.getTitle(), task.getDescription(),
                task.getCreationDate(), task.getDueDate(), task.getTaskCategory());
    }
}
