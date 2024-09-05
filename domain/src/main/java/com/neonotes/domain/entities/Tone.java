package com.neonotes.domain.entities;

public class Tone {
    private final Note note;
    private final ScaleType scale;

    public Tone(Note note, ScaleType scale) {
        this.note = note;
        this.scale = scale;
    }

    public Note getNote() {
        return note;
    }

    public ScaleType getScale() {
        return scale;
    }

}
