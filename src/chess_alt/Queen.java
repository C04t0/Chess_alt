package chess_alt;

public class Queen extends Piece{

    public Queen(Piece[][] chessboard, int x, int y, int i) {
        super (chessboard, x, y, y);
    }

    public Queen(Piece[][] chessboard, int colour) {
        super(chessboard, colour);
    }

    public Queen (int colour, int x, int y) {
        super (colour, x, y);
    }

    public Queen(Board chessboard, int colour, int x, int y) {
        super(chessboard, colour, x, y);
    }
}
