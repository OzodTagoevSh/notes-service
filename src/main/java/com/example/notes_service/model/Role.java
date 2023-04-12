package com.example.notes_service.model;

public enum Role {
    REGISTERED("Registered");

    private final String role;
    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
