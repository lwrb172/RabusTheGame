package org.example.gameManagment;

import org.example.frames.Color;

import java.util.Random;

public class ScoreAndCoins {
    private int playerScore;
    private int playerCoins;
    private int playerRabusStreak;
    Random random = new Random();

    public ScoreAndCoins() {
        this.playerScore = 10;
        this.playerCoins = 10;
        this.playerRabusStreak = 0;
    }

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
            x = 10000;
            y = random.nextInt(200, 300);
        } else if (mistakes <= 8) {
            x = 5000;
            y = random.nextInt(100, 200);
        } else if (mistakes <= 12) {
            x = 1000;
            y = random.nextInt(50, 100);
        } else {
            x = 500;
            y = random.nextInt(10, 50);
        }
        UserInterface.clearScreen();
        this.playerScore += x;
        this.playerCoins += y;
        System.out.println("You got " + Color.CYAN + x + Color.RESET + " points!\nYou got " + Color.YELLOW + y + Color.RESET + " coins!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addScoreCoinsTicTacToe(int whoWon, int compScore) {
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
        UserInterface.clearScreen();
        this.playerScore += x;
        this.playerCoins += y;
        System.out.println("You got " + Color.CYAN + x + Color.RESET + " points!\nYou got " + Color.YELLOW + y + Color.RESET + " coins!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addScoreCoinsFastTyping(int tries, int time) { //todo debug
        int x = 0;
        int y = 0;
        switch (tries) {
            case 3:
                if (time <= 20) {
                    x = 10000;
                    y = random.nextInt(250, 300);
                } else {
                    x = 7500;
                    y = random.nextInt(200, 250);
                }
                break;
            case 2:
                if (time <= 20) {
                    x = 7500;
                    y = random.nextInt(200, 250);
                } else {
                    x = 5000;
                    y = random.nextInt(150, 200);
                }
                break;
            case 1:
                if (time <= 20) {
                    x = 5000;
                    y = random.nextInt(150, 200);
                } else {
                    x = 1000;
                    y = random.nextInt(100, 150);
                }
                break;
        }
        UserInterface.clearScreen();
        this.playerScore = x;
        this.playerCoins += y;
        System.out.println("You got " + Color.CYAN + x + Color.RESET + " points!\nYou got " + Color.YELLOW + y + Color.RESET + " coins!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addRabusStreak() { playerRabusStreak++; }

    public int getPlayerCoins() { return playerCoins; }

    public int getPlayerScore() { return playerScore; }

    public void addPlayerCoins(int amount) { playerCoins += amount; }

    public void decreasePlayerCoins(int amount) { playerCoins -= amount; }

    public void addPlayerScore(int amount) { playerScore += amount; }
}
