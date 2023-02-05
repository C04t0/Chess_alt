package chess_alt;

public class Bishop extends Piece{
    public Bishop(int x, int y) {
        super(x, y);
    }

    public Bishop (Board chessboard, int colour) {
        super(chessboard, colour);
    }


    public Bishop(Board chessboard, int colour, int x, int y) {
        super(chessboard, colour, x, y);
    }
}
