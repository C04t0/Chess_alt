package chess_alt;

public class Board {
    private static Piece[][] chessboard;           //piece array om plaatsen in op te slaan

    public Board(int x, int y) {
        chessboard = new Piece[x][y];       //board constructor 1
    }

    public boolean isEmpty(int x, int y) {       //isEmpty checker
        if (isInBounds(x, y)) {
            if (chessboard[x][y] == null)
                return true;
        }
        return false;
    }

    public boolean isInBounds(int x, int y) {    //inBounds checker
        if (x < getX() && x >= 0 &&
                y < getY() && y >= 0)
            return true;
        return false;
    }

    public Piece pieceAt(int x, int y) {         //bordpositie
        if (isInBounds(x, y)) {
            return chessboard[x][y];
        }
        return null;
    }

    public void displayBoard() {                 //bord tonen
        for (int i = 0; i < getX(); i++) {
            for (int j = 0; j < getY(); j++) {
                if (chessboard[i][j] == null)
                    System.out.print("\u001B[37m.");
                else {
                    if (pieceAt(i, j).getColour() == Game.BLACK) {
                        if (chessboard[i][j] instanceof Pawn) {
                            System.out.print("\u001B[31mP");
                        } else if (chessboard[i][j] instanceof Knight) {
                            System.out.print("\u001B[31mL");
                        } else if (chessboard[i][j] instanceof Queen) {
                            System.out.print("\u001B[31mQ");
                        } else if (chessboard[i][j] instanceof  King) {

                        } else if (chessboard[i][j] instanceof Rook) {
                            System.out.print("\u001B[31mR");
                        } else if (chessboard[i][j] instanceof Bishop) {
                            System.out.print("\u001B[31mB");
                        } else {
                            System.out.print(".");
                        }

                    } else {
                        if (chessboard[i][j] instanceof Pawn) {
                            System.out.print("\u001B[37mP");
                        } else if (chessboard[i][j] instanceof Knight){
                            System.out.print("\u001B[37mL");
                        } else if (chessboard[i][j] instanceof Queen) {
                            System.out.print("\u001B[37mQ");
                        } else if (chessboard[i][j] instanceof King) {
                            System.out.print("\u001B[37mK");
                        } else if (chessboard[i][j] instanceof Rook) {
                        System.out.print("\u001B[37mR");
                        } else if (chessboard[i][j] instanceof Bishop) {
                            System.out.print("\u001B[37mB");
                        } else {
                                System.out.print("\u001B[37m.");

                        }
                    }
                }
                System.out.println("\u001B[37m");
            }
        }
    }

        /** Getters en setters **/
        public int getX () {
            return chessboard[0].length;
        }
        public int getY () {
            return chessboard.length;
        }
        public static Piece[][] getchessboard () {
            return chessboard;
        }
        public void removeFromBoard (Piece removePiece){
            int oldX = removePiece.getX();
            int oldY = removePiece.getY();

            chessboard[oldX][oldY] = null;
        }
        public Piece placePiece (Piece chessPiece,int x, int y){
            if (isInBounds(x, y)) {
                chessboard[x][y] = chessPiece;
            }
            return chessPiece;
        }
    }


