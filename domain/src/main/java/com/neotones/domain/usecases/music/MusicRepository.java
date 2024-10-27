package com.neotones.domain.usecases.music;

import com.neotones.domain.usecases.music.dto.MusicDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MusicRepository {

    void save(MusicDTO music);
    Optional<MusicDTO> findByUuid(UUID uuid);
    List<MusicDTO> findByUserUuid(UUID userUuid);
    List<MusicDTO> findByUsername(String username);
}
