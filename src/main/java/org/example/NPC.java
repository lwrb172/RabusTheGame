package org.example;

import java.util.HashMap;
import java.util.Map;

public class NPC {
    private String name;
    private String description;
    private int friendshipLevel;
    private Map<Integer, String> spawnTimes;
    private Map<String, String> dialogues;

    public NPC(String name, String description) {
        this.name = name;
        this.description = description;
        this.friendshipLevel = 0;
        this.dialogues = new HashMap<>();
        this.spawnTimes = new HashMap<>();
    }

    private void initDialogues() {
        dialogues.put("greeting", "Hi, how it's going?");
        dialogues.put("work", "I should go to work");
        dialogues.put("angry", "Leave me alone!");
    }

    private void initSpawnTimes(int hour, String locationName) {
        spawnTimes.put(hour, locationName);
    }

    public String interact(String interactionType) {
        switch (interactionType.toLowerCase()) {
            case "talk":
                friendshipLevel = Math.min(friendshipLevel + 2, 100);
                return dialogues.get("greeting");
            case "gift":
                friendshipLevel = Math.min(friendshipLevel + 5, 100);
                return "Thanks!";
            default:
                return dialogues.get("greeting");

        }
    }

    public String getCurrentLocation(int currentHour) {
        return spawnTimes.get(currentHour);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getFriendshipLevel() {
        return friendshipLevel;
    }
}
