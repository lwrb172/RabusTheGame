package org.example;

import org.example.entities.NPC;
import org.example.frames.Frame;
import org.example.gameManagment.GameManager;
import org.example.gameManagment.Item;

import static org.example.frames.Color.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameManager gameManager = new GameManager();
        //gameManager.startMenu();

        // TEST FRAME
        NPC npcTest = new NPC("npc1", "xd");

        Item telewizor = new Item("tv", "xd", 100, "furniture", 15);
        Item wanna = new Item("bath", "xd", 100, "furniture", 20);
        Item kuchenka = new Item("oven", "xd", 100, "furniture", 20);

        Frame frame = new Frame();

        // input validator HEADS TAILS
        //frame.printCoinFlip("heads");

        frame.setPlayerColor(RED);
        frame.setNPC(npcTest);

        frame.printShop();
    }
}