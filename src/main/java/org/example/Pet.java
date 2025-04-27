package org.example;

public class Pet {
    private final String name;
    private final String type;
    private int hunger;
    private int happiness;

    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
        this.hunger = 50;
        this.happiness = 70;
    }

    public void update() {
        hunger = Math.max(hunger-2, 0);
        if (hunger < 20) {
            happiness = Math.max(happiness-1, 0);
        }
    }

    public void describe() {
        System.out.println("Pet: " + name + " (" + type + ")");
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
