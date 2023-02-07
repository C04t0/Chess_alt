package chess_alt;

import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    public static final int BLACK = 0;
    public static final int WHITE = 1;
    Scanner userInput = new Scanner(System.in);
    private int currentPlayer;
    private Board chessboard = new Board(8, 8);
    private LinkedList<Piece> blackPieces;
    private LinkedList<Piece> whitePieces;
    private King blackKing;
    private King whiteKing;
    private Queen blackQueen;
    private Queen whiteQueen;
    private Pawn blackPawn;
    private Pawn whitePawn;
    private Rook blackRook;
    private Rook whiteRook;
    private Bishop blackBishop;
    private Bishop whiteBishop;
    private Knight blackKnight;
    private Knight whiteKnight;

    public Game(){

        newGame();

    }
    public void gameLoop(){

        boolean continueGame = true;

        while(continueGame){
            chessboard.displayBoard();
        //    if (isGameOver()){
        //        break;
        //    }
            System.out.print("Which piece to move? X: ");
            int nextX = userInput.nextInt();
            System.out.print("Y: ");
            int nextY = userInput.nextInt();

            Piece target = chessboard.pieceAt(nextX, nextY);
            if (target == null){
                System.out.println("That location is invalid");
                continue;
            }
            else if (target.getColour() != currentPlayer){
                System.out.println("That is not your piece");
                continue;
            }
            else {
                System.out.print("Where to move this piece? X: ");
                nextX = userInput.nextInt();
                System.out.print("Y: ");
                nextY = userInput.nextInt();

                if (target.isValidMove(chessboard, nextX, nextY)){
                    target.move(target, nextX, nextY);
                }
                else {
                    System.out.println("Cannot move there");
                }
            }
            switchPlayerTurn();
        }
    }

    public void newGame() {
        currentPlayer = WHITE;
        blackPieces = new LinkedList<Piece>();
        whitePieces = new LinkedList<Piece>();

        blackKing = new King(chessboard, BLACK);
        whiteKing = new King(chessboard, WHITE);
        chessboard.placePiece(blackKing, 0, 4);
        chessboard.placePiece(whiteKing, 7, 4);

        blackQueen = new Queen(chessboard, BLACK);
        whiteQueen = new Queen(chessboard, WHITE);
        chessboard.placePiece(blackQueen,0, 3);
        chessboard.placePiece(whiteQueen, 7, 3);

        blackBishop = new Bishop(chessboard,BLACK);
        chessboard.placePiece(blackBishop, 0, 2);
        chessboard.placePiece(blackBishop, 0, 5);

        whiteBishop = new Bishop(chessboard, WHITE);
        chessboard.placePiece(whiteBishop, 7, 2);
        chessboard.placePiece(whiteBishop, 7, 5);

        blackKnight = new Knight(chessboard, BLACK);
        chessboard.placePiece(blackKnight, 0, 1);
        chessboard.placePiece(blackKnight, 0, 6);

        whiteKnight = new Knight (chessboard, WHITE);
        chessboard.placePiece(whiteKnight, 7, 1);
        chessboard.placePiece(whiteKnight, 7, 6);

        blackRook = new Rook(chessboard, BLACK);
        chessboard.placePiece(blackRook, 0, 0);
        chessboard.placePiece(blackRook, 0, 7);

        whiteRook = new Rook(chessboard, WHITE);
        chessboard.placePiece(whiteRook, 7, 0);
        chessboard.placePiece(whiteRook, 7, 7);


        blackPieces.add(blackKing);
        whitePieces.add(whiteKing);
        blackPieces.add(blackQueen);
        whitePieces.add(whiteQueen);

        for (int i = 0; i < 2; i++) {
            blackPieces.add(blackBishop);
            whitePieces.add(whiteBishop);
            blackPieces.add(blackKnight);
            whitePieces.add(whiteKnight);
            blackPieces.add(blackRook);
            whitePieces.add(whiteRook);

        }

        for (int i = 0; i < 8; i++) {
            blackPawn = new Pawn(chessboard, BLACK, 1, i);
            chessboard.placePiece(blackPawn, 1, i);
            blackPieces.add(blackPawn);
            whitePawn = new Pawn(chessboard, WHITE, 6, i);
            chessboard.placePiece(whitePawn, 6, i);
            whitePieces.add(whitePawn);
        }
    }

    public void testSetupBoard() {
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < 8; j++) {       //constructor voor het bord of andere situaties te testen
                this.addPawn(BLACK, i, j);
            }
        }
        this.addQueen(BLACK, 0, 3);
        this.addBishop(BLACK, 0, 2);
        this.addBishop(BLACK, 0, 5);
        this.addKnight(BLACK, 0, 1);
        this.addKnight(BLACK, 0, 6);
        this.addRook(BLACK, 0, 0);
        this.addRook(BLACK, 0, 7);

        for (int i = 6; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                this.addPawn(WHITE, i, j);
            }
        }
        this.addQueen(WHITE, 7, 3);
        this.addBishop(WHITE, 7, 2);
        this.addBishop(WHITE, 7, 5);
        this.addKnight(WHITE, 7, 1);
        this.addKnight(WHITE, 7, 6);
        this.addRook(WHITE, 7, 0);
        this.addRook(WHITE, 7, 7);
    }

    public void testSetup() {
        this.addKing(BLACK, 0, 4);
        this.addKing(WHITE, 7, 4);
        blackKing.moveTo(5, 0);
        whiteKing.moveTo(7, 1);
        this.addPawn(BLACK, 1, 1);
        this.addPawn(BLACK, 2, 1);
        this.addPawn(BLACK, 3, 1);
        this.addPawn(BLACK, 4, 1);
        this.addPawn(BLACK, 5, 1);
        this.addPawn(BLACK, 6, 1);
        this.addQueen(BLACK, 4, 0);
        this.addRook(BLACK, 3, 0);
        this.addBishop(BLACK, 2, 0);
        currentPlayer = BLACK;
    }
    public boolean isGameOver(){
        if (isCheckmate(BLACK) || isCheckmate(WHITE)){
            System.out.println("CHECKMATE");
            return true;
        }
        else if (!canMove(currentPlayer)){
            System.out.println("STALEMATE");
            return true;
        }
        return false;
    }
    public boolean isCheckmate(int colour){
        if (isKingInCheck(colour)){
            if(!canMove(colour))
                return true;
        }
        return false;
    }
    public boolean canMove(int player){
        int oldX, oldY;
        Piece target;
        LinkedList<Piece> checkPieces;

        if (player == BLACK)
            checkPieces = blackPieces;
        else
            checkPieces = whitePieces;

        for (int x = 0; x < chessboard.getX(); x++){
            for (int y = 0; y < chessboard.getY(); y++){
                for (Piece currentPiece : checkPieces){
                    if (currentPiece.isValidMove(chessboard, x, y)){
                        target = chessboard.pieceAt(x, y);
                        oldX = currentPiece.getX();
                        oldY = currentPiece.getY();

                        currentPiece.moveTo(x, y);

                        if (!isKingInCheck(player)){
                            currentPiece.moveTo(oldX, oldY);
                            if (target != null)
                                target.moveTo(x, y);
                            return true;
                        } else {
                            currentPiece.moveTo( oldX, oldY);
                            if (target != null)
                                target.moveTo(x, y);
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean isKingInCheck(int colour){
        boolean result = false;

        LinkedList<Piece> originalList;
        King kingInQuestion;

        if (colour == BLACK){
            originalList = whitePieces;
            kingInQuestion = blackKing;
        } else {
            originalList = blackPieces;
            kingInQuestion = whiteKing;
        }

        int xKing = kingInQuestion.getX();
        int yKing = kingInQuestion.getY();

        for (Piece currentPiece : originalList){
            if (currentPiece.isValidMove(chessboard, xKing, yKing)){
                result = true;
            }
        }

        return result;
    }
    public void removePiece(Piece removeThisPiece){
        removeThisPiece.removePiece(chessboard);
        int colour = removeThisPiece.getColour();

        if (colour == BLACK)
            blackPieces.remove(removeThisPiece);
        else
            whitePieces.remove(removeThisPiece);
    }

    public void switchPlayerTurn(){
        if (currentPlayer == WHITE)
            currentPlayer = BLACK;
        else currentPlayer = WHITE;
    }

    public King addKing(int colour, int x, int y) {
        King king = new King(chessboard,colour, x, y);
        pieceToColourHelper(king, colour);
        return king;
    }

    public Queen addQueen(int colour, int x, int y){
        Queen queen = new Queen(chessboard, colour, x, y);
        pieceToColourHelper(queen, colour);
        return queen;
    }

    public Knight addKnight(int colour, int x, int y){
        Knight knight = new Knight(chessboard, colour, x, y);
        pieceToColourHelper(knight, colour);
        return knight;
    }

    public Rook addRook(int colour, int x, int y){
        Rook rook = new Rook(chessboard, colour, x, y);
        pieceToColourHelper(rook, colour);
        return rook;
    }

    public Bishop addBishop(int colour, int x, int y){
        Bishop bishop = new Bishop(chessboard, colour, x, y);
        pieceToColourHelper(bishop, colour);
        return bishop;
    }

    public Pawn addPawn(int colour, int x, int y){
        Pawn pawn = new Pawn(chessboard, colour, x, y);
        pieceToColourHelper(pawn, colour);

        return pawn;
    }

    private void pieceToColourHelper(Piece piece, int colour){
        if (colour == BLACK)
            blackPieces.add(piece);
        else
            whitePieces.add(piece);
    }


    /** Getters en setters **/

    public int getPlayerTurn(){
        return currentPlayer;
    }

    public void setPlayer(int player){
        currentPlayer = player;
    }

    public King getBlackKing(){
        return blackKing;
    }

    public King getWhiteKing(){
        return whiteKing;
    }
}

