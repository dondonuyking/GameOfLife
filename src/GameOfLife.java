import java.util.Arrays;

public class GameOfLife {

    private static int horizontalBorder;
    private static int verticalBorder;
    public static char[] gameOfLifeMap;

    public GameOfLife(int maxCoordinate) {
        initializeGameOfLifeMap(maxCoordinate,maxCoordinate);
    }

    public GameOfLife(int maxXCoordinate, int maxYCoordinate) {
        initializeGameOfLifeMap(maxXCoordinate,maxYCoordinate);
    }

    private void initializeGameOfLifeMap(int maxXCoordinate, int maxYCoordinate){
        horizontalBorder = maxXCoordinate;
        verticalBorder = maxYCoordinate;
        gameOfLifeMap = new char[getNumberOfCells()];
        Arrays.fill(gameOfLifeMap, '0');
    }
    public String getWorld () {
        return String.valueOf(horizontalBorder).concat("x").concat(String.valueOf(verticalBorder));
    }

    public int getNumberOfCells() {
        return horizontalBorder * verticalBorder;
    }

    public String getAllCellStatus() {
        return String.valueOf(gameOfLifeMap);
    }

    public void plantSeed(int xCoordinate, int yCoordinate) {
     gameOfLifeMap[0] = '1';
    }
}

