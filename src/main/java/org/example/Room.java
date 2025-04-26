package org.example;

public class Room {
    private String name;
    private int level;

    public Room(String name) {
        this.name = name;
        this.level = 0;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
