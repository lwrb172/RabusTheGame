package org.example;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);

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

    public void clearScreen() {
        System.out.println("\n".repeat(50));
        //System.out.print("\033[H\033[2J"); to gdy w terminalu
        //System.out.flush();
    }
}
