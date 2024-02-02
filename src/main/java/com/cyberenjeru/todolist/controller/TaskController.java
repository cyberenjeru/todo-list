package com.cyberenjeru.todolist.controller;

import com.cyberenjeru.todolist.model.Task;
import com.cyberenjeru.todolist.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class TaskController {


    TaskService taskService;

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){

        log.info("Criando tarefa [{}]", task);
        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks(){

        log.info("Listando todas as tarefas cadastradas");
        return taskService.listAllTasks();
    }

    @GetMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id")Long id){
        log.info("Buscando tarefa [{}]", id);
        return taskService.findTaskById(id);
    }

    @PutMapping("tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTaskById(@PathVariable(value = "id") Long id,@RequestBody Task task){
        log.info("Atualidando tarefa [{}] com as informações [{}]", id, task);
        return taskService.updateTaskById(task,id);
    }

    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTaskById(@PathVariable(value = "id")Long id){
        log.info("Deletando a tarefa [{}]", id);
        return taskService.deleteTaskById(id);
    }
}
