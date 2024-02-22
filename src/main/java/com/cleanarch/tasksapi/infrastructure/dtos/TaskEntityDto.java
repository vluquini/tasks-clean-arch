package com.cleanarch.tasksapi.infrastructure.dtos;

import com.cleanarch.tasksapi.core.domain.TaskCategory;

import java.time.LocalDate;

public record TaskEntityDto(
        String title,
        String description,
        LocalDate creationDate,
        LocalDate dueDate,
        TaskCategory taskCategory
) {
}
