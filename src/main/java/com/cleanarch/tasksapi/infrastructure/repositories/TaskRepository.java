package com.cleanarch.tasksapi.infrastructure.repositories;

import com.cleanarch.tasksapi.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    TaskEntity findByTitle(String title);
}
