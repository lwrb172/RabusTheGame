package org.example;

import java.util.Random;

public class Frame {
    private final String[] coinFlip = { // dodać kolor żółty
            "  _____\n" + // 1
            " /       \\\n" +
            "(    ●    )\n" +
            " \\_____/",
            "   .---.  \n" + // 2
            "  (     )  \n" +
            "   '---'  ",
            "    |  \n" + // 3
            "   ) (  \n" +
            "    |  ",
            "   .---.  \n" + // 4
            "  (     )  \n" +
            "   '---'  ",
            "  _____\n" + // 5
            " /       \\\n" +
            "(    ●    )\n" +
            " \\_____/"
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

    public void printCoinFlip() throws InterruptedException {
//        String[] sides = {"ORZEŁ", "RESZKA"};
//        Random rand = new Random();
//
//        System.out.println("Rzucam monetą...");
//        System.out.println();
//
//        // Animacja obracającej się monety
//        for (int i = 0; i < 20; i++) {
//            String side = sides[i % 2]; // na zmianę
//            System.out.print("\r" + "Wynik: " + side);
//            Thread.sleep(100); // 100 ms opóźnienia
//        }

        // Losowy wynik
//        String result = sides[rand.nextInt(2)];
//        System.out.print("\r" + "Wynik końcowy: " + result + "       \n");
//        while (true) {
//            for (String frame : coinFlip) {
//                UserInterface.clearScreen();
//                System.out.println(frame);
//                try {
//                    Thread.sleep(1500);
//                } catch (InterruptedException e) {
//                    System.err.println(e.getMessage());
//                }
//            }
//        }
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
                npcBody[0] = Color.GRAY + "  O  " + Color.RESET;
                npcBody[1] = Color.GRAY + " \\|/" + Color.RESET;
                npcBody[2] = Color.GRAY + " / \\" + Color.RESET;
            }
            case "npc1" -> { // do ustalenia
                npcBody[0] = Color.YELLOW + "  O  " + Color.RESET;
                npcBody[1] = Color.YELLOW + " /|\\" + Color.RESET;
                npcBody[2] = Color.YELLOW + " / \\" + Color.RESET;
            }
            case "npc2" -> { // też do ustalenia
                npcBody[0] = Color.RED + "  O  " + Color.RESET;
                npcBody[1] = Color.RED + " /|\\" + Color.RESET;
                npcBody[2] = Color.RED + " / \\" + Color.RESET;
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
