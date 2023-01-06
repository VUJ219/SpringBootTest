package com.vuj.practice.controller;

import com.vuj.practice.model.dto.UserDto;
import com.vuj.practice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserService userService;

    public UsersController(UserService userService) { this.userService = userService; }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUser() {
        return userService.getUsers();
    }

    @GetMapping(value= "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable final Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDto createUser(@RequestBody final UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping(value= "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@PathVariable final Integer id, @RequestBody final UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping(value= "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable final Integer id) {
        userService.deleteUser(id);
    }
}
