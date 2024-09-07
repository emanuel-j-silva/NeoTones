package com.neonotes.domain.entities.music.components;

import com.neonotes.domain.entities.music.note.Note;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Melody implements MusicComponent {
    private final List<Note> notes;

    public Melody() {
        this.notes = new ArrayList<>();
    }

    public Melody(List<Note> notes) {
        this.notes = notes;
    }

    public void addNote(Note note){
        notes.add(note);
    }
    public void addNotes(Note... notes){
        this.notes.addAll(List.of(notes));
    }

    public List<Note> getNotes() {
        return notes;
    }

    @Override
    public MusicComponent shiftTone(int semitones) {
        Melody transposedMelody = new Melody();

        for (Note note:notes){
            Note transposedNote = note.transpose(semitones);
            transposedMelody.addNote(transposedNote);
        }

        return transposedMelody;
    }

    @Override
    public String toString() {
        return "Melody{" +
                "notes=" + notes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Melody melody = (Melody) o;
        return Objects.equals(this.notes, melody.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.notes);
    }

}
