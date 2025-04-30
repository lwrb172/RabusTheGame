package org.example.actions;

import org.example.Player;
import org.example.TimeManager;

import java.util.Random;

public class WorkAction implements Action {
    private final Random rand = new Random();
    @Override
    public void execute(Player player, TimeManager time) {
        System.out.println("You went to work for 8 hours and earned 100 coins.");

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

        time.setHour(time.getHour() + 8);
    }

    @Override
    public String getName() {
        return "Work";
    }

    @Override
    public String getDescription() {
        return "go to work to earn coins.";
    }
}
