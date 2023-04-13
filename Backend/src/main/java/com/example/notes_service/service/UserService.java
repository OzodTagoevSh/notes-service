package com.example.notes_service.service;

import com.example.notes_service.dto.UserDto;
import com.example.notes_service.exception.ResourceNotFound;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
    UserDto createUser(UserDto userDto);
    UserDto updateUser(String userId, UserDto userDto) throws ResourceNotFound;
    void deleteUser(String userId) throws ResourceNotFound;
}
