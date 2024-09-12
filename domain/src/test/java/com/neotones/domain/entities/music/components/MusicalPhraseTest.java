package com.neotones.domain.entities.music.components;

import com.neotones.domain.entities.music.note.Note;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MusicalPhraseTest {

    @Test
    @DisplayName("Create instance with unique null element")
    void createWithOneNullElement(){
        MusicalPhrase musicalPhrase = new MusicalPhrase(null);

        assertThatThrownBy(()-> new MusicalPhrase(null))
                .isInstanceOf(NullPointerException.class);
    }
    @Test
    @DisplayName("Create instance with null elements")
    void createWithNullElements(){
        Melody melody = new Melody(List.of(Note.B,Note.A));
        Phrase phrase = new Phrase("Phrase");

        assertThatThrownBy(()-> new MusicalPhrase(melody,phrase,null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Should block if add a null component in the components list")
    void shouldBlockAddNullComponent(){
        MusicalPhrase musicalPhrase = new MusicalPhrase();
        musicalPhrase.addComponent(null);

        assertThat(musicalPhrase).hasNoNullFieldsOrProperties();
    }
}
