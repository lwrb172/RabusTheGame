package org.example;

import java.util.List;
import java.util.Random;

public class Action {
    private String name;
    private String description;
    private static Random rand = new Random();

    public Action(String name, String description) {
        this.name = name;
        this.description = description;
        rand = new Random();
    }


    public static void eat(Player player, Item food) {
        player.setHunger(Math.min(player.getHunger()+food.getEffectValue(), 100));
        System.out.println("You have eaten and regenerated " + food.getEffectValue() + " hunger.");
        player.getInventory().remove(food);
    }

    public static List<Item> printFoods(Player player) {
        System.out.println("Chose item number to eat:");
        List<Item> foods = player.getInventory();
        int i = 1;
        for (Item food : foods) {
            if (food.getType().equals("food")) {
                System.out.print(i++ + "." + food.getName() + ' ');
            } else {
                foods.remove(food);
            }
        }
        System.out.println();
        return foods;
    }

    public static void work(Player player) {
        player.setEnergy(Math.max(player.getEnergy()-20, 0));
        player.setHunger(Math.max(player.getHunger()-20, 0));
        player.addCoins(100);
        if (rand.nextInt(100) < 50) {
            player.addCoins(20);
            System.out.println("You had a good day at work and earned additional 20 coins!");
        } else {
            player.setEnergy(Math.max(player.getEnergy()-20, 0));
            System.out.println("You had a bad day at work and lost additional 20 energy!");
        }
    }

    public static void sleep(Player player, int hours) {
        player.setEnergy(Math.min(player.getEnergy()+hours*10, 100));
        player.setHunger(Math.max(player.getHunger()-hours*5, 0));
        System.out.println("You slept for " + hours + ".");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
