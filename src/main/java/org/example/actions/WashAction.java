package org.example.actions;

import org.example.entities.Player;
import org.example.gameManagment.TimeManager;
import org.example.gameManagment.UserInterface;

public class WashAction implements Action{
    public void execute(Player player, TimeManager time) {
        player.decreaseStats(20,10,0);

        player.setEnergy(Math.min(player.getEnergy()+hours*15, 100));
        if (!player.getGodMode()){
            player.setHunger(Math.max(player.getHunger() - hours * 2, 0));
        }

        UserInterface.clearScreen();
        System.out.println("You slept for " + hours + " hours.");
        UserInterface.threadSleep(2000);
    }

    public String getName() {
        return "";
    }

    public String getDescription() {
        return "";
    }
}
