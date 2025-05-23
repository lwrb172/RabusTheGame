package org.example.actions;

import org.example.entities.Player;
import org.example.gameManagement.TimeManager;

public interface Action {
    void execute(Player player, TimeManager time);
    String getName();
    String getDescription();
}
