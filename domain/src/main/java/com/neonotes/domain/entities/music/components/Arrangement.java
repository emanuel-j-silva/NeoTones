package com.neonotes.domain.entities.music.components;

import com.neonotes.domain.entities.music.Tone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrangement {

    private Tone tone;
    private final List<MusicComponent> components;

    public Arrangement(Tone tone){
        this.tone = tone;
        this.components = new ArrayList<>();
    }

    public Arrangement(Tone tone, MusicComponent... components) {
        this.tone = tone;
        this.components = new ArrayList<>(Arrays.asList(components));
    }

    public void addComponent(MusicComponent component){
        components.add(component);
    }

    public Tone getTone() {
        return tone;
    }

    public void setTone(Tone tone) {
        this.tone = tone;
    }

    public List<MusicComponent> getComponents() {
        return components;
    }


}
