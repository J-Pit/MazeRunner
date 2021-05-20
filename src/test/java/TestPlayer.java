import mazerunner.engine.GameEngine;
import mazerunner.engine.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPlayer {

    @Test
    void testOutOfBounds(){
        Player p = new Player();
        p.move("down");
        assertEquals(9,p.getPlayerX());
        assertEquals(0,p.getPlayerY());


    }
    @Test
    void testUpDown(){
        Player p = new Player();
        p.move("up");
        assertEquals(8,p.getPlayerX());
        assertEquals(0,p.getPlayerY());
        p.move("down");
        assertEquals(9,p.getPlayerX());
        assertEquals(0,p.getPlayerY());


    }
    @Test
    void testLeftRight(){
        Player p = new Player();

        p.move("right");
        assertEquals(9,p.getPlayerX());
        assertEquals(1,p.getPlayerY());
        p.move("left");
        assertEquals(9,p.getPlayerX());
        assertEquals(0,p.getPlayerY());


    }
}
