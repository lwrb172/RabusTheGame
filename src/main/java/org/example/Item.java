package org.example;

public class Item {
    private String name;
    private String description;
    private int price;
    private String type;
    private int effectValue;

    public Item(String name, String description, int price, String type, int effectValue) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.effectValue = effectValue;
    }

    public void use(Player player) {

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
}
