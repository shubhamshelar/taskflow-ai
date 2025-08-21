package com.shubham.taskflow_ai;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepo extends JpaRepository<Task, String> {
    public Optional<Task> findById(String id);

}
