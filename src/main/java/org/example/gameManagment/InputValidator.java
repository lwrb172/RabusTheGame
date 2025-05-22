package org.example.gameManagment;

import java.util.Scanner;
import java.util.Set;

public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("Choose number between %d and %d!\n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("It has to be a number!");
            }
        }
    }

    public static String getStringInput(String prompt, Set<String> validOptions) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (validOptions.contains(input)) {
                return input;
            }
            System.out.println("\nInvalid command. Correct options: " + validOptions);
        }
    }

    public static String getNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("\nString must not be empty!");
        }
    }
}
