package org.example.actions;

import org.example.entities.Player;
import org.example.gameManagement.InputValidator;
import org.example.gameManagement.TimeManager;
import org.example.gameManagement.UserInterface;

public class SleepAction implements Action {
    @Override
    public void execute(Player player, TimeManager time) {
        int hours = InputValidator.getIntInput("How many hours you want to sleep?: ", 1, 24);

        time.setHour(time.getHour() + hours);
        player.setEnergy(Math.min(player.getEnergy()+hours*15, 100));
        if (!player.getGodMode()){
            player.decreaseStatsNoComment(hours * 2,0,15);
        }

        UserInterface.clearScreen();
        System.out.println("You slept for " + hours + " hours.");
        UserInterface.threadSleep(2000);
    }

    @Override
    public String getName() {
        return "Sleep";
    }

    @Override
    public String getDescription() {
        return "Go to sleep and get some rest.";
    }
}
