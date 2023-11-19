package com.dgmf.service.impl;

import com.dgmf.entity.User;
import com.dgmf.mapper.UserMapper;
import com.dgmf.repository.UserRepository;
import com.dgmf.service.UserService;
import com.dgmf.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserDto> userDtos = users.stream()
                // .map(user -> UserMapper.mapToUserDto(user))
                .map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());

        return userDtos;
    }
}
