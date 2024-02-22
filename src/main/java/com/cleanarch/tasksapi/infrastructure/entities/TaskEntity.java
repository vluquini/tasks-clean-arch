package com.cleanarch.tasksapi.infrastructure.entities;

import com.cleanarch.tasksapi.core.domain.TaskCategory;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate creationDate;
    private LocalDate dueDate;
    @Enumerated(EnumType.STRING)
    private TaskCategory taskCategory;

    public TaskEntity(String title, String description, LocalDate creationDate, LocalDate dueDate, TaskCategory taskCategory) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.taskCategory = taskCategory;
    }
}
