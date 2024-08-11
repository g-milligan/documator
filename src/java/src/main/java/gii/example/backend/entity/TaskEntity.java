package gii.example.backend.entity;

import gii.example.backend.constant.TaskStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TaskEntity {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int taskId;
    private String taskSummary;
    private boolean taskIsActive;
    private TaskStatusEnum taskStatus;
}
