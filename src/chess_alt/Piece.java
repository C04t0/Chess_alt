package chess_alt;


import static chess_alt.Game.*;

public class Piece {
    private int x;
    private int y;
    private static int colour;
    private boolean hasMoved;

    public void removePiece(Piece[][] chessboard) {
        removeFromBoard(this, x, y);		//piece remover
    }
    public void capturePiece(Piece capturedPiece) {		//stuk capturen
        capturedPiece.removePiece(getBoard());
    }
    public boolean isValidMove(Piece[][] chessboard, int x, int y) {
        if (isInBounds(x, y)) {
            Piece place = pieceAt(x, y); //pieceAt -> pieceAt
            if (place == null) {
                return true;
            }
            if (place.getColour() != this.colour) {
                return true;
            }
        }
        return false;
    }
    public Piece move(Piece movedPiece, int x, int y) {
        movedPiece = new Piece(Game.getBoard(), colour, x, y);
        return movedPiece;
    }

    public void moveTo(int newX, int newY){
        if (pieceAt(x, y) == this) {
            removeFromBoard(this, x, y);
        }
        this.x = newX;
        this.y = newY;

        Piece target = pieceAt(newX, newY);
        if (target != null){
            this.capturePiece(target);
        }
        placePiece(this, newX, newY);
        hasMoved = true;
    }

    /**CONSTRUCTORS**/

    public Piece(Piece[][] chessboard, int colour) {			//constructor 1
        this.colour = colour;
        hasMoved = false;
    }

    public Piece(Board chessboard, int x, int y, int i) {
        this.x = x;
        this.y = y;
    }

    public Piece(Piece[][] chessboard, int colour, int x, int y) {
        chessboard = getBoard();
        this.colour = colour;
        this.x = x;
        this.y = y;
    }

    public Piece(int colour, int x, int y) {
        this.colour = colour;
        this.x = x;
        this.y = y;
    }

    /** Getters en Setters **/

    public static int getColour() {
        return colour;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

}
