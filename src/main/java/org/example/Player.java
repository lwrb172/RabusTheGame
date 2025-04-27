package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private String name;
    private String color;
    private int hunger;
    private int energy;
    private int happiness;
    private int coins;
    private Pet pet;
    private String currentJob;
    private List<String> inventory;
    private Map<String, Integer> relationships;
    private int streak = 0;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.hunger = 100;
        this.energy = 100;
        this.happiness = 70;
        this.coins = 50;
        this.currentJob = "Jobless";
        this.inventory = new ArrayList<>();
        this.relationships = new HashMap<>();
    }

    public Player(String name, String color, Pet pet) {
        this.name = name;
        this.color = color;
        this.pet = pet;
        this.hunger = 100;
        this.energy = 100;
        this.happiness = 70;
        this.coins = 50;
        this.currentJob = "Jobless";
        this.inventory = new ArrayList<>();
        this.relationships = new HashMap<>();
    }

    public void update() {
        hunger = Math.max(hunger-2, 0);
        energy = Math.max(energy-1, 0);
        if (hunger < 20) {
            energy = Math.max(energy-2, 0);
        }
        if (energy < 20) {
            happiness = Math.max(happiness-1, 0);
        }
        if (hunger == 100) {
            System.out.println("You died from starvation!");
        }
        if (energy == 0) {
            System.out.println("You're completely exhausted!");
        }
    }

    public String getStatus() {
        return String.format(
                "%s\nHunger: %d/100\nEnergy: %d/100\nHappiness: %d/100\nCoins: %d\nJob: %s",
                name,
                hunger,
                energy,
                happiness,
                coins,
                currentJob
        );
    }

    public String getName() { return name; }

    public String getColor() { return color; }

    public String getInventoryStatus() {
        if (inventory.isEmpty()) {
            return "\nYour inventory is empty!";
        }
        return "\nInventory:\n" + String.join(", ", inventory);
    }

    public void adoptPet(Pet pet) {
        this.pet = pet;
        happiness = Math.max(happiness+10, 100);
        System.out.println("You adopted a " + pet.getType() + "!");
    }

    public void feedPet(Pet pet) {
        if (pet != null) {
            happiness = Math.max(happiness+2, 100);
            System.out.println("You fed " + pet.getName() + "!");
        }
    }

    public void eat(Item food) {
        if (food.getType().equals("food")) {
            hunger = Math.min(hunger+food.getEffectValue(), 100);
            // niech zwieksza troche energie moze
        } else {
            System.out.println("You can't eat this!");
        }
    }

    public void sleep(int hours) {
        energy = 100;
        happiness = Math.min(happiness+5, 100);
    }

    public void work() {
        energy = Math.max(energy-20, 0);
        coins += 100;
    }

    public void addCoins(int amount) {
        this.coins += amount;
    }

    public void loseCoins(int amount) {
        this.coins -= amount;
    }

    public void incrementStreak() {
        streak++;
        if (streak >= 0)
            System.out.println("Secret Ending!");
    }

    public int getCoins() {
        return coins;
    }

    public String getPetName() { return pet.getName(); }

    public String getPetType() { return pet.getType(); }
}
