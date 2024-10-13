package com.neotones.domain.usecases.arrangement.dto;

import java.util.List;

public record ArrangementDTO(ToneDTO tone, List<MusicComponentDTO> components) {
}
