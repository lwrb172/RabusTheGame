package org.example.gameManagement;

public class Item {
    private final String name;
    private final String description;
    private final int price;
    private final String type;
    private final int effectValue;
    private String place = "";

    public Item(String name, String description, int price, String type, int effectValue) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.effectValue = effectValue;
    }

    public Item(String name, String description, int price, String type, int effectValue, String place) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.effectValue = effectValue;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getEffectValue() {
        return effectValue;
    }

    public String getPlace() { return place; }
}
