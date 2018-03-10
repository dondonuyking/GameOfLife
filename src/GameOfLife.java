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

        for (int x = 0; x < horizontalBorder ; x++)
        {
            for (int y = 0; y < verticalBorder; y++)
                    sb.append(gameOfLifeMap[x][y]);
        }
        return sb.toString();
    }

    public void plantSeed(int xCoordinate, int yCoordinate) {
     gameOfLifeMap[xCoordinate][yCoordinate] = '1';
    }

    public int getCellPosition(int xCoordinate, int yCoordinate) {

        return xCoordinate * yCoordinate;
    }

    public String getRightCell(int xCoordinate, int yCoordinate) {
        return String.valueOf(gameOfLifeMap[xCoordinate][yCoordinate+1]);
    }

    public String getLeftCell(int xCoordinate, int yCoordinate) {
        return String.valueOf(gameOfLifeMap[xCoordinate][yCoordinate-1]);
    }
    public String getTopCell(int xCoordinate, int yCoordinate) {
        return String.valueOf(gameOfLifeMap[xCoordinate-1][yCoordinate]);
    }
    public String getBottomCell(int xCoordinate, int yCoordinate) {
        return String.valueOf(gameOfLifeMap[xCoordinate+1][yCoordinate]);
    }
}

