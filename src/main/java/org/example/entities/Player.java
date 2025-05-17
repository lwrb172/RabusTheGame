package org.example.entities;

import org.example.frames.Color;
import org.example.gameManagment.Item;
import org.example.gameManagment.ScoreAndCoins;
import org.example.gameManagment.UserInterface;
import org.example.gameManagment.job.Job;

import java.util.*;

public class Player {
    private final String name;
    private final String color;
    private int hunger;
    private int energy;
    private int hygiene;
    private Pet pet;
    private final Job job;
    private final List<Item> inventory;
    private int streak;
    private final ScoreAndCoins scoreAndCoins;
    private boolean gameOver;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.hunger = 100;
        this.energy = 100;
        this.hygiene = 100;
        this.streak = 0;
        this.gameOver = false;
        this.scoreAndCoins = new ScoreAndCoins();
        this.job = new Job(getName(), getScoreAndCoins());
        this.inventory = new ArrayList<>();
        inventory.add(new Item("Apple", "", 10, "food", 15));
        inventory.add(new Item("Banana", "", 12, "food", 17));
    }

    public Player(String name, String color, Pet pet) {
        this.name = name;
        this.color = color;
        this.pet = pet;
        this.hunger = 100;
        this.energy = 100;
        this.hygiene = 100;
        this.job = new Job(getName(), getScoreAndCoins());
        this.scoreAndCoins = new ScoreAndCoins();
        this.inventory = new ArrayList<>();
        inventory.add(new Item("Apple", "", 10, "food", 30));
        inventory.add(new Item("Banana", "", 12, "food", 35));
    }

    public void update() {
        hunger = Math.max(hunger-10, 0);
        energy = Math.max(energy-15, 0);
        if (hunger < 20) {
            energy = Math.max(energy-2, 0);
            System.out.println("You're hungry!");
        }
        if (energy < 20) {
            System.out.println("Your energy is low!");
        }
        if (hunger == 0) {
            UserInterface.clearScreen();
            System.out.println("You died from starvation!");
            gameOver = true;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        if (energy == 0) {
            UserInterface.clearScreen();
            System.out.println("You're completely exhausted!");
            gameOver = true;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String getStatus() {
        return String.format(
                "%s\n" + Color.RED + "Hunger:" + Color.RESET + " %d/100 | " + Color.GREEN + "Energy:" + Color.RESET + " %d/100 | " + Color.BLUE + "Hygiene:" + Color.RESET + " %d/100\n" + Color.PURPLE + "Score: %d\n" + Color.RESET + Color.YELLOW + "Coins: %d" + Color.RESET,
                name,
                hunger,
                energy,
                hygiene,
                scoreAndCoins.getPlayerScore(),
                scoreAndCoins.getPlayerCoins()
        );
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

//    public void sleep(int hours) {
//        energy = Math.min(energy+hours*10, 100);
//        hunger = Math.max(hunger-hours*5, 0);
//        System.out.println("You slept for " + hours + ".");
//    }

    public void loseCoins(int amount) {
        this.scoreAndCoins.decreasePlayerCoins(amount);
    }

    public void addCoins(int amount) {
        this.scoreAndCoins.addPlayerCoins(amount);
    }

    public void incrementRabusStreak() {
        streak++;
        if (streak >= 0)
            System.out.println("Secret Ending!");
    }

    public int getCoins() {
        return this.scoreAndCoins.getPlayerCoins();
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public String getPetName() { return pet.getName(); }

    public String getPetType() { return pet.getType(); }

    public String getName() { return name; }

    public Job getJob() { return job; }

    public String getColor() { return color; }

    public int getHunger() {
        return hunger;
    }

    public int getEnergy() {
        return energy;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Object getPet() {
        return null;
    }

    public ScoreAndCoins getScoreAndCoins() { return scoreAndCoins; }

    public boolean getGameOver() { return gameOver; }
}
