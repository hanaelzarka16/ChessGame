/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class ChessGame {

    private Board chessBoard;
    private MoveType currentMove;

    public ChessGame(Board board) {
        this.chessBoard = board;
    }

    public Piece[][] getBoard() {
        return chessBoard.getBoard();
    }
    public MoveType getCurrentMove(){
        return this.currentMove;
    }

    public boolean isValidMove(Square src, Square dest,int turn) {
       try{
       if(turn%2==0 && src.getPiece().getColour().equals(Colour.BLACK)){
            return false;
        }
        if(turn%2!=0 && src.getPiece().getColour().equals(Colour.WHITE)){
            return false;
        }
        Piece[][] board = chessBoard.getBoard();
        Piece[][] cloneBoard = chessBoard.copyBoard();
        Board cloneB = new Board();
        cloneB.setBoard(cloneBoard,chessBoard.getEnpassentColumn());
        ChessGame cloneGame = new ChessGame(cloneB);
        if (board[src.getSquareRow()][src.getSquareCol().colNumber].isValidMove(dest.getSquareRow(), dest.getSquareCol(), board)) {
            if (board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove().equals(MoveType.Move) || board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove().equals(MoveType.Take) || board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove().equals(MoveType.DoubleMove)){
                cloneBoard[src.getSquareRow()][src.getSquareCol().colNumber].applyMove(dest, cloneBoard);
                if (board[src.getSquareRow()][src.getSquareCol().colNumber].colour.equals(Colour.WHITE)) {
                    if (cloneGame.isWhiteInCheck()) {
                        return false;
                    } else {
                        this.currentMove = board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove();
                        if(this.currentMove.equals(MoveType.DoubleMove)){
                            chessBoard.setEnpassentColumn(dest.getSquareCol());
                        }else{
                            chessBoard.setEnpassentColumn(null);
                        }
                        return true;
                    }
                } else if (board[src.getSquareRow()][src.getSquareCol().colNumber].colour.equals(Colour.BLACK)) {
                    if (cloneGame.isBlackInCheck()) {
                        return false;
                    } else {
                        this.currentMove = board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove();
                        if(this.currentMove.equals(MoveType.DoubleMove)){
                            chessBoard.setEnpassentColumn(dest.getSquareCol());
                        }else{
                            chessBoard.setEnpassentColumn(null);
                        }
                        return true;
                    }
                }
            } else if (board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove().equals(MoveType.Castle)) {
                ((King) cloneBoard[src.getSquareRow()][src.getSquareCol().colNumber]).applyCastling(dest, cloneBoard);
                if (board[src.getSquareRow()][src.getSquareCol().colNumber].colour.equals(Colour.WHITE)) {
                    if (cloneGame.isWhiteInCheck()) {
                        return false;
                    } else {
                        this.currentMove = board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove();
                        chessBoard.setEnpassentColumn(null);
                        return true;
                    }
                } else if (board[src.getSquareRow()][src.getSquareCol().colNumber].colour.equals(Colour.BLACK)) {
                    if (cloneGame.isBlackInCheck()) {
                        return false;
                    } else {
                        this.currentMove = board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove();
                        chessBoard.setEnpassentColumn(null);
                        return true;
                    }
                }
            } else if (board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove().equals(MoveType.Promotion) || board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove().equals(MoveType.PromotionTake)) {
                ((Pawn)cloneBoard[src.getSquareRow()][src.getSquareCol().colNumber]).applyPromotion(dest, PieceName.Pawn, cloneBoard);
               if (board[src.getSquareRow()][src.getSquareCol().colNumber].colour.equals(Colour.WHITE)) {
                    if (cloneGame.isWhiteInCheck()) {
                        return false;
                    } else {
                        this.currentMove = board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove();
                        chessBoard.setEnpassentColumn(null);
                        return true;
                    }
                } else if (board[src.getSquareRow()][src.getSquareCol().colNumber].colour.equals(Colour.BLACK)) {
                    if (cloneGame.isBlackInCheck()) {
                        return false;
                    } else {
                        this.currentMove = board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove();
                        chessBoard.setEnpassentColumn(null);
                        return true;
                    }
                }
            }else if(board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove().equals(MoveType.Enpassent) && dest.getSquareCol().equals(chessBoard.getEnpassentColumn())){
                ((Pawn) cloneBoard[src.getSquareRow()][src.getSquareCol().colNumber]).applyEnpassent(dest, cloneBoard);
                          if (board[src.getSquareRow()][src.getSquareCol().colNumber].colour.equals(Colour.WHITE)) {
                    if (cloneGame.isWhiteInCheck()) {
                        return false;
                    } else {
                        this.currentMove = board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove();
                        chessBoard.setEnpassentColumn(null);
                        return true;
                    }
                } else if (board[src.getSquareRow()][src.getSquareCol().colNumber].colour.equals(Colour.BLACK)) {
                    if (cloneGame.isBlackInCheck()) {
                        return false;
                    } else {
                        this.currentMove = board[src.getSquareRow()][src.getSquareCol().colNumber].getCurrentMove();
                        chessBoard.setEnpassentColumn(null);
                        return true;
                    }
                }
            }
        } else {
            return false;
        }
    }catch(NullPointerException e){
        return false;
            }
       return false;
    }

    public ArrayList<Move> getAllValidMovesFromSquare(Square square) {
        Piece[][] board = chessBoard.getBoard();
        Piece[][] cloneBoard = chessBoard.copyBoard();
        Board cloneB = new Board();
        cloneB.setBoard(cloneBoard,chessBoard.getEnpassentColumn());
        ChessGame cloneGame = new ChessGame(cloneB);
        ArrayList<Move> validMoves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square dest = new Square(i,Column.getColumn(j),board[i][j]);
                if (cloneGame.isValidMove(square,dest,square.getPiece().colour.getTurn())) {
                    validMoves.add(new Move(square, dest,this.currentMove));
                }
            }
        }
        return validMoves;
    }

    public boolean isWhiteInCheck() {
        Piece[][] board = chessBoard.getBoard();
        Square kingPosition = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] instanceof King && board[i][j].colour.equals(Colour.WHITE)) {
                    kingPosition = new Square(i, Column.getColumn(j), board[i][j]);
                    break;
                }
            }
        }
        if (kingPosition != null) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] != null && board[i][j].colour.equals(Colour.BLACK)) {
                        if (board[i][j].isValidMove(kingPosition.getSquareRow(), kingPosition.getSquareCol(), board)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;

    }

    public boolean isBlackInCheck() {
        Piece[][] board = chessBoard.getBoard();
        Square kingPosition = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] instanceof King && board[i][j].colour.equals(Colour.BLACK)) {
                    kingPosition = new Square(i, Column.getColumn(j), board[i][j]);
                    break;
                }
            }
        }

        if (kingPosition != null) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] != null && board[i][j].colour.equals(Colour.WHITE)) {
                        if (board[i][j].isValidMove(kingPosition.getSquareRow(), kingPosition.getSquareCol(), board)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;

    }

    public boolean whiteCheckmate() {
        Piece[][] board = chessBoard.getBoard();
        if (!this.isWhiteInCheck()) {
            return false;
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] != null && board[i][j].colour.equals(Colour.WHITE)) {
                        Square currentSqr = new Square(i, Column.getColumn(j), board[i][j]);
                        ArrayList<Move> possibleMoves = this.getAllValidMovesFromSquare(currentSqr);
                        for (int k = 0; k < possibleMoves.size(); k++) {
                            Piece[][] cloneBoard = chessBoard.copyBoard();
                            Board cloneB = new Board();
                            cloneB.setBoard(cloneBoard,chessBoard.getEnpassentColumn());
                            ChessGame cloneGame = new ChessGame(cloneB);
                            if(possibleMoves.get(k).getType().equals(MoveType.Move) || possibleMoves.get(k).getType().equals(MoveType.Take) || possibleMoves.get(k).getType().equals(MoveType.Promotion) || possibleMoves.get(k).getType().equals(MoveType.PromotionTake) || possibleMoves.get(k).getType().equals(MoveType.DoubleMove)){
                            cloneBoard[i][j].applyMove(possibleMoves.get(k).getDestSquare(), cloneBoard);
                            }else if(possibleMoves.get(k).getType().equals(MoveType.Castle)){
                                ((King)cloneBoard[i][j]).applyCastling(possibleMoves.get(k).getDestSquare(), cloneBoard);
                            }else if(possibleMoves.get(k).getType().equals(MoveType.Enpassent)){
                                ((Pawn)cloneBoard[i][j]).applyEnpassent(possibleMoves.get(k).getDestSquare(), cloneBoard);
                            }
                            if (!cloneGame.isWhiteInCheck()) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

    public boolean blackCheckmate() {
        Piece[][] board = chessBoard.getBoard();
        if (!this.isBlackInCheck()) {
            return false;
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] != null && board[i][j].colour.equals(Colour.BLACK)) {
                        Square currentSqr = new Square(i, Column.getColumn(j), board[i][j]);
                        ArrayList<Move> possibleMoves = this.getAllValidMovesFromSquare(currentSqr);
                        for (int k = 0; k < possibleMoves.size(); k++) {
                            Piece[][] cloneBoard = chessBoard.copyBoard();
                            Board cloneB = new Board();
                            cloneB.setBoard(cloneBoard,chessBoard.getEnpassentColumn());
                            ChessGame cloneGame = new ChessGame(cloneB);
                            if(possibleMoves.get(k).getType().equals(MoveType.Move) || possibleMoves.get(k).getType().equals(MoveType.Take) || possibleMoves.get(k).getType().equals(MoveType.Promotion) || possibleMoves.get(k).getType().equals(MoveType.PromotionTake) || possibleMoves.get(k).getType().equals(MoveType.DoubleMove)){
                            cloneBoard[i][j].applyMove(possibleMoves.get(k).getDestSquare(), cloneBoard);
                            }else if(possibleMoves.get(k).getType().equals(MoveType.Castle)){
                                ((King)cloneBoard[i][j]).applyCastling(possibleMoves.get(k).getDestSquare(), cloneBoard);
                            }else if(possibleMoves.get(k).getType().equals(MoveType.Enpassent)){
                                ((Pawn)cloneBoard[i][j]).applyEnpassent(possibleMoves.get(k).getDestSquare(), cloneBoard);
                            }
                            if (!cloneGame.isBlackInCheck()) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

    public boolean whiteStalemate() {
        Piece[][] board = chessBoard.getBoard();
        if (this.isWhiteInCheck()) {
            return false;
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] != null && board[i][j].colour.equals(Colour.WHITE)) {
                        Square currentSqr = new Square(i, Column.getColumn(j), board[i][j]);
                        ArrayList<Move> validMoves = this.getAllValidMovesFromSquare(currentSqr);
                        if (!validMoves.isEmpty()) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    public boolean blackStalemate() {
        Piece[][] board = chessBoard.getBoard();
        if (this.isBlackInCheck()) {
            return false;
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] != null && board[i][j].colour.equals(Colour.BLACK)) {
                        Square currentSqr = new Square(i, Column.getColumn(j), board[i][j]);
                        ArrayList<Move> validMoves = this.getAllValidMovesFromSquare(currentSqr);
                        if (!validMoves.isEmpty()) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    private boolean insufficientMaterialWhite() {
        Piece[][] board = chessBoard.getBoard();
        ArrayList<Piece> whitePieces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j]!=null && board[i][j].colour.equals(Colour.WHITE)) {
                    whitePieces.add(board[i][j]);
                }
            }
        }
        if (whitePieces.size() == 1 && whitePieces.get(0) instanceof King) {
            return true;
        } else if (whitePieces.size() == 2 && whitePieces.get(0) instanceof King && whitePieces.get(1) instanceof Knight) {
            return true;
        } else if (whitePieces.size() == 2 && whitePieces.get(0) instanceof Knight && whitePieces.get(1) instanceof King) {
            return true;
        } else if (whitePieces.size() == 2 && whitePieces.get(0) instanceof King && whitePieces.get(1) instanceof Bishop) {
            return true;
        } else if (whitePieces.size() == 2 && whitePieces.get(0) instanceof Bishop && whitePieces.get(1) instanceof King) {
            return true;
        } else {
            return false;
        }

    }

    private boolean insufficientMaterialBlack() {
        Piece[][] board = chessBoard.getBoard();
        ArrayList<Piece> blackPieces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j]!=null && board[i][j].colour.equals(Colour.BLACK)) {
                    blackPieces.add(board[i][j]);
                }
            }
        }
        if (blackPieces.size() == 1 && blackPieces.get(0) instanceof King) {
            return true;
        } else if (blackPieces.size() == 2 && blackPieces.get(0) instanceof King && blackPieces.get(1) instanceof Knight) {
            return true;
        } else if (blackPieces.size() == 2 && blackPieces.get(0) instanceof Knight && blackPieces.get(1) instanceof King) {
            return true;
        } else if (blackPieces.size() == 2 && blackPieces.get(0) instanceof King && blackPieces.get(1) instanceof Bishop) {
            return true;
        } else if (blackPieces.size() == 2 && blackPieces.get(0) instanceof Bishop && blackPieces.get(1) instanceof King) {
            return true;
        } else {
            return false;
        }

    }

    public boolean insufficientMaterial() {
        return this.insufficientMaterialWhite() && this.insufficientMaterialBlack();
    }
    public PreviousGame storePreviousState()
    {
        Piece[][] cloneBoard = chessBoard.copyBoard();
        Board cloneB = new Board();
        cloneB.setBoard(cloneBoard, chessBoard.getEnpassentColumn());
       return new PreviousGame(cloneB,this.currentMove) ;
       
    }
    public void undoMove(PreviousGame prevGame)
    {
        this.chessBoard=prevGame.getChessBoard();
        this.currentMove=prevGame.getCurrentMove();
    }

    public static class PreviousGame
    {
        private final Board chessBoard;
    private final MoveType currentMove;
    
    private PreviousGame(Board chessBoard , MoveType currentMove)
    {
        this.chessBoard=chessBoard;
        this.currentMove=currentMove;
    }

        private Board getChessBoard() {
            return chessBoard;
        }

        private MoveType getCurrentMove() {
            return currentMove;
        }
    
    }
    
    
}
