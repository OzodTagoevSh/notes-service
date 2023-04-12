package com.example.notes_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userId;
    @NotBlank(message = "Username should not be empty")
    @Size(max = 50, message = "Password should contain at max 50 characters")
    private String username;

    @NotBlank(message = "Password should not be empty")
    @Size(max = 20, message = "Password should contain at max 20 characters")
    private String password;
    private String role;
}
