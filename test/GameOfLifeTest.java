import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {

    @Test
    public void testNewOnebyOneWorld() {
        GameOfLife gameOfLife = new GameOfLife(1);
        assertEquals("1x1",gameOfLife.getWorld());
    }
    @Test
    public void testNewThreebyThreeWorld() {
        GameOfLife gameOfLife = new GameOfLife(3);
        assertEquals("3x3",gameOfLife.getWorld());
    }
    @Test
    public void testGetNumberOfCells() {
        GameOfLife gameOfLife = new GameOfLife(3);
        assertEquals(9,gameOfLife.getNumberOfCells());
    }
}
