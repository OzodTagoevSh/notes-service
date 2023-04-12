package com.example.notes_service.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String userId;

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Size(max = 20)
    private String password;

    private String role;
}
