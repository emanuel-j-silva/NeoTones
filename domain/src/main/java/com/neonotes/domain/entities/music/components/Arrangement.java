package com.neonotes.domain.entities.music.components;

import com.neonotes.domain.entities.music.Tone;

import java.util.Arrays;
import java.util.List;

public class Arrangement {

    private final Tone tone;
    private final List<MusicComponent> components;

    public Arrangement(Tone tone, MusicComponent... components) {
        this.tone = tone;
        this.components = Arrays.asList(components);
    }

    public Tone getTone() {
        return tone;
    }

    public List<MusicComponent> getComponents() {
        return components;
    }
}
