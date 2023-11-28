package com.dgmf.mapper;

import com.dgmf.entity.User;
import com.dgmf.web.dto.UserDto;

public class UserMapper {
    // Map User Entity to UserDto
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .gender(user.getGender())
                .build();

        return userDto;
    }

    // Map UserDto to User Entity
    public static User mapToUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .role(userDto.getRole())
                .gender(userDto.getGender())
                .build();

        return user;
    }
}
