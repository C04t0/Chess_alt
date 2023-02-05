package chess_alt;

import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    public static final int BLACK = 0;
    public static final int WHITE = 1;
    public final int xBlkKing = 0;
    public final int yBlkKing = 4;
    public final int xWhtKing = 7;
    public final int yWhtKing = 4;

    public final int xBlkQueen = 0;

    public final int yBlkQueen = 3;

    public final int xWhtQueen = 7;

    public final int yWhtQueen = 3;
    Scanner userInput = new Scanner(System.in);
    private int currentPlayer;
    private Board chessBoard = new Board(8, 8);
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

    public Game(){
        currentPlayer = WHITE;
        blackPieces = new LinkedList<Piece>();
        whitePieces = new LinkedList<Piece>();

        blackKing = new King(chessBoard, BLACK, xBlkKing, yBlkKing);
        whiteKing = new King(chessBoard, WHITE, xWhtKing, yWhtKing);
        chessBoard.placePiece(blackKing, xBlkKing, yBlkKing);
        chessBoard.placePiece(whiteKing, xWhtKing, yWhtKing);

        blackQueen = new Queen(chessBoard, BLACK, xBlkQueen, yBlkQueen);
        whiteQueen = new Queen(chessBoard, WHITE, xWhtQueen,  yWhtQueen);
        chessBoard.placePiece(blackQueen, xBlkQueen, yBlkQueen);
        chessBoard.placePiece(whiteQueen, xWhtQueen, yWhtQueen);

        blackBishop = new Bishop(chessBoard,BLACK);
        chessBoard.placePiece(blackBishop, 0, 2);
        chessBoard.placePiece(blackBishop, 0, 5);

        whiteBishop = new Bishop(chessBoard, WHITE);
        chessBoard.placePiece(whiteBishop, 7, 2);
        chessBoard.placePiece(whiteBishop, 7, 5);

        blackKnight = new Knight(chessBoard, BLACK);
        chessBoard.placePiece(blackKnight, 0, 1);
        chessBoard.placePiece(blackKnight, 0, 6);

        whiteKnight = new Knight (chessBoard, WHITE);
        chessBoard.placePiece(whiteKnight, 7, 1);
        chessBoard.placePiece(whiteKnight, 7, 6);

        blackRook = new Rook(chessBoard, BLACK);
        chessBoard.placePiece(blackRook, 0, 0);
        chessBoard.placePiece(blackRook, 0, 7);

        whiteRook = new Rook(chessBoard, WHITE);
        chessBoard.placePiece(whiteRook, 7, 0);
        chessBoard.placePiece(whiteRook, 7, 7);


        blackPieces.add(blackKing);
        whitePieces.add(whiteKing);
        blackPieces.add(blackQueen);
        whitePieces.add(whiteQueen);

        for (int i = 0; i < 8; i++) {
            blackPawn = new Pawn(chessBoard, BLACK, 1, i);
            chessBoard.placePiece(blackPawn, 1, i);
            blackPieces.add(blackPawn);
            whitePawn = new Pawn(chessBoard, WHITE, 6, i);
            chessBoard.placePiece(whitePawn, 6, i);
            whitePieces.add(whitePawn);
        }

        testSetupBoard();                       //testen of de bordconstructors werken

    }
    public void gameLoop(){

        boolean continueGame = true;

        while(continueGame){
            chessBoard.displayBoard();
        //    if (isGameOver()){
        //        break;
        //    }
            System.out.print("Which piece to move? X: ");
            int nextX = userInput.nextInt();
            System.out.print("Y: ");
            int nextY = userInput.nextInt();

            Piece target = chessBoard.pieceAt(nextX, nextY);
            if (target == null){
                System.out.println("That location is invalid");
                continueGame = false;
            }
            else if (target.getColour() != currentPlayer){
                System.out.println("That is not your piece");
                continueGame = false;
            }
            else {
                System.out.print("Where to move this piece? X: ");
                nextX = userInput.nextInt();
                System.out.print("Y: ");
                nextY = userInput.nextInt();

                if (target.isValidMove(nextX, nextY)){
                    target.move(nextX, nextY);
                }
                else {
                    System.out.println("Cannot move there");
                }
            }
            switchPlayerTurn();
        }
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

        for (int x = 0; x < chessBoard.getX(); x++){
            for (int y = 0; y < chessBoard.getY(); y++){
                for (Piece currentPiece : checkPieces){
                    if (currentPiece.isValidMove(x, y)){
                        target = chessBoard.pieceAt(x, y);
                        oldX = currentPiece.getX();
                        oldY = currentPiece.getY();

                        currentPiece.move(x, y);

                        if (!isKingInCheck(player)){
                            currentPiece.move(oldX, oldY);
                            if (target != null)
                                target.move(x, y);
                            return true;
                        } else {
                            currentPiece.move(oldX, oldY);
                            if (target != null)
                                target.move(x, y);
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
            if (currentPiece.isValidMove(xKing, yKing)){
                result = true;
            }
        }

        return result;
    }
    public void removePiece(Piece removeThisPiece){
        removeThisPiece.removePiece();
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

    public Queen addQueen(int colour, int x, int y){
        Queen queen = new Queen(chessBoard, colour, x, y);
        pieceToColourHelper(queen, colour);
        return queen;
    }

    public Knight addKnight(int colour, int x, int y){
        Knight knight = new Knight(chessBoard, colour, x, y);
        pieceToColourHelper(knight, colour);
        return knight;
    }

    public Rook addRook(int colour, int x, int y){
        Rook rook = new Rook(chessBoard, colour, x, y);
        pieceToColourHelper(rook, colour);
        return rook;
    }

    public Bishop addBishop(int colour, int x, int y){
        Bishop bishop = new Bishop(chessBoard, colour, x, y);
        pieceToColourHelper(bishop, colour);
        return bishop;
    }

    public Pawn addPawn(int colour, int x, int y){
        Pawn pawn = new Pawn(chessBoard, colour, x, y);
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

