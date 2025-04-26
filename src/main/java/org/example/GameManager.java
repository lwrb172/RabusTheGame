package org.example;

import java.util.List;
import java.util.Scanner;

public class GameManager {
    private Player player;
    private World world;
    private TimeManager time;
    private boolean isRunning = false;
    private Scanner scanner;
    private UserInterface ui;

    public GameManager() {
        this.player = new Player("Player");
        this.world = new World();
        this.time = new TimeManager();
        this.ui = new UserInterface();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        isRunning = true;
        ui.showMessage("Welcome to the world!");

        while (isRunning) {
            time.update();
            player.update();
            world.checkEvents(player, time);

            renderUI();
            handleInput();
        }
    }

    private void renderUI() {
        ui.showMessage("\n--- " + time.getFormattedTime() + " ---");
        ui.displayLocationInfo(world.getCurrentLocation());
        ui.showMessage(player.getStatus());

        // show NPC

        ui.showMessage("Actions:");

        int i = 1;
        for (Action action : world.getCurrentLocation().getActions()) {
            ui.showMessage(i++ + ". " + action.getName() + " (" + action.getDescription() + ")");
        }
        ui.showMessage("Enter action number or location name: ");
    }

    private void handleInput() {
        String input = scanner.nextLine().toLowerCase();

        switch (input) {
            case "exit":
                isRunning = false;
                break;
            case "faster":
                time.increaseSpeed();
                System.out.println("Speed: " + time.getSpeed());
                break;
            case "slower":
                time.decreaseSpeed();
                System.out.println("Speed: " + time.getSpeed());
                break;
            default:
                try {
                    int actionIndex = Integer.parseInt(input) - 1;
                    List<Action> actions = world.getCurrentLocation().getActions();
                    if (actionIndex >= 0 && actionIndex < actions.size()) {
                        actions.get(actionIndex).execute(player, time);
                    }
                } catch (NumberFormatException e) {
                    if (!world.moveToLocation(input)) {
                        System.out.println("Invalid command!");
                    }
                }
        }
    }
}
