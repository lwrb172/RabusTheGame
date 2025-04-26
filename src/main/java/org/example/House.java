package org.example;

import java.util.ArrayList;
import java.util.List;

public class House {
    private String name;
    private int upgradeLevel;
    private List<Room> rooms;

    public House() {
        this.name = "House Test";
        this.upgradeLevel = 0;
        this.rooms = new ArrayList<>();
        initDefaultRooms();
    }

    public void upgrade() {
        if (upgradeLevel >= 5) {
            System.out.println("House is already on max level.");
        }
        upgradeLevel++;
        System.out.println("House successfully upgraded to level: " + getUpgradeLevel() + "!");
    }

    private void initDefaultRooms() {
        rooms.add(new Room("Kitchen"));
        rooms.add(new Room("Bathroom"));
        rooms.add(new Room("Bedroom"));
    }

    public void showRooms() {
        for (Room room : rooms) {
            System.out.println(room.getName() + " (Lvl: " + room.getLevel() + ")");
        }
    }

    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    public String getName() {
        return name;
    }
}
