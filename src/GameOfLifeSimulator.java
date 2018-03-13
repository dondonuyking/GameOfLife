public class GameOfLifeSimulator
{

    public static void main(String args[]) {
        GameOfLife gameOfLife = new GameOfLife(5);
        gameOfLife.plantSeed(0,1);
        gameOfLife.plantSeed(0,3);
        gameOfLife.plantSeed(0,4);

        gameOfLife.plantSeed(1,1);
        gameOfLife.plantSeed(2,1);
        gameOfLife.plantSeed(3,1);
        gameOfLife.plantSeed(4,1);

        for (int ticks = 0; ticks < 10; ticks++ ) {
          gameOfLife.tick();
          System.out.println(gameOfLife.getAllCellStatus());
        }
    }

}
