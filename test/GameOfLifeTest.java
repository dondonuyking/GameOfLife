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
    @Test
    public void testNewGameWithFourByFourMapReturnsAllCellStatus() {
        GameOfLife gameOfLife = new GameOfLife(4);
        assertEquals("0000000000000000",gameOfLife.getAllCellStatus());
    }
    @Test
    public void testNewGameWithTwoByTwoMapReturnsAllCellStatus() {
        GameOfLife gameOfLife = new GameOfLife(2);
        assertEquals("0000",gameOfLife.getAllCellStatus());
    }

    @Test
    public void testTwoDimensinonalNonSqaureWorld() {
        GameOfLife gameOfLife = new GameOfLife(3,2);
        assertEquals("3x2",gameOfLife.getWorld());
    }

    @Test
    public void testNewGameWithTwoByThreeMapReturnsAllCellStatus() {
        GameOfLife gameOfLife = new GameOfLife(2, 3);
        assertEquals("000000",gameOfLife.getAllCellStatus());
    }

    @Test
    public void testPlantSeedInFirstCell() {
        GameOfLife gameOfLife = new GameOfLife(2, 3);
        gameOfLife.plantSeed(0,0);
        assertEquals("100000",gameOfLife.getAllCellStatus());

    }
    @Test
    public void testPlantSeedInLastCell() {
        GameOfLife gameOfLife = new GameOfLife(2, 3);
        gameOfLife.plantSeed(1,2);
        assertEquals("000001",gameOfLife.getAllCellStatus());
    }
}
