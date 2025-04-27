package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameManager {
    private Player player;
    private World world;
    private TimeManager time;
    private boolean isRunning = false;
    private Scanner scanner;
    private UserInterface ui;
    private Map<String, Integer> actions;

    public GameManager() {
        this.player = new Player("Player");
        this.world = new World();
        this.time = new TimeManager();
        this.ui = new UserInterface();
        this.actions = new HashMap<>();
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
        ui.showMessage("Available locations:");
        List<Location> locations = world.getAllLocations();
        for (Location location : locations) {
            System.out.print(location.getName() + ' ');
        }
        System.out.println();
        // show NPC
        ui.showMessage("Actions:");
        int i = 1;
        for (Action action : world.getCurrentLocation().getActions()) {
            ui.showMessage(i++ + ". " + action.getName() + " (" + action.getDescription() + ")");
            actions.put(action.getName(), i);
        }
        ui.showMessage("Enter action or location name: ");
    }

    private void handleInput() {
        String input = scanner.nextLine().toLowerCase();

        switch (input) {
            case "exit":
                isRunning = false;
                break;
            case "eat":
                if (actions.containsKey("Eat")) {
                    System.out.println("Chose item number to eat:");
                    List<Item> foods = player.getInventory();
                    int i = 1;
                    for (Item food : foods) {
                        if (food.getType().equals("food")) {
                            System.out.print(i++ + "." + food.getName() + ' ');
                        } else {
                            foods.remove(food);
                        }
                    }
                    System.out.println();
                    String chosenFood = scanner.nextLine();
                    player.eat(foods.get(Integer.parseInt(chosenFood)-1));
                } else {
                    System.out.println("Action not available.");
                }
                break;
            case "sleep":
                if (actions.containsKey("Sleep")) {
                    System.out.println("How many hours you want to sleep?");
                    String hours = scanner.nextLine();
                    player.sleep(Integer.parseInt(hours));
                    time.setHour(time.getHour() + Integer.parseInt(hours));
                } else {
                    System.out.println("Action not available.");
                }
                break;
            case "work":
                if (actions.containsKey("Work")) {
                    player.work();
                    time.setHour(time.getHour() + 8);
                } else {
                    System.out.println("Action not available.");
                }
                break;
            default:
                if (!world.moveToLocation(input)) {
                    System.out.println("Invalid command!");
                }
        }
    }
}
