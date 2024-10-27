package com.neotones.domain.usecases.music;

import com.neotones.domain.usecases.music.dto.MusicDTO;
import com.neotones.domain.usecases.music.dto.RequestMusicDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MusicRepository {

    void save(MusicDTO music);
    Optional<MusicDTO> findByUuid(UUID uuid);
    Optional<MusicDTO> findByUserAndTitle(RequestMusicDTO requestMusicDTO);
    List<MusicDTO> findByUserUuid(UUID userUuid);
    List<MusicDTO> findByUsername(String username);
}
