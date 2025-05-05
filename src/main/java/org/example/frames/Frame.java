package org.example.frames;

import org.example.gameManagment.Item;
import org.example.entities.NPC;
import org.example.gameManagment.UserInterface;

import java.util.Random;

public class Frame {
    private final String[] coinFlip = { // dodać kolor żółty
            Color.YELLOW + "  .------.\n" + Color.RESET + // 1
            Color.YELLOW + " /  ★ ★  \\\n" + Color.RESET +
            Color.YELLOW + "|  ★ $ ★  |\n" + Color.RESET +
            Color.YELLOW + " \\  ★ ★  /\n" + Color.RESET +
            Color.YELLOW + "  '------'" + Color.RESET,
            Color.YELLOW + "   .---.  \n" + Color.RESET + // 2
            Color.YELLOW +  "  (  $  )  \n" + Color.RESET +
            Color.YELLOW + "   '---'  \n\n\n" + Color.RESET,
            Color.YELLOW + "    |  \n" + Color.RESET + // 3
            Color.YELLOW + "   ) (  \n" + Color.RESET +
            Color.YELLOW +  "    |  \n\n\n\n\n\n\n" + Color.RESET,
            Color.YELLOW +  "   .---.  \n" + Color.RESET + // 2
            Color.YELLOW + "  (  $  )  \n" + Color.RESET +
            Color.YELLOW +   "   '---'  \n\n\n" + Color.RESET,
            Color.YELLOW +   "  .------.\n" + Color.RESET + // 5
            Color.YELLOW +   " /  ★ ★  \\\n" + Color.RESET +
            Color.YELLOW +    "|  ★ $ ★  |\n" + Color.RESET +
            Color.YELLOW +   " \\  ★ ★  /\n" + Color.RESET +
            Color.YELLOW +   "  '------'" + Color.RESET
    };

    private final String[] tv = {
            " _____ ",
            "| ▒▒▒ |",
            "|_____|",
            Color.BROWN + "/     \\" + Color.RESET
    };

    private final String[] dresser = {
            Color.BROWN + "┌─────┐" + Color.RESET,
            Color.BROWN + "│▒▒▒▒▒│" + Color.RESET,
            Color.BROWN + "├─────┤" + Color.RESET,
            Color.BROWN + "│▒▒▒▒▒│" + Color.RESET
    };

    private final String[] table = {
            "       ",
            "       ",
            Color.BROWN + "╔═════╗" + Color.RESET,
            Color.BROWN + "  ║ ║  " + Color.RESET
    };

    private final String[] sofa = {
            "       ",
            Color.RED + " (   ) " + Color.RESET,
            Color.RED + "(-----)" + Color.RESET,
            Color.RED + "|-----|" + Color.RESET
    };

    private final String[] toilet = {
            " __    ",
            " ||    ",
            " (----)",
            " /    \\"
    };

    private final String[] shower = {
            " ----- ",
            "| | | |",
            "| | | |",
            " _____ "
    };

    private final String[] bath = {
            "       ",
            "       ",
            Color.BLUE + "(~~~~~)" + Color.RESET,
            "|_____|"
    };

    private final String[] fridge = {
            "  ___  ",
            " |*  | ",
            " |   | ",
            " |___| "
    };

    private final String[] oven = {
            "       ",
            " _-_-_ ",
            "|** **|",
            "(_____)"
    };

    private final String[] rabus = {
            Color.GRAY + "  O  " + Color.RESET,
            Color.GRAY + " \\|/" + Color.RESET,
            Color.GRAY + " / \\" + Color.RESET
    };

    private final String[] npc1 = {
            Color.YELLOW + "  O  " + Color.RESET,
            Color.YELLOW + " /|\\" + Color.RESET,
            Color.YELLOW + " / \\" + Color.RESET
    };

    private final String[] npc2 = {
            Color.RED + "  O  " + Color.RESET,
            Color.RED + " /|\\" + Color.RESET,
            Color.RED + " / \\" + Color.RESET
    };

    private String[] playerBody = {
            "     ",
            "    ",
            "    "
    };

    private String[] npcBody = {
            "     ",
            "    ",
            "    "
    };

    private String[] itemMainRoom = {
            "       ",
            "       ",
            "       ",
            "       "
    };

    private String[] itemBathoom = {
            "       ",
            "       ",
            "       ",
            "       "
    };

    private String[] itemKitchen = {
            "       ",
            "       ",
            "       ",
            "       "
    };

