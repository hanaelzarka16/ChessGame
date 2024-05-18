/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author hp
 */
public class Rook extends Piece{

    public Rook(int row, Column col, Colour colour,boolean hasMoved) {
        super(row, col, colour,hasMoved);
        this.name=PieceName.Rook;
    }

    @Override
    public boolean isValidMove(int newRow, Column newCol, Piece[][] board) {
        int topLimit = 8-(row+1);
        int bottomLimit = row;
        int rightLimit=8-(col.colNumber+1);
        int leftLimit =col.colNumber;
        if(newRow>row && newCol.colNumber==col.colNumber && board[newRow][newCol.colNumber]==null){//upwards case
            for(int i = 1 ; i<=topLimit ; i++){
                if(board[row+i][col.colNumber]!= null && row+i<newRow){
                    return false;
                }
            }
            this.setCurrentMove(MoveType.Move);
            return true;
        }else if(newRow>row && newCol.colNumber==col.colNumber && board[newRow][newCol.colNumber]!=null && (board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){//take
             for(int i = 1 ; i<=topLimit ; i++){
                if(board[row+i][col.colNumber]!= null && row+i<newRow){
                    return false;
                }
            }
             this.setCurrentMove(MoveType.Take);
             return true;    
        }
        
         if(newRow<row && newCol.colNumber==col.colNumber && board[newRow][newCol.colNumber]==null){  //downwards case
            for(int i = 1 ; i<=bottomLimit ; i++){
                if(board[row-i][col.colNumber]!= null && row-i>newRow){
                    return false;
                }
            }
            this.setCurrentMove(MoveType.Move);
            return true;
        }else if(newRow<row && newCol.colNumber==col.colNumber && board[newRow][newCol.colNumber]!=null && (board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){//take
            for(int i = 1 ; i<=bottomLimit ; i++){
                if(board[row-i][col.colNumber]!= null && row-i>newRow){
                    return false;
                }
            }
            this.setCurrentMove(MoveType.Take);
            return true;
        }
         
         if(newRow==row && newCol.colNumber>col.colNumber && board[newRow][newCol.colNumber]==null){//Left case
             for(int i=1; i<=rightLimit ; i++){
                 if(board[row][col.colNumber+i] != null && col.colNumber+i<newCol.colNumber){
                     return false;
                 }
             }
             this.setCurrentMove(MoveType.Move);
             return true;
         }else if(newRow==row && newCol.colNumber>col.colNumber && board[newRow][newCol.colNumber]!=null && (board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){//take
                   for(int i=1; i<=rightLimit ; i++){
                 if(board[row][col.colNumber+i] != null && col.colNumber+i<newCol.colNumber){
                     return false;
                 }
             }
                   this.setCurrentMove(MoveType.Take);
                   return true;
         }
         
         if(newRow==row && newCol.colNumber<col.colNumber && board[newRow][newCol.colNumber]==null){//Right case
             for(int i=1; i<=leftLimit ; i++){
                 if(board[row][col.colNumber-i] != null && col.colNumber-i>newCol.colNumber){
                     return false;
                 }
             }
             this.setCurrentMove(MoveType.Move);
             return true;
         }else if(newRow==row && newCol.colNumber<col.colNumber && board[newRow][newCol.colNumber]!=null && (board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){//take
             for(int i=1; i<=leftLimit ; i++){
                 if(board[row][col.colNumber-i] != null && col.colNumber-i>newCol.colNumber){
                     return false;
                 }
             }
              this.setCurrentMove(MoveType.Take);
              return true;
         }
         return false;
    }
    
    @Override
    public void applyMove(Square dest,Piece[][] board){
        board[dest.getSquareRow()][dest.getSquareCol().colNumber] = new Rook(dest.getSquareRow(),dest.getSquareCol(),this.colour,true);
        board[row][col.colNumber]=null;
    }
}
