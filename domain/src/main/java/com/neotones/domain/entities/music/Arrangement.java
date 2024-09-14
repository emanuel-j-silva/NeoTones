package com.neotones.domain.entities.music;

import com.neotones.domain.entities.music.components.MusicComponent;
import com.neotones.domain.entities.music.note.Tone;

import java.util.*;

public class Arrangement {

    private final UUID uuid;
    private final Tone tone;
    private final List<MusicComponent> components;

    public Arrangement(Tone tone){
        this(null,tone, new ArrayList<>());
    }

    public Arrangement(Tone tone, List<MusicComponent> components) {
        this(null, tone, components);
    }

    public Arrangement(UUID uuid, Tone tone, List<MusicComponent> components) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.tone = Objects.requireNonNull(tone,"Tone can't be null");
        this.components = new ArrayList<>(components);
    }

    public void addComponent(MusicComponent component){
        if (component == null){
            throw new IllegalArgumentException("Can't add null components in arrangement");
        }
        components.add(component);
    }

    public void addComponents(List<MusicComponent> components){
        if (components == null || components.stream().anyMatch(Objects::isNull)){
            throw new IllegalArgumentException("Can't add null components in arrangement");
        }
        this.components.addAll(components);
    }

    public UUID getUuid() {
        return uuid;
    }

    public Tone getTone() {
        return tone;
    }

    public List<MusicComponent> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        return "Arrangement{" +
                "tone=" + tone +
                ", components=" + components +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arrangement that)) return false;
        return uuid.equals(that.uuid) && tone.equals(that.tone) && Objects.equals(components, that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
