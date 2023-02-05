package chess_alt;

public class Pawn extends Piece{

    public Pawn(int colour, int x, int y) {
        super(colour, x, y);
    }

    public Pawn(Board chessboard, int colour, int x, int y) {
        super(chessboard, colour, x, y);
    }
}
