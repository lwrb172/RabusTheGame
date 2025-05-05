package org.example.actions;

import org.example.entities.Player;
import org.example.gameManagment.TimeManager;

import java.util.Scanner;

public class SleepAction implements Action {
    @Override
    public void execute(Player player, TimeManager time) {
        System.out.println("How many hours you want to sleep?");
        Scanner scanner = new Scanner(System.in);
        int hours = scanner.nextInt();

        time.setHour(time.getHour() + hours);
        player.setEnergy(Math.min(player.getEnergy()+hours*10, 100));
        player.setHunger(Math.max(player.getHunger()-hours*5, 0));

        System.out.println("You slept for " + hours + ".");
    }

    @Override
    public String getName() {
        return "Sleep";
    }

    @Override
    public String getDescription() {
        return "go to sleep and get some rest.";
    }
}
