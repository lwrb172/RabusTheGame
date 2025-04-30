package org.example.actions;

import org.example.Item;
import org.example.Player;
import org.example.TimeManager;

import java.util.List;
import java.util.Scanner;

public class EatAction implements Action {
    @Override
    public void execute(Player player, TimeManager time) {
        List<Item> foods = printFoods(player);

        Scanner scanner = new Scanner(System.in);
        String chosenFood = scanner.nextLine();

        Item food = foods.get(Integer.parseInt(chosenFood));
        player.setHunger(Math.min(player.getHunger()+food.getEffectValue(), 100));
        System.out.println("You have eaten and regenerated " + food.getEffectValue() + " hunger.");

        player.getInventory().remove(food);
    }

    private List<Item> printFoods(Player player) {
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

    @Override
    public String getName() {
        return "Eat";
    }

    @Override
    public String getDescription() {
        return "choose food to eat from your inventory.";
    }
}
