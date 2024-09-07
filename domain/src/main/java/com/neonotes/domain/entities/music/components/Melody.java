package com.neonotes.domain.entities.music.components;

import com.neonotes.domain.entities.music.note.Note;
import java.util.ArrayList;
import java.util.Arrays;
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
        if (note == null){
            throw new IllegalArgumentException("Unable to add null objects in melody list");
        }
        notes.add(note);
    }
    public void addNotes(Note... notes){
        if (Arrays.stream(notes).anyMatch(Objects::isNull)){
            throw new IllegalArgumentException("Unable to add null objects in melody list");
        }
        this.notes.addAll(List.of(notes));
    }

    public boolean removeNoteByIndex(int index){
        if (index < 0 || index >= notes.size()){
            throw new IllegalArgumentException("Note not found with this index");
        }

        Note note = notes.get(index);
        return notes.remove(note);
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
