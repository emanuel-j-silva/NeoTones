package com.neonotes.domain.usecases.user.dto;

import java.util.UUID;

public record UserDTO(UUID uuid, String username, String email, String password) {
}
