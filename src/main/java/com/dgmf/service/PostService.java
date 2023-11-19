package com.dgmf.service;

import com.dgmf.web.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();
}
