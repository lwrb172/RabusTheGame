package org.example.gameManagement.job;

import org.example.gameManagement.InputValidator;
import org.example.gameManagement.ScoreAndCoins;
import org.example.gameManagement.UserInterface;
import org.example.gameManagement.job.tictactoe.TicTacToe;

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
                "1. Glovo (Memory)\n" +
                "2. Collecting strawberries in Germany (Tic-Tac-Toe)\n" +
                "3. Become parliamentary representative (Typing)\n",
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
                UserInterface.threadSleep(3000);
        }
    }

    public String getJobName() { return jobName; }
}
