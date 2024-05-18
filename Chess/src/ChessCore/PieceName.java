/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ChessCore;

/**
 *
 * @author hp
 */
public enum PieceName {
    Pawn,Knight,Bishop,Rook,Queen,King;
    
    public static PieceName getPieceName(char c){
        switch(c){
            case 'K':
                return Knight;
            case 'B':
                return Bishop;
            case 'R':
                return Rook;
            case 'Q':
                return Queen;
            default:
                return null;
        }
    }
    
    public Piece getPieceObject(int row , Column col, Colour colour,boolean hasMoved){
        if(this.equals(Knight)){
            return new Knight(row,col,colour,hasMoved);
        }else if(this.equals(Bishop)){
            return new Bishop(row,col,colour,hasMoved);
        }else if(this.equals(Rook)){
            return new Rook(row,col,colour,hasMoved);
        }else if(this.equals(Queen)){
            return new Queen(row,col,colour,hasMoved);
        }else if(this.equals(Pawn)){
            return new Pawn(row,col,colour,hasMoved);
        }else if(this.equals(King)){
            return new King(row,col,colour,hasMoved);
        }else
            return null;
    }
}
