package com.neotones.domain.entities.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    @DisplayName("Should create user without informing uuid")
    void createUserWithoutUuid(){
        User user = new User("test","email","password");

        assertNotNull(user.getUuid());
        assertEquals("test",user.getUsername());
        assertEquals("email",user.getEmail());
        assertEquals("password",user.getPassword());
    }

    @Test
    @DisplayName("Should throw exception when trying to create user with null username")
    void createUserWithNullUsername(){
        assertThrows(NullPointerException.class, ()-> new User(null,"email","password"));
    }

    @Test
    @DisplayName("Should throw exception when trying to create user with null email")
    void createUserWithNullEmail(){
        assertThrows(NullPointerException.class, ()-> new User("test",null,"password"));
    }

    @Test
    @DisplayName("Should throw exception when trying to create user with null password")
    void createUserWithNullPassword(){
        assertThrows(NullPointerException.class, ()-> new User("test","email",null));
    }

    @Test
    @DisplayName("Should users with same username and UUID be the same")
    void shouldUsersBeTheSame(){
        UUID uuid = UUID.randomUUID();
        User user1 = new User(uuid,"test","email","password");
        User user2 = new User(uuid,"test","anotherEmail","anotherPassword");

        assertEquals(user1,user2);
        assertEquals(user1.hashCode(),user2.hashCode());
    }
}
