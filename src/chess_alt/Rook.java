package chess_alt;

public class Rook extends Piece{

    public Rook (Board chessboard, int colour) {
        super(chessboard, colour);
    }

    public Rook (int colour, int x, int y) {
        super(colour, x, y);
    }
    public Rook(Board chessboard, int colour, int x, int y) {
        super(chessboard, colour, x, y);
    }
}
