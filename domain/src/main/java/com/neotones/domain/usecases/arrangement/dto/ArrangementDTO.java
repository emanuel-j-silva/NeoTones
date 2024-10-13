package com.neotones.domain.usecases.arrangement.dto;

import com.neotones.domain.entities.music.components.MusicComponent;

import java.util.List;

public record ArrangementDTO(ToneDTO tone, List<MusicComponent> components) {
}
