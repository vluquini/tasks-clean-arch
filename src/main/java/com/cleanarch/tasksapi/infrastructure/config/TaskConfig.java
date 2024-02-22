package com.cleanarch.tasksapi.infrastructure.config;

import com.cleanarch.tasksapi.application.gateway.TaskGateway;
import com.cleanarch.tasksapi.application.services.TaskUseCaseImpl;
import com.cleanarch.tasksapi.core.usecases.TaskUseCase;
import com.cleanarch.tasksapi.infrastructure.dtos.TaskMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {
    @Bean
    public TaskUseCase createTask(TaskGateway taskUseCase){
        return new TaskUseCaseImpl(taskUseCase);
    }

    @Bean
    public TaskMapper mapper(){
        return new TaskMapper();
    }
}
