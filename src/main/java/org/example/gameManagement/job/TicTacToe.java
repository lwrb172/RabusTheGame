package org.example.gameManagement.job;

import org.example.frames.Color;
import org.example.gameManagement.InputValidator;
import org.example.gameManagement.ScoreAndCoins;
import org.example.gameManagement.UserInterface;

import java.util.Arrays;
import java.util.Random;

public class TicTacToe {
    private final int[] gameScores = new int[3]; // player, comp, draw
    private final int[] board = new int[9];
    private final String playerName;
    private final ScoreAndCoins playerScoreCoins;
    Random random = new Random();

    public TicTacToe(String playerName, ScoreAndCoins playerScoreCoins) {
        this.playerName = playerName;
        this.playerScoreCoins = playerScoreCoins;
    }

    public void start() {
        while (true) {
            compMove();
            if (analyzeGame()) {
                if (checkGameEnd()) break;
                continue;
            }

            printBoard();
            playerMove();
            if (analyzeGame()) {
                if (checkGameEnd()) break;
            }
        }
    }

    private boolean checkGameEnd() {
        for (int i = 0; i < 3; i++) {
            if (gameScores[i] == 3) {
                UserInterface.clearScreen();
                playerScoreCoins.addScoreCoinsTicTacToe(i, gameScores[1]);
                return true;
            }
        }
        return false;
    }

    private void printBoard() {
        UserInterface.clearScreen();
        System.out.println("\n-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                int index = row * 3 + col;
                switch (board[index]) {
                    case 1 -> System.out.print("X | ");
                    case -1 -> System.out.print("O | ");
                    default -> System.out.print("  | ");
                }
            }
            System.out.println("\n-------------");
        }
    }

    private void compMove() {
        for (int i = 0; i < 9; i++) {
            if (board[i] == 0) {
                board[i] = -1;
                if (checkWin(-1)) return;
                board[i] = 0;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i] == 0) {
                board[i] = 1;
                if (checkWin(1)) {
                    board[i] = -1;
                    return;
                }
                board[i] = 0;
            }
        }

        int compChoice;
        do {
            compChoice = random.nextInt(9);
        } while (board[compChoice] != 0);
        board[compChoice] = -1;
    }

    private void playerMove() {
        int playerChoice = InputValidator.getIntInput("\nChoose field: ", 1, 9);;
        while (board[playerChoice - 1] != 0) {
            System.out.println("Field already taken!");
            playerChoice = InputValidator.getIntInput("Choose field: ", 1, 9);;
        }
        board[playerChoice - 1] = 1;
    }

    private boolean checkWin(int player) {
        return (board[0] == player && board[1] == player && board[2] == player) ||
                (board[3] == player && board[4] == player && board[5] == player) ||
                (board[6] == player && board[7] == player && board[8] == player) ||
                (board[0] == player && board[3] == player && board[6] == player) ||
                (board[1] == player && board[4] == player && board[7] == player) ||
                (board[2] == player && board[5] == player && board[8] == player) ||
                (board[0] == player && board[4] == player && board[8] == player) ||
                (board[2] == player && board[4] == player && board[6] == player);
    }

    private boolean analyzeGame() {
        if (checkWin(1)) {
            addClearPrint("player", playerName);
            return true;
        } else if (checkWin(-1)) {
            addClearPrint("comp", playerName);
            return true;
        } else if (isBoardFull()) {
            addClearPrint("draw", playerName);
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i : board) {
            if (i == 0) return false;
        }
        return true;
    }

    private void addClearPrint(String whoWon, String playerName) {
        UserInterface.clearScreen();
        printBoard();
        switch (whoWon) {
            case "player":
                gameScores[0]++;
                System.out.println("You won a round!");
                break;
            case "comp":
                gameScores[1]++;
                System.out.println("Comp has won a round...");
                break;
            case "draw":
                gameScores[2]++;
                System.out.println("It's a draw.");
                break;
        }
        Arrays.fill(board, 0);
        System.out.println("Scores:\n   " + playerName + ": " + Color.GREEN + gameScores[0] +
                Color.RESET + " | Comp: " + Color.RED + gameScores[1] + Color.RESET +" | Draws: "
                + Color.GRAY + gameScores[2] + Color.RESET);
        UserInterface.threadSleep(3000);
    }

}
