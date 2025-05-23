package org.example.gameManagement;

import org.example.frames.Color;

import java.io.*;
import java.util.Random;

public class ScoreAndCoins {
    private int playerScore;
    private int playerCoins;
    Random random;

    public ScoreAndCoins() {
        this.playerScore = 0;
        this.playerCoins = 50;
        this.random = new Random();
    }

    public void addScoreCoinsMemory(int mistakes) {
        int x;
        int y;
        if (mistakes <= 5) {
            x = 100000;
            y = random.nextInt(300, 500);
        } else if (mistakes <= 8) {
            x = 50000;
            y = random.nextInt(150, 300);
        } else if (mistakes <= 12) {
            x = 15000;
            y = random.nextInt(50, 100);
        } else {
            x = 5000;
            y = random.nextInt(10, 50);
        }
        UserInterface.clearScreen();
        this.playerScore += x;
        this.playerCoins += y;
        System.out.println("You got " + Color.CYAN + x + Color.RESET + " points!\nYou got " + Color.YELLOW + y + Color.RESET + " coins!");
        UserInterface.threadSleep(3000);
    }

    public void addScoreCoinsTicTacToe(int whoWon, int compScore) {
        int x;
        int y;
        switch (whoWon) {
            case 0: // player
                if (compScore == 0) {
                    x = 1000000;
                    y = 10000;
                } else if (compScore == 1) {
                    x = 500000;
                    y = 5000;
                } else {
                    x = 100000;
                    y = 1000;
                }
                break;
            case 1: // comp
                x = 1000;
                y = random.nextInt(50, 100);
                break;
            default: // draw
                x = 15000;
                y = random.nextInt(150, 200);
                break;
        }
        UserInterface.clearScreen();
        this.playerScore += x;
        this.playerCoins += y;
        System.out.println("You got " + Color.CYAN + x + Color.RESET + " points!\nYou got " + Color.YELLOW + y + Color.RESET + " coins!");
        UserInterface.threadSleep(3000);
    }

    public void addScoreCoinsFastTyping(int tries, int time) {
        int x = 0;
        int y = 0;
        switch (tries) {
            case 3:
                if (time <= 20) {
                    x = 50000;
                    y = random.nextInt(250, 300);
                } else {
                    x = 30000;
                    y = random.nextInt(200, 250);
                }
                break;
            case 2:
                if (time <= 20) {
                    x = 30000;
                    y = random.nextInt(200, 250);
                } else {
                    x = 15000;
                    y = random.nextInt(150, 200);
                }
                break;
            case 1:
                if (time <= 20) {
                    x = 10000;
                    y = random.nextInt(150, 200);
                } else {
                    x = 5000;
                    y = random.nextInt(100, 150);
                }
                break;
        }
        UserInterface.clearScreen();
        this.playerScore += x;
        this.playerCoins += y;
        System.out.println("You got " + Color.CYAN + x + Color.RESET + " points!\nYou got " + Color.YELLOW + y + Color.RESET + " coins!");
        UserInterface.threadSleep(3000);
    }

    public void printScores() {
        try (BufferedReader reader = new BufferedReader(new FileReader("scores.txt"))) {
            String line;
            UserInterface.clearScreen();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error printScores(): " + e.getMessage());
        }
    }

    public void saveScore(String playerName, int days) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt"))) {
            writer.write("Name: " + playerName + ", Score: " + playerScore + ", Days survived: " + days);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saveScore(): " + e.getMessage());
        }
    }

    public int getPlayerCoins() { return playerCoins; }

    public int getPlayerScore() { return playerScore; }

    public void addPlayerCoins(int amount) { playerCoins += amount; }

    public void decreasePlayerCoins(int amount) { playerCoins = Math.max(playerCoins - amount, 0); }

    public void addPlayerScore(int amount) { playerScore += amount; }
}
