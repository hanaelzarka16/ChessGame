/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author hp
 */
public class Knight extends Piece {

    public Knight(int row, Column col, Colour colour,boolean hasMoved) {
        super(row, col, colour,hasMoved);
        this.name=PieceName.Knight;
    }

    @Override
    public boolean isValidMove(int newRow, Column newCol, Piece[][] board) {
        int rowDiff = newRow - row;
        
        if((rowDiff==2 && newCol.colNumber == col.colNumber+1 && board[newRow][newCol.colNumber] == null) || (rowDiff==2 && newCol.colNumber == col.colNumber-1 && board[newRow][newCol.colNumber] == null)){//Upward L condition left or right
            this.setCurrentMove(MoveType.Move);
            return true;
        }else if((rowDiff==2 && newCol.colNumber == col.colNumber+1 && board[newRow][newCol.colNumber] != null) || (rowDiff==2 && newCol.colNumber == col.colNumber-1 && board[newRow][newCol.colNumber] != null)){//take
            if((board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){
                this.setCurrentMove(MoveType.Take);
                return true;
            }
        }
        
        if((rowDiff==1 && newCol.colNumber == col.colNumber+2 && board[newRow][newCol.colNumber] == null) || (rowDiff==1 && newCol.colNumber == col.colNumber-2 && board[newRow][newCol.colNumber] == null)){//Left or right then up L condition
             this.setCurrentMove(MoveType.Move);
            return true;
        }else if((rowDiff==1 && newCol.colNumber == col.colNumber+2 && board[newRow][newCol.colNumber] != null) || (rowDiff==1 && newCol.colNumber == col.colNumber-2 && board[newRow][newCol.colNumber] != null)){//take
            if((board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){
                 this.setCurrentMove(MoveType.Take);
                 return true;
            }
        }
        
        if((rowDiff==-1 && newCol.colNumber == col.colNumber+2 && board[newRow][newCol.colNumber] == null) || (rowDiff==-1 && newCol.colNumber == col.colNumber-2 && board[newRow][newCol.colNumber] == null)){//Left or right then down L condition
             this.setCurrentMove(MoveType.Move);
            return true;
        }else if((rowDiff==-1 && newCol.colNumber == col.colNumber+2 && board[newRow][newCol.colNumber] != null) || (rowDiff==-1 && newCol.colNumber == col.colNumber-2 && board[newRow][newCol.colNumber] != null)){//take
            if((board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){
                 this.setCurrentMove(MoveType.Take);
                 return true;
            }
        }
        
        if((rowDiff==-2 && newCol.colNumber == col.colNumber+1 && board[newRow][newCol.colNumber] == null ) || (rowDiff==-2 && newCol.colNumber == col.colNumber-1 && board[newRow][newCol.colNumber] == null)){//Downwards L then left or right
            this.setCurrentMove(MoveType.Move);
            return true;
        }else if((rowDiff==-2 && newCol.colNumber == col.colNumber+1 && board[newRow][newCol.colNumber] != null ) || (rowDiff==-2 && newCol.colNumber == col.colNumber-1 && board[newRow][newCol.colNumber] != null)){//take
            if((board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){
                this.setCurrentMove(MoveType.Take);
                 return true;
            }
        }
        
        return false;
    }
    
    @Override
    public void applyMove(Square dest,Piece[][] board){
        board[dest.getSquareRow()][dest.getSquareCol().colNumber] = new Knight(dest.getSquareRow(),dest.getSquareCol(),this.colour,true);
        board[row][col.colNumber]=null;
    }
}
