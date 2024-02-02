package com.cyberenjeru.todolist.controller;

import com.cyberenjeru.todolist.model.Task;
import com.cyberenjeru.todolist.service.TaskService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @ApiOperation(value = "Criando uma nova task")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "Task criada"),
            @ApiResponse(code = 500, message = "Ocorreu um erro")
    })

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){

        log.info("Criando tarefa [{}]", task);
        return taskService.createTask(task);
    }

    @ApiOperation(value = "Listando todas as tasks")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Tasks listadas"),
            @ApiResponse(code = 500, message = "Ocorreu um erro ao listar as tasks")
    })
    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks(){

        log.info("Listando todas as tarefas cadastradas");
        return taskService.listAllTasks();
    }

    @ApiOperation(value = "Buscando uma task pelo id")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "Task encontrada"),
            @ApiResponse(code = 404, message = "Ocorreu um erro ao buscar task")
    })
    @GetMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id")Long id){
        log.info("Buscando tarefa [{}]", id);
        return taskService.findTaskById(id);
    }

    @ApiOperation(value = "Atualizando uma task pelo id")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "Task atualizada"),
            @ApiResponse(code = 404, message = "Task não encontrada")
    })
    @PutMapping("tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTaskById(@PathVariable(value = "id") Long id,@RequestBody Task task){
        log.info("Atualidando tarefa [{}] com as informações [{}]", id, task);
        return taskService.updateTaskById(task,id);
    }

    @ApiOperation(value = "Deletando uma task")
    @ApiResponses(value ={
            @ApiResponse(code = 204, message = "Task deletada"),
            @ApiResponse(code = 404, message = "Task não encontrada")
    })
    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTaskById(@PathVariable(value = "id")Long id){
        log.info("Deletando a tarefa [{}]", id);
        return taskService.deleteTaskById(id);
    }
}
