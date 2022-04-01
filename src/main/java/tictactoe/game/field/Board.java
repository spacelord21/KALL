package tictactoe.game.field;

import tictactoe.game.piece.Piece;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Integer, Piece> gameConfig;

    public Board() {
        this.gameConfig = createStartBoard();
    }

    public Map<Integer,Piece> createStartBoard() {
        Map<Integer,Piece> startBoard = new HashMap<>();
        for(int i = 0; i < 9; i++) {
            startBoard.put(i,null);
        }
        return startBoard;
    }

    public Map<Integer, Piece> getGameConfig() {
        return gameConfig;
    }

    public void setGameConfig(final int tileCoordinate, final Piece piece) {
        this.gameConfig.put(tileCoordinate, piece);
    }
}
