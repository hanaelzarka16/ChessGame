/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author hp
 */
public class Square {
    private int row;
    private Column col;
    private Piece piece;
    public Square(int row , Column col, Piece piece){
        this.row=row;
        this.col=col;
        this.piece=piece;
    }
    
    public int getSquareRow(){
        return row;
    }
    
    public Column getSquareCol(){
        return col;
    }
    
    public Piece getPiece(){
        return piece;
    }
    
    @Override
    public String toString(){
        return (col).toString() + (row+1);
    }
    
}
