package chess_alt;

public class Knight extends Piece{


    public Knight(Piece[][] chessboard, int x, int y, int i) {
        super(chessboard, x, y, y);
    }

    public Knight(Piece[][] chessboard, int colour) {
        super(chessboard, colour);
    }

    public Knight(int colour, int x, int y) {
        super(colour, x, y);
    }

    public Knight(Board chessboard, int colour, int x, int y) {
        super(chessboard, colour, x, y);
    }
}
