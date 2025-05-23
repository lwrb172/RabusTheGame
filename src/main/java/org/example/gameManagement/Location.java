package org.example.gameManagement;

import org.example.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private String description;
    private List<Action> actions;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.actions = new ArrayList<>();
    }

    public void addAction(Action action) {
        this.actions.add(action);
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

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", actions=" + actions +
                '}';
    }
}
