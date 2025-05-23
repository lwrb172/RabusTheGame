package org.example.events;

import org.example.entities.Player;
import org.example.gameManagement.TimeManager;

public interface Event {
    boolean timeTrigger(TimeManager time);
    void trigger(Player player);
    String getName();
    String getDescription();
}
