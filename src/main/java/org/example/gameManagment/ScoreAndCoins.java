package org.example.gameManagment;

import org.example.frames.Color;

import java.util.Random;

public class ScoreAndCoins {
    private double playerScore = 0;
    private int playerCoins = 0;
    private int playerRabusStreak = 0;
    Random random = new Random();

    public void printScore() {
        System.out.println(playerScore);
    }

    public void printCoins() {
        System.out.println(playerCoins);
    }

    public void addScoreCoinsMemory(int mistakes) {
        int x;
        int y;
        if (mistakes <= 5) {
            x = 3000;
            y = random.nextInt(200, 300);
        } else if (mistakes <= 8) {
            x = 1000;
            y = random.nextInt(100, 200);
        } else if (mistakes <= 12) {
            x = 500;
            y = random.nextInt(50, 100);
        } else {
            x = 100;
            y = random.nextInt(10, 50);
        }
        playerScore += x;
        playerCoins += y;
        System.out.println("You got " + x + " points!\nYou got " + Color.YELLOW + y + Color.RESET + " coins!");
    }

    public void addScoreCoinsTTT(int whoWon, int compScore) {
        int x;
        int y;
        switch (whoWon) {
            case 0: // player
                if (compScore == 0) {
                    x = 10000;
                    y = random.nextInt(400, 500);
                } else if (compScore == 1) {
                    x = 7500;
                    y = random.nextInt(300, 400);
                } else {
                    x = 5000;
                    y = random.nextInt(200, 300);
                }
                break;
            case 1: // comp
                x = 1000;
                y = random.nextInt(50, 100);
                break;
            default:
                x = 3000;
                y = random.nextInt(100, 200);
                break;
        }
        playerScore += x;
        playerCoins += y;
        System.out.println("You got " + x + " points!\nYou got " + Color.YELLOW + y + Color.RESET + " coins!");
    }

    public void addRabusStreak() { playerRabusStreak++; }
}
