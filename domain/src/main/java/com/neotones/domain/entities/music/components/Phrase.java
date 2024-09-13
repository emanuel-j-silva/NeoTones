package com.neotones.domain.entities.music.components;

import java.util.Objects;

public class Phrase implements MusicComponent {
    private String phrase;

    public Phrase(String phrase) {
        this.phrase = Objects.requireNonNull(phrase);
    }

    public String getPhrase() {
        return phrase;
    }

    @Override
    public MusicComponent shiftTone(int semitones) {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phrase phrase1)) return false;
        return Objects.equals(phrase, phrase1.phrase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phrase);
    }
}
