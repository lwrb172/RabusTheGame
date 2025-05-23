package org.example.actions;

import org.example.entities.Player;
import org.example.frames.Frame;
import org.example.gameManagement.InputValidator;
import org.example.gameManagement.Item;
import org.example.gameManagement.TimeManager;
import org.example.gameManagement.UserInterface;

import java.util.List;

public class BuyFurnitureAction implements Action{
    private final List<Item> furnitures;
    private final Frame frame;

    public BuyFurnitureAction(Frame frame) {
        furnitures = List.of(
                new Item("tv", "big ass tv", 1750, "furniture", 0, "main room"),
                new Item("dresser", "you can store things there (not implemented in game)", 750, "furniture", 0, "main room"),
                new Item("sofa", "sofa", 1500, "furniture", 0, "main room"),
                new Item("shower", "shower", 1500, "furniture", 0, "bathroom"),
                new Item("bath", "bath", 1750, "furniture", 0, "bathroom"),
                new Item("table", "table", 750, "furniture", 0, "kitchen"),
                new Item("oven", "oven", 1500, "furniture", 0, "kitchen")
        );
        this.frame = frame;
    }

    @Override
    public void execute(Player player, TimeManager time) {
        for (int i = 0; i < furnitures.size(); i++) {
            Item item = furnitures.get(i);
            System.out.println(
                    (i+1) + ". " + item.getName()
                            + " (" + item.getDescription() + ") - "
                            + item.getPrice()
                            + " coins."
            );
        }
        int choice = InputValidator.getIntInput("Choose whatever you want: ", 1, furnitures.size());
        if (player.getScoreAndCoins().getPlayerCoins() >= furnitures.get(choice - 1).getPrice()) {
            player.getScoreAndCoins().decreasePlayerCoins(furnitures.get(choice - 1).getPrice());
            switch (furnitures.get(choice - 1).getPlace()) {
                case "main room":
                    frame.setItemMainRoom(furnitures.get(choice - 1));
                    break;
                case "kitchen":
                    frame.setItemKitchen(furnitures.get(choice - 1));
                    break;
                case "bathroom":
                    frame.setItemBathroom(furnitures.get(choice - 1));
                    break;
                default:
                    break;
            }
            player.setShouldNotUpdate();
            UserInterface.clearScreen();
            System.out.println("You bought: " + furnitures.get(choice - 1).getName() + '.');
            UserInterface.threadSleep(3000);
        } else {
            UserInterface.clearScreen();
            System.out.println("You're too broke for that mate, go earn some money first!");
            UserInterface.threadSleep(3000);
            player.setShouldNotUpdate();
        }
    }

    @Override
    public String getName() {
        return "Buy furnitures";
    }

    @Override
    public String getDescription() {
        return "Wide variety of furnitures.";
    }
}
