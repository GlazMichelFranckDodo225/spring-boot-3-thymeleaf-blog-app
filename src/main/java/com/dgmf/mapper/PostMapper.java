package com.dgmf.mapper;

import com.dgmf.entity.User;
import com.dgmf.web.dto.UserDto;

public class UserMapper {
    // Map User Entity to UserDto
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .title(user.getTitle())
                .description(user.getDescription())
                .content(user.getContent())
                .url(user.getUrl())
                .createdOn(user.getCreatedOn())
                .updatedOn(user.getUpdatedOn())
                .build();

        return userDto;
    }

    // Map UserDto to User Entity
    public static User mapToUser(UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .title(userDto.getTitle())
                .description(userDto.getDescription())
                .content(userDto.getContent())
                .url(userDto.getUrl())
                .createdOn(userDto.getCreatedOn())
                .updatedOn(userDto.getUpdatedOn())
                .build();

        return user;
    }
}
