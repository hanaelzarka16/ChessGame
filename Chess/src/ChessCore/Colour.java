/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ChessCore;

/**
 *
 * @author hp
 */
public enum Colour {
    BLACK,WHITE;
    public Colour getOpposite(){
        if(this.equals(WHITE)){
            return BLACK;
        }else
            return WHITE;
    }
    public int getTurn(){
        if(this.equals(WHITE)){
            return 0;
        }else
            return 1;
    }
}
