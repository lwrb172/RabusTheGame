package org.example.actions;

import org.example.entities.Player;
import org.example.gameManagment.TimeManager;

public class TalkAction implements Action {

    @Override
    public void execute(Player player, TimeManager time) {

    }

    @Override
    public String getName() {
        return "Talk";
    }

    @Override
    public String getDescription() {
        return "talk to the npc.";
    }
}
