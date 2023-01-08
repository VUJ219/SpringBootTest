package com.vuj.practice.service;

import com.vuj.practice.mapper.UserMapper;
import com.vuj.practice.model.User;
import com.vuj.practice.model.dto.UserDto;
import com.vuj.practice.repository.TodoRepository;
import com.vuj.practice.repository.UserRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
        passwordEncoder = new BCryptPasswordEncoder(12);
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(UserMapper::map).collect(Collectors.toList());
    }

    public UserDto getUserById(final int id) {
        return UserMapper.map(userRepository.findById(id).orElseThrow());
    }

    public UserDto updateUser(int id, UserDto userDto) {
        final User user = userRepository.findById(id).orElseThrow();
        user.setUsername(userDto.getUsername());
        user.setEmailAddress(userDto.getEmailAddress());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return UserMapper.map(userRepository.save(user));
    }

    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmailAddress(userDto.getEmailAddress());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return UserMapper.map(userRepository.save(user));
    }

    public void deleteUser(final int id) {
        userRepository.deleteById(id);
    }
}
