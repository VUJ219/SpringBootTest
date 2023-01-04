package com.vuj.practice.mapper;

import com.vuj.practice.model.User;
import com.vuj.practice.model.dto.UserDto;

public class UserMapper {
    public static UserDto map(final User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmailAddress(user.getEmailAddress());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
}
