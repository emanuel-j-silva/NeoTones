package com.neotones.domain.entities.music;

import com.neotones.domain.entities.music.components.MusicComponent;
import com.neotones.domain.entities.music.note.Tone;


public class Transposer {

    public static Arrangement transpose(Arrangement defaultArrangement, Tone pretendedTone){
        Arrangement arrangement = new Arrangement(pretendedTone);

        int semitones = pretendedTone.getNote().ordinal() - defaultArrangement.getTone().getNote().ordinal();

        for (MusicComponent component: defaultArrangement.getComponents()){
            component.shiftTone(semitones);
            arrangement.addComponent(component);
        }

        return arrangement;
    }
}
