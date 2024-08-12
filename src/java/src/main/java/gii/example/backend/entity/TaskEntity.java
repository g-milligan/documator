package gii.example.backend.entity;

import java.time.LocalDateTime;

import gii.example.backend.constant.TaskStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "task", schema = "public")
public class TaskEntity {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="task_id", unique = true, nullable = false)
    private Long taskId;

    @Column(name="task_summary", nullable = true)
    private String taskSummary;

    @Column(name="task_active", nullable = false)
    private boolean taskIsActive;

    @Column(name="task_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatusEnum taskStatus;

    @Column(name="task_created", nullable = false)
    private LocalDateTime taskCreatedAt;

    @Column(name="task_modified", nullable = false)
    private LocalDateTime taskModifiedAt;
}
