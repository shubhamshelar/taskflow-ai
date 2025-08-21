package com.shubham.taskflow_ai;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;


@Getter
@Setter
@AllArgsConstructor
public class TaskDTO {
    private String id;
    private String title;
    private String status;

    public TaskDTO(Optional<Task> task) {
        if(task.isEmpty()) {
            throw new IllegalArgumentException("Task not found");
        }

        this.id = task.get().getId();
        this.title = task.get().getTitle();
        this.status = task.get().getStatus();
    }
}
