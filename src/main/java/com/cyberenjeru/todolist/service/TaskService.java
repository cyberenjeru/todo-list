package com.cyberenjeru.todolist.service;

import com.cyberenjeru.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;
}
