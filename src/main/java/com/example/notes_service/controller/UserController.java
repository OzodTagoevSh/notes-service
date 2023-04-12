package com.example.notes_service.controller;

import com.example.notes_service.dto.UserDto;
import com.example.notes_service.exception.ResourceNotFound;
import com.example.notes_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(name = "id") String userId,
                                              @RequestBody @Valid UserDto userDto) throws ResourceNotFound {
        return new ResponseEntity<>(userService.updateUser(userId, userDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") String userId) throws ResourceNotFound {
        userService.deleteUser(userId);
        return new ResponseEntity<>("Successfully deleted!", HttpStatus.OK);
    }
}
