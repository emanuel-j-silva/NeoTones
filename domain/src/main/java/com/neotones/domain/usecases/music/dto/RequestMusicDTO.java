package com.neotones.domain.usecases.music.dto;

import java.util.UUID;

public record RequestMusicDTO(UUID userUuid, String title) {
}
