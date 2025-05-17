package org.example;

import org.example.entities.NPC;
import org.example.entities.Player;
import org.example.frames.Frame;
import org.example.gameManagment.GameManager;
import org.example.gameManagment.InputValidator;
import org.example.gameManagment.Item;
import org.example.gameManagment.job.FastTyping;
import org.example.gameManagment.job.Memory;
import org.example.gameManagment.job.TicTacToe;

import java.util.HashSet;
import java.util.Set;

import static org.example.frames.Color.*;

public class Main {
    public static void main(String[] args) {
        //GameManager gameManager = new GameManager();
        //gameManager.startMenu();

        // TEST FRAME
        //NPC npcTest = new NPC("Kacper", "xd");

        //Item telewizor = new Item("tv", "xd", 100, "furniture", 15);
        //Item wanna = new Item("bath", "xd", 100, "furniture", 20);
        //Item kuchenka = new Item("oven", "xd", 100, "furniture", 20);

        //Frame.setPlayerColor(RED);
        //Frame.setNPC(npcTest);

        //Frame.printPark();
        //Frame.printShop();
        //Frame.printLogo();

        // TEST JOB
        //new Memory().start();
        Player player = new Player("Kacper", "green");
        //new TicTacToe(player.getName()).start();
        //new Memory().start();
        new FastTyping().start();
    }
}