package org.example.frames;

import org.example.gameManagment.Item;
import org.example.entities.NPC;
import org.example.gameManagment.UserInterface;

import java.util.Random;

public class Frame {
    private static final String[] coinFlip = {
            Color.YELLOW + "  .-----.\n" + Color.RESET + // 1
            Color.YELLOW + " /  ★ ★  \\\n" + Color.RESET +
            Color.YELLOW + "|  ★ $ ★  |\n" + Color.RESET +
            Color.YELLOW + " \\  ★ ★  /\n" + Color.RESET +
            Color.YELLOW + "  '-----'" + Color.RESET,
            Color.YELLOW + "   .---.  \n" + Color.RESET + // 2
            Color.YELLOW +  "  (  $  )  \n" + Color.RESET +
            Color.YELLOW + "   '---'  \n\n\n" + Color.RESET,
            Color.YELLOW + "    |  \n" + Color.RESET + // 3
            Color.YELLOW + "   ) (  \n" + Color.RESET +
            Color.YELLOW +  "    |  \n\n\n\n\n\n\n" + Color.RESET,
            Color.YELLOW +  "   .---.  \n" + Color.RESET + // 2
            Color.YELLOW + "  (  $  )  \n" + Color.RESET +
            Color.YELLOW +   "   '---'  \n\n\n" + Color.RESET,
            Color.YELLOW +   "  .-----.\n" + Color.RESET + // 5
            Color.YELLOW +   " /  ★ ★  \\\n" + Color.RESET +
            Color.YELLOW +    "|  ★ $ ★  |\n" + Color.RESET +
            Color.YELLOW +   " \\  ★ ★  /\n" + Color.RESET +
            Color.YELLOW +   "  '-----'" + Color.RESET
    };

    public static final String[] CARD_FRAME = {
            " _____ ",
            "|     |",
            "|     |",
            "|     |",
            "|     |",
            "|_____|"
    };

    public static final String[] CARD_PATTERNS = {
            "\n●",
            "● \n\n ●",
            "●\n ●\n ●",
            "● ●\n\n ● ●",
            "●\n ● ●\n ● ● ",
            "● ● ●\n\n ● ● ●",
    };

    private static final String[] tv = {
            " _____ ",
            "| ▒▒▒ |",
            "|_____|",
            Color.BROWN + "/     \\" + Color.RESET
    };

    private static final String[] dresser = {
            Color.BROWN + "┌─────┐" + Color.RESET,
            Color.BROWN + "│▒▒▒▒▒│" + Color.RESET,
            Color.BROWN + "├─────┤" + Color.RESET,
            Color.BROWN + "│▒▒▒▒▒│" + Color.RESET
    };

    private static final String[] table = {
            "       ",
            "       ",
            Color.BROWN + "╔═════╗" + Color.RESET,
            Color.BROWN + "  ║ ║  " + Color.RESET
    };

    private static final String[] sofa = {
            "       ",
            Color.RED + " (   ) " + Color.RESET,
            Color.RED + "(-----)" + Color.RESET,
            Color.RED + "|-----|" + Color.RESET
    };

    private static final String[] toilet = {
            " __    ",
            " ||    ",
            " (----)",
            " /    \\"
    };

    private static final String[] shower = {
            " ----- ",
            "| | | |",
            "| | | |",
            " _____ "
    };

    private static final String[] bath = {
            "       ",
            "       ",
            Color.BLUE + "(~~~~~)" + Color.RESET,
            "|_____|"
    };

    private static final String[] fridge = {
            "  ___  ",
            " |*  | ",
            " |   | ",
            " |___| "
    };

    private static final String[] oven = {
            "       ",
            " _-_-_ ",
            "|** **|",
            "(_____)"
    };

    private static final String[] rabus = {
            Color.GRAY + "  O  " + Color.RESET,
            Color.GRAY + " \\|/" + Color.RESET,
            Color.GRAY + " / \\" + Color.RESET
    };

    private static final String[] npc1 = {
            Color.YELLOW + "  O  " + Color.RESET,
            Color.YELLOW + " /|\\" + Color.RESET,
            Color.YELLOW + " / \\" + Color.RESET
    };

