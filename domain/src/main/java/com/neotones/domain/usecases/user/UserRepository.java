package com.neotones.domain.usecases.user;

import com.neotones.domain.usecases.user.dto.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    void save(UserDTO user);
    Optional<UserDTO> findByUuid(UUID uuid);
    Optional<UserDTO> findByUsername(String username);
    Optional<UserDTO> findByEmail(String email);
    List<UserDTO> findAll();
}
