package org.example.entities;

import org.example.entities.pet.Pet;
import org.example.entities.pet.PetType;
import org.example.gameManagement.ScoreAndCoins;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    private Player player;
    private Pet pet;
    private ScoreAndCoins scoreAndCoins;

    @Before
    public void setUp() throws Exception {
        pet = new Pet("Test", PetType.DOG);
        scoreAndCoins = new ScoreAndCoins();
        player = new Player("JakiśPlayer", "red", pet, scoreAndCoins);
    }

    @Test
    public void testAddAndLoseCoins() {
        // ma 50
        player.addCoins(50);
        assertEquals(100, player.getCoins());

        player.loseCoins(20);
        assertEquals(80, player.getCoins());
    }

    @Test
    public void testInventoryInit() {
        assertEquals(2, player.getInventory().size());
        assertEquals("Apple", player.getInventory().get(0).getName());
        assertEquals("Banana", player.getInventory().get(1).getName());
    }
}
