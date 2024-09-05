package com.neonotes.domain.entities;

public class Phrase implements MusicComponent{
    private String phrase;

    public Phrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    @Override
    public void display() {

    }
}
