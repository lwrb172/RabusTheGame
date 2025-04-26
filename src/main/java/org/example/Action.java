package org.example;

public class Action {
    private String name;
    private String description;
    private int energyCost;
    private int timeCost;

    public Action(String name, String description, int energyCost, int timeCost) {
        this.name = name;
        this.description = description;
        this.energyCost = energyCost;
        this.timeCost = timeCost;
    }

    public void execute(Player player, TimeManager time) {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
