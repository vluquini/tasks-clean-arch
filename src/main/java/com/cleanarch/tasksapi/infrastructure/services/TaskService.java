package com.cleanarch.tasksapi.infrastructure.services;

import com.cleanarch.tasksapi.application.gateway.TaskGateway;
import com.cleanarch.tasksapi.core.domain.Task;
import com.cleanarch.tasksapi.infrastructure.entities.TaskEntity;
import com.cleanarch.tasksapi.infrastructure.dtos.TaskMapper;
import com.cleanarch.tasksapi.infrastructure.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class TaskService implements TaskGateway {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper =  taskMapper;
    }

    @Override
    public void createTask(Task task) {
        TaskEntity entityObj = taskMapper.domainToEntity(task);
        taskRepository.save(entityObj);
    }

    @Override
    public Task getTaskByTitle(String title) {
        TaskEntity taskDomain = taskRepository.findByTitle(title);
        return taskMapper.entityToDomain(taskDomain);
    }

    @Override
    public List<Task> getAllTasks() {
        List<TaskEntity> list = taskRepository.findAll();
        return list.stream()
                        .sorted(Comparator.comparing(TaskEntity::getTitle, String.CASE_INSENSITIVE_ORDER))
                        .map(entity -> new Task(
                                entity.getTitle(),
                                entity.getDescription(),
                                entity.getCreationDate(),
                                entity.getDueDate(),
                                entity.getTaskCategory()
                        ))
                        .toList();
    }
}
