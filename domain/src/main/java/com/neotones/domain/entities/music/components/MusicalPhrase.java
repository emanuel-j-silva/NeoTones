package com.neotones.domain.entities.music.components;


import java.util.*;

public class MusicalPhrase implements MusicComponent{
    private final List<MusicComponent> components;

    public MusicalPhrase(){
        this.components = new ArrayList<>();
    }

    public MusicalPhrase(List<MusicComponent> components) {
        if (components == null || components.stream().anyMatch(Objects::isNull)){
            throw new IllegalArgumentException("Musical phrase can't contain null components");
        }

        this.components = new ArrayList<>(components);
    }

    public void addComponent(MusicComponent component){
        if (component == null){
            throw new IllegalArgumentException("Can't add null to components list");
        }
        if (component == this){
            throw new IllegalArgumentException("A component cannot contain itself");
        }
        components.add(component);
    }

    public void addComponents(List<MusicComponent> components){
        if (components == null || components.stream().anyMatch(Objects::isNull)){
            throw new IllegalArgumentException("Unable to add null in components list");
        }
        if (components.stream().anyMatch(component -> component == this)){
            throw new IllegalArgumentException("A component cannot contain itself");
        }
        this.components.addAll(components);
    }

    public List<MusicComponent> getComponents() {
        return components;
    }

    @Override
    public MusicComponent shiftTone(int semitones) {
        MusicalPhrase transposedMusicalPhrase = new MusicalPhrase();

        for (MusicComponent component:components){
            MusicComponent transposedComponent = component.shiftTone(semitones);
            transposedMusicalPhrase.addComponent(transposedComponent);
        }

        return transposedMusicalPhrase;
    }

    public boolean removeComponentByIndex(int index){
        if (index < 0 || index >= components.size()){
            throw new IllegalArgumentException("Component not found with this index");
        }

        MusicComponent component = components.get(index);
        return components.remove(component);
    }

    @Override
    public String toString() {
        return "MusicalPhrase{" +
                "components=" + components +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicalPhrase that)) return false;
        return components.equals(that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }
}
