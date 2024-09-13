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
        assertThatThrownBy(()-> new MusicalPhrase(null))
                .isInstanceOf(NullPointerException.class);
    }
    @Test
    @DisplayName("Create instance with null elements")
    void createWithNullElements(){
        Melody melody = new Melody(List.of(Note.B,Note.A));
        Phrase phrase = new Phrase("Phrase");

        assertThatThrownBy(()-> new MusicalPhrase(List.of(melody,phrase,null)))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Should block if add a null component in the components list")
    void shouldBlockAddNullComponent(){
        MusicalPhrase musicalPhrase = new MusicalPhrase();

        assertThatThrownBy(()-> musicalPhrase.addComponent(null))
                .isInstanceOf(NullPointerException.class);

        assertThat(musicalPhrase).hasNoNullFieldsOrProperties();
    }

    @Test
    @DisplayName("Should correctly add components individually")
    void shouldAddComponentsIndividually(){
        Melody melody1 = new Melody(List.of(Note.A,Note.B));
        Phrase phrase1 = new Phrase("Test");

        Melody melody2 = new Melody(List.of(Note.C_SHARP,Note.E));
        Phrase phrase2 = new Phrase("Test phrase");
        MusicalPhrase mp1 = new MusicalPhrase(List.of(melody2,phrase2));

        MusicalPhrase musicalPhrase = new MusicalPhrase();
        musicalPhrase.addComponent(mp1);
        musicalPhrase.addComponent(melody1);
        musicalPhrase.addComponent(phrase1);

        assertThat(musicalPhrase.getComponents().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Should add components after instantiation with elements")
    void shouldAddAfterInstantiationNoEmpty(){
        Melody melody = new Melody(List.of(Note.A_SHARP));
        Phrase phrase = new Phrase("Test");
        MusicalPhrase musicalPhrase = new MusicalPhrase(List.of(melody,phrase));

        Phrase phrase2 = new Phrase("Another test");
        musicalPhrase.addComponent(phrase2);

        assertThat(musicalPhrase.getComponents().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Should add components after instantiation with no elements")
    void shouldAddAfterInstantiationEmpty(){
        Melody melody = new Melody(List.of(Note.B,Note.E));
        Phrase phrase = new Phrase("Test");

        MusicalPhrase musicalPhrase = new MusicalPhrase();
        musicalPhrase.addComponent(melody);
        musicalPhrase.addComponent(phrase);

        assertThat(musicalPhrase.getComponents().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Should add a single component in components list")
    void shouldAddSingleComponent(){
        Phrase phrase = new Phrase("Test");
        MusicalPhrase musicalPhrase = new MusicalPhrase(List.of(phrase));

        assertThat(musicalPhrase.getComponents().size()).isEqualTo(1);
    }
}
