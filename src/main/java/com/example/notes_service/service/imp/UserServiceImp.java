package com.example.notes_service.service.imp;

import com.example.notes_service.dto.UserDto;
import com.example.notes_service.exception.APIException;
import com.example.notes_service.exception.ResourceNotFound;
import com.example.notes_service.model.Role;
import com.example.notes_service.model.User;
import com.example.notes_service.repository.UserRepository;
import com.example.notes_service.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImp(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername());
        if(user != null) {
            throw new APIException(HttpStatus.BAD_REQUEST, "This user has already registered!");
        }
        user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(Role.REGISTERED.getRole());
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) throws ResourceNotFound {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFound("User", "Id", userId));
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(Role.REGISTERED.getRole());
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void deleteUser(String userId) throws ResourceNotFound {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFound("User", "Id", userId));
        userRepository.delete(user);
    }
}
