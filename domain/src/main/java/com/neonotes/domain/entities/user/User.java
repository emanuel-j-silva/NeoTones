package com.neonotes.domain.entities.user;

import java.util.Objects;
import java.util.UUID;

public class User {

    private UUID uuid;
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password){
        this(null,username,email,password);
    }

    public User(UUID uuid, String username, String email, String password) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.username = Objects.requireNonNull(username,"Username can't be null");
        this.email = Objects.requireNonNull(email,"Email can't be null");;
        this.password = Objects.requireNonNull(password,"Password can't be null");;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uuid.equals(user.uuid) && username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, username);
    }
}
