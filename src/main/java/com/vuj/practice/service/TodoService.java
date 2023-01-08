package com.vuj.practice.service;

import com.vuj.practice.mapper.TodoMapper;
import com.vuj.practice.model.Todo;
import com.vuj.practice.model.dto.TodoDto;
import com.vuj.practice.repository.TodoRepository;
import com.vuj.practice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private TodoRepository todoRepository;
    private UserRepository userRepository;

    public TodoService(final TodoRepository todoRepository, final UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public List<TodoDto> getTodos() {
        return todoRepository
                .findAll()
                .stream()
                .map(TodoMapper::map)
                .collect(Collectors.toList());
    }

    public List<TodoDto> getTodosByOwnerId(final int ownerId) {
        return todoRepository
                .findAll()
                .stream()
                .filter(x -> x.getOwner().getId() == ownerId)
                .map(TodoMapper::map)
                .collect(Collectors.toList());
    }

    public TodoDto getTodoById(final int id) {
        return TodoMapper.map(todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public TodoDto updateTodo(int id, TodoDto todoDto) {
        final Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setOwner(userRepository.findById(
                todoDto.getOwnerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
        );
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setDeadline(todoDto.getDeadline());
        todo.setIsItDone(todoDto.getIsItDone());

        return TodoMapper.map(todoRepository.save(todo));
    }

    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setOwner(userRepository.findById(todoDto.getOwnerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setDeadline(todoDto.getDeadline());
        todo.setIsItDone(todoDto.getIsItDone());

        return TodoMapper.map(todoRepository.save(todo));
    }

    public void deleteTodo(final int id) {
        todoRepository.deleteById(id);
    }
}
