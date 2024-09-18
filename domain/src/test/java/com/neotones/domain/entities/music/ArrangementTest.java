package com.neotones.domain.entities.music;

import com.neotones.domain.entities.music.components.Melody;
import com.neotones.domain.entities.music.components.MusicComponent;
import com.neotones.domain.entities.music.components.Phrase;
import com.neotones.domain.entities.music.note.Note;
import com.neotones.domain.entities.music.note.ScaleType;
import com.neotones.domain.entities.music.note.Tone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class ArrangementTest {

    private final Tone tone = new Tone(Note.C, ScaleType.MAJOR);
    private final List<MusicComponent> components = new ArrayList<>(
            List.of(new Phrase("phrase"), new Melody(List.of(Note.C,Note.D,Note.E))));

    @Test
    @DisplayName("Create Arrangement with null UUID parameter")
    void shouldCreateWithNullUuid(){
        Arrangement arrangement = new Arrangement(null,tone,components);

        assertThat(arrangement.getUuid()).isInstanceOf(UUID.class);
    }

    @Test
    @DisplayName("Should throw exception when add a null component")
    void shouldBlockAddNull(){
        Arrangement arrangement = new Arrangement(UUID.randomUUID(),tone,components);

        assertThat(arrangement.getUuid()).isInstanceOf(UUID.class);
        assertThatThrownBy(()-> arrangement.addComponent(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Should throw exception when add a null list")
    void shouldBlockAddNullList(){
        Arrangement arrangement = new Arrangement(UUID.randomUUID(),tone,components);

        assertThatThrownBy(()-> arrangement.addComponents(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Should throw exception when add a null component into the list")
    void shouldBlockAddNullComponentInList(){
        Arrangement arrangement = new Arrangement(UUID.randomUUID(),tone,components);
        List<MusicComponent> components = new ArrayList<>();
        Phrase phrase = new Phrase("Test");
        components.add(phrase);
        components.add(null);

        assertThatThrownBy(()-> arrangement.addComponents(components))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
