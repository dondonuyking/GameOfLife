import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {
    @Test
    public void testNewOnebyOneWorld() {
        assertEquals("1x1",(new GameOfLife()).getWorld());
    }
}
