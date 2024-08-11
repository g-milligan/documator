package gii.example.backend.constant;

import gii.example.backend.entity.TaskEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TasksResponse {
    private TaskEntity[] tasks;
}
