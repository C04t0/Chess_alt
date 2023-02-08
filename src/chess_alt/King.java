package chess_alt;

public class King extends Piece {

    public King(Piece[][] chessboard, int colour, int x, int y) {
        super(chessboard, colour, x, y);
    }

    public King(Piece[][] chessboard, int colour) {
        super(chessboard, colour);
    }

    public King(int colour, int x, int y) {
        super(colour, x, y);
    }

}
