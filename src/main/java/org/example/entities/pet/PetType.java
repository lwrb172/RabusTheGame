package org.example.entities.pet;

public enum PetType {
    CAT,
    DOG,
    NONE;

    public PetType toPetType(String petType) {
        return PetType.valueOf(petType);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
