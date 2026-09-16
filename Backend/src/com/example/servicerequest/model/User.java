package com.example.servicerequest.model;

import java.util.Objects;

public class User {
    private final long id;
    private String name;
    private final String email;
    private UserRole role;
    private boolean active;

    public User(long id, String name, String email, UserRole role){
        validateName(name);
        validateEmail(email);

        Objects.requireNonNull(role,"Role cannot be null");

        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.active = true;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }

    public void updateName(String name) {
        validateName(name);
        this.name = name;
    }

    public void changeRole(UserRole role) {
        this.role = Objects.requireNonNull(role,"Role cannot be null");
    }

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }

    private void validateName(String name){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

    private void validateEmail(String email) {
        if(email == null || email.isBlank() || !email.contains("@")){
            throw new IllegalArgumentException("A valid email is required");
        }
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }

        if(!(object instanceof User other)){
            return false;
        }

        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", active=" + active +
                '}';
    }





}
