package com.neonotes.domain.entities.music;

import com.neonotes.domain.entities.music.components.Arrangement;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Music {
    private final UUID uuid;
    private final String title;
    private final Map<Tone, Arrangement> arrangements;

    public Music(String title) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.arrangements = new HashMap<>();
    }

    public Music(String title, Map<Tone, Arrangement> arrangements) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.arrangements = arrangements;
    }

    public Music(UUID uuid, String title, Map<Tone, Arrangement> arrangements) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.title = title;
        this.arrangements = arrangements;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public Map<Tone, Arrangement> getArrangements() {
        return arrangements;
    }
}
