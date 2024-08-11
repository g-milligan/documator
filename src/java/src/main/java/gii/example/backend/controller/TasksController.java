package gii.example.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gii.example.backend.constant.TasksResponse;
import gii.example.backend.entity.TaskEntity;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    // get all tasks
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TasksResponse> getTasks() {
        return new ResponseEntity<>(new TasksResponse(), HttpStatus.OK);
    }

    // get one task by id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable int id) {
        return new ResponseEntity<>(new TaskEntity(), HttpStatus.OK);
    }

}
