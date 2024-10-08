package com.neotones.domain.entities.music.components;

import com.neotones.domain.entities.music.note.Note;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

public class MusicalPhraseTest {

    @Test
    @DisplayName("Create instance with unique null element")
    void createWithOneNullElement(){
        assertThatThrownBy(()-> new MusicalPhrase(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("Create instance with null elements")
    void createWithNullElements(){
        Melody melody = new Melody(List.of(Note.B,Note.A));
        Phrase phrase = new Phrase("Phrase");

        List<MusicComponent> components = new ArrayList<>();
        components.add(melody);
        components.add(phrase);
        components.add(null);

        assertThatThrownBy(()-> new MusicalPhrase(components))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Should block if add a null component in the components list")
    void shouldBlockAddNullComponent(){
        MusicalPhrase musicalPhrase = new MusicalPhrase();

        assertThatThrownBy(()-> musicalPhrase.addComponent(null))
                .isInstanceOf(IllegalArgumentException.class);

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

    @Test
    @DisplayName("Should block when adding itself to component list")
    void shouldBlockAddItself(){
        Melody melody = new Melody(List.of(Note.B,Note.C));
        Phrase phrase = new Phrase("Test");
        MusicalPhrase musicalPhrase = new MusicalPhrase(List.of(melody,phrase));

        assertThatThrownBy(()-> musicalPhrase.addComponent(musicalPhrase))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Should block when adding null list in add components method")
    void shouldBlockAddNullList(){
        MusicalPhrase musicalPhrase = new MusicalPhrase();
        assertThatThrownBy(()-> musicalPhrase.addComponents(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Should block when adding some null component in add components method")
    void shouldBlockAddNullComponentInList(){
        Phrase phrase = new Phrase("Test");
        Phrase phrase2 = new Phrase("Another test");
        List<MusicComponent> components = new ArrayList<>(List.of(phrase, phrase2));
        components.add(null);

        MusicalPhrase musicalPhrase = new MusicalPhrase();
        assertThatThrownBy(()-> musicalPhrase.addComponents(components))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Should remove element by index correctly")
    void shouldRemoveByIndex(){
        Phrase phrase = new Phrase("Test");
        Phrase phrase2 = new Phrase("Another test");

        MusicalPhrase musicalPhrase = new MusicalPhrase();
        musicalPhrase.addComponents(List.of(phrase,phrase2));
        boolean removeByIndex = musicalPhrase.removeComponentByIndex(0);

        assertThat(removeByIndex).isTrue();
        assertThat(musicalPhrase.getComponents()).noneMatch(Predicate.isEqual(phrase));
        assertThat(musicalPhrase.getComponents().size()).isEqualTo(1);

    }

    @Test
    @DisplayName("Should block when trying remove element out of index")
    void shouldBlockRemoveOutOfIndex(){
        Phrase phrase = new Phrase("Test");
        Phrase phrase2 = new Phrase("Another test");

        MusicalPhrase musicalPhrase = new MusicalPhrase();
        musicalPhrase.addComponents(List.of(phrase,phrase2));

        assertThatThrownBy(()-> musicalPhrase.removeComponentByIndex(2))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("Should transpose all components correctly")
    void shouldTransposeCorrectly(){
        Phrase phrase = new Phrase("Test");
        Melody melody = new Melody(List.of(Note.C,Note.D,Note.E));

        Phrase componentPhrase = new Phrase("Another test");
        Melody componentMelody = new Melody(List.of(Note.A,Note.B,Note.C));
        MusicalPhrase compMusicalPhrase = new MusicalPhrase(List.of(componentPhrase,componentMelody));

        Melody expectedComponentMelody = new Melody(List.of(Note.B,Note.C_SHARP,Note.D));
        MusicalPhrase expectedCompMusicalPhase = new MusicalPhrase(List.of(componentPhrase,expectedComponentMelody));

        MusicalPhrase musicalPhrase = new MusicalPhrase(List.of(phrase,melody,compMusicalPhrase));
        MusicalPhrase component = (MusicalPhrase) musicalPhrase.shiftTone(2);

        assertThat(component.getComponents().get(0)).isEqualTo(phrase);
        assertThat(component.getComponents().get(1))
                .isEqualTo(new Melody(List.of(Note.D, Note.E,Note.F_SHARP)));

        assertThat(component.getComponents().get(2)).isInstanceOf(MusicalPhrase.class);
        assertThat(component.getComponents().get(2)).isEqualTo(expectedCompMusicalPhase);



    }
}
