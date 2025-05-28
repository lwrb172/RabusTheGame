package org.example.gameManagement;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class gameManagerTest {
    private GameManager gameManager;

    @Before
    public void setUp() throws Exception {
        gameManager = new GameManager();
    }

    @Test
    public void testRunInit() {
        assertFalse(gameManager.isRunning());
    }

    @Test
    public void testRun() {
        gameManager.setRunning(true);
        assertTrue(gameManager.isRunning());
    }

}
