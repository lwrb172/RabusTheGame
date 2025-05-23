package org.example.events;

import org.example.entities.Player;
import org.example.frames.Color;
import org.example.frames.Frame;
import org.example.gameManagement.InputValidator;
import org.example.gameManagement.TimeManager;
import org.example.gameManagement.UserInterface;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RobberyEvent implements Event {
    Random rand = new Random();
    private final Frame frame;

    public RobberyEvent(Frame frame) {
        this.frame = frame;
    }

    @Override
    public boolean timeTrigger(TimeManager time) {
        if (time.getHour() >= 22 || (time.getHour() >= 0 && time.getHour() <= 6)) {
            return rand.nextInt(100) < 30;
        }
        return false;
    }

    @Override
    public void trigger(Player player) {
            UserInterface.clearScreen();
            frame.setRabus();
            frame.printMainRoom();
            frame.setNoRabus();
            System.out.println("Hands up, this is a robbery! Call it right and I might let you go...");
            Set<String> coinSides = new HashSet<>(Set.of("heads", "tails"));
            String choice = InputValidator.getStringInput("Enter coin side: ", coinSides);
            String result = printCoinFlip(frame);

            if (result.toLowerCase().equals(choice)) {
                UserInterface.clearScreen();
                System.out.print("I'm letting you go... this time.\nYou got " + Color.CYAN + "10000" + Color.RESET + " points!");
                UserInterface.threadSleep(3000);
                player.addScore(10000);
            } else {
                UserInterface.clearScreen();
                System.out.print("Too bad, you lost ;)");
                UserInterface.threadSleep(3000);
                if (rand.nextInt(100) < 20) {
                    player.death("Rabuś killed you!");
                } else {
                    int x = rand.nextInt(100, 500);
                    UserInterface.clearScreen();
                    System.out.println("You lost " + Color.YELLOW + x + Color.RESET + " coins.");
                    player.decreaseCoins(x);
                    UserInterface.threadSleep(3000);
                }
        }
    }

    public String printCoinFlip(Frame frame) {
        String[] sides = {"HEADS", "TAILS"};
        Random rand = new Random();

        UserInterface.clearScreen();
        System.out.print("I'm throwing coin...");
        UserInterface.threadSleep(3000);

        String result = "";
        int i = 0;
        for (String coin : frame.getCoinFrames()) {
            UserInterface.clearScreen();
            System.out.println(coin);
            String side = sides[rand.nextInt(2)];
            System.out.print("\r" + "Result: " + side);
            result = side;
            i++;
            UserInterface.threadSleep(1500);
        }
        System.out.print("\r" + "Result: " + result + "       \n");
        return result;
    }

    public String getName() {
        return "Rabus";
    }

    public String getDescription() {
        return "Rabuś tries to steal your money!";
    }
}
