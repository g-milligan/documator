package gii.example.backend.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gii.example.backend.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>{
    List<TaskEntity> findAllByOrderByTaskCreatedAtAscTaskIdAsc();
    Optional<TaskEntity> findByTaskId(Long taskId);
}
