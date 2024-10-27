package com.neotones.domain.usecases.music;

import com.neotones.domain.usecases.exceptions.EntityAlreadyExistsException;
import com.neotones.domain.usecases.music.dto.MusicDTO;
import com.neotones.domain.usecases.music.dto.RequestMusicDTO;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class CreateMusicUseCase {

    private final MusicRepository musicRepository;

    public CreateMusicUseCase(MusicRepository musicRepository) {
        this.musicRepository = Objects.requireNonNull(musicRepository,"music repository can't be nul");
    }

    public void create(RequestMusicDTO music){
        if (musicRepository.findByUserAndTitle(music).isPresent()){
            throw new EntityAlreadyExistsException("This music already exists");
        }

        MusicDTO musicDTO = new MusicDTO(UUID.randomUUID(),music.title(),new ArrayList<>());
        musicRepository.save(musicDTO);
    }
}
