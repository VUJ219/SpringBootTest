package com.vuj.practice.service;

import com.vuj.practice.mapper.UserMapper;
import com.vuj.practice.model.dto.UserDto;
import com.vuj.practice.repository.TodoRepository;
import com.vuj.practice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;
    private TodoRepository todoRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> listUsers() {
        return userRepository.findAll().stream().map(UserMapper::map).collect(Collectors.toList());
    }
}
