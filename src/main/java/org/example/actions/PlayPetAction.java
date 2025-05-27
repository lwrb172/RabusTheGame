package org.example.actions;

import org.example.entities.Player;
import org.example.entities.pet.PetType;
import org.example.frames.Frame;
import org.example.gameManagement.TimeManager;
import org.example.gameManagement.UserInterface;

public class PlayPetAction implements Action{
    private final Frame frame;

    public PlayPetAction(Frame frame) {
        this.frame = frame;
    }

    public void execute(Player player, TimeManager time) {
        UserInterface.clearScreen();
        if (player.getPet().getType().equals(PetType.NONE)) {
            System.out.println("You don't have a pet :(");
        } else {
            if (player.getPetType().equals(PetType.CAT)) {
                frame.printCat();
            } else {
                frame.printDog();
            }
            System.out.println(player.getPetName() + " is happy to be with you.");
        }
        player.setShouldNotUpdate();
        UserInterface.threadSleep(3000);
    }

    public String getName() { return "Play with your pet"; }

    public String getDescription() { return "He really wants to play with you."; }
}
