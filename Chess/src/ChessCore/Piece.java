/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author hp
 */
public abstract class Piece {
    protected int row;
    protected Column col;
    protected Colour colour;
    private MoveType currentMove;
    protected PieceName name;
    protected boolean hasMoved;
    
    public Piece(int row, Column col, Colour colour,boolean hasMoved){
        this.row=row;
        this.col=col;
        this.colour=colour;
        this.currentMove=null;
        this.hasMoved=hasMoved;
    }
    
    public abstract boolean isValidMove(int newRow,Column newCol,Piece[][] board);
    public abstract void applyMove(Square dest,Piece[][] board);
    
    public void setCurrentMove(MoveType currentMove){
        this.currentMove = currentMove;
    }
    
    public MoveType getCurrentMove(){
        return currentMove;
    }
    
    public Colour getColour(){
        return colour;
    }
    
    public int getRow(){
        return row;
    }
    
    public Column getCol(){
        return col;
    }
}
