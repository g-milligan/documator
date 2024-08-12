package gii.example.backend.constant;

import java.util.List;

import gii.example.backend.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TasksResponse {
    private List<TaskEntity> tasks;
}
