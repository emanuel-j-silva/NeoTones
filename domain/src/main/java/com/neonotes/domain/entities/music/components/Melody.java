package com.neonotes.domain.entities.music.components;

import com.neonotes.domain.entities.music.Note;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void display() {

    }
}
