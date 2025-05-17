package org.example.frames;

public enum Color {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    CYAN("\033[36m"),
    BLUE("\u001B[34m"),
    YELLOW("\u001B[33m"),
    PINK("\u001B[35m"),
    PURPLE("\u001B[35m"),
    GRAY("\u001B[90m"),
    BROWN("\u001B[38;5;94m"),
    DARKBROWN("\u001B[38;5;94m"),
    BLACK("\u001B[30m"),
    WHITE("\u001B[37m"),
    RESET("\u001B[0m");

    private final String color;

    Color(String color) { this.color = color; }

    @Override
    public String toString() { return color; }

    public static String toMyString(Color color) {
        return switch (color) {
            case Color.RED -> "red";
            case Color.GREEN -> "green";
            case Color.CYAN -> "cyan";
            case Color.BLUE -> "blue";
            case Color.YELLOW -> "yellow";
            case Color.PINK -> "pink";
            case Color.PURPLE -> "purple";
            case Color.GRAY -> "gray";
            case Color.BROWN -> "brown";
            case Color.DARKBROWN -> "darkbrown";
            case Color.BLACK -> "black";
            case Color.WHITE -> "white";
            default -> null;
        };
    }

    public static Color toColor(String color) {
        return switch (color) {
            case "red" -> Color.RED;
            case "green" -> Color.GREEN;
            case "cyan" -> Color.CYAN;
            case "blue" -> Color.BLUE;
            case "yellow" -> Color.YELLOW;
            case "pink" -> Color.PINK;
            case "purple" -> Color.PURPLE;
            case "gray" -> Color.GRAY;
            case "brown" -> Color.BROWN;
            case "darkbrown" -> Color.DARKBROWN;
            case "black" -> Color.BLACK;
            case "white" -> Color.WHITE;
            default -> null;
        };
    }
}
