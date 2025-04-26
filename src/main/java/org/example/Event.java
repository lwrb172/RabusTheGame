package org.example;

public abstract class Event {
    protected String name;
    protected String description;

    public abstract boolean timeTrigger(TimeManager time);
    public abstract void trigger(Player player);
}
