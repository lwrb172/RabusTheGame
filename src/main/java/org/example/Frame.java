package org.example;

public class Frame {
    private final String[] coinFlip = {
            "  _______\n" + // 1
            " /       \\\n" +
            "(    ●    )\n" +
            " \\_______/",
            "   .---.  \n" + // 2
            "  (     )  \n" +
            "   '---'  ",
            "    |  \n" + // 3
            "   ) (  \n" +
            "    |  ",
            "   .---.  \n" + // 4
            "  (     )  \n" +
            "   '---'  ",
            "  _______\n" + // 5
            " /       \\\n" +
            "(    ●    )\n" +
            " \\_______/"
    };

    private final String[] tv = {
            " _____ ",
            "| ▒▒▒ |",
            "|_____|",
            "/     \\"
    };

    private final String[] dresser = {
            "┌─────┐",
            "│▒▒▒▒▒│",
            "├─────┤",
            "│▒▒▒▒▒│"
    };

    private final String[] table = {
            "       ",
            "       ",
            "╔═════╗",
            "  ║ ║  "
    };

    private final String[] sofa = {
            "       ",
            " (   ) ",
            "(-----)",
            "|-----|"
    };

    private final String[] toilet = {
            " __    ",
            " ||    ",
            " (----)",
            " /   \\"
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
            "(~~~~~)",
            "|_____|"
    };

    private String head;
    private String torso;
    private String legs;

    private String itemFirst = "       ";
    private String itemSecond = "       ";
    private String itemThird = "       ";
    private String itemFourth = "       ";

    private String npcHead = "     ";
    private String npcTorso = "    ";
    private String npcLegs = "    ";

    public void printCoin() {
        for (String frame : coinFlip) {
            UserInterface.clearScreen();
            System.out.println(frame);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printPlayer() { System.out.print(head + '\n' + torso + '\n' + legs + '\n'); }

    public void printMainRoom() {
        System.out.println("\n ----------------------------------------------------------");
        System.out.println("/                                                          \\");
        System.out.println("------------------------------------------------------------");
        System.out.printf(
                """
                        |   ____                   │       %s     ┌──┐  ____  |
                        |  |    |  %s %s   ^-^-^     %s     │~~│ |    | |
                        |  | o  |  %s  %s              %s     └──┘ | o  | |
                        |  |____|  %s  %s              %s          |____| |""",
                this.itemFirst,
                this.head, this.npcHead, this.itemSecond,
                this.torso, this.npcTorso, this.itemThird,
                this.legs, this.npcLegs, this.itemFourth
        );
        System.out.println("\n------------------------------------------------------------");
    }

    public void printBathroom() {
        System.out.println("\n ----------------------------------------------------------");
        System.out.println("/                                                          \\");
        System.out.println("------------------------------------------------------------");
        System.out.printf(
                """
                        |                                                    ____  |
                        |                                           %s   |    | |
                        |                                           %s    | o  | |
                        |                                           %s    |____| |""",
                this.head, this.torso, this.legs
        );
        System.out.println("\n------------------------------------------------------------");
    }

    public void printKitchen() {
        System.out.println("\n ----------------------------------------------------------");
        System.out.println("/                                                          \\");
        System.out.println("------------------------------------------------------------");
        System.out.printf(
                """
                        |   ____                   │       %s     ┌──┐  ____  |
                        |  |    |  %s %s   ^-^-^     %s     │~~│ |    | |
                        |  | o  |  %s  %s              %s     └──┘ | o  | |
                        |  |____|  %s  %s              %s          |____| |""",
                this.itemFirst,
                this.head, this.npcHead, this.itemSecond,
                this.torso, this.npcTorso, this.itemThird,
                this.legs, this.npcLegs, this.itemFourth
        );
        System.out.println("\n------------------------------------------------------------");
    }

    public void setPlayerColor(Color color) {
        this.head = color + "  O  " + Color.RESET;
        this.torso = color + " /|\\" + Color.RESET;
        this.legs = color + " / \\" + Color.RESET;
    }

    public void setNPC(NPC npc) {
        switch (npc.getName()) {
            case "Rabuś" -> {
                this.npcHead = Color.GRAY + "  O  " + Color.RESET;
                this.npcTorso = Color.GRAY + " \\|/" + Color.RESET;
                this.npcLegs = Color.GRAY + " / \\" + Color.RESET;
            }
            case "npc1" -> { // do ustalenia
                this.npcHead = Color.YELLOW + "  O  " + Color.RESET;
                this.npcTorso = Color.YELLOW + " /|\\" + Color.RESET;
                this.npcLegs = Color.YELLOW + " / \\" + Color.RESET;
            }
            case "npc2" -> { // też do ustalenia
                this.npcHead = Color.RED + "  O  " + Color.RESET;
                this.npcTorso = Color.RED + " /|\\" + Color.RESET;
                this.npcLegs = Color.RED + " / \\" + Color.RESET;
            }
        }
    }

    public void setItem(Item item) {
        switch (item.getName()) {
            case "tv" -> {
                this.itemFirst = tv[0];
                this.itemSecond = tv[1];
                this.itemThird = tv[2];
                this.itemFourth = tv[3];
            }
            case "dresser" -> {
                this.itemFirst = dresser[0];
                this.itemSecond = dresser[1];
                this.itemThird = dresser[2];
                this.itemFourth = dresser[3];
            }
            case "table" -> {
                this.itemFirst = table[0];
                this.itemSecond = table[1];
                this.itemThird = table[2];
                this.itemFourth = table[3];
            }
            case "sofa" -> {
                this.itemFirst = sofa[0];
                this.itemSecond = sofa[1];
                this.itemThird = sofa[2];
                this.itemFourth = sofa[3];
            }
        }
    }
}
