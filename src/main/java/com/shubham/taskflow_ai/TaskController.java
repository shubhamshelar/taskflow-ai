package com.shubham.taskflow_ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    @GetMapping("/getTask/{id}")
    public TaskDTO getTask(@PathVariable String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Task id must not be empty");
        }
        return new TaskDTO(taskRepo.findById(id));
    }

    @PostMapping("/createTask")
    public void createTask(@RequestParam String id, @RequestParam String title, @RequestParam String status) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Task id must not be empty");
        }
        taskRepo.save(new Task(id, title, status));
    }
}
