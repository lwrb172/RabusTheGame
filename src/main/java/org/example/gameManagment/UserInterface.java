package org.example.gameManagment;

public class UserInterface {
    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static void displayLocationInfo(Location location) {
        System.out.println("\n=== " + location.getName().toUpperCase() + " ===");
        System.out.println(location.getDescription());
    }

    public static void clearScreen() {
        System.out.println("\n".repeat(50));
        //System.out.print("\033[H\033[2J");
        //System.out.flush();
    }
}
