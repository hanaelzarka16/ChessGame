/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;


public class King extends Piece{
    
    

    public King(int row, Column col, Colour colour,boolean hasMoved) {
        super(row, col, colour,hasMoved);
        this.name=PieceName.King;
    }

    @Override
    public boolean isValidMove(int newRow, Column newCol , Piece[][] board) {
        int rowDiff = newRow - row;
        if((rowDiff == 1 && newCol.colNumber == col.colNumber && board[newRow][newCol.colNumber] == null) || (rowDiff == 1 && newCol.colNumber == col.colNumber+1 && board[newRow][newCol.colNumber] == null) || (rowDiff == 1 && newCol.colNumber == col.colNumber-1 && board[newRow][newCol.colNumber] == null)){
            this.setCurrentMove(MoveType.Move);
            return true; //top straight and diagonals case
        }else if((rowDiff == 1 && newCol.colNumber == col.colNumber && board[newRow][newCol.colNumber] != null) || (rowDiff == 1 && newCol.colNumber == col.colNumber+1 && board[newRow][newCol.colNumber] != null) || (rowDiff == 1 && newCol.colNumber == col.colNumber-1 && board[newRow][newCol.colNumber] != null)){
            if((board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){
                this.setCurrentMove(MoveType.Take);//take
                return true;
            }
        }
        
        if((rowDiff==0 && newCol.colNumber==col.colNumber+1 && board[newRow][newCol.colNumber] == null) || (rowDiff==0 && newCol.colNumber==col.colNumber-1 && board[newRow][newCol.colNumber] == null)){
            this.setCurrentMove(MoveType.Move);
            return true; //left and right case
        }else if((rowDiff==0 && newCol.colNumber==col.colNumber+1 && board[newRow][newCol.colNumber] != null) || (rowDiff==0 && newCol.colNumber==col.colNumber-1 && board[newRow][newCol.colNumber] != null)){
            if((board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){
                 this.setCurrentMove(MoveType.Take);//take
                 return true;
            }
        }
        
        if((rowDiff == -1 && newCol.colNumber == col.colNumber && board[newRow][newCol.colNumber] == null) || (rowDiff == -1 && newCol.colNumber == col.colNumber+1 && board[newRow][newCol.colNumber] == null) || (rowDiff == -1 && newCol.colNumber == col.colNumber-1 && board[newRow][newCol.colNumber] == null)){
            this.setCurrentMove(MoveType.Move);
            return true; //bottom straight and diagonals case
        }else if((rowDiff == -1 && newCol.colNumber == col.colNumber && board[newRow][newCol.colNumber] != null) || (rowDiff == -1 && newCol.colNumber == col.colNumber+1 && board[newRow][newCol.colNumber] != null) || (rowDiff == -1 && newCol.colNumber == col.colNumber-1 && board[newRow][newCol.colNumber] != null)){
            if((board[newRow][newCol.colNumber].colour).equals(this.colour.getOpposite())){
                 this.setCurrentMove(MoveType.Take);//take
                 return true;
            }
        }
        if(rowDiff==0 && (newCol.colNumber == col.colNumber+2 || newCol.colNumber==col.colNumber+3)){
        if(this.colour.equals(Colour.WHITE)){
        if(row==0 && col.colNumber == 4 && board[row][col.colNumber+1]==null && board[row][col.colNumber+2]==null && board[0][7] instanceof Rook && board[0][7].colour.equals(Colour.WHITE) && !this.hasMoved && !board[0][7].hasMoved ) //castling for white king 
        {
            this.setCurrentMove(MoveType.Castle);
            return true;
        }
        }
        if(this.colour.equals(Colour.BLACK)){
        if(row==7 && col.colNumber == 4 && board[row][col.colNumber+1]==null && board[row][col.colNumber+2]==null && board[7][7] instanceof Rook && board[7][7].colour.equals(Colour.BLACK) && !this.hasMoved && !board[7][7].hasMoved ) // castling for black king
        {
            this.setCurrentMove(MoveType.Castle);
            return true;
        }
        }
      }else if( rowDiff==0 && (newCol.colNumber == col.colNumber-2 || newCol.colNumber == col.colNumber - 4)){
            if(this.colour.equals(Colour.WHITE)){
        if( row==0 && col.colNumber == 4 && board[row][col.colNumber-1]==null && board[row][col.colNumber-2]==null && board[row][col.colNumber-3]==null && board[0][0] instanceof Rook && board[0][0].colour.equals(Colour.WHITE) && !this.hasMoved && !board[0][0].hasMoved ) //castling for white king 
        {
            this.setCurrentMove(MoveType.Castle);
            return true;
        }
        }
        if(this.colour.equals(Colour.BLACK)){
        if( row==7 && col.colNumber == 4 && board[row][col.colNumber-1]==null && board[row][col.colNumber-2]==null && board[row][col.colNumber-3]==null && board[7][0] instanceof Rook && board[7][0].colour.equals(Colour.BLACK) && !this.hasMoved && !board[7][0].hasMoved) // castling for black king
        {
            this.setCurrentMove(MoveType.Castle);
            return true;
        }
        }
    }
        return false;
    }
    
    @Override
    public void applyMove(Square dest,Piece[][] board){
        board[dest.getSquareRow()][dest.getSquareCol().colNumber] = new King(dest.getSquareRow(),dest.getSquareCol(),this.colour,true);
        board[row][col.colNumber]=null;
    }
    
    public void applyCastling(Square dest, Piece[][] board){
        if(dest.getSquareCol().colNumber == col.colNumber+2 || dest.getSquareCol().colNumber == col.colNumber+3){
            board[row][col.colNumber+2]=new King(row,Column.getColumn(col.colNumber+2),this.colour,true);
            board[row][5]=new Rook(row,Column.getColumn(5),this.colour,true);
            board[row][7]=null;
            board[row][col.colNumber]=null;
        }else if(dest.getSquareCol().colNumber == col.colNumber-2 || dest.getSquareCol().colNumber == col.colNumber-4){
            board[row][col.colNumber-2]=new King(row,Column.getColumn(col.colNumber-2),this.colour,true);
            board[row][3]=new Rook(row,Column.getColumn(3),this.colour,true);
            board[row][0]=null;
            board[row][col.colNumber]=null;
        }
    }
   
    public Square getKingPosition(Colour colour){
        return new Square(row,col,this);
    }
}