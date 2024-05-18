/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author hp
 */
public class Queen extends Piece {

    public Queen(int row, Column col, Colour colour,boolean hasMoved) {
        super(row, col, colour,hasMoved);
        this.name=PieceName.Queen;
    }

    @Override
    public boolean isValidMove(int newRow , Column newCol , Piece[][] board) 
   {
       
       Bishop bishCondition = new Bishop(row,col,colour,this.hasMoved) ;
       Rook  rookCondition = new Rook(row,col,colour,this.hasMoved);
       
       if(bishCondition.isValidMove(newRow, newCol, board)){
           this.setCurrentMove(bishCondition.getCurrentMove());
           return true ;
       }
       else if(rookCondition.isValidMove(newRow, newCol, board)){
           this.setCurrentMove(rookCondition.getCurrentMove());
           return true;
       }
       
       return false;
             
   }
    
    @Override
    public void applyMove(Square dest,Piece[][] board){
        board[dest.getSquareRow()][dest.getSquareCol().colNumber] = new Queen(dest.getSquareRow(),dest.getSquareCol(),this.colour,true);
        board[row][col.colNumber]=null;
    }
}