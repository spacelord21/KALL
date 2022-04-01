package tictactoe.game.piece;

public class Piece {
    private final PieceType pieceType;

    public Piece(final PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public String getUrl() {
        return this.pieceType.url;
    }

    public enum PieceType {
        TIC("art/krestik.gif") {
            @Override
            public boolean isTic() {
                return true;
            }
        },
        TACTOE("art/nolik.gif") {
            @Override
            public boolean isTic() {
                return false;
            }
        };

        private final String url;

        PieceType(final String url) {
            this.url = url;
        }

        public abstract boolean isTic();
    }




}
