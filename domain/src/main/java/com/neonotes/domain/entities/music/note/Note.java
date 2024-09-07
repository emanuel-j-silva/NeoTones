package com.neonotes.domain.entities.music.note;

import java.util.Objects;

public enum Note {
    C("C","DO"),
    C_SHARP("C#","DO#","Db","REb"),
    D("D","RE"),
    D_SHARP("D#","RE#","Eb","MIb"),
    E("E","MI"),
    F("F","FA"),
    F_SHARP("F#","FA#","Gb","SOLb"),
    G("G","SOL"),
    G_SHARP("G#","SOL#","Ab","LAb"),
    A("A","LA"),
    A_SHARP("A#","LA#","Bb","SIb"),
    B("B","SI");

    private static final int NOTE_RANGE = 12;

    private String letter;
    private String symbol;
    private String relativeFlatLetter;
    private String relativeFlatSymbol;

    Note(String letter, String symbol) {
        this.letter = letter;
        this.symbol = symbol;
    }

    Note(String letter, String symbol, String relativeFlatLetter, String relativeFlatSymbol) {
        this.letter = letter;
        this.symbol = symbol;
        this.relativeFlatLetter = relativeFlatLetter;
        this.relativeFlatSymbol = relativeFlatSymbol;
    }

    public String getLetter() {
        return letter;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getRelativeFlatLetter() {
        return relativeFlatLetter;
    }

    public String getRelativeFlatSymbol() {
        return relativeFlatSymbol;
    }

    public Note transpose(int semitones) {
        int actualSemitone = this.ordinal();

        // Module to ensure semitones stay within the range of available notes
        semitones = semitones % NOTE_RANGE;

        int pretendedTone = actualSemitone + semitones;
        int i = pretendedTone % NOTE_RANGE;

        if (i < 0){
            i += NOTE_RANGE;
        }

        return Note.values()[i];
    }

    public boolean equalsNote(Note other) {
        if (other == null) return false;

        return Objects.equals(this.letter, other.letter)
                || Objects.equals(this.symbol, other.symbol);
    }

    @Override
    public String toString() {
        return "Note{" +
                "letter='" + letter + '\'' +
                ", symbol='" + symbol + '\'' +
                "} " + super.toString();
    }
}
