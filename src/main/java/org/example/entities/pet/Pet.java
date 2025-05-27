package org.example.entities.pet;

public class Pet {
    private final String name;
    private final PetType type;

    public Pet(String name, PetType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public PetType getType() {
        return type;
    }
}
