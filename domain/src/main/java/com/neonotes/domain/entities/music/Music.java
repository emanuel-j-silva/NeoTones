package com.neonotes.domain.entities.music;

import com.neonotes.domain.entities.music.note.Tone;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Music {
    private final UUID uuid;
    private final String title;
    private final Map<Tone, Arrangement> arrangements;

    public Music(String title) {
        this(UUID.randomUUID(), title, new HashMap<>());
    }

    public Music(String title, Map<Tone, Arrangement> arrangements) {
        this(UUID.randomUUID(), title, arrangements);
    }

    public Music(UUID uuid, String title, Map<Tone, Arrangement> arrangements) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.title = Objects.requireNonNull(title,"Title can't be null");
        this.arrangements = Objects.requireNonNull(arrangements,"Arrangements can't be null");
    }

    public void addArrangement(Arrangement arrangement){
        if (arrangements.containsKey(arrangement.getTone())){
            throw new IllegalStateException("There is already an arrangement with this tone for this music");
        }
        arrangements.put(arrangement.getTone(),arrangement);
    }
    public Arrangement getArrangementByTone(Tone tone){
        if (!arrangements.containsKey(tone)){
            throw new IllegalStateException("There is no arrangement with this tone for this music");
        }
        return arrangements.get(tone);
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
