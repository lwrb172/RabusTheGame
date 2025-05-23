package org.example.actions;

import org.example.entities.Player;
import org.example.gameManagement.TimeManager;

public class ChooseJob implements Action {
    @Override
    public void execute(Player player, TimeManager time) {
        player.getJob().chooseJob();
        player.setShouldNotUpdate();
    }

    @Override
    public String getName() {
        return "Choose job";
    }

    @Override
    public String getDescription() {
        return "Choose between three unique jobs.";
    }
}
