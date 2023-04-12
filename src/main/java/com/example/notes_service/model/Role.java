package com.example.notes_service.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Document(collection = "role")
public class Role {
    @Id
    private String roleId;

    private UserRole userRole;
}
