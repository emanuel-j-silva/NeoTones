package com.neonotes.domain.usecases.user;

import com.neonotes.domain.usecases.exceptions.EntityNotFoundException;
import com.neonotes.domain.usecases.user.dto.UserDTO;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class FindUserUseCase {

    private final UserRepository userRepository;

    public FindUserUseCase(UserRepository userRepository) {
        this.userRepository = Objects.requireNonNull(userRepository,"User repository can't be null");
    }

    public UserDTO findByUuid(UUID uuid){
        return userRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public UserDTO findByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public UserDTO findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public List<UserDTO> findAll(){
        return  userRepository.findAll();
    }
}
