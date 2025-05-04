package org.example;

public enum Color {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
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
}