    public void printCoinFlip(String choice) { // dorobic if win if lose
        String[] sides = {"HEADS", "TAILS"};
        Random rand = new Random();

        System.out.println("I'm throwing coin...");
        System.out.println();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        String result = "";
        int i = 0;
        for (String frame : coinFlip) {
            UserInterface.clearScreen();
            System.out.println(frame);
            String side = sides[rand.nextInt(2)];
            System.out.print("\r" + "Result: " + side);
            result = side;
            i++;
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.print("\r" + "Result: " + result + "       \n");
    }

    public void printPlayer() { System.out.print(playerBody[0] + '\n' + playerBody[1] + '\n' + playerBody[2] + '\n'); }

    public void printMainRoom() {
        System.out.println(Color.RED + "\n ----------------------------------------------------------" + Color.RESET);
        System.out.println(Color.RED + "/                                                          \\" + Color.RESET);
        System.out.println(Color.RED + "------------------------------------------------------------" + Color.RESET);
        System.out.printf(
                        "|   " + Color.DARKBROWN + "____" + Color.RESET + "                   │       %s     ┌──┐  " + Color.DARKBROWN + "____" + Color.RESET + "  |" +
                        "\n|  " + Color.DARKBROWN + "|    |" + Color.RESET + "  %s %s   ^-^-^     %s     │~~│ " + Color.DARKBROWN + "|    |" + Color.RESET + " |" +
                        "\n|  " + Color.DARKBROWN + "| o  |" + Color.RESET + "  %s  %s              %s     └──┘ " + Color.DARKBROWN + "| o  |" + Color.RESET + " |" +
                        "\n|  " + Color.DARKBROWN + "|____|" + Color.RESET + "  %s  %s              %s          " + Color.DARKBROWN + "|____|" + Color.RESET + " |",
                itemMainRoom[0],
                playerBody[0], npcBody[0], itemMainRoom[1],
                playerBody[1], npcBody[1], itemMainRoom[2],
                playerBody[2], npcBody[2], itemMainRoom[3]
        );
        System.out.println("\n------------------------------------------------------------");
    }

    public void printBathroom() {
        System.out.println(Color.RED + "\n ----------------------------------------------------------" + Color.RESET);
        System.out.println(Color.RED + "/                                                          \\" + Color.RESET);
        System.out.println(Color.RED + "------------------------------------------------------------" + Color.RESET);
        System.out.printf(
                        "|      %s            %s                    " + Color.DARKBROWN + "____" + Color.RESET + "  |\n" +
                        "|      %s            %s           %s   " + Color.DARKBROWN + "|    |" + Color.RESET + " |\n" +
                        "|      %s            %s           %s    " + Color.DARKBROWN + "| o  |" + Color.RESET + " |\n" +
                        "|      %s            %s           %s    " + Color.DARKBROWN + "|____|" + Color.RESET + " |",
                toilet[0], itemBathoom[0],
                toilet[1], itemBathoom[1], playerBody[0],
                toilet[2], itemBathoom[2], playerBody[1],
                toilet[3], itemBathoom[3], playerBody[2]
        );
        System.out.println("\n------------------------------------------------------------");
    }

    public void printKitchen() {
        System.out.println(Color.RED + "\n ----------------------------------------------------------" + Color.RESET);
        System.out.println(Color.RED + "/                                                          \\" + Color.RESET);
        System.out.println(Color.RED + "------------------------------------------------------------" + Color.RESET);
        System.out.printf(
                       "|   " + Color.DARKBROWN + "____" + Color.RESET + "                   %s       %s           |\n" +
                       "|  " + Color.DARKBROWN + "|    |" + Color.RESET + "  %s           %s       %s           |\n" +
                       "|  " + Color.DARKBROWN + "| o  |" + Color.RESET + "  %s            %s       %s           |\n" +
                       "|  " + Color.DARKBROWN + "|____|" + Color.RESET + "  %s            %s       %s           |",
                itemKitchen[0], fridge[0],
                playerBody[0], itemKitchen[1], fridge[1],
                playerBody[1], itemKitchen[2], fridge[2],
                playerBody[2], itemKitchen[3], fridge[3]
        );
        System.out.println("\n------------------------------------------------------------");
    }

    public void setPlayerColor(Color color) {
        playerBody[0] = color + "  O  " + Color.RESET;
        playerBody[1] = color + " /|\\" + Color.RESET;
        playerBody[2] = color + " / \\" + Color.RESET;
    }

    public void setNPC(NPC npc) {
        switch (npc.getName()) {
            case "Rabuś" -> {
                insert(rabus, npcBody);
            }
            case "npc1" -> { // do ustalenia
                insert(npc1, npcBody);
            }
            case "npc2" -> { // też do ustalenia
                insert(npc2, npcBody);
            }
        }
    }

    public void setItemMainRoom(Item item) {
        switch (item.getName()) {
            case "tv" -> {
                insert(tv, itemMainRoom);
            }
            case "dresser" -> {
                insert(dresser, itemMainRoom);
            }
            case "table" -> {
                insert(table, itemMainRoom);
            }
            case "sofa" -> {
                insert(sofa, itemMainRoom);
            }
        }
    }

    public void setItemBathroom(Item item) {
        switch (item.getName()) {
            case "toilet" -> {
                insert(toilet, itemBathoom);
            }
            case "shower" -> {
                insert(shower, itemBathoom);
            }
            case "bath" -> {
                insert(bath, itemBathoom);
            }
        }
    }

    public void setItemKitchen(Item item) {
        switch (item.getName()) {
            case "fridge" -> {
                insert(fridge, itemKitchen);
            }
            case "oven" -> {
                insert(oven, itemKitchen);
            }
            case "table" -> {
                insert(table, itemKitchen);
            }
        }
    }

    private void insert(String[] from, String[] to) {
        for (int i = 0; i < from.length && i < to.length; i++) {
            to[i] = from[i];
        }
    }
}
