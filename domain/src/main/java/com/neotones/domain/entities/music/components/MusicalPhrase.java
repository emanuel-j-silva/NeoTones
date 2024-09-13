package com.neotones.domain.entities.music.components;

import java.util.*;

public class MusicalPhrase implements MusicComponent{
    private final List<MusicComponent> components;

    public MusicalPhrase(){
        this.components = new ArrayList<>();
    }

    public MusicalPhrase(List<MusicComponent> components) {
        if (components == null || components.stream().anyMatch(Objects::isNull)){
            throw new NullPointerException("Musical phrase can't contain null components");
        }

        this.components = new ArrayList<>(components);
    }

    public void addComponent(MusicComponent component){
        if (component == null){
            throw new NullPointerException("Can't add null to components list");
        }
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
