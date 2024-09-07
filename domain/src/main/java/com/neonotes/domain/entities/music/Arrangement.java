package com.neonotes.domain.entities.music;

import com.neonotes.domain.entities.music.components.MusicComponent;
import com.neonotes.domain.entities.music.note.Tone;

import java.util.*;

public class Arrangement {

    private final UUID uuid;
    private final Tone tone;
    private final List<MusicComponent> components;

    public Arrangement(Tone tone, MusicComponent... components) {
        this(UUID.randomUUID(), tone, components);
    }

    public Arrangement(UUID uuid, Tone tone, MusicComponent... components) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.tone = Objects.requireNonNull(tone,"Tone can't be null");
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