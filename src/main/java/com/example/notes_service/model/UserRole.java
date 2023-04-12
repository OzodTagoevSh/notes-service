package com.example.notes_service.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {

    REGISTERED;

    @Override
    public String getAuthority() {
        return name();
    }
}
