import java.util.Arrays;

public class GameOfLife {

    private static int horizontalBorder;
    private static int verticalBorder;
    public static char[][] gameOfLifeMap;

    public GameOfLife(int maxCoordinate) {
        initializeGameOfLifeMap(maxCoordinate,maxCoordinate);
    }

    public GameOfLife(int maxXCoordinate, int maxYCoordinate) {
        initializeGameOfLifeMap(maxXCoordinate,maxYCoordinate);
    }

    private void initializeGameOfLifeMap(int maxXCoordinate, int maxYCoordinate){
        horizontalBorder = maxXCoordinate;
        verticalBorder = maxYCoordinate;
        gameOfLifeMap = new char[horizontalBorder][verticalBorder];

        for (int i = 0; i < horizontalBorder ; i++)
        {
            for (int j = 0; j < verticalBorder; j++)
                gameOfLifeMap[i][j] = '0';
        }


    }
    public String getWorld () {
        return String.valueOf(horizontalBorder).concat("x").concat(String.valueOf(verticalBorder));
    }

    public int getNumberOfCells() {
        return horizontalBorder * verticalBorder;
    }

    public String getAllCellStatus() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < horizontalBorder ; i++)
        {
            for (int j = 0; j < verticalBorder; j++)
                    sb.append(gameOfLifeMap[i][j]);
        }
        return sb.toString();
    }

    public void plantSeed(int xCoordinate, int yCoordinate) {
     gameOfLifeMap[xCoordinate][yCoordinate] = '1';
    }

    public int getCellPosition(int xCoordinate, int yCoordinate) {

        return xCoordinate * yCoordinate;
    }
}

