package com.vuj.practice.controller;

import com.vuj.practice.model.dto.TodoDto;
import com.vuj.practice.model.dto.UserDto;
import com.vuj.practice.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) { this.todoService = todoService; }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TodoDto> getAllTodos() {
        return todoService.getTodos();
    }

    @GetMapping(value="/owner/{ownerId}")
    public List<TodoDto> getUsersEveryTodo(@PathVariable final Integer ownerId) {
        return todoService.getTodosByOwnerId(ownerId);
    }

    @GetMapping(value= "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TodoDto getUserById(@PathVariable final Integer id) {
        return todoService.getTodoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public TodoDto createTodo(@RequestBody final TodoDto todoDto) {
        return todoService.createTodo(todoDto);
    }

    @PutMapping(value= "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TodoDto updateTodo(@PathVariable final Integer id, @RequestBody final TodoDto todoDto) {
        return todoService.updateTodo(id, todoDto);
    }

    @DeleteMapping(value= "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTodo(@PathVariable final Integer id) {
        todoService.deleteTodo(id);
    }
}
