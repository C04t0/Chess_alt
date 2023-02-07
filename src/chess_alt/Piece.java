package chess_alt;

public class Piece {
    private int x;
    private int y;
    private int colour;
    private boolean hasMoved;


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

        chessboard.placePiece(this, x, y);
    }
    public void removePiece(Board chessboard) {
        chessboard.removeFromBoard(this);		//piece remover
        x = -1;
        y = -1;
    }
    public void capturePiece(Piece capturedPiece) {		//stuk capturen
        capturedPiece.removePiece();
    }
    public boolean isValidMove(Board chessboard, int x, int y) {
        if (chessboard.isInBounds(x, y)) {
            Piece place = chessboard.pieceAt(x, y); //pieceAt -> getCoordinates
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
        movedPiece = chessboard.placePiece(this, x, y);
        return movedPiece;
    }

    public void moveTo(int newX, int newY){
        if (chessboard.pieceAt(x, y) == this) {
            chessboard.removeFromBoard(this);
        }
        this.x = newX;
        this.y = newY;

        Piece target = chessboard.pieceAt(newX, newY);
        if (target != null){
            this.capturePiece(target);
        }
        chessboard.placePiece(this, newX, newY);
        hasMoved = true;
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
