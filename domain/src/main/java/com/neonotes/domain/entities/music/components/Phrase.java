package com.neonotes.domain.entities.music.components;

import com.neonotes.domain.entities.music.components.MusicComponent;

public class Phrase implements MusicComponent {
    private String phrase;

    public Phrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    @Override
    public MusicComponent shiftTone(int semitones) {
        return this;
    }
}
