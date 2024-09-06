package com.neonotes.domain.entities.music.components;

import com.neonotes.domain.entities.music.note.Note;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MelodyTest {

    private static Melody melody;
    @BeforeAll
    static void setUp(){
        melody = new Melody();
        Note note1 = Note.G;
        Note note2 = Note.A;
        Note note3 = Note.B;
        melody.addNotes(note1,note2,note3);
    }

    @Test
    @DisplayName("Should return correct transposition of note sequence")
    void shouldReturnCorrectMinimumSequenceTranspose(){
        MusicComponent transposedMelody = melody.shiftTone(1);
        MusicComponent expectedMelody = new Melody(List.of(Note.G_SHARP,Note.A_SHARP,Note.C));

        assertEquals(expectedMelody,transposedMelody);
    }
}
