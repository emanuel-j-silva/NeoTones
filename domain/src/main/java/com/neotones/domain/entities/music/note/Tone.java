package com.neotones.domain.entities.music.note;

import java.util.Objects;

public class Tone {
    private final Note note;
    private final ScaleType scaleType;

    public Tone(Note note, ScaleType scaleType) {
        this.note = Objects.requireNonNull(note,"Note of tone can't be null");
        this.scaleType = Objects.requireNonNull(scaleType, "Scale type of tone can't be null");
    }

    public Note getNote() {
        return note;
    }

    public ScaleType getScale() {
        return scaleType;
    }

    @Override
    public String toString() {
        return "Tone{" +
                "note=" + note +
                ", scale=" + scaleType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tone tone)) return false;
        return note == tone.note && scaleType == tone.scaleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(note, scaleType);
    }
}
