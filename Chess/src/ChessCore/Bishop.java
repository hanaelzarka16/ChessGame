/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author hp
 */
public class Bishop extends Piece{

    public Bishop(int row, Column col, Colour colour,boolean hasMoved) {
        super(row, col, colour,hasMoved);
        this.name=PieceName.Bishop;
    }

    @Override
    public boolean isValidMove(int newRow, Column newCol,Piece[][] board) {
       int maxRowLim_T = 8 - (row+1); //# of rows above bishop
       int maxRowLim_B = row; //# of rows under bishop
       int maxColLim_R= 8 - (col.colNumber+1); //# of columns to the right of bishop
       int maxColLim_L=col.colNumber; //# of columns to the left of the bishop
       
      
       if(newRow>row && newCol.colNumber>col.colNumber){
       for(int i=1; i<=maxRowLim_T ; i++){//Top right diagonal condition
           for(int j=1; j<=maxColLim_R ; j++){
                if(board[row+i][col.colNumber+j]!=null && i==j && newRow!=row+i && newCol.colNumber!=col.colNumber+j){
                       return false;
                   }
               if(newRow == row + i && newCol.colNumber == col.colNumber + j && i==j && board[newRow][newCol.colNumber]==null){
                   this.setCurrentMove(MoveType.Move);
                   return true;
               }else if(newRow == row + i && newCol.colNumber == col.colNumber + j && i==j && board[newRow][newCol.colNumber]!=null && (board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){//take
                   this.setCurrentMove(MoveType.Take);
                   return true;
               }
           }
       }
      }else if(newRow>row && newCol.colNumber<col.colNumber){
       
       for(int i=1 ; i<=maxRowLim_T ;i++){//Top left diagonal condition
           for(int j=1 ; j<=maxColLim_L ;j++){
                if(board[row+i][col.colNumber-j]!=null && i==j && newRow!=row+i && newCol.colNumber!=col.colNumber-j){
                       return false;
                   }
               if(newRow == row + i && newCol.colNumber == col.colNumber - j && i==j && board[newRow][newCol.colNumber] == null){
                   this.setCurrentMove(MoveType.Move);
                   return true;
               }else if(newRow == row + i && newCol.colNumber == col.colNumber - j && i==j && board[newRow][newCol.colNumber] != null && (board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){//take
                   this.setCurrentMove(MoveType.Take);
                   return true;
               }
           }
       }
      }else if(newRow<row && newCol.colNumber>col.colNumber){
       
       for(int i=1 ; i<=maxRowLim_B ;i++){//Bottom right diagonal condition
           for(int j=1 ; j<=maxColLim_R ;j++){
                if(board[row-i][col.colNumber+j]!=null && i==j && newRow!=row-i && newCol.colNumber!=col.colNumber+j){
                       return false;
                   }
               if(newRow == row - i && newCol.colNumber == col.colNumber + j && i==j && board[newRow][newCol.colNumber] == null){
                   this.setCurrentMove(MoveType.Move);
                   return true;
               }else if(newRow == row - i && newCol.colNumber == col.colNumber + j && i==j && board[newRow][newCol.colNumber] != null && (board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){//take
                   this.setCurrentMove(MoveType.Take);
                   return true;
               }
           }
       }
      }else if(newRow<row && newCol.colNumber < col.colNumber){
       
        for(int i=1 ; i<=maxRowLim_B ;i++){//Bottom left diagonal condition
           for(int j=1 ; j<=maxColLim_L ;j++){
                if(board[row-i][col.colNumber-j]!=null && i==j && newRow!=row-i && newCol.colNumber!=col.colNumber-j){
                       return false;
                   }
               if(newRow == row - i && newCol.colNumber == col.colNumber - j && i==j && board[newRow][newCol.colNumber] == null){
                   this.setCurrentMove(MoveType.Move);
                   return true;
               }else if(newRow == row - i && newCol.colNumber == col.colNumber - j && i==j && board[newRow][newCol.colNumber] != null && (board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){//take
                   this.setCurrentMove(MoveType.Take);
                   return true;
               }
           }
       }
      } 
       return false;
       
    }
    
    @Override
    public void applyMove(Square dest,Piece[][] board){
        board[dest.getSquareRow()][dest.getSquareCol().colNumber] = new Bishop(dest.getSquareRow(),dest.getSquareCol(),this.colour,true);
        board[row][col.colNumber]=null;
    }
    
}
