package com.neonotes.domain.entities.music.components;

import com.neonotes.domain.entities.music.Tone;

import java.util.*;

public class Arrangement {

    private final UUID uuid;
    private final Tone tone;
    private final List<MusicComponent> components;

    public Arrangement(Tone tone, MusicComponent... components) {
        this.uuid = null;
        this.tone = tone;
        this.components = new ArrayList<>(Arrays.asList(components));
    }

    public Arrangement(UUID uuid, Tone tone, MusicComponent... components) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.tone = Objects.requireNonNull(tone);
        this.components = new ArrayList<>(Arrays.asList(components));
    }

    public void addComponent(MusicComponent component){
        components.add(component);
    }

    public Tone getTone() {
        return tone;
    }

    public List<MusicComponent> getComponents() {
        return components;
    }
}
