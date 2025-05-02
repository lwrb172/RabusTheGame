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

    private String head;
    private String torso;
    private String legs;

    private String itemFirst;
    private String itemSecond;
    private String itemThird;

    private String npcHead;
    private String npcTorso;
    private String npcLegs;

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

    public void printHouse() {
        System.out.println("\n----------------------------------------");
        System.out.print(
                String.format(
                        "|   ____                         ____  |\n" +
                        "|  |    |  %s %s    %s   |    | |\n" +
                        "|  | o  |  %s  %s    %s   | o  | |\n" +
                        "|  |____|  %s  %s    %s   |____| |",
                        this.head, this.npcHead, this.itemFirst,
                        this.torso, this.npcTorso, this.itemSecond,
                        this.legs, this.npcLegs, this.itemThird
                )
        );
        System.out.println("\n----------------------------------------");
    }

    public void setPlayerColor(Color color) {
        this.head = color + "  O  " + Color.RESET;
        this.torso = color + " /|\\" + Color.RESET;
        this.legs = color + " / \\" + Color.RESET;
    }
}
