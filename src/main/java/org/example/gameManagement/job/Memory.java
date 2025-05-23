package org.example.gameManagement.job;

import org.example.frames.Color;
import org.example.frames.Frame;
import org.example.gameManagement.InputValidator;
import org.example.gameManagement.ScoreAndCoins;
import org.example.gameManagement.UserInterface;

import java.util.Arrays;
import java.util.Random;


public class Memory {
    private final int[] cards = new int[12];
    private final boolean[] revealedStatus = new boolean[12];
    private int gameScore = 0;
    private int mistakes = 0;
    private final Frame frame = new Frame();
    private final ScoreAndCoins playerScoreCoins;

    public Memory(ScoreAndCoins playerScoreCoins) {
        this.playerScoreCoins = playerScoreCoins;
    }

    public void start() {
        generateCardsValues();
        do {
            printCards();
            pickCards();
        } while (gameScore != 6);
        playerScoreCoins.addScoreCoinsMemory(mistakes);
    }

    private void pickCards() {
        int first, second;
        first = pickSingleCard("Pick first card: ");
        second = pickSingleCard("Pick second card: ");
        if (cards[first - 1] == cards[second - 1]) {
            gameScore++;
        } else {
            revealedStatus[first - 1] = false;
            revealedStatus[second - 1] = false;
            mistakes++;
        }
    }

    private int pickSingleCard(String prompt) {
        while (true) {
            int card = InputValidator.getIntInput(prompt, 1, 12);
            if (!revealedStatus[card - 1]) {
                revealedStatus[card - 1] = true;
                UserInterface.clearScreen();
                printCards();
                return card;
            }
            System.out.println("Card already picked, choose another!\n");
        }

    }

    private void generateCardsValues() {
        Random random = new Random();
        int[] values = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};

        for (int i = values.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = values[index];
            values[index] = values[i];
            values[i] = temp;
        }

        System.arraycopy(values, 0, cards, 0, values.length);
    }

    public void printCards() {
        int cardsPerRow = 4;
        String[] rows = new String[6];

        UserInterface.clearScreen();
        for (int i = 0; i < cards.length; i++) {
            String card = generateCard(cards[i], revealedStatus[i]);
            String[] cardLines = card.split("\n");

            if (i % cardsPerRow == 0) {
                Arrays.fill(rows, "");
            }

            for (int j = 0; j < 6 && j < cardLines.length; j++) {
                rows[j] += cardLines[j] + "  ";
            }

            if ((i + 1) % cardsPerRow == 0 || i == cards.length - 1) {
                for (String row : rows) {
                    System.out.println(row);
                }
                System.out.println();
            }
        }
        System.out.println("Score: " + Color.GREEN + gameScore + Color.RESET +" | Mistakes: " + Color.RED + mistakes + Color.RESET);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private String generateCard(int value, boolean isRevealed) {
        if (!isRevealed) {
            return String.join("\n",
                    " _____ ",
                    "|/////|",
                    "|/////|",
                    "|/////|",
                    "|/////|",
                    "|_____|");
        }

        String[] card = Arrays.copyOf(frame.CARD_FRAME, frame.CARD_FRAME.length);
        String pattern = frame.CARD_PATTERNS[value - 1];
        String[] patternLines = pattern.split("\n");

        for (int i = 0; i < patternLines.length && (i + 2) < card.length; i++) {
            String patternLine = patternLines[i].trim();
            StringBuilder cardLine = new StringBuilder(card[i + 2]);

            int start = (cardLine.length() - patternLine.length()) / 2;
            start = Math.max(1, start);

            for (int j = 0; j < patternLine.length() && (start + j) < cardLine.length() - 1; j++) {
                cardLine.setCharAt(start + j, patternLine.charAt(j));
            }

            card[i + 2] = cardLine.toString();
        }

        return String.join("\n", card);
    }
}