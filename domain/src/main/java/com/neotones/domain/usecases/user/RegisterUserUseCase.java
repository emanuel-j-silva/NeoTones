package com.neotones.domain.usecases.user;

import com.neotones.domain.usecases.exceptions.EntityAlreadyExistsException;
import com.neotones.domain.usecases.user.dto.RegisterUserDTO;
import com.neotones.domain.usecases.user.dto.UserDTO;

import java.util.Objects;
import java.util.UUID;

public class RegisterUserUseCase {
    private final UserRepository userRepository;

    public RegisterUserUseCase(UserRepository userRepository) {
        this.userRepository = Objects.requireNonNull(userRepository,"user repository can't be null");
    }

    public void register(RegisterUserDTO user){
        String errors = "";

        if (userRepository.findByUsername(user.email()).isPresent()){
            errors += "This e-mail is already in use" + "\n";
        }
        if (userRepository.findByUsername(user.username()).isPresent()){
            errors +="This username is already in use";
        }
        if (!errors.isEmpty()){
            throw new EntityAlreadyExistsException(errors);
        }

        UserDTO userDTO = new UserDTO(UUID.randomUUID(),user.username(), user.email(), user.password());
        userRepository.save(userDTO);
    }
}
