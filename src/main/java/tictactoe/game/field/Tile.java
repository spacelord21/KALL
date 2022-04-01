package tictactoe.game.field;


// НЕ ИСПОЛЬЗУЕТСЯ..

public abstract class Tile {

    private final int tileCoordinate;

    public Tile(final int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isOccupiedTile();

    public static class EmptyTile extends Tile {

        public EmptyTile(int tileCoordinate) {
            super(tileCoordinate);
        }

        @Override
        public boolean isOccupiedTile() {
            return false;
        }
    }

    public static class OccupiedTile extends Tile {

        public OccupiedTile(int tileCoordinate) {
            super(tileCoordinate);
        }

        @Override
        public boolean isOccupiedTile() {
            return true;
        }
    }
}
