/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author hp
 */
public class Pawn extends Piece {
    
    public Pawn(int row, Column col, Colour colour,boolean hasMoved) {
        super(row, col, colour,hasMoved);
        this.name=PieceName.Pawn;
    }
    
    @Override
    public boolean isValidMove(int newRow, Column newCol, Piece[][] board) {
        if (this.colour.equals(Colour.WHITE)) {//White pawns
            if (this.row == 1) {
                if (newCol.equals(col) && newRow == row + 1  && board[newRow][newCol.colNumber] == null) {//First move case
                    this.setCurrentMove(MoveType.Move);
                    return true;
                }else if(newCol.equals(col) && newRow == row + 2 && board[newRow][newCol.colNumber] == null && board[row+1][newCol.colNumber] ==null){
                    this.setCurrentMove(MoveType.DoubleMove);
                    return true;
                }else if (newRow == row + 1 && newCol.colNumber == col.colNumber + 1 && board[newRow][newCol.colNumber] != null && (board[newRow][newCol.colNumber].colour).equals(Colour.BLACK)) {//take
                    this.setCurrentMove(MoveType.Take);
                    return true;
                } else if (newRow == row + 1 && newCol.colNumber == col.colNumber - 1 && board[newRow][newCol.colNumber] != null && (board[newRow][newCol.colNumber].colour).equals(Colour.BLACK)) {//take
                    this.setCurrentMove(MoveType.Take);
                    return true;
                } else {
                    return false;
                }
            } else if (newCol.equals(col) && newRow == row + 1 && board[newRow][newCol.colNumber] == null) {//After first move
                if(newRow == 7){
                    this.setCurrentMove(MoveType.Promotion);
                    return true;
                }
                this.setCurrentMove(MoveType.Move);
                return true;
            } else if (newRow == row + 1 && newCol.colNumber == col.colNumber + 1 && board[newRow][newCol.colNumber] != null && (board[newRow][newCol.colNumber].colour).equals(Colour.BLACK)) {//take
                if(newRow == 7){
                    this.setCurrentMove(MoveType.PromotionTake);
                    return true;
                }
                this.setCurrentMove(MoveType.Take);
                return true;
            } else if (newRow == row + 1 && newCol.colNumber == col.colNumber - 1 && board[newRow][newCol.colNumber] != null && (board[newRow][newCol.colNumber].colour).equals(Colour.BLACK)) {//take
                if(newRow==7){
                    this.setCurrentMove(MoveType.PromotionTake);
                    return true;
                }
                this.setCurrentMove(MoveType.Take);
                return true;
            }else if(newRow == row + 1 && newCol.colNumber == col.colNumber + 1 && board[newRow][newCol.colNumber] == null && board[row][col.colNumber+1] != null && (board[row][col.colNumber+1].colour).equals(Colour.BLACK) && row==4 ){
                this.setCurrentMove(MoveType.Enpassent);
                return true;
            }else if(newRow == row + 1 && newCol.colNumber == col.colNumber - 1 && board[newRow][newCol.colNumber] == null && board[row][col.colNumber-1] != null && (board[row][col.colNumber-1].colour).equals(Colour.BLACK) && row==4  ){
                this.setCurrentMove(MoveType.Enpassent);
                return true;
            }else {
                return false;
            }
        }

        if (this.colour.equals(Colour.BLACK)) {//Black pawns
            if (this.row == 6) {
                if (newCol.equals(col) && newRow == row - 1   && board[newRow][newCol.colNumber] == null) {//First move case
                    this.setCurrentMove(MoveType.Move);
                    return true;
                }else if(newCol.equals(col) && newRow == row - 2 && board[newRow][newCol.colNumber] == null && board[row-1][newCol.colNumber]==null){
                    this.setCurrentMove(MoveType.DoubleMove);
                    return true;
                }else if (newRow == row - 1 && newCol.colNumber == col.colNumber + 1 && board[newRow][newCol.colNumber] != null && (board[newRow][newCol.colNumber].colour).equals(Colour.WHITE)) {//take
                    this.setCurrentMove(MoveType.Take);
                    return true;
                } else if (newRow == row - 1 && newCol.colNumber == col.colNumber - 1 && board[newRow][newCol.colNumber] != null && (board[newRow][newCol.colNumber].colour).equals(Colour.WHITE)) {//take
                    this.setCurrentMove(MoveType.Take);
                    return true;
                } else {
                    return false;
                }
            } else if (newCol.equals(col) && newRow == row - 1 && board[newRow][newCol.colNumber] == null) {
                if(newRow == 0){
                    this.setCurrentMove(MoveType.Promotion);
                    return true;
                }
                this.setCurrentMove(MoveType.Move);
                return true;
            } else if (newRow == row - 1 && newCol.colNumber == col.colNumber + 1 && board[newRow][newCol.colNumber] != null && (board[newRow][newCol.colNumber].colour).equals(Colour.WHITE)) {//take
                if(newRow == 0){
                    this.setCurrentMove(MoveType.PromotionTake);
                    return true;
                }
                this.setCurrentMove(MoveType.Take);
                return true;
            } else if (newRow == row - 1 && newCol.colNumber == col.colNumber - 1 && board[newRow][newCol.colNumber] != null && (board[newRow][newCol.colNumber].colour).equals(Colour.WHITE)) {//take
                if(newRow == 0){
                    this.setCurrentMove(MoveType.PromotionTake);
                    return true;
                }
                this.setCurrentMove(MoveType.Take);
                return true;
            }else if(newRow == row - 1 && newCol.colNumber == col.colNumber + 1 && board[newRow][newCol.colNumber] == null && board[row][col.colNumber+1]!=null && (board[row][col.colNumber+1].colour).equals(Colour.WHITE) && row == 3){
                this.setCurrentMove(MoveType.Enpassent);
                return true;
            }else if(newRow == row - 1 && newCol.colNumber == col.colNumber - 1 && board[newRow][newCol.colNumber] == null && board[row][col.colNumber-1]!=null && (board[row][col.colNumber-1].colour).equals(Colour.WHITE) && row == 3 ){
                this.setCurrentMove(MoveType.Enpassent);
                return true;
            }else {
                return false;
            }
        }

        return false;
    }
    
    @Override
    public void applyMove(Square dest,Piece[][] board){
        board[dest.getSquareRow()][dest.getSquareCol().colNumber] = new Pawn(dest.getSquareRow(),dest.getSquareCol(),this.colour,true);
        board[row][col.colNumber]=null;
    }
    
    public void applyPromotion(Square dest, PieceName promoteTo , Piece[][] board){
        board[dest.getSquareRow()][dest.getSquareCol().colNumber] = promoteTo.getPieceObject(dest.getSquareRow(), dest.getSquareCol(), this.colour,true);
        board[row][col.colNumber]=null;
    }
    
    public void applyEnpassent(Square dest,Piece[][] board){
            board[dest.getSquareRow()][dest.getSquareCol().colNumber] = new Pawn(dest.getSquareRow(),dest.getSquareCol(),this.colour,true);
            board[row][dest.getSquareCol().colNumber]=null;
            board[row][col.colNumber]=null; 
    }
}
