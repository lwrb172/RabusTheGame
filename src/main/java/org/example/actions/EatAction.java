package org.example.actions;

import org.example.gameManagment.InputValidator;
import org.example.gameManagment.Item;
import org.example.entities.Player;
import org.example.gameManagment.TimeManager;
import org.example.gameManagment.UserInterface;

import java.util.List;
import java.util.Scanner;

public class EatAction implements Action {
    @Override
    public void execute(Player player, TimeManager time) {
        List<Item> foods = printFoods(player);

        if (!foods.isEmpty()) {
            String chosenFood = String.valueOf(InputValidator.getIntInput("", 1, player.getInventory().toArray().length));

            Item food = foods.get(Integer.parseInt(chosenFood) - 1);
            player.setHunger(Math.min(player.getHunger() + food.getEffectValue(), 100));
            UserInterface.clearScreen();
            System.out.println("You have eaten and regenerated " + food.getEffectValue() + " hunger.");
            UserInterface.threadSleep(2000);
            player.getInventory().remove(food);
        }
        player.setShouldNotUpdate();
    }

    private List<Item> printFoods(Player player) {
        if (player.getInventory().toArray().length > 0) {
            UserInterface.clearScreen();
            System.out.println("Choose what to eat:");
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
        } else {
            List<Item> foods = player.getInventory();
            UserInterface.clearScreen();
            System.out.println("You have nothing to eat! Better buy something.");
            UserInterface.threadSleep(2000);
            return foods;
        }
    }

    @Override
    public String getName() {
        return "Eat";
    }

    @Override
    public String getDescription() {
        return "Choose what food to eat from your inventory.";
    }
}
