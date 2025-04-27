package org.example;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void displayMainManu() {
        System.out.println("\n=== RABUŚ THE GAME ===");
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("3. Exit");
        System.out.println("Choose: ");
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void displayLocationInfo(Location location) {
        System.out.println("\n=== " + location.getName().toUpperCase() + " ===");
        System.out.println(location.getDescription());
    }
}
