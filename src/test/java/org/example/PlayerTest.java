package org.example;

import org.example.entities.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("test", "red");
    }

    @Test
    void testUpdateHungerAndEnergy() {
        player.setHunger(100);
        player.setEnergy(100);
        player.update();
        assertTrue(player.getHunger() < 100);
        assertTrue(player.getEnergy() < 100);
    }

    @Test
    void testAddAndLoseCoins() {
        int initialCoins = player.getCoins();
        player.addCoins(10);
        assertEquals(initialCoins + 10, player.getCoins());

        player.loseCoins(5);
        assertEquals(initialCoins + 5, player.getCoins());
    }
}
