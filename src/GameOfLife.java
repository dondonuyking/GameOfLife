public class GameOfLife {

    private static int mapSize;

    public GameOfLife(int i) {
        mapSize = i;
    }

    public String getWorld () {
        return String.valueOf(mapSize).concat("x").concat(String.valueOf(mapSize));
    }

    public int getNumberOfCells() {
        return mapSize * mapSize;
    }
}
