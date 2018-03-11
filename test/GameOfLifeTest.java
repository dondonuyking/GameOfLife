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
        gameOfLife.plantSeed(0,1);
        assertEquals("1", gameOfLife.getRightCell(0, 0));
    }
    @Test
    public void testGetLeftCell(){
        gameOfLife.plantSeed(0,0);
        assertEquals("1", gameOfLife.getLeftCell(0, 1));
    }
    @Test
    public void testGetTopCell(){
        gameOfLife.plantSeed(0,0);
        assertEquals("1", gameOfLife.getTopCell(1, 0));
    }
    @Test
    public void testGetBottomtCell(){
        gameOfLife.plantSeed(1,1);
        assertEquals("1", gameOfLife.getBottomCell(0, 1));
    }
    @Test
    public void testGetTopLeftCell(){
        gameOfLife.plantSeed(0,0);
        assertEquals("1", gameOfLife.getTopLeftCell(1, 1));
    }
    @Test
    public void testGetTopRightCell(){
        gameOfLife.plantSeed(0,2);
        assertEquals("1", gameOfLife.getTopRightCell(1, 1));
    }
    @Test
    public void testGetBottomLeftCell(){
        gameOfLife.plantSeed(1,1);
        assertEquals("1", gameOfLife.getBottomLeftCell(0, 2));
    }
    @Test
    public void testGetBottompRightCell(){
        gameOfLife.plantSeed(1,2);
        assertEquals("1", gameOfLife.getBottomRightCell(0, 1));
    }
    @Test
    public void testGetHorizontalAndVertiacalBorderIfCellAlReadyInEdge(){
        assertEquals("0", gameOfLife.getLeftCell(0, 0));
        assertEquals("0", gameOfLife.getRightCell(0, 2));
        assertEquals("0", gameOfLife.getTopCell(0, 0));
        assertEquals("0", gameOfLife.getBottomCell(1, 0));
    }
    @Test
    public void testDiagonalBordersIfCellAlreadyInTheEdge(){
        assertEquals("0", gameOfLife.getTopLeftCell(0, 0));
        assertEquals("0", gameOfLife.getTopRightCell(0, 0));
        assertEquals("0", gameOfLife.getBottomRightCell(1, 0));
        assertEquals("0", gameOfLife.getTopLeftCell(0, 0));
        assertEquals("0", gameOfLife.getBottomLeftCell(0, 0));
        assertEquals("0", gameOfLife.getTopRightCell(0, 0));
        assertEquals("0", gameOfLife.getBottomRightCell(1, 0));
    }
    @Test
    public void testGetNumberOfLivingNeighbors(){
        assertEquals(0, gameOfLife.getNumberOfLivingNeighbors(0, 0));
        assertEquals(0, gameOfLife.getNumberOfLivingNeighbors(0, 1));
        assertEquals(0, gameOfLife.getNumberOfLivingNeighbors(0, 2));
        assertEquals(0, gameOfLife.getNumberOfLivingNeighbors(1, 0));
        assertEquals(0, gameOfLife.getNumberOfLivingNeighbors(1, 1));
        assertEquals(0, gameOfLife.getNumberOfLivingNeighbors(1, 2));
    }

    @Test
    public void testGetNumberOfLivingNeighborsGivenOneLivingCell(){
       gameOfLife.plantSeed(0,0);
       assertEquals(0, gameOfLife.getNumberOfLivingNeighbors(0, 0));
       assertEquals(1, gameOfLife.getNumberOfLivingNeighbors(0, 1));
       assertEquals(0, gameOfLife.getNumberOfLivingNeighbors(0, 2));
       assertEquals(1, gameOfLife.getNumberOfLivingNeighbors(1, 0));
       assertEquals(1, gameOfLife.getNumberOfLivingNeighbors(1, 1));
       assertEquals(0, gameOfLife.getNumberOfLivingNeighbors(1, 2));
    }
    @Test
    public void testGetNumberOfLivingNeighborsGivenThreeLivingCells(){
        gameOfLife.plantSeed(0,0);
        gameOfLife.plantSeed(0,1);
        gameOfLife.plantSeed(1,0);
        assertEquals(2, gameOfLife.getNumberOfLivingNeighbors(0, 0));
        assertEquals(2, gameOfLife.getNumberOfLivingNeighbors(0, 1));
        assertEquals(1, gameOfLife.getNumberOfLivingNeighbors(0, 2));
        assertEquals(2, gameOfLife.getNumberOfLivingNeighbors(1, 0));
        assertEquals(3, gameOfLife.getNumberOfLivingNeighbors(1, 1));
        assertEquals(1, gameOfLife.getNumberOfLivingNeighbors(1, 2));
    }
    @Test
    public void testGetNumberOfLivingNeighborsGivenFiveLivingCells(){
        gameOfLife.plantSeed(0,0);
        gameOfLife.plantSeed(0,1);
        gameOfLife.plantSeed(1,0);
        gameOfLife.plantSeed(1,1);
        gameOfLife.plantSeed(1,2);
        assertEquals(3, gameOfLife.getNumberOfLivingNeighbors(0, 0));
        assertEquals(4, gameOfLife.getNumberOfLivingNeighbors(0, 1));
        assertEquals(3, gameOfLife.getNumberOfLivingNeighbors(0, 2));
        assertEquals(3, gameOfLife.getNumberOfLivingNeighbors(1, 0));
        assertEquals(4, gameOfLife.getNumberOfLivingNeighbors(1, 1));
        assertEquals(2, gameOfLife.getNumberOfLivingNeighbors(1, 2));

    }
    @Test
    public void testGetNumberOfLivingNeighborsGivenFiveLivingCellsAndOneZeroIsDead(){
        gameOfLife.plantSeed(0,0);
        gameOfLife.plantSeed(0,1);
        gameOfLife.plantSeed(0,2);
        gameOfLife.plantSeed(1,1);
        gameOfLife.plantSeed(1,2);
        assertEquals(2, gameOfLife.getNumberOfLivingNeighbors(0, 0));
        assertEquals(4, gameOfLife.getNumberOfLivingNeighbors(0, 1));
        assertEquals(3, gameOfLife.getNumberOfLivingNeighbors(0, 2));
        assertEquals(3, gameOfLife.getNumberOfLivingNeighbors(1, 0));
        assertEquals(4, gameOfLife.getNumberOfLivingNeighbors(1, 1));
        assertEquals(3, gameOfLife.getNumberOfLivingNeighbors(1, 2));

    }
    @Test
    public void testIfCellShouldLiveInNextGeneration(){
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(0, 0));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(0, 1));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(0, 2));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 0));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 1));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 2));
    }
    @Test
    public void testIfCellShouldLiveInNextGenerationWithOneLivingCell(){
        gameOfLife.plantSeed(0,0);
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(0, 0));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(0, 1));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(0, 2));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 0));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 1));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 2));
    }
    @Test
    public void testIfCellShouldLiveInNextGenerationWithTwoLivingCells(){
        gameOfLife.plantSeed(0,0);
        gameOfLife.plantSeed(0,1);
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(0, 0));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(0, 1));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(0, 2));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 0));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 1));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 2));
    }
    @Test
    public void testIfCellShouldLiveInNextGenerationWithThreeLivingCells(){
        gameOfLife.plantSeed(0,0);
        gameOfLife.plantSeed(0,1);
        gameOfLife.plantSeed(0,2);
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(0, 0));
        assertEquals(true, gameOfLife.shouldLiveInNextGeneration(0, 1));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(0, 2));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 0));
        assertEquals(true, gameOfLife.shouldLiveInNextGeneration(1, 1));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 2));
    }
    @Test
    public void testIfCellShouldLiveInNextGenerationWithFourLivingCells(){
        gameOfLife.plantSeed(0,0);
        gameOfLife.plantSeed(0,1);
        gameOfLife.plantSeed(0,2);
        gameOfLife.plantSeed(1,2);
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(0, 0));
        assertEquals(true, gameOfLife.shouldLiveInNextGeneration(0, 1));
        assertEquals(true, gameOfLife.shouldLiveInNextGeneration(0, 2));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 0));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 1));
        assertEquals(true, gameOfLife.shouldLiveInNextGeneration(1, 2));
    }

    @Test
    public void testIfCellShouldLiveInNextGenerationWithFiveLivingCells(){
        gameOfLife.plantSeed(0,0);
        gameOfLife.plantSeed(0,1);
        gameOfLife.plantSeed(0,2);
        gameOfLife.plantSeed(1,1);
        gameOfLife.plantSeed(1,2);
        assertEquals(true, gameOfLife.shouldLiveInNextGeneration(0, 0));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(0, 1));
        assertEquals(true, gameOfLife.shouldLiveInNextGeneration(0, 2));
        assertEquals(true, gameOfLife.shouldLiveInNextGeneration(1, 0));
        assertEquals(false, gameOfLife.shouldLiveInNextGeneration(1, 1));
        assertEquals(true, gameOfLife.shouldLiveInNextGeneration(1, 2));
    }
    @Test
    public void testKillCellIfShouldDieInNextGeneration(){
        gameOfLife.plantSeed(0,0);
        gameOfLife.plantSeed(0,1);
        gameOfLife.plantSeed(0,2);
        gameOfLife.plantSeed(1,1);
        gameOfLife.plantSeed(1,2);
        gameOfLife.initializeGameOfLifeMapSnapShot();
        assertEquals("111011",gameOfLife.getAllCellStatus());
        if (!gameOfLife.shouldLiveInNextGeneration(0, 1)) {
            gameOfLife.killCell(0,1);
         }
        assertEquals("101011",gameOfLife.getSnapShotCellStatus());
    }

    @Test
    public void testKillMultipleCellsIfShouldDieinNextGeneration(){
        gameOfLife.plantSeed(0,0);
        gameOfLife.plantSeed(0,1);
        gameOfLife.plantSeed(0,2);
        gameOfLife.plantSeed(1,1);
        gameOfLife.plantSeed(1,2);
        gameOfLife.initializeGameOfLifeMapSnapShot();
        assertEquals("111011",gameOfLife.getAllCellStatus());
        assertEquals("111011",gameOfLife.getSnapShotCellStatus());
        if (!gameOfLife.shouldLiveInNextGeneration(0, 1)) {
            gameOfLife.killCell(0,1);
        }
        assertEquals("111011",gameOfLife.getAllCellStatus());
        assertEquals("101011",gameOfLife.getSnapShotCellStatus());
        if (!gameOfLife.shouldLiveInNextGeneration(1, 1)) {
            gameOfLife.killCell(1,1);
        }
        assertEquals("111011",gameOfLife.getAllCellStatus());
        assertEquals("101001",gameOfLife.getSnapShotCellStatus());

    }
    @Test
    public void testGetSnapShotBeforeNextGeneration(){
        gameOfLife.plantSeed(0,0);
        gameOfLife.plantSeed(0,1);
        gameOfLife.plantSeed(0,2);
        gameOfLife.plantSeed(1,1);
        gameOfLife.plantSeed(1,2);
        gameOfLife.initializeGameOfLifeMapSnapShot();
        assertEquals(gameOfLife.getAllCellStatus(),gameOfLife.getSnapShotCellStatus());

    }

    @Test
    public void testTick() {
        gameOfLife.plantSeed(0,0);
        gameOfLife.plantSeed(0,1);
        gameOfLife.plantSeed(0,2);
        gameOfLife.plantSeed(1,1);
        gameOfLife.plantSeed(1,2);
        gameOfLife.tick();
        assertEquals("101101",gameOfLife.getAllCellStatus());
    }
}