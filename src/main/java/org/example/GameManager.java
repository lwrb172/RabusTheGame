package org.example;

import java.util.*;

public class GameManager {
    private Player player;
    private World world;
    private TimeManager time;
    private boolean isRunning = true;
    private Scanner scanner;
    private UserInterface ui;

    public GameManager() {
        this.world = new World();
        this.time = new TimeManager();
        this.ui = new UserInterface();
        this.scanner = new Scanner(System.in);
    }

    public void startMenu() {
        System.out.println("\n=== RABUŚ THE GAME ===");
        int choice = InputValidator.getIntInput("1. Create Character\n2. Exit", 1, 2);
        switch (choice) {
            case 1:
                createCharacter();
                break;
            case 2:
                isRunning = false;
                break;
        }
    }

    public void createCharacter() {
        ui.clearScreen();
        Set<String> confCommands = new HashSet<>(Set.of("yes", "no"));
        Set<String> petTypeCommands = new HashSet<>(Set.of("dog", "cat"));
        Set<String> colorCommands = new HashSet<>(Set.of("red", "green", "blue", "white"));
        String creationChoice = InputValidator.getStringInput("Do you want a fast default creation?: ", confCommands);
        if (Objects.equals(creationChoice, "yes")) {
            this.player = new Player("Player", "white");
        }
        String name = InputValidator.getNonEmptyString("Enter name: ");
        String color = InputValidator.getStringInput("Enter color: ", colorCommands);
        String petChoice = InputValidator.getStringInput("Do you want a pet?: ", confCommands);
        if (Objects.equals(petChoice, "yes")) {
            String petType = InputValidator.getStringInput("Cat or dog?: ", petTypeCommands);
            String petName = InputValidator.getNonEmptyString("Enter pet's name: ");
            Pet pet = new Pet(petName, petType);
            this.player = new Player(name, color, pet);
        } else {
            this.player = new Player(name, color);
        }
        System.out.println(player.getName());
        System.out.println(player.getColor());
        System.out.println(player.getPetName());
        System.out.println(player.getPetType());
        startGame();
    }

    public void startGame() {
        ui.clearScreen();
        while (isRunning) {
            time.update();
            player.update();
            world.checkEvents(player, time);

            renderUI();
            mainGameInput();
        }
    }

    private void renderUI() {
        ui.clearScreen();
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

    private void mainGameInput() {
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