    private static final String[] npc2 = {
            Color.RED + "  O  " + Color.RESET,
            Color.RED + " /|\\" + Color.RESET,
            Color.RED + " / \\" + Color.RESET
    };

    private static String[] playerBody = {
            "     ",
            "    ",
            "    "
    };

    private static String[] npcBody = {
            "     ",
            "    ",
            "    "
    };

    private static String[] itemMainRoom = {
            "       ",
            "       ",
            "       ",
            "       "
    };

    private static String[] itemBathoom = {
            "       ",
            "       ",
            "       ",
            "       "
    };

    private static String[] itemKitchen = {
            "       ",
            "       ",
            "       ",
            "       "
    };

    public static void printCoinFlip(String choice) { //todo przeniesc funkcjonalnosc do eventa
        String[] sides = {"HEADS", "TAILS"};
        Random rand = new Random();

        UserInterface.clearScreen();
        System.out.print("I'm throwing coin...");
        try {
            Thread.sleep(2000);
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
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.print("\r" + "Result: " + result + "       \n");

        if(result.toLowerCase().equals(choice)) {
            UserInterface.clearScreen();
            System.out.print("I'm letting you go... this time.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            //score.addRabusStreak();
        } else {
            UserInterface.clearScreen();
            System.out.print("Too bad, you lose ;)");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            // TO-DO lose
        }
    }

    public static void printPlayer() { System.out.print(playerBody[0] + '\n' + playerBody[1] + '\n' + playerBody[2] + '\n'); }

    public static void printMainRoom() {
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

    public static void printBathroom() {
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

    public static void printKitchen() {
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

    public static void printPark() {
        System.out.printf(
                "\n                                          " + Color.BROWN + "v .   ._, |_  .,        \n" +
                "     " + Color.GREEN + "ccee88oo" + Color.RESET + "                          " + Color.BROWN + "`-._\\/  .  \\ /    |/_      \n" + Color.RESET +
                "  " + Color.GREEN + "C8O8O8Q8PoOb o8oo" + Color.RESET + "                        " + Color.BROWN + "\\\\  _\\, y | \\//        \n" + Color.RESET +
                " " + Color.GREEN + "dOB69QO8PdUOpugoO9bD" + Color.RESET + "                " + Color.BROWN + "_\\_.___\\\\, \\\\/ -.\\||       \n" + Color.RESET +
                Color.GREEN + "CgggbU8OU qOp qOdoUOdcb" + Color.RESET + "                " + Color.BROWN + "`7-,--.`._||  / / ,      \n" + Color.RESET +
                "    " + Color.GREEN + "6OuU  " + Color.RESET + Color.BROWN + "/" + Color.RESET + Color.GREEN + "p u gcoUodpP" + Color.RESET + "                " + Color.BROWN + "/'     `-. `./ / |/_.'       \n" + Color.RESET +
                "      " + Color.BROWN + "\\\\\\//  /" + Color.RESET + Color.GREEN + "douUP" + Color.RESET + "                              " + Color.BROWN + "|    |//      \n" +
                "       " + Color.BROWN + "\\\\\\////" + Color.RESET + "                                   " + Color.BROWN + "|_    /\n" + Color.RESET +
                "        " + Color.BROWN + "|||/\\" + Color.RESET + "                                    " + Color.BROWN + "|-   |\n" + Color.RESET +
                "        " + Color.BROWN + "|||\\/" + Color.RESET + "             %s   " + Color.DARKBROWN + "┌────┐" + Color.RESET + "         " + Color.BROWN + "|   =|\n" + Color.RESET +
                "        " + Color.BROWN + "|||||" + Color.RESET + "             %s   " + Color.DARKBROWN + "(______)" + Color.RESET + "        " + Color.BROWN + "|    |\n" + Color.RESET +
                "       " + Color.BROWN + "//||||\\" + Color.RESET + "            %s   " + Color.DARKBROWN + "||    ||" + Color.RESET + "       " + Color.BROWN + "/ ,  . \\\n" + Color.RESET,
                playerBody[0],
                playerBody[1],
                playerBody[2]);
        System.out.println(Color.GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + Color.RESET);
    }

    public static void printShop() {
        System.out.println(
                Color.BROWN + "\n       ║ ║             ║ ║         \n" + Color.RESET +
                Color.BROWN + "       ║ ║             ║ ║         \n" + Color.RESET +
                Color.BROWN + "  _____________________________\n" + Color.RESET +
                Color.BROWN + " /     " + Color.RESET + "_____ _                 " + Color.BROWN + "\\\n" + Color.RESET +
                Color.BROWN + "|    " + Color.RESET + "/ ____| |                  " + Color.BROWN + "|\n" + Color.RESET +
                Color.BROWN + "|   " + Color.RESET + "| (___ | |__   ___  _ __    " + Color.BROWN + "|\n" + Color.RESET +
                Color.BROWN + "|    " + Color.RESET + "\\___ \\| '_ \\ / _ \\| '_ \\   " + Color.BROWN + "|\n" + Color.RESET +
                Color.BROWN + "|    " + Color.RESET + "____) | | | | (_) | |_) |  " + Color.BROWN + "|\n" + Color.RESET +
                Color.BROWN + "|   " + Color.RESET + "|_____/|_| |_|\\___/| .__/   " + Color.BROWN + "|\n" + Color.RESET +
                Color.BROWN + "|                      " + Color.RESET + "|_|      " + Color.BROWN + "|\n" + Color.RESET +
                Color.BROWN + " \\_____________________________/\n" + Color.RESET
        );
    }

    public static void printLogo() {
        System.out.println(
                Color.CYAN + "\n ______   ______   ______   __  __   ______       ______  __  __   ______       ______   ______   __    __   ______  \n" + Color.RESET +
                Color.CYAN + "/\\  == \\ /\\  __ \\ /\\  == \\ /\\ \\/\\ \\ /\\  ___\\     /\\__  _\\/\\ \\_\\ \\ /\\  ___\\     /\\  ___\\ /\\  __ \\ /\\ \"-./  \\ /\\  ___\\  \n" + Color.RESET +
                Color.CYAN + "\\ \\  __< \\ \\  __ \\\\ \\  __< \\ \\ \\_\\ \\\\ \\___  \\    \\/_/\\ \\/\\ \\  __ \\\\ \\  __\\     \\ \\ \\__ \\\\ \\  __ \\\\ \\ \\-./\\ \\\\ \\  __\\  \n" + Color.RESET +
                Color.CYAN + " \\ \\_\\ \\_\\\\ \\_\\ \\_\\\\ \\_____\\\\ \\_____\\\\/\\_____\\      \\ \\_\\ \\ \\_\\ \\_\\\\ \\_____\\    \\ \\_____\\\\ \\_\\ \\_\\\\ \\_\\ \\ \\_\\\\ \\_____\\ \n" + Color.RESET +
                Color.CYAN + "  \\/_/ /_/ \\/_/\\/_/ \\/_____/ \\/_____/ \\/_____/       \\/_/  \\/_/\\/_/ \\/_____/     \\/_____/ \\/_/\\/_/ \\/_/  \\/_/ \\/_____/ " + Color.RESET
        );
    }

    public static void setPlayerColor(Color color) {
        playerBody[0] = color + "  O  " + Color.RESET;
        playerBody[1] = color + " /|\\" + Color.RESET;
        playerBody[2] = color + " / \\" + Color.RESET;
    }

    public static void setNPC(NPC npc) {
        switch (npc.getName()) {
            case "Rabuś" -> {
                insert(rabus, npcBody);
            }
            case "Kacper" -> {
                insert(npc1, npcBody);
            }
            case "Oliwier" -> {
                insert(npc2, npcBody);
            }
        }
    }

    public static void setItemMainRoom(Item item) {
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

    public static void setItemBathroom(Item item) {
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

    public static void setItemKitchen(Item item) {
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

    private static void insert(String[] from, String[] to) {
        for (int i = 0; i < from.length && i < to.length; i++) {
            to[i] = from[i];
        }
    }
}
