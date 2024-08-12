package gii.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gii.example.backend.constant.TasksResponse;
import gii.example.backend.entity.TaskEntity;
import gii.example.backend.repo.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TaskRepository taskRepo;

    // get all tasks
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TasksResponse> getTasks() {
        List<TaskEntity> tasks = taskRepo.findAll();
        return new ResponseEntity<>(new TasksResponse(tasks), HttpStatus.OK);
    }

    // get one task by id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable int id) {
        return new ResponseEntity<>(new TaskEntity(), HttpStatus.OK);
    }

}
