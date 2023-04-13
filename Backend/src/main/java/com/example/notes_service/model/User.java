package com.example.notes_service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@RequiredArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String userId;
    private String username;
    private String password;
}
