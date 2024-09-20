package com.neotones.domain.entities.music;

import com.neotones.domain.entities.music.note.Tone;
import com.neotones.domain.entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MusicTest {

    private Music musicTest;
    @Mock private User user;
    @Mock private Tone tone;
    @Mock private Arrangement arrangement;
    private Map<Tone,Arrangement> arrangements = new HashMap<>();

    @BeforeEach
    void setUp(){
        arrangements.put(tone,arrangement);
        musicTest = new Music("Title",arrangements,user);
    }

    @Test
    @DisplayName("Should create music with null Uuid parameter")
    void shouldCreateMusicWithNullUuid(){
        Music music = new Music("Title",user);

        assertThat(music.getUuid()).isInstanceOf(UUID.class);
    }

    @Test
    @DisplayName("Should create music with arrangements parameter")
    void shouldCreateMusicWithArrangements(){
        Music music = new Music("Title",arrangements,user);

        assertThat(music.getUuid()).isInstanceOf(UUID.class);
    }

    @Test
    @DisplayName("Should create music with all parameters")
    void shouldCreateMusicWithAllParameters(){
        Music music = new Music(null,"Title",arrangements,user);

        assertThat(music.getUuid()).isInstanceOf(UUID.class);
    }
}
