package org.example;

import java.util.*;

public class Player {
    private String name;
    private int hunger;
    private int energy;
    private int happiness;
    private int coins;
    private Random rand;
    private Pet pet;
    private String currentJob;
    private List<Item> inventory;
    private Map<String, Integer> relationships;
    private int streak = 0;

    public Player(String name) {
        this.name = name;
//      this.pet = pet;
        this.hunger = 100;
        this.energy = 100;
        this.happiness = 70;
        this.coins = 50;
        this.rand = new Random();
        this.currentJob = "Jobless";
        this.inventory = new ArrayList<>();
        inventory.add(new Item("Apple", "", 10, "food", 30));
        inventory.add(new Item("Banana", "", 12, "food", 35));
        this.relationships = new HashMap<>();
    }

    public void update() {
        hunger = Math.max(hunger-5, 0);
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

//    public String getInventoryStatus() {
//        if (inventory.isEmpty()) {
//            return "\nYour inventory is empty!";
//        }
//        return "\nInventory:\n" + String.join(", ", inventory);
//    }

    public void adoptPet(Pet pet) {
        this.pet = pet;
        happiness = Math.min(happiness+10, 100);
        System.out.println("You adopted a " + pet.getType() + "!");
    }

    public void feedPet(Pet pet) {
        if (pet != null) {
            happiness = Math.min(happiness+2, 100);
            System.out.println("You fed " + pet.getName() + "!");
        }
    }

    public void eat(Item food) {
        if (food.getType().equals("food")) {
            hunger = Math.min(hunger+food.getEffectValue(), 100);
            System.out.println("You have eaten and regenerated " + food.getEffectValue() + " hunger.");
            inventory.remove(food);
        } else {
            System.out.println("You can't eat this!");
        }
    }

    public void sleep(int hours) {
        energy = Math.min(energy+hours*10, 100);
        happiness = Math.min(happiness+hours, 100);
        hunger = Math.max(hunger-hours*5, 0);
        System.out.println("You slept for " + hours + ".");
    }

    public void work() {
        energy = Math.max(energy-20, 0);
        hunger = Math.max(hunger-20, 0);
        coins += 100;
        if (rand.nextInt(100) < 50) {
            System.out.println("You had a good day at work and earned additional 20 coins!");
            coins += 20;
            happiness = Math.min(happiness+10, 0);
        } else {
            System.out.println("You had a bad day at work and lost additional 20 energy!");
            energy = Math.max(energy-20, 0);
            happiness = Math.max(happiness-10, 0);
        }
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

    public List<Item> getInventory() {
        return inventory;
    }
}
