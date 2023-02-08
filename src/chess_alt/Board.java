package chess_alt;

import static chess_alt.Game.pieceAt;

public class Board {
    private static Piece[][] chessboard;           //piece array om plaatsen in op te slaan

    public Board(int x, int y) {
        chessboard = new Piece[x][y];       //board constructor 1
    }
}

        /** Getters en setters **/


