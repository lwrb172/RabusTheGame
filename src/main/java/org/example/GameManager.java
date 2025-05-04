package org.example;

import org.example.actions.Action;

import java.util.*;

public class GameManager {
    private Player player;
    private final World world;
    private final TimeManager time;
    private boolean isRunning = false;
    private final Scanner scanner;
    private final UserInterface ui;
    private List<Action> actions;

    public GameManager() {
        this.world = new World();
        this.time = new TimeManager();
        this.ui = new UserInterface();
        this.actions = new ArrayList<>();
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
        UserInterface.clearScreen();
        Set<String> confCommands = new HashSet<>(Set.of("yes", "no"));
        Set<String> petTypeCommands = new HashSet<>(Set.of("dog", "cat"));
        Set<String> colorCommands = new HashSet<>(Set.of("red", "green", "blue", "yellow", "pink", "purple", "grey", "brown", "black", "white"));

        String creationChoice = InputValidator.getStringInput("Do you want a fast default creation?: ", confCommands);
        if (Objects.equals(creationChoice, "yes")) {
            this.player = new Player("Player", "white");
        } else {
            String name = InputValidator.getNonEmptyString("Enter name: ");
            String color = InputValidator.getStringInput("Enter color: ", colorCommands);
            String petChoice = InputValidator.getStringInput("Do you want a pet?: ", confCommands);
            if (Objects.equals(petChoice, "yes")) {
                String petType = InputValidator.getStringInput("Cat or dog?: ", petTypeCommands);
                String petName = InputValidator.getNonEmptyString("Enter pet's name: ");
                Pet pet = new Pet(petName, petType);
                this.player = new Player(name, color, pet);
                System.out.println(player.getName());
                System.out.println(player.getColor());
                System.out.println(player.getPetName());
                System.out.println(player.getPetType());
            } else {
                this.player = new Player(name, color);
                System.out.println(player.getName());
                System.out.println(player.getColor());
            }
        }
        startGame();
    }

    public void startGame() {
        isRunning = true;
        while (isRunning) {
            time.update();
            player.update();
            world.checkEvents(player, time);

            renderUI();
            mainGameInput();
        }
    }

    private void renderUI() {
        //ui.clearScreen();
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

        actions = world.getCurrentLocation().getActions();
        ui.showMessage("Actions:");
        for (int i = 0; i < actions.size(); i++) {
            Action action = actions.get(i);
            ui.showMessage((i+1) + ". " + action.getName() + " (" + action.getDescription() + ")");
        }
        ui.showMessage("Enter action number or location name:");
    }

    private void mainGameInput() {
        String input = scanner.nextLine().toLowerCase();

        try {
            int actionIndex = Integer.parseInt(input);
            actions = world.getCurrentLocation().getActions();

            if (actionIndex > 0 && actionIndex <= actions.size()) {
                actions.get(actionIndex-1).execute(player, time);
            } else {
                System.out.println("Invalid action number!");
            }
        } catch (NumberFormatException e) {
            // if not number - check locations
            if (!world.moveToLocation(input)) {
                if (input.equals("exit")) {
                    System.out.println("You left the game.");
                    isRunning = false;
                } else {
                    System.out.println("Invalid command!");
                }
            }
        }
    }
}
