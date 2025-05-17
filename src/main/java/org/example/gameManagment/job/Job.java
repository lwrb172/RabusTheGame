package org.example.gameManagment.job;

import org.example.entities.Player;
import org.example.gameManagment.InputValidator;
import org.example.gameManagment.ScoreAndCoins;
import org.example.gameManagment.UserInterface;

public class Job {
    private String jobName;
    private final String playerName;
    private final ScoreAndCoins playerScoreCoins;

    public Job(String playerName, ScoreAndCoins playerScoreCoins) {
        this.playerName = playerName;
        this.playerScoreCoins = playerScoreCoins;
        this.jobName = "jobless";
    }

    public void chooseJob() {
        UserInterface.clearScreen();
        int jobChoice = InputValidator.getIntInput("What job do you wanna take? \n" +
                "1. glovo (snake)\n" +
                "2. collecting strawberries in Germany (tic-tac-toe)\n" +
                "3. become parliamentary representative (typing game)\n",
                1, 3
        );
        switch (jobChoice) {
            case 1:
                this.jobName = "glovo";
                break;
            case 2:
                this.jobName = "strawberry man";
                break;
            case 3:
                this.jobName = "parliamentary representative";
                break;
        }
    }

    public void startJob(String job) {
        switch (job) {
            case "glovo":
                new Memory(playerScoreCoins).start();
                break;
            case "strawberry man":
                new TicTacToe(playerName, playerScoreCoins).start();
                break;
            case "parliamentary representative":
                new FastTyping(playerScoreCoins).start();
                break;
            default:
                UserInterface.clearScreen();
                System.out.println("Choose your job first!\n");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
        }
    }

    public String getJobName() { return jobName; }
}
