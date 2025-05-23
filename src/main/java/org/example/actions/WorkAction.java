package org.example.actions;

import org.example.entities.Player;
import org.example.gameManagement.TimeManager;

import java.util.Random;

public class WorkAction implements Action {
    @Override
    public void execute(Player player, TimeManager time) {
        player.getJob().startJob(player.getJob().getJobName());
    }

    @Override
    public String getName() {
        return "Work";
    }

    @Override
    public String getDescription() {
        return "Go to work to earn coins and points.";
    }
}
