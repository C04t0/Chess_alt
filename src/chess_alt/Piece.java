package chess_alt;

public class Piece {
    private int x;
    private int y;
    private int colour;
    private boolean hasMoved;

    protected Board chessboard;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Piece(Board chessboard, int colour) {			//constructor 1
        this.chessboard = chessboard;
        this.colour = colour;
        hasMoved = false;
        x = -1;
        y = -1;
    }

    public Piece(int colour, int x, int y) {
        this.colour = colour;
        this.x = x;
        this.y = y;
    }

    public Piece (Board chessboard, int colour, int x, int y) {		//constructor 2
        this.chessboard = chessboard;
        this.colour = colour;
        this.x = x;
        this.y = y;
    }

    public void removePiece() {
        chessboard.removeFromBoard(this);		//piece remover
        x = -1;
        y = -1;
    }
    public void capturePiece(Piece capturedPiece) {		//stuk capturen
        capturedPiece.removePiece();
    }
    public boolean isValidMove(int x, int y) {
        if (chessboard.isInBounds(x, y)) {
            Piece place = chessboard.pieceAt(x, y);
            if (place == null) {
                return true;
            }
            if (place.getColour() != this.colour) {
                return true;
            }
        }
        return false;
    }

    public Piece move(int x, int y) {
        Piece movedPiece = chessboard.pieceAt(x, y);
        return movedPiece;
    }


    /** Getters en Setters **/

    public int getColour() {
        return colour;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

}
