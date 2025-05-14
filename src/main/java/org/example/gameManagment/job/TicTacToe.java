package org.example.gameManagment.job;

import org.example.gameManagment.InputValidator;
import org.example.gameManagment.ScoreAndCoins;

import java.util.Arrays;
import java.util.Random;

public class TicTacToe {
    private final int[] gameScores = new int[3]; // player, comp, draw
    private final int[] board = new int[9];
    Random random = new Random();
    ScoreAndCoins score = new ScoreAndCoins();

    public void startTTT() {
        while (true) {
            compMove();
            printBoard();
            playerMove();
            analyzeGame();
            for (int i = 0; i < 3; i++) {
                if (gameScores[i] == 3) {
                    score.addScoreCoinsTTT(i, gameScores[1]);
                    break;
                }
            }
        }
    }

    private void printBoard() {
        System.out.println("\n-------------");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("\n-------------");
            }

            System.out.print("| ");
            switch (board[i]) {
                case 1 -> System.out.print("X ");
                case -1 -> System.out.print("O ");
                default -> System.out.print("  ");
            }
        }
        System.out.println("|\n-------------");
    }

    private void analyzeGame() {
        checkPlayer();
        checkComp();
        checkDraw();
    }

    private void compMove() {
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

    private void checkPlayer() {
        // horizontal
        if (board[0] == 1 && board[1] == 1 && board[2] == 1) {
            gameScores[0]++;
            Arrays.fill(board, 0);
            return;
        } else if (board[3] == 1 && board[4] == 1 && board[5] == 1) {
            gameScores[0]++;
            Arrays.fill(board, 0);
            return;
        } else if (board[6] == 1 && board[7] == 1 && board[8] == 1) {
            gameScores[0]++;
            Arrays.fill(board, 0);
            return;
        }

        // vertical
        if (board[0] == 1 && board[3] == 1 && board[6] == 1) {
            gameScores[0]++;
            Arrays.fill(board, 0);
            return;
        } else if (board[1] == 1 && board[4] == 1 && board[7] == 1) {
            gameScores[0]++;
            Arrays.fill(board, 0);
            return;
        } else if (board[2] == 1 && board[5] == 1 && board[8] == 1) {
            gameScores[0]++;
            Arrays.fill(board, 0);
            return;
        }

        // cross
        if (board[0] == 1 && board[4] == 1 && board[8] == 1) {
            gameScores[0]++;
            Arrays.fill(board, 0);
            return;
        } else if (board[2] == 1 && board[4] == 1 && board[6] == 1) {
            gameScores[0]++;
            Arrays.fill(board, 0);
            return;
        }
    }

    private void checkComp() {
        // horizontal
        if (board[0] == 1 && board[1] == 1 && board[2] == 1) {
            gameScores[1]++;
            Arrays.fill(board, 0);
            return;
        } else if (board[3] == 1 && board[4] == 1 && board[5] == 1) {
            gameScores[1]++;
            Arrays.fill(board, 0);
            return;
        } else if (board[6] == 1 && board[7] == 1 && board[8] == 1) {
            gameScores[1]++;
            Arrays.fill(board, 0);
            return;
        }

        // vertical
        if (board[0] == 1 && board[3] == 1 && board[6] == 1) {
            gameScores[1]++;
            Arrays.fill(board, 0);
            return;
        } else if (board[1] == 1 && board[4] == 1 && board[7] == 1) {
            gameScores[1]++;
            Arrays.fill(board, 0);
            return;
        } else if (board[2] == 1 && board[5] == 1 && board[8] == 1) {
            gameScores[1]++;
            Arrays.fill(board, 0);
            return;
        }

        // cross
        if (board[0] == 1 && board[4] == 1 && board[8] == 1) {
            gameScores[1]++;
            Arrays.fill(board, 0);
            return;
        } else if (board[2] == 1 && board[4] == 1 && board[6] == 1) {
            gameScores[1]++;
            Arrays.fill(board, 0);
            return;
        }
    }

    private void checkDraw() {
        int occupied = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] != 0) occupied++;
        }
        if (occupied == 9) {
            gameScores[2]++;
            Arrays.fill(board, 0);
        }
    }

}
