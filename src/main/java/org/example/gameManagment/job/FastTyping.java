package org.example.gameManagment.job;

import org.example.frames.Color;
import org.example.gameManagment.ScoreAndCoins;
import org.example.gameManagment.UserInterface;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class FastTyping {
    private int tries = 3;
    private final ScoreAndCoins playerScoreCoins;
    Scanner input = new Scanner(System.in);

    private final String[] texts = {
        "Rzeczpospolita Polska jest demokratycznym państwem prawnym, urzeczywistniającym zasady sprawiedliwości społecznej.",
        "Naród sprawuje władzę przez swoich przedstawicieli lub bezpośrednio.",
        "Ustrój Polski opiera się na podziale i równowadze władzy ustawodawczej, wykonawczej i sądowniczej.",
        "Zakazane są partie odwołujące się do totalitarnych metod nazizmu, faszyzmu i komunizmu oraz nienawiści rasowej.",
        "Władze publiczne zachowują bezstronność w sprawach przekonań religijnych, światopoglądowych i filozoficznych.",
        "Godność człowieka jest nienaruszalna. Jej poszanowanie i ochrona jest obowiązkiem władz publicznych.",
        "Wszyscy są wobec prawa równi. Wszyscy mają prawo do równego traktowania przez władze publiczne.",
        "Rzeczpospolita Polska zapewnia każdemu człowiekowi prawną ochronę życia.",
        "Nikt nie może być poddany torturom ani okrutnemu, nieludzkiemu lub poniżającemu traktowaniu i karaniu.",
        "Każdy ma prawo do ochrony życia prywatnego, rodzinnego, czci i dobrego imienia.",
        "Każdemu zapewnia się wolność poruszania się oraz wyboru miejsca zamieszkania i pobytu.",
        "Każdy ma prawo do nauki. Nauka do 18. roku życia jest obowiązkowa."
    };

    public FastTyping(ScoreAndCoins playerScoreCoins) {
        this.playerScoreCoins = playerScoreCoins;
    }

    public void start() {
        String text = chooseText();
        text = "a";
        waitForInput(text);
    }

    private void countdown() {
        UserInterface.clearScreen();
        for(int i = 3; i >= 1; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            UserInterface.clearScreen();
        }
    }

    private String chooseText() {
        return texts[new Random().nextInt(texts.length)];
    }

    private void waitForInput(String text) {
        if (tries != 0) {
            countdown();
            System.out.println(text);
            Instant start = Instant.now();
            String playerInput = input.nextLine();
            Instant end = Instant.now();
            Duration duration = Duration.between(start, end);
            String time = Long.toString(duration.getSeconds());
            checkInputPrint(playerInput, text, time);
        } else {
            UserInterface.clearScreen();
            System.out.println("Game Over\nYou got " + Color.CYAN + 0 + Color.RESET + " points\nYou got " + Color.YELLOW + 0 + Color.RESET + " coins");
        }
    }

    private void checkInputPrint(String playerInput, String text, String time) {
        if (playerInput.equals(text)) {
            UserInterface.clearScreen();
            System.out.println("Text rewritten correctly!\nTime: " + time + " seconds.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            playerScoreCoins.addScoreCoinsFastTyping(tries, Integer.parseInt(time));
        } else {
            tries--;
            UserInterface.clearScreen();
            System.out.println("Text rewritten uncorrectly...\nTries left: " + tries);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            start();
        }
    }
}
