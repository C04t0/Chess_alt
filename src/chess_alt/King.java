package chess_alt;

public class King extends Piece {
    public King(int x, int y) {
        super(x, y);
    }

    public King(Board chessboard, int colour) {
        super(chessboard, colour);
    }

    public King(int colour, int x, int y) {
        super(colour, x, y);
    }

    public King(Board chessboard, int colour, int x, int y) {
        super(chessboard, colour, x, y);
    }

}
