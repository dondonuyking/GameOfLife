import java.util.Arrays;

public class GameOfLife {

    private static int mapSize;
    public static char[] gameOfLifeMap;

    public GameOfLife(int i) {
        mapSize = i;
        initializeGameOfLifeMap();

    }
    private void initializeGameOfLifeMap(){
        gameOfLifeMap = new char[getNumberOfCells()];
        Arrays.fill(gameOfLifeMap, '0');
    }
    public String getWorld () {
        return String.valueOf(mapSize).concat("x").concat(String.valueOf(mapSize));
    }

    public int getNumberOfCells() {
        return mapSize * mapSize;
    }

    public String getAllCellStatus() {
        return String.valueOf(gameOfLifeMap);
    }
}

