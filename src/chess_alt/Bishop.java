package chess_alt;

public class Bishop extends Piece{
    public Bishop(Piece[][] chessboard, int x, int y, int i) {
        super(chessboard, x, y, y);
    }

    public Bishop (Piece[][] chessboard, int colour) {
        super(chessboard, colour);
    }


    public Bishop(Board chessboard, int colour, int x, int y) {
        super(chessboard, colour, x, y);
    }
}
