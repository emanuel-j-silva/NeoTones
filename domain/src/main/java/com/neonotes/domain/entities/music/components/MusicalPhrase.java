package com.neonotes.domain.entities.music.components;

import java.util.Arrays;
import java.util.List;

public class MusicalPhrase implements MusicComponent{
    private final List<MusicComponent> components;

    public MusicalPhrase(MusicComponent... components) {
        this.components = Arrays.asList(components);
    }

    public void addComponent(MusicComponent component){
        components.add(component);
    }

    public List<MusicComponent> getComponents() {
        return components;
    }

    @Override
    public MusicComponent shiftTone(int semitones) {
        MusicalPhrase transposedMusicalPhrase = new MusicalPhrase();

        for (MusicComponent component:components){
            MusicComponent transposedComponent = component.shiftTone(semitones);
            transposedMusicalPhrase.addComponent(transposedComponent);
        }

        return transposedMusicalPhrase;
    }
}
