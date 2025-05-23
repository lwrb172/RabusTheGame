package org.example.gameManagement;

public class UserInterface {
    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static void displayLocationInfo(Location location) {
        System.out.println("\n=== " + location.getName().toUpperCase() + " ===");
        System.out.println(location.getDescription());
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void threadSleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
