package com.neotones.domain.entities.music;

import com.neotones.domain.entities.music.note.Note;
import com.neotones.domain.entities.music.note.ScaleType;
import com.neotones.domain.entities.music.note.Tone;
import com.neotones.domain.entities.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MusicTest {

    private static Map<Tone,Arrangement> arrangements;

    private Music musicTest;
    private final User user = Mockito.mock(User.class);
    private static final Tone tone = Mockito.mock(Tone.class);
    private static final Arrangement arrangement = Mockito.mock(Arrangement.class);

    @BeforeAll
    static void setUpMocks(){
        arrangements = new HashMap<>();
        arrangements.put(tone, arrangement);
    }

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
        assertThat(music.getTitle()).isEqualTo("Title");
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

    @Test
    @DisplayName("Should block when adding a repeated arrangement")
    void shouldBlockAddSameArrangement(){
        Arrangement arrangement = new Arrangement(tone);

        assertThatThrownBy(()-> musicTest.addArrangement(arrangement))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("Should add a new arrangement correctly")
    void shouldAddNewArrangement(){
        Arrangement arrangement = new Arrangement(new Tone(Note.A, ScaleType.MAJOR));

        musicTest.addArrangement(arrangement);
        assertThat(musicTest.getArrangements().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Should return arrangement by tone correctly")
    void shouldReturnArrangementByTone(){

        assertThat(musicTest.getArrangementByTone(tone)).isEqualTo(arrangement);
    }

    @Test
    @DisplayName("Should block when not found arrangement by tone")
    void shouldBlockArrangementByTone(){

        assertThatThrownBy(()-> musicTest.getArrangementByTone(new Tone(Note.C_SHARP,ScaleType.ARABIC_MINOR)))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("Should return false on equals method")
    void shouldReturnFalseEquals(){
        Music music = new Music("Test title", user);

        assertThat(music.equals(musicTest)).isFalse();
    }

    @Test
    @DisplayName("Should return true on equals method")
    void shouldReturnTrueEquals(){
        UUID uuid = UUID.randomUUID();
        Music music = new Music(uuid,"Another title",arrangements,user);
        Music music2 = new Music(uuid,"Another title",arrangements,user);

        assertThat(music.equals(music2)).isTrue();
    }
}
