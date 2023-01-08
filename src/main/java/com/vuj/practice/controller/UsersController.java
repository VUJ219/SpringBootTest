package com.vuj.practice.controller;

import com.vuj.practice.model.dto.UserDto;
import com.vuj.practice.service.UserService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping(value = "{id}/profilePicture", produces = MediaType.IMAGE_JPEG_VALUE)
    Resource downloadImage(@PathVariable Integer id) {
        try {
            return new ByteArrayResource(userService.getProfilePictureOfUser(id));
        } catch (Exception ResponseStatusException) {
            return null;
        }
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

    @PutMapping(value= "/{id}/profilePicture")
    @ResponseStatus(HttpStatus.OK)
    public UserDto UploadProfilePicture(@PathVariable final Integer id, @RequestParam MultipartFile multipartImage) throws Exception {
        return userService.addProfilePictureToUser(id, multipartImage);
    }

    @DeleteMapping(value= "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable final Integer id) {
        userService.deleteUser(id);
    }
}
