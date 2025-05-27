package org.example.actions;

import org.example.gameManagement.InputValidator;
import org.example.gameManagement.Item;
import org.example.entities.Player;
import org.example.gameManagement.TimeManager;
import org.example.gameManagement.UserInterface;

import java.util.List;

public class BuyFoodAction implements Action {
    private final List<Item> foods;

    public BuyFoodAction() {
        foods = List.of(
                new Item("Apple", "A crunchy, sweet fruit. Restores 10 hunger.", 50, "food", 10),
                new Item("Banana", "A soft, energy-rich fruit. Restores 12 hunger.", 60, "food", 12),
                new Item("Bread", "A basic staple food. Restores 15 hunger.", 80, "food", 15),
                new Item("Cheese", "A dairy product. Restores 8 hunger.", 30, "food", 8),
                new Item("Cooked Chicken", "Grilled poultry. Restores 25 hunger.", 200, "food", 25),
                new Item("Steak", "Juicy beef. Restores 30 hunger.", 250, "food", 30),
                new Item("Fish", "Freshly caught. Restores 20 hunger.", 180, "food", 20)
        );
    }

    @Override
    public void execute(Player player, TimeManager time) {
        for (int i = 0; i < foods.size(); i++) {
            Item item = foods.get(i);
            System.out.println(
                    (i+1) + ". " + item.getName()
                            + " (" + item.getDescription() + ") - "
                            + item.getPrice()
                            + " coins."
            );
        }
        int choice = InputValidator.getIntInput("Choose whatever you want: ", 1, foods.size());
        if (player.getScoreAndCoins().getPlayerCoins() >= foods.get(choice - 1).getPrice()) {
            player.getScoreAndCoins().decreasePlayerCoins(foods.get(choice - 1).getPrice());
            player.getInventory().add(foods.get(choice - 1));
            player.setShouldNotUpdate();
            UserInterface.clearScreen();
            System.out.println("You bought: " + foods.get(choice - 1).getName() + '.');
            UserInterface.threadSleep(2000);
        } else {
            UserInterface.clearScreen();
            System.out.println("You're too broke for that mate, go earn some money first!");
            UserInterface.threadSleep(3000);
            player.setShouldNotUpdate();
        }
    }

    @Override
    public String getName() {
        return "Buy food";
    }

    @Override
    public String getDescription() {
        return "Look what foods shop offers you.";
    }
}
