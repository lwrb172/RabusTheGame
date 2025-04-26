package org.example;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private String description;
    private List<Action> actions;
    private List<NPC> npcs;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.actions = new ArrayList<>();
        this.npcs = new ArrayList<>();
    }

    public void addAction(Action action) {
        this.actions.add(action);
    }

    public void removeAction(Action action) {
        this.actions.remove(action);
    }

    public void displayActions() {
        for (Action action : actions) {
            System.out.println(action);
        }
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);
    }

    public List<NPC> getNpcs() {
        return new ArrayList<>(npcs);
    }

    public String getName() {
        return name;
    }

    public List<Action> getActions() {
        return actions;
    }

    public String getDescription() {
        return description;
    }
}
