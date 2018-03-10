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

    private static GameOfLife gameOfLife;

    @Before
    public void setUp() throws Exception {
        gameOfLife = new GameOfLife(2,3);
    }

    @Test
    public void testTwoDimensinonalNonSqaureWorld() {
        assertEquals("2x3",gameOfLife.getWorld());
    }

    @Test
    public void testNewGameWithTwoByThreeMapReturnsAllCellStatus() {
        assertEquals("000000",gameOfLife.getAllCellStatus());
    }

    @Test
    public void testPlantSeedInFirstCell() {
        gameOfLife.plantSeed(0,0);
        assertEquals("100000",gameOfLife.getAllCellStatus());

    }
    @Test
    public void testPlantSeedInLastCell() {
        gameOfLife.plantSeed(1,2);
        assertEquals("000001",gameOfLife.getAllCellStatus());
    }
    @Test
    public void testPlantSeedsAtFirstAndLastCell() {
        gameOfLife.plantSeed(1, 2);
        gameOfLife.plantSeed(0, 0);
        assertEquals("100001", gameOfLife.getAllCellStatus());
    }
    @Test
    public void testPlantSeedAtSecondCell(){
        gameOfLife.plantSeed(0, 1);
        assertEquals("010000", gameOfLife.getAllCellStatus());
    }
    @Test
    public void testPlantSeedAtThirdCell(){
        gameOfLife.plantSeed(0, 2);
        assertEquals("001000", gameOfLife.getAllCellStatus());
    }
    @Test
    public void testPlantSeedAtThirdAndFourthCell(){
        gameOfLife.plantSeed(0, 2);
        gameOfLife.plantSeed(1, 0);
        assertEquals("001100", gameOfLife.getAllCellStatus());
    }
    @Test
    public void testGetRightCell(){
        assertEquals("0", gameOfLife.getRightCell(0, 0));
    }
    @Test
    public void testGetLeftCell(){
        assertEquals("0", gameOfLife.getLeftCell(0, 1));
    }
    @Test
    public void testGetTopCell(){
        assertEquals("0", gameOfLife.getTopCell(1, 0));
    }
    @Test
    public void testGetBottomtCell(){
        assertEquals("0", gameOfLife.getBottomCell(0, 1));
    }
}
