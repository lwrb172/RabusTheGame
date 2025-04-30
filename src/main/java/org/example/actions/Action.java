package org.example.actions;

import org.example.Player;
import org.example.TimeManager;

public interface Action {
    void execute(Player player, TimeManager time);
    String getName();
    String getDescription();
}
