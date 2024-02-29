package com.cleanarch.tasksapi.infrastructure.repositories;

import com.cleanarch.tasksapi.core.domain.TaskCategory;
import com.cleanarch.tasksapi.infrastructure.dtos.TaskEntityDto;
import com.cleanarch.tasksapi.infrastructure.entities.TaskEntity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class TaskRepositoryTest {
    @Autowired
    TaskRepository repository;
    @Autowired
    EntityManager entityManager;

    private TaskEntity createTaskEntity(TaskEntityDto dto){
        TaskEntity newTask = new TaskEntity(dto.title(), dto.description(),
                                dto.creationDate(), dto.dueDate(), dto.taskCategory());
        this.entityManager.persist(newTask);
        return newTask;
    }

    @Test
    @DisplayName("Tarefa encontrada com sucesso")
    void findByTitleCase1() {
        String titleToFind = "Tarefa teste";
        TaskEntityDto dto = new TaskEntityDto("Tarefa teste", "Tarefa importante",
                LocalDate.now(), LocalDate.now().plusDays(7), TaskCategory.WORK);

        this.createTaskEntity(dto);
        TaskEntity result = this.repository.findByTitle(titleToFind);
        assertThat(!result.getTitle().isEmpty());
    }

    @Test
    @DisplayName("Tarefa não encontrada")
    void findByTitleCase2() {
        String titleToFind = "Tarefa N";
        TaskEntity result = this.repository.findByTitle(titleToFind);
        assertThat(result==null);
    }
}