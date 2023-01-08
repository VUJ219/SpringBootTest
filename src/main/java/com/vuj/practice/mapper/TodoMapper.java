package com.vuj.practice.mapper;

import com.vuj.practice.model.Todo;
import com.vuj.practice.model.dto.TodoDto;

public class TodoMapper {
    public static TodoDto map(final Todo todo) {

        TodoDto todoDto = new TodoDto();

        todoDto.setId(todo.getId());
        todoDto.setOwnerId(todo.getOwner().getId());
        todoDto.setTitle(todo.getTitle());
        todoDto.setDeadline(todo.getDeadline());
        todoDto.setDescription(todo.getDescription());
        todoDto.setIsItDone(todo.getIsItDone());

        return todoDto;
    }
}
