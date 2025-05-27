package org.example.actions;

import org.example.entities.Player;
import org.example.gameManagement.TimeManager;
import org.example.gameManagement.UserInterface;

public class WashAction implements Action{
    public void execute(Player player, TimeManager time) {
        player.setHygiene(100);
        UserInterface.clearScreen();
        System.out.println("You washed yourself and now you feel a lot better.");
        UserInterface.threadSleep(2000);
    }

    public String getName() {
        return "Wash yourself";
    }

    public String getDescription() {
        return "It's time to take a hot bath.";
    }
}
