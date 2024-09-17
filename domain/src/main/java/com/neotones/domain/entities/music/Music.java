package com.neotones.domain.entities.music;

import com.neotones.domain.entities.music.note.Tone;
import com.neotones.domain.entities.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Music {
    private final UUID uuid;
    private final String title;
    private final Map<Tone, Arrangement> arrangements;

    private final User user;

    public Music(String title, User user) {
        this(null, title, new HashMap<>(), user);
    }

    public Music(String title, Map<Tone, Arrangement> arrangements, User user) {
        this(UUID.randomUUID(), title, arrangements, user);
    }

    public Music(UUID uuid, String title, Map<Tone, Arrangement> arrangements, User user) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.title = Objects.requireNonNull(title,"Title can't be null");
        this.arrangements = Objects.requireNonNull(arrangements,"Arrangements can't be null");
        this.user = Objects.requireNonNull(user, "User can´t be null");
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
