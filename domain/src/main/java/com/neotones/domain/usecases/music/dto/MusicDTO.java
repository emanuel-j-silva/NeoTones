package com.neotones.domain.usecases.music.dto;

import com.neotones.domain.usecases.arrangement.dto.ArrangementDTO;

import java.util.List;
import java.util.UUID;

public record MusicDTO(UUID uuid, String title, List<ArrangementDTO> arrangements) {
}
