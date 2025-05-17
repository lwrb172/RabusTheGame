package org.example.actions;

import org.example.gameManagment.Item;
import org.example.entities.Player;
import org.example.gameManagment.TimeManager;

import java.util.List;
import java.util.Scanner;

public class BuyAction implements Action {
    private final List<Item> foods;

    public BuyAction() {
        foods = List.of(
                new Item("Apple", "big red and green apples.", 10, "food", 15),
                new Item("Banana", "these bananas are very ripe.", 12, "food", 17),
                new Item("Meat", "cooked meat, rich in protein", 25, "food", 40),
                new Item("Bread", "a loaf of fresh bread", 15, "food", 20)
        );
    }

    @Override
    public void execute(Player player, TimeManager time) {
        System.out.println("Choose a number from the following offer:");
        for (int i = 0; i < foods.size(); i++) {
            Item item = foods.get(i);
            System.out.println(
                    (i+1) + ". " + item.getName()
                            + " (" + item.getDescription() + ") - "
                            + item.getPrice()
                            + " coins."
            );
        }
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt()-1;
            player.getInventory().add(foods.get(choice));
            System.out.println("You bought: '" + foods.get(choice).getName() + "' and it is now in your inventory.");
        } else {
            System.out.println("Invalid choice. You left the shop.");
        }
    }

    @Override
    public String getName() {
        return "Buy food";
    }

    @Override
    public String getDescription() {
        return "Look what shop offers you.";
    }
}
