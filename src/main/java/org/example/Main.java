package org.example;

import static org.example.Color.*;

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
       // frame.printCoinFlip();

        frame.setPlayerColor(RED);
        frame.setNPC(npcTest);

        frame.setItemKitchen(kuchenka);
        frame.setItemBathroom(wanna);
        frame.setItemMainRoom(telewizor);

        frame.printKitchen();
        frame.printBathroom();
        frame.printMainRoom();

    }
}