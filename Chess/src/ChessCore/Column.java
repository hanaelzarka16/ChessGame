/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ChessCore;

/**
 *
 * @author hp
 */
public enum Column {
     A(0),B(1),C(2),D(3),E(4),F(5),G(6),H(7);
     
    public final int colNumber;
    
    private Column(int colNumber){
        this.colNumber=colNumber;
    }
    
    public static Column getColumn(int colNumber){
        switch(colNumber){
            case 0 : return A;
            case 1 : return B;
            case 2 : return C;
            case 3 : return D;
            case 4 : return E;
            case 5 : return F;
            case 6 : return G;
            case 7 : return H;
            default : return null;
             
        }
    }
    
    public static Column getColumn(char colLetter){
           switch(colLetter){
            case 'A' : return A;
            case 'a' : return A;
            case 'B' : return B;
            case 'b' : return B;
            case 'C' : return C;
            case 'c' : return C;
            case 'D' : return D;
            case 'd' : return D;
            case 'E' : return E;
            case 'e' : return E;
            case 'F' : return F;
            case 'f' : return F;
            case 'G' : return G;
            case 'g' : return G;
            case 'H' : return H;
            case 'h' : return H;
            default : return null;
             
        }
    }
}
