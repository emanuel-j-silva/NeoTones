package com.neotones.domain.entities.music.note;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoteTest{

    @Test
    @DisplayName("Should return correct note on non-circular transposition")
    void shouldReturnCorrectNoteBasicTranspose(){
        Note note = Note.C;
        Note transposedNote = note.transpose(3);

        assertEquals(Note.D_SHARP,transposedNote);
        assertEquals(3,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return correct note on simple circular transposition")
    void shouldReturnCorrectNoteCircularTranspose(){
        Note note = Note.A;
        Note transposedNote = note.transpose(5);

        assertEquals(Note.D,transposedNote);
        assertEquals(2,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return the correct note in more then one turn in the range of notes")
    void shouldReturnCorrectNoteOnMoreThenOneTurn(){
        Note note = Note.A;
        Note transposedNote = note.transpose(17);

        assertEquals(Note.D,transposedNote);
        assertEquals(2,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return the correct note in exactly one turn in the range of notes")
    void shouldReturnCorrectNoteOnExactlyOneTurn(){
        Note note = Note.F;
        Note transposedNote = note.transpose(12);

        assertEquals(note,transposedNote);
        assertEquals(5,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return the same note in zero semitones")
    void shouldReturnCorrectNoteOnZero(){
        Note note = Note.E;
        Note transposedNote = note.transpose(0);

        assertEquals(note,transposedNote);
        assertEquals(4,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return the correct note in maximum semitone transposition")
    void shouldReturnCorrectNoteOnMaximum(){
        Note note = Note.C;
        Note transposedNote = note.transpose(11);

        assertEquals(Note.B,transposedNote);
        assertEquals(11,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return the correct note in minimum semitone transposition")
    void shouldReturnCorrectNoteOnMinimum(){
        Note note = Note.G;
        Note transposedNote = note.transpose(1);

        assertEquals(Note.G_SHARP,transposedNote);
        assertEquals(8,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return the correct note in several turns on the range of notes")
    void shouldReturnCorrectNoteOnSeveralTurns(){
        Note note = Note.F;
        Note transposedNote = note.transpose(40);

        assertEquals(Note.A,transposedNote);
        assertEquals(9,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return the correct note in more than one exact turn around the range of notes")
    void shouldReturnCorrectNoteOnExactlySeveralTurns(){
        Note note = Note.F_SHARP;
        Note transposedNote = note.transpose(72);

        assertEquals(note,transposedNote);
        assertEquals(6,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return correct note on non-circular negative transpose")
    void shouldReturnCorrectNoteBasicNegativeTranspose(){
        Note note = Note.D_SHARP;
        Note transposedNote = note.transpose(-3);

        assertEquals(Note.C,transposedNote);
        assertEquals(0,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return correct note on simple circular negative transpose")
    void shouldReturnCorrectNoteNegativeCircularTranspose(){
        Note note = Note.D;
        Note transposedNote = note.transpose(-5);

        assertEquals(Note.A,transposedNote);
        assertEquals(9,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return the correct note in more then one negative turn in the range of notes")
    void shouldReturnCorrectNoteOnMoreThenOneNegativeTurn(){
        Note note = Note.D;
        Note transposedNote = note.transpose(-17);

        assertEquals(Note.A,transposedNote);
        assertEquals(9,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return the correct note in exactly one turn in the range of notes")
    void shouldReturnCorrectNoteOnExactlyOneNegativeTurn(){
        Note note = Note.F;
        Note transposedNote = note.transpose(-12);

        assertEquals(note,transposedNote);
        assertEquals(5,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return the correct note in maximum negative semitone transposition")
    void shouldReturnCorrectNoteOnMaximumNegative(){
        Note note = Note.C;
        Note transposedNote = note.transpose(-11);

        assertEquals(Note.C_SHARP,transposedNote);
        assertEquals(1,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return the correct note in minimum negative semitone transposition")
    void shouldReturnCorrectNoteOnMinimumNegative(){
        Note note = Note.G;
        Note transposedNote = note.transpose(-1);

        assertEquals(Note.F_SHARP,transposedNote);
        assertEquals(6,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return the correct note in several turns on the range of notes")
    void shouldReturnCorrectNoteOnSeveralNegativeTurns(){
        Note note = Note.F;
        Note transposedNote = note.transpose(-40);

        assertEquals(Note.C_SHARP,transposedNote);
        assertEquals(1,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return the correct note in more than one exact turn around the range of notes")
    void shouldReturnCorrectNoteOnExactlySeveralNegativeTurns(){
        Note note = Note.F_SHARP;
        Note transposedNote = note.transpose(-72);

        assertEquals(note,transposedNote);
        assertEquals(6,transposedNote.ordinal());
    }

    @Test
    @DisplayName("Should return true for comparing equal notes")
    void shouldReturnTrueToEqualNotes(){
        Note note1 = Note.G;
        Note note2 = Note.G;

        assertTrue(note2.equalsNote(note1));
    }

    @Test
    @DisplayName("Should return false for comparing different notes")
    void shouldReturnFalseToDifferentNotes(){
        Note note1 = Note.G;
        Note note2 = Note.E;

        assertFalse(note2.equalsNote(note1));
    }
}
