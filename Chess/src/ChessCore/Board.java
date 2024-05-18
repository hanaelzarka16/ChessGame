/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author hp
 */
public class Board {
     private Piece[][] board = new Piece[8][8];
     private Column enPassentColumn;
    public Board(){
        board[0][0] = new Rook(0,Column.A,Colour.WHITE,false);
        board[0][1] = new Knight(0,Column.B,Colour.WHITE,false);
        board[0][2] = new Bishop(0,Column.C,Colour.WHITE,false);
        board[0][3] = new Queen(0,Column.D,Colour.WHITE,false);
        board[0][4] = new King(0,Column.E, Colour.WHITE,false);
        board[0][5] = new Bishop(0,Column.F,Colour.WHITE,false);
        board[0][6] = new Knight(0,Column.G,Colour.WHITE,false);
        board[0][7] = new Rook(0,Column.H,Colour.WHITE,false); 
        for(int i = 0 ; i<8 ; i++){
            board[1][i] = new Pawn(1,Column.getColumn(i),Colour.WHITE,false);
        }
        
        board[7][0] = new Rook(7,Column.A,Colour.BLACK,false);
        board[7][1] = new Knight(7,Column.B,Colour.BLACK,false);
        board[7][2] = new Bishop(7,Column.C,Colour.BLACK,false);
        board[7][3] = new Queen(7,Column.D,Colour.BLACK,false);
        board[7][4] = new King(7,Column.E, Colour.BLACK,false);
        board[7][5] = new Bishop(7,Column.F,Colour.BLACK,false);
        board[7][6] = new Knight(7,Column.G,Colour.BLACK,false);
        board[7][7] = new Rook(7,Column.H,Colour.BLACK,false);
        for(int i=0 ; i<8 ; i++){
            board[6][i] = new Pawn(6,Column.getColumn(i),Colour.BLACK,false);        
        }    
    }
    
    public Piece[][] getBoard(){
        return this.board;
    }
    
    public void setBoard(Piece[][] board,Column enPassentColumn){
        this.board=board;
        this.enPassentColumn=enPassentColumn;
    }
    public void setEnpassentColumn(Column column){
        this.enPassentColumn=column;
    }
    public Column getEnpassentColumn(){
        return enPassentColumn;
    }
    public Piece[][] copyBoard(){
        Piece[][] boardCopy = new Piece[8][8];
        for(int i=0 ; i<8 ;i++){
            for(int j=0 ; j<8;j++){
                if(board[i][j]==null){
                    boardCopy[i][j]=board[i][j];
                }else
                boardCopy[i][j]=board[i][j].name.getPieceObject(i, Column.getColumn(j), board[i][j].colour,board[i][j].hasMoved);
            }
        }
        return boardCopy;
    }
    
}
