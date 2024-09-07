package com.neonotes.domain.entities.music.components;

import com.neonotes.domain.entities.music.note.Note;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MelodyTest {

    private static Melody melody;

    @BeforeEach
    void setUp(){
        melody = new Melody();
        Note note1 = Note.G;
        Note note2 = Note.A;
        Note note3 = Note.B;
        melody.addNotes(note1,note2,note3);
    }

    @AfterEach
    void tearDown(){
        melody.getNotes().clear();
    }

    @Test
    @DisplayName("Should return correct minimum transposition of note sequence")
    void shouldReturnCorrectMinimumSequenceTranspose(){
        MusicComponent transposedMelody = melody.shiftTone(1);
        MusicComponent expectedMelody = new Melody(List.of(Note.G_SHARP,Note.A_SHARP,Note.C));

        assertEquals(expectedMelody,transposedMelody);
    }

    @Test
    @DisplayName("Should return correct maximum transposition of note sequence")
    void shouldReturnCorrectMaximumSequenceTranspose(){
        MusicComponent transposedMelody = melody.shiftTone(11);
        MusicComponent expectedMelody = new Melody(List.of(Note.F_SHARP,Note.G_SHARP,Note.A_SHARP));

        assertEquals(expectedMelody,transposedMelody);
    }

    @Test
    @DisplayName("Should return correct minimum negative transposition of note sequence")
    void shouldReturnCorrectMinimumNegativeSequenceTranspose(){
        MusicComponent transposedMelody = melody.shiftTone(-1);
        MusicComponent expectedMelody = new Melody(List.of(Note.F_SHARP,Note.G_SHARP,Note.A_SHARP));

        assertEquals(expectedMelody,transposedMelody);
    }

    @Test
    @DisplayName("Should return correct maximum negative transposition of note sequence")
    void shouldReturnCorrectMaximumNegativeSequenceTranspose(){
        MusicComponent transposedMelody = melody.shiftTone(-11);
        MusicComponent expectedMelody = new Melody(List.of(Note.G_SHARP,Note.A_SHARP,Note.C));

        assertEquals(expectedMelody,transposedMelody);
    }

    @Test
    @DisplayName("Should return the same melody in zero semitones transposition")
    void shouldReturnEqualsMelodyZeroTranspose(){
        MusicComponent transposedMelody = melody.shiftTone(0);
        assertEquals(melody,transposedMelody);
    }

    @Test
    @DisplayName("Should return true to contains method on melody list")
    void shouldReturnTrueToContainsNote(){
        Note note = Note.A;

        assertTrue(melody.getNotes().contains(note));
    }

    @Test
    @DisplayName("Should remove the note correctly")
    void shouldRemoveTheNoteCorrectly(){
        boolean isRemoved = melody.removeNoteByIndex(1);

        assertTrue(isRemoved);
        assertEquals(2,melody.getNotes().size());
        assertFalse(melody.getNotes().contains(Note.A));
    }

    @Test
    @DisplayName("Should remove the note correctly")
    void shouldReturnEmptyNotesList(){
        melody.removeNoteByIndex(0);
        melody.removeNoteByIndex(0);
        melody.removeNoteByIndex(0);

        assertEquals(0,melody.getNotes().size());

        assertFalse(melody.getNotes().contains(Note.G));
        assertFalse(melody.getNotes().contains(Note.A));
        assertFalse(melody.getNotes().contains(Note.B));
    }

    @Test
    @DisplayName("Should add one note correctly")
    void shouldAddOneNote(){
        melody.addNote(Note.C);

        assertTrue(melody.getNotes().contains(Note.C));
        assertEquals(4,melody.getNotes().size());
    }

    @Test
    @DisplayName("Should add multiple notes correctly")
    void shouldAddMultipleNotes(){
        melody.addNotes(Note.values());

        assertEquals(15,melody.getNotes().size());
    }

    @Test
    @DisplayName("Should block null additions to notes list")
    void shouldBlockNullAdd(){

        assertThrows(IllegalArgumentException.class, () -> melody.addNote(null));
        assertThrows(IllegalArgumentException.class, () -> melody.addNotes(Note.C,null,Note.E));
    }

}
