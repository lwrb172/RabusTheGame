package org.example;

import org.example.entities.NPC;
import org.example.frames.Frame;
import org.example.gameManagment.GameManager;
import org.example.gameManagment.InputValidator;
import org.example.gameManagment.Item;

import java.util.HashSet;
import java.util.Set;

import static org.example.frames.Color.*;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        //gameManager.startMenu();

        // TEST FRAME
        NPC npcTest = new NPC("Kacper", "xd");

        Item telewizor = new Item("tv", "xd", 100, "furniture", 15);
        Item wanna = new Item("bath", "xd", 100, "furniture", 20);
        Item kuchenka = new Item("oven", "xd", 100, "furniture", 20);

        Frame frame = new Frame();

        // w ten sposób coinflipa wstawić nie usuwaj ok?
        //Set<String> coinSides = new HashSet<>(Set.of("heads", "tails"));
        //frame.printCoinFlip(InputValidator.getStringInput("Enter coin side: ", coinSides));

        frame.setPlayerColor(RED);
        frame.setNPC(npcTest);

        //frame.printPark();
        frame.printShop();
        //frame.printLogo();
    }
}