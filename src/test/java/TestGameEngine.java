import mazerunner.engine.GameEngine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGameEngine {
    @Test
    void testGetSize() {
        GameEngine ge = new GameEngine(10);

        assertEquals(10, ge.getSize());

    }

    @Test
    void testCells() {
        GameEngine ge = new GameEngine(10);
        ge.setDifficulty(5);
        ge.createInitialMap();

        assertEquals(5, ge.getNumOfApples());
        assertEquals(5, ge.getNumOfCoins());
        assertEquals(1, ge.getNumOfExits());
        assertEquals(5, ge.getNumOfTraps());

    }
}
