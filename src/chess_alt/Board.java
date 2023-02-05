package chess_alt;

public class Board {
    private Piece[][] chessBoard;           //piece array om plaatsen in op te slaan
    public Board(int x, int y) {
        chessBoard = new Piece[x][y];       //board constructor 1
    }

    public boolean isEmpty(int x, int y){       //isEmpty checker
        if (isInBounds(x, y)){
            if (chessBoard[x][y] == null)
                return true;
        }
        return false;
    }
    public boolean isInBounds(int x, int y){    //inBounds checker
        if (x < getX() && x >= 0 &&
                y < getY() && y >= 0)
            return true;
        return false;
    }
    public Piece pieceAt(int x, int y){         //bordpositie
        if (isInBounds(x, y)){
            return chessBoard[x][y];
        }
        return null;
    }
    public void displayBoard(){                 //bord tonen
        for (int i = 0; i < getX(); i++){
            for (int j = 0; j < getY(); j++){
                if (chessBoard[i][j] == null)
                    System.out.print("\u001B[37m.");
                else {

                    if (pieceAt(i, j).getColour() == Game.BLACK) {

                        if (chessBoard[i][j] instanceof Pawn)
                            System.out.print("\u001B[31mP");
                        else if (chessBoard[i][j] instanceof Knight)
                            System.out.print("\u001B[31mL");
                        else if (chessBoard[i][j] instanceof Queen)
                            System.out.print("\u001B[31mQ");
                        else if (chessBoard[i][j] instanceof King)
                            System.out.print("\u001B[31mK");
                        else if (chessBoard[i][j] instanceof Rook)
                            System.out.print("\u001B[31mR");
                        else if (chessBoard[i][j] instanceof Bishop)
                            System.out.print("\u001B[31mB");
                        else
                            System.out.print(".");

                    } else {

                        if (chessBoard[i][j] instanceof Pawn)
                            System.out.print("\u001B[37mP");
                        else if (chessBoard[i][j] instanceof Knight)
                            System.out.print("\u001B[37mL");
                        else if (chessBoard[i][j] instanceof Queen)
                            System.out.print("\u001B[37mQ");
                        else if (chessBoard[i][j] instanceof King)
                            System.out.print("\u001B[37mK");
                        else if (chessBoard[i][j] instanceof Rook)
                            System.out.print("\u001B[37mR");
                        else if (chessBoard[i][j] instanceof Bishop)
                            System.out.print("\u001B[37mB");
                        else
                            System.out.print("\u001B[37m.");

                    }
                }
            }
            System.out.println("\u001B[37m");
        }
    }

    /** Getters en setters **/
    public int getX(){
        return chessBoard[0].length;
    }
    public int getY(){
        return chessBoard.length;
    }
    public Piece[][] getChessBoard(){
        return chessBoard;
    }
    public void removeFromBoard(Piece removePiece){
        int oldXLocation = removePiece.getX();
        int oldYLocation = removePiece.getY();

        chessBoard[oldXLocation][oldYLocation] = null;
    }
    public void placePiece(Piece chessPiece, int x, int y){
        if (isInBounds(x, y)) {
            chessBoard[x][y] = chessPiece;
        }
    }
}

