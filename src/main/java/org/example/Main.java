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
        new GameManager().startMenu();
    }
}