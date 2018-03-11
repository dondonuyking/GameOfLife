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
        if (yCoordinate >= verticalBorder -1) {
            return " ";
        }
        return String.valueOf(gameOfLifeMap[xCoordinate][yCoordinate+1]);
    }

    public String getLeftCell(int xCoordinate, int yCoordinate) {
        if (yCoordinate <= 0) {
            return " ";
        }
        return String.valueOf(gameOfLifeMap[xCoordinate][yCoordinate-1]);
    }
    public String getTopCell(int xCoordinate, int yCoordinate) {
        if (xCoordinate <= 0) {
            return " ";
        }
        return String.valueOf(gameOfLifeMap[xCoordinate-1][yCoordinate]);
    }
    public String getBottomCell(int xCoordinate, int yCoordinate) {
        if (xCoordinate >= horizontalBorder-1) {
            return " ";
        }
        return String.valueOf(gameOfLifeMap[xCoordinate+1][yCoordinate]);
    }
    public String getTopLeftCell(int xCoordinate, int yCoordinate) {
        if ((xCoordinate <= 0) || (yCoordinate <=0)) {
            return " ";
        }
        return String.valueOf(gameOfLifeMap[xCoordinate-1][yCoordinate-1]);
    }
    public String getTopRightCell(int xCoordinate, int yCoordinate) {
        if ((xCoordinate <= 0) || (yCoordinate >= verticalBorder -1)) {
            return " ";
        }
        return String.valueOf(gameOfLifeMap[xCoordinate-1][yCoordinate+1]);
    }
    public String getBottomLeftCell(int xCoordinate, int yCoordinate) {
        if ((xCoordinate >= horizontalBorder-1) || (yCoordinate <=0)) {
            return " ";
        }
        return String.valueOf(gameOfLifeMap[xCoordinate+1][yCoordinate-1]);
    }
    public String getBottomRightCell(int xCoordinate, int yCoordinate) {
        if ((xCoordinate >= horizontalBorder -1) || (yCoordinate >= verticalBorder-1)) {
            return " ";
        }
        return String.valueOf(gameOfLifeMap[xCoordinate+1][yCoordinate+1]);
    }

    public int getNumberOfLivingNeighbors(int xCoordinate, int yCoordinate) {
        return
        integerValueOfLiveCell(getLeftCell(xCoordinate,yCoordinate)) +
                integerValueOfLiveCell(getRightCell(xCoordinate,yCoordinate)) +
                        integerValueOfLiveCell(getTopCell(xCoordinate,yCoordinate)) +
                                integerValueOfLiveCell(getBottomCell(xCoordinate,yCoordinate)) +
                                        integerValueOfLiveCell(getTopLeftCell(xCoordinate,yCoordinate)) +
                                                integerValueOfLiveCell(getBottomLeftCell(xCoordinate,yCoordinate)) +
                                                        integerValueOfLiveCell(getTopRightCell(xCoordinate,yCoordinate)) +
                                                                integerValueOfLiveCell(getBottomRightCell(xCoordinate,yCoordinate));

    }

    public int integerValueOfLiveCell(String stringValueOfCell){
        if (stringValueOfCell.equals(" ")) {
            return 0;
        };
        return Integer.parseInt(stringValueOfCell);
    }

    public int getNumberOfLDeadNeighbors(int xCoordinate, int yCoordinate) {
        return
                integerValueOfDeadCell(getLeftCell(xCoordinate,yCoordinate)) +
                        integerValueOfDeadCell(getRightCell(xCoordinate,yCoordinate)) +
                        integerValueOfDeadCell(getTopCell(xCoordinate,yCoordinate)) +
                        integerValueOfDeadCell(getBottomCell(xCoordinate,yCoordinate)) +
                        integerValueOfDeadCell(getTopLeftCell(xCoordinate,yCoordinate)) +
                        integerValueOfDeadCell(getBottomLeftCell(xCoordinate,yCoordinate)) +
                        integerValueOfDeadCell(getTopRightCell(xCoordinate,yCoordinate)) +
                        integerValueOfDeadCell(getBottomRightCell(xCoordinate,yCoordinate));


    }

    private int integerValueOfDeadCell(String stringValueOfCell) {
        if (stringValueOfCell.equals(" ") || stringValueOfCell.equals("1")) {
            return 0;
        };
        return 1;
    }
}

