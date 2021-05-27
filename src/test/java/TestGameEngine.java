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
    void testMap(){
        GameEngine ge = new GameEngine(10);
        ge.createInitialMap();
        assertEquals(ge.getDifficulty(), ge.getCellCount("t"));

    }


}
