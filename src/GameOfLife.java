import static java.lang.System.arraycopy;

public class GameOfLife {

    private static int maxRows;
    private static int maxColumns;
    public static char[][] gameOfLifeMap;
    public static char[][] gameOfLifeMapSnapShot = null;


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
        gameOfLifeMapSnapShot = null;
        for (int cellRow = 0; cellRow < maxRows; cellRow++)
        {
            for (int cellColumn = 0; cellColumn < maxColumns; cellColumn++)
                gameOfLifeMap[cellRow][cellColumn] = '0';
        }


    }
    public void initializeGameOfLifeMapSnapShot(){

        if (gameOfLifeMapSnapShot == null) {
            gameOfLifeMapSnapShot = new char[maxRows][maxColumns];

            for (int cellRow = 0; cellRow < maxRows; cellRow++) {
                for (int cellColumn = 0; cellColumn < maxColumns; cellColumn++)
                    gameOfLifeMapSnapShot[cellRow][cellColumn] = gameOfLifeMap[cellRow][cellColumn];
            }
        }
    }
    public void updateGameOfLifeMap(){

        for (int cellRow = 0; cellRow < maxRows; cellRow++) {
             for (int cellColumn = 0; cellColumn < maxColumns; cellColumn++)
                 gameOfLifeMap[cellRow][cellColumn] = gameOfLifeMapSnapShot[cellRow][cellColumn];
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

    public String getAllCellStatus(char[][] snapShotOfGameOfLifeMap) {
        StringBuffer sb = new StringBuffer();

        for (int row = 0; row < maxRows; row++)
        {
            for (int column = 0; column < maxColumns; column++)
                sb.append(snapShotOfGameOfLifeMap[row][column]);
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

        if (isCellAlive(gameOfLifeMap[row][column]) && (liveNeighbors == 2 || liveNeighbors == 3)) {
            return true;
        }
        if (isCellDead(gameOfLifeMap[row][column]) && liveNeighbors == 3){
            return true;
        }
        return  false;
    }

    public boolean isCellAlive(Character cell) {
        if ("1".equals(String.valueOf(cell)))
            return true;
        return false;
    }
    public boolean isCellDead(Character cell) {
        return !isCellAlive(cell);
    }

    public void killCell(int row, int column) {
        getMapSnapShot()[row][column] = '0';
    }
    private void makeCellLive(int row, int column ) {
        getMapSnapShot()[row][column] = '1';
    }

    public char[][] getMapSnapShot() {
         return gameOfLifeMapSnapShot;
    }

    public String getSnapShotCellStatus() {
        return getAllCellStatus(getMapSnapShot());
    }

    public void tick() {
        initializeGameOfLifeMapSnapShot();
        for (int cellRow = 0; cellRow < maxRows; cellRow++)
        {
            for (int cellColumn = 0; cellColumn < maxColumns; cellColumn++)
            {
                if (shouldLiveInNextGeneration(cellRow,cellColumn))
                    makeCellLive(cellRow,cellColumn);
                else
                    killCell(cellRow,cellColumn);
            }
        }
        updateGameOfLifeMap();
    }



}

