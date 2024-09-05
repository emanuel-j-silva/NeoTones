package com.neonotes.domain.entities;

public class Tone {
    private final Notes note;
    private final ScaleType scale;

    public Tone(Notes note, ScaleType scale) {
        this.note = note;
        this.scale = scale;
    }

    public Notes getNote() {
        return note;
    }

    public ScaleType getScale() {
        return scale;
    }

}
