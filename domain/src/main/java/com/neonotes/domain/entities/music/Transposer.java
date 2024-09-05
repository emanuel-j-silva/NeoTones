package com.neonotes.domain.entities.music;

import com.neonotes.domain.entities.music.Note;

public class Transposer {
    private final Note standardScale;
    private final Note pretendedScale;

    public Transposer(Note standardScale, Note pretendedScale) {
        this.standardScale = standardScale;
        this.pretendedScale = pretendedScale;
    }
}
