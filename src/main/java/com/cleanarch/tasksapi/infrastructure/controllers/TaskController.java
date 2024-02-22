package com.cleanarch.tasksapi.infrastructure.controllers;

import com.cleanarch.tasksapi.core.domain.Task;
import com.cleanarch.tasksapi.core.usecases.TaskUseCase;
import com.cleanarch.tasksapi.infrastructure.dtos.TaskEntityDto;
import com.cleanarch.tasksapi.infrastructure.dtos.TaskMapper;
import com.cleanarch.tasksapi.infrastructure.entities.TaskEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskUseCase taskUseCase;
    private final TaskMapper mapper;

    public TaskController(TaskUseCase taskUseCase, TaskMapper mapper) {
        this.taskUseCase = taskUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<TaskEntity> createTask(@RequestBody TaskEntityDto request){
        TaskEntity entity = mapper.dtoToEntity(request);
        Task domain = mapper.entityToDomain(entity);
        taskUseCase.createTask(domain);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @GetMapping
    public ResponseEntity<List<TaskEntityDto>> getAllTasks(){
        List<Task> tasks = taskUseCase.getAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(
                 tasks.stream()
                .map(mapper::domainToDto)
                .toList());
    }

    @GetMapping("/{title}")
    public ResponseEntity<TaskEntityDto> getTaskByTitle(@PathVariable(value="title") String title){
        Task taskDomain = taskUseCase.getTaskByTitle(title);
        TaskEntityDto dto = mapper.domainToDto(taskDomain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
