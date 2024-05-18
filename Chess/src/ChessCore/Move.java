/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author hp
 */
public class Move {
    private Square source;
    private Square dest;
    private Piece piece;
    private MoveType type;
    public Move(Square source , Square dest , MoveType type){
        this.source = source; 
        this.dest = dest;
        this.piece = source.getPiece();
        this.type = type;
    }
    
    public Square getSourceSquare(){
        return source;
    }
    public Square getDestSquare(){
        return dest;
    }

    public MoveType getType() {
        return type;
    }
    
    
    
    
}
