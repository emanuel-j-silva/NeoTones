package com.neonotes.domain.entities.music;

public enum Note {
    C("C","DO"),
    C_SHARP("C#","DO#","Db","REb"),
    D("D","RE"),
    D_SHARP("D#","RE#","Eb","MIb"),
    E("E","MI"),
    F("F","FA"),
    F_SHARP("F#","FA#","SOLb","SOLb"),
    G("G","SOL"),
    G_SHARP("G#","SOL#","Ab","LAb"),
    A("A","LA"),
    A_SHARP("A#","LA#","Bb","SIb"),
    B("B","SI");

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
}
