package org.example.actions;

import org.example.entities.Player;
import org.example.gameManagment.TimeManager;

import java.util.Random;

public class WorkAction implements Action {
    private final Random rand = new Random();
    @Override
    public void execute(Player player, TimeManager time) {
        player.getJob().startJob(player.getJob().getJobName());
        player.decreaseStatsNoComment(15, 15, 15);
        player.setShouldNotUpdate();
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
