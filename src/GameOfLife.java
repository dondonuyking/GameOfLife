public class GameOfLife {

    private static int maxRows;
    private static int maxColumns;
    public static char[][] gameOfLifeMap;

    public GameOfLife(int maxRowAndColums) {
        initializeGameOfLifeMap(maxRowAndColums,maxRowAndColums);
    }

    public GameOfLife(int inputMaxRow, int inputMaxColumn) {
        initializeGameOfLifeMap(inputMaxRow,inputMaxColumn);
    }

    private void initializeGameOfLifeMap(int inputMaxRow, int inputMaxColumn){
        maxRows = inputMaxRow;
        maxColumns = inputMaxColumn;
        gameOfLifeMap = new char[maxRows][maxColumns];

        for (int cellRow = 0; cellRow < maxRows; cellRow++)
        {
            for (int cellColumn = 0; cellColumn < maxColumns; cellColumn++)
                gameOfLifeMap[cellRow][cellColumn] = '0';
        }


    }
    public String getWorld () {
        return String.valueOf(maxRows).concat("x").concat(String.valueOf(maxColumns));
    }

    public String getAllCellStatus() {
        StringBuffer sb = new StringBuffer();

        for (int row = 0; row < maxRows; row++)
        {
            for (int column = 0; column < maxColumns; column++)
                    sb.append(gameOfLifeMap[row][column]);
        }
        return sb.toString();
    }

    public void plantSeed(int row, int column) {
     gameOfLifeMap[row][column] = '1';
    }

    public String getRightCell(int row, int column) {
        if (column >= maxColumns -1) {
            return "0";
        }
        return String.valueOf(gameOfLifeMap[row][column+1]);
    }

    public String getLeftCell(int row, int column) {
        if (column <= 0) {
            return "0";
        }
        return String.valueOf(gameOfLifeMap[row][column-1]);
    }
    public String getTopCell(int row, int column) {
        if (row <= 0) {
            return "0";
        }
        return String.valueOf(gameOfLifeMap[row-1][column]);
    }
    public String getBottomCell(int row, int column) {
        if (row >= maxRows -1) {
            return "0";
        }
        return String.valueOf(gameOfLifeMap[row+1][column]);
    }
    public String getTopLeftCell(int row, int column) {
        if ((row <= 0) || (column <=0)) {
            return "0";
        }
        return String.valueOf(gameOfLifeMap[row-1][column-1]);
    }
    public String getTopRightCell(int row, int column) {
        if ((row <= 0) || (column >= maxColumns -1)) {
            return "0";
        }
        return String.valueOf(gameOfLifeMap[row-1][column+1]);
    }
    public String getBottomLeftCell(int row, int column) {
        if ((row >= maxRows -1) || (column <=0)) {
            return "0";
        }
        return String.valueOf(gameOfLifeMap[row+1][column-1]);
    }
    public String getBottomRightCell(int row, int column) {
        if ((row >= maxRows -1) || (column >= maxColumns -1)) {
            return "0";
        }
        return String.valueOf(gameOfLifeMap[row+1][column+1]);
    }

    public int getNumberOfLivingNeighbors(int row, int column) {
        return
        integerValueOfLiveCell(getLeftCell(row,column)) +
                integerValueOfLiveCell(getRightCell(row,column)) +
                        integerValueOfLiveCell(getTopCell(row,column)) +
                                integerValueOfLiveCell(getBottomCell(row,column)) +
                                        integerValueOfLiveCell(getTopLeftCell(row,column)) +
                                                integerValueOfLiveCell(getBottomLeftCell(row,column)) +
                                                        integerValueOfLiveCell(getTopRightCell(row,column)) +
                                                                integerValueOfLiveCell(getBottomRightCell(row,column));

    }

    public int integerValueOfLiveCell(String stringValueOfCell){
         return Integer.parseInt(stringValueOfCell);
    }

    public boolean shouldLiveInNextGeneration(int row, int column) {
        int liveNeighbors = getNumberOfLivingNeighbors(row,column);

        if ("0".equals(String.valueOf(gameOfLifeMap[row][column])) && liveNeighbors == 3){
            return true;
        }
        if ("1".equals(String.valueOf(gameOfLifeMap[row][column])) && (liveNeighbors == 2 || liveNeighbors == 3)) {
            return true;
        }
        return  false;
    }
}

