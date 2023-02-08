package chess_alt;

public class Pawn extends Piece{

    public Pawn(Piece[][] chessboard, int x, int y, int i) {
        super(chessboard, x, y, y);
    }

    public Pawn(Piece[][] chessboard, int colour) {
        super (chessboard, colour);
    }

    public Pawn(int colour, int x, int y) {
        super(colour, x, y);
    }

    public Pawn(Board chessboard, int colour, int x, int y) {
        super(chessboard, colour, x, y);
    }

}
