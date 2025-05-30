package org.example.entities;

import org.example.entities.pet.Pet;
import org.example.entities.pet.PetType;
import org.example.frames.Color;
import org.example.gameManagement.Item;
import org.example.gameManagement.ScoreAndCoins;
import org.example.gameManagement.UserInterface;
import org.example.gameManagement.job.Job;

import java.util.*;

public class Player {
    private final String name;
    private final String color;
    private int hunger;
    private int energy;
    private int hygiene;
    private final ScoreAndCoins scoreAndCoins;
    private final Pet pet;
    private final Job job;
    private final List<Item> inventory;
    private boolean gameOver;
    private boolean shouldNotUpdate;
    private boolean godMode;

    public Player(String name, String color, Pet pet, ScoreAndCoins scoreAndCoins) {
        this.name = name;
        this.color = color;
        this.pet = pet;
        this.hunger = 100;
        this.energy = 100;
        this.hygiene = 100;
        this.scoreAndCoins = scoreAndCoins;
        this.job = new Job(getName(), getScoreAndCoins());
        this.inventory = new ArrayList<>();
        this.shouldNotUpdate = true;
        this.godMode = false;
        inventory.add(new Item("Apple", "", 0, "food", 10));
        inventory.add(new Item("Banana", "", 0, "food", 12));
    }

    public void update() {
        if (!godMode) {
            if (!shouldNotUpdate) {
                decreaseStats(3,1,2);
            }
        }
        shouldNotUpdate = false;
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

    public void loseCoins(int amount) {
        this.scoreAndCoins.decreasePlayerCoins(amount);
    }

    public void addCoins(int amount) {
        this.scoreAndCoins.addPlayerCoins(amount);
    }

    public void death(String prompt) {
        UserInterface.clearScreen();
        System.out.println(prompt);
        gameOver = true;
        UserInterface.threadSleep(3000);
    }

    public int getCoins() {
        return this.scoreAndCoins.getPlayerCoins();
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public Pet getPet() { return pet; }

    public String getPetName() { return pet.getName(); }

    public PetType getPetType() { return pet.getType(); }

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

    public void setHygiene(int hygiene) {
        this.hygiene = hygiene;
    }

    public ScoreAndCoins getScoreAndCoins() { return scoreAndCoins; }

    public boolean getGameOver() { return gameOver; }

    public void setShouldNotUpdate() { this.shouldNotUpdate = true; }

    public void decreaseStats(int hungerPoints, int energyPoints, int hygienePoints) {
        hunger = Math.max(hunger - hungerPoints, 0);
        energy = Math.max(energy - energyPoints, 0);
        hygiene = Math.max(hygiene - hygienePoints, 0);
        if (hunger <= 20) {
            UserInterface.clearScreen();
            System.out.println("You're hungry!");
            UserInterface.threadSleep(2000);
        }
        if (energy <= 25) {
            UserInterface.clearScreen();
            System.out.println("You're are getting very tired!");
            UserInterface.threadSleep(2000);
        }
        if (hygiene <= 25) {
            UserInterface.clearScreen();
            System.out.println("You're starting to smell really bad!");
            UserInterface.threadSleep(2000);
        }
        if (hunger == 0) {
            death("You forgot to eat. Now you're dead.");
        }
        if (energy == 0) {
            death("Your body gave up... You died from exhaustion!");
        }
        if (hygiene == 0) {
            death("Your terrible smell drove everyone away... including life itself!");
        }
    }

    public void decreaseStatsNoComment(int hungerPoints, int energyPoints, int hygienePoints) {
        hunger = Math.max(hunger - hungerPoints, 0);
        energy = Math.max(energy - energyPoints, 0);
        hygiene = Math.max(hygiene - hygienePoints, 0);
    }

    public void enableGodMode() { this.godMode = true; }

    public boolean getGodMode() { return godMode; }

    public void addScore(int amount) { scoreAndCoins.addPlayerScore(amount); }

    public void decreaseCoins(int amount) { scoreAndCoins.decreasePlayerCoins(amount); }
}
