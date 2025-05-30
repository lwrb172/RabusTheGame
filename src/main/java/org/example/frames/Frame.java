package org.example.frames;

import org.example.gameManagement.Item;

public class Frame {
    private static final String[] coinFrames = {
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

    public final String[] CARD_FRAME = {
            " _____ ",
            "|     |",
            "|     |",
            "|     |",
            "|     |",
            "|_____|"
    };

    public final String[] CARD_PATTERNS = {
            "\n●",
            "● \n\n ●",
            "●\n ●\n ●",
            "● ●\n\n ● ●",
            "●\n ● ●\n ● ● ",
            "● ● ●\n\n ● ● ●",
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

    private final String[] noNPC = {
            "     ",
            "    ",
            "    "
    };

    private String[] playerBody = {
            "     ",
            "    ",
            "    "
    };

    private String[] catBody = {
            "",
            "",
            ""
    };

    private String[] dogBody = {
            "",
            "",
            "",
            "",
            ""
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

    public String[] getCoinFrames() { return coinFrames; }

    public void printCat() { System.out.print(catBody[0] + '\n' + catBody[1] + '\n' + catBody[2] + '\n'); }

    public void printDog() { System.out.print(dogBody[0] + '\n' + dogBody[1] + '\n' + dogBody[2] + '\n' + dogBody[3] + '\n' + dogBody[4] + '\n'); }

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

    public void printPark() {
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

    public void printShop() {
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

    public void printLogo() {
        System.out.println(
                Color.CYAN + "\n ______   ______   ______   __  __   ______       ______  __  __   ______       ______   ______   __    __   ______  \n" + Color.RESET +
                Color.CYAN + "/\\  == \\ /\\  __ \\ /\\  == \\ /\\ \\/\\ \\ /\\  ___\\     /\\__  _\\/\\ \\_\\ \\ /\\  ___\\     /\\  ___\\ /\\  __ \\ /\\ \"-./  \\ /\\  ___\\  \n" + Color.RESET +
                Color.CYAN + "\\ \\  __< \\ \\  __ \\\\ \\  __< \\ \\ \\_\\ \\\\ \\___  \\    \\/_/\\ \\/\\ \\  __ \\\\ \\  __\\     \\ \\ \\__ \\\\ \\  __ \\\\ \\ \\-./\\ \\\\ \\  __\\  \n" + Color.RESET +
                Color.CYAN + " \\ \\_\\ \\_\\\\ \\_\\ \\_\\\\ \\_____\\\\ \\_____\\\\/\\_____\\      \\ \\_\\ \\ \\_\\ \\_\\\\ \\_____\\    \\ \\_____\\\\ \\_\\ \\_\\\\ \\_\\ \\ \\_\\\\ \\_____\\ \n" + Color.RESET +
                Color.CYAN + "  \\/_/ /_/ \\/_/\\/_/ \\/_____/ \\/_____/ \\/_____/       \\/_/  \\/_/\\/_/ \\/_____/     \\/_____/ \\/_/\\/_/ \\/_/  \\/_/ \\/_____/ " + Color.RESET
        );
    }

    public void setPlayerColor(Color color) {
        playerBody[0] = color + "  O  " + Color.RESET;
        playerBody[1] = color + " /|\\" + Color.RESET;
        playerBody[2] = color + " / \\" + Color.RESET;
    }

    public void setCatColor(Color color) {
        catBody[0] = color + " /\\_/\\ " + Color.RESET;
        catBody[1] = color + "( o.o )" + Color.RESET;
        catBody[2] = color + " > ^ < " + Color.RESET;
    }

    public void setDogColor(Color color) {
        dogBody[0] = color + ",'.-.'. " + Color.RESET;
        dogBody[1] = color + "'\\~ o/` ,," + Color.RESET;
        dogBody[2] = color + " { @ } f" + Color.RESET;
        dogBody[3] = color + " /`-'\\$ " + Color.RESET;
        dogBody[4] = color + "(_/-\\_) " + Color.RESET;
    }

    public void setRabus() {
        insert(rabus, npcBody);
    }

    public void setNoRabus() {
        insert(noNPC, npcBody);
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
