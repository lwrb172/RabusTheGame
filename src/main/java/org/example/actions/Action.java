package org.example.actions;

import org.example.entities.Player;
import org.example.gameManagment.TimeManager;

public interface Action {
    void execute(Player player, TimeManager time);
    String getName();
    String getDescription();
}
