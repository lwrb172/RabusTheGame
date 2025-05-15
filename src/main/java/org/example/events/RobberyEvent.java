package org.example.events;

import org.example.entities.Player;
import org.example.frames.Frame;
import org.example.gameManagment.InputValidator;
import org.example.gameManagment.TimeManager;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RobberyEvent extends Event {
    Random rand = new Random();

    public RobberyEvent() {
        this.name = "Rabuś!";
        this.description = "Rabuś tries to steal your money!";
    }

    @Override
    public boolean timeTrigger(TimeManager time) {
        return rand.nextInt(100) < 0;
    }

    @Override
    public void trigger(Player player) {
        System.out.println("Hands up, this is a robbery! Call it right and I might let you go...");
        Set<String> coinSides = new HashSet<>(Set.of("heads", "tails"));
        Frame.printCoinFlip(InputValidator.getStringInput("Enter coin side: ", coinSides));
    }
}
