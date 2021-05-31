import mazerunner.engine.GameEngine;
import mazerunner.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertEquals(5,ge.getCellCount("c"));
        assertEquals(10 - ge.getDifficulty(),ge.getCellCount("a"));
        assertEquals(1,ge.getCellCount("e"));

    }

    @Test
    void testPickup(){
        GameEngine ge = new GameEngine(10);
        Player p = new Player();
        ge.createInitialMap();
        ge.setCell(8,0,"c");
        p.move("up");
        ge.onEnter(p);
        assertEquals(1, p.getCoins());
        ge.setCell(7,0,"a");
        p.move("up");
        ge.onEnter(p);
        assertEquals(13,p.getStamina());
        ge.setCell(7,1,"t");
        p.move("right");
        ge.onEnter(p);
        assertEquals(0,p.getCoins());
    }
    @Test
    void testTrap(){
        GameEngine ge = new GameEngine(10);
        Player p = new Player();
        ge.createInitialMap();
        ge.setCell(8,0,"t");
        p.move("up");
        ge.onEnter(p);
        assertTrue(ge.isEnd());
    }
    @Test
    void testExit(){
        GameEngine ge = new GameEngine(10);
        Player p = new Player();
        ge.createInitialMap();
        ge.setCell(8,0,"e");
        p.move("up");
        ge.onEnter(p);
        assertTrue(ge.isEnd());
    }


}
