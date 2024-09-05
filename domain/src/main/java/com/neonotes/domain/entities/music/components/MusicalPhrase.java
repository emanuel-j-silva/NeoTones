package com.neonotes.domain.entities.music.components;

import java.util.Arrays;
import java.util.List;

public class MusicalPhrase implements MusicComponent{
    private final List<MusicComponent> components;

    public MusicalPhrase(MusicComponent... components) {
        this.components = Arrays.asList(components);
    }

    public List<MusicComponent> getComponents() {
        return components;
    }

    @Override
    public void display() {

    }
}
