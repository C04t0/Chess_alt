package chess_alt;

public class Knight extends Piece{


    public Knight(int x, int y) {
        super(x, y);
    }

    public Knight(Board chessboard, int colour) {
        super(chessboard, colour);
    }

    public Knight(int colour, int x, int y) {
        super(colour, x, y);
    }

    public Knight(Board chessboard, int colour, int x, int y) {
        super(chessboard, colour, x, y);
    }
}
