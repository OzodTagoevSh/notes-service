package com.example.notes_service.service;

import com.example.notes_service.dto.UserDto;
import com.example.notes_service.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
    UserDto createUser(UserDto userDto);
    UserDto updateUser(String userId, UserDto userDto);
    void deleteUser(String userId);
}
