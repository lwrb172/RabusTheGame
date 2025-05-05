package org.example.events;

import org.example.entities.Player;
import org.example.gameManagment.TimeManager;

import java.util.Random;

public class RobberyEvent extends Event {
    private Random rand = new Random();

    public RobberyEvent() {
        this.name = "Rabuś!";
        this.description = "Rabuś tries to steal your money!";
    }

    @Override
    public boolean timeTrigger(TimeManager time) {
        return rand.nextInt(100) < 30;
    }

    @Override
    public void trigger(Player player) {
        System.out.println("Wild Rabuś appears! Let's flip a coin (heads - win, tails - you lose half your money");
        boolean win = rand.nextBoolean();

        if (win) {
            System.out.println("You won! Rabuś is running away");
            player.incrementStreak();
        } else {
            int lost = player.getCoins();
            player.loseCoins(lost);
            System.out.println("You lost " + lost + " coins");
        }
    }
}
