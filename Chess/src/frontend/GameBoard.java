/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import javax.swing.JPanel;
import ChessCore.*;
import ChessCore.ChessGame.PreviousGame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class GameBoard extends javax.swing.JFrame {
    
    private ChessGame game;
    private Board board;
    private Piece currentPiece;
    private int turn;
    private boolean gameEnded;
    private BufferedImage[] pieces = new BufferedImage[12];
    private Stack<PreviousGame> prevMoves ;
    
    
    public GameBoard() {
        prevMoves = new Stack<>();
        board = new Board();
        game = new ChessGame(board);
        try {
            pieces[0] = ImageIO.read(new File("WhitePawn.png"));
            pieces[1] = ImageIO.read(new File("WhiteRook.png"));
            pieces[2] = ImageIO.read(new File("WhiteKnight.png"));
            pieces[3] = ImageIO.read(new File("WhiteBishop.png"));
            pieces[4] = ImageIO.read(new File("WhiteQueen.png"));
            pieces[5] = ImageIO.read(new File("WhiteKing.png"));
            pieces[6] = ImageIO.read(new File("BlackPawn.png"));
            pieces[7] = ImageIO.read(new File("BlackRook.png"));
            pieces[8] = ImageIO.read(new File("BlackKnight.png"));
            pieces[9] = ImageIO.read(new File("BlackBishop.png"));
            pieces[10] = ImageIO.read(new File("BlackQueen.png"));
            pieces[11] = ImageIO.read(new File("BlackKing.png"));
        } catch (IOException ex) {
            System.out.println("File Not Found!");
        }
        initComponents();
    }
    
    public Piece toPiece(int row, int col) {
        Piece[][] chessBoard = game.getBoard();
        return chessBoard[row][col];
    }
    
    public ImageIcon getPiece(int row, int col) {
        Piece[][] chessBoard = game.getBoard();
        if (chessBoard[row][col] instanceof Pawn && chessBoard[row][col].getColour().equals(Colour.WHITE)) {
            Image scaledimg = pieces[0].getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledimg);
            return img;
        } else if (chessBoard[row][col] instanceof Rook && chessBoard[row][col].getColour().equals(Colour.WHITE)) {
            Image scaledimg = pieces[1].getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledimg);
            return img;
        } else if (chessBoard[row][col] instanceof Knight && chessBoard[row][col].getColour().equals(Colour.WHITE)) {
            Image scaledimg = pieces[2].getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledimg);
            return img;
        } else if (chessBoard[row][col] instanceof Bishop && chessBoard[row][col].getColour().equals(Colour.WHITE)) {
            Image scaledimg = pieces[3].getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledimg);
            return img;
        } else if (chessBoard[row][col] instanceof Queen && chessBoard[row][col].getColour().equals(Colour.WHITE)) {
            Image scaledimg = pieces[4].getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledimg);
            return img;
        } else if (chessBoard[row][col] instanceof King && chessBoard[row][col].getColour().equals(Colour.WHITE)) {
            Image scaledimg = pieces[5].getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledimg);
            return img;
        } else if (chessBoard[row][col] instanceof Pawn && chessBoard[row][col].getColour().equals(Colour.BLACK)) {
            Image scaledimg = pieces[6].getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledimg);
            return img;
        } else if (chessBoard[row][col] instanceof Rook && chessBoard[row][col].getColour().equals(Colour.BLACK)) {
            Image scaledimg = pieces[7].getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledimg);
            return img;
        } else if (chessBoard[row][col] instanceof Knight && chessBoard[row][col].getColour().equals(Colour.BLACK)) {
            Image scaledimg = pieces[8].getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledimg);
            return img;
        } else if (chessBoard[row][col] instanceof Bishop && chessBoard[row][col].getColour().equals(Colour.BLACK)) {
            Image scaledimg = pieces[9].getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledimg);
            return img;
        } else if (chessBoard[row][col] instanceof Queen && chessBoard[row][col].getColour().equals(Colour.BLACK)) {
            Image scaledimg = pieces[10].getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledimg);
            return img;
        } else if (chessBoard[row][col] instanceof King && chessBoard[row][col].getColour().equals(Colour.BLACK)) {
            Image scaledimg = pieces[11].getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledimg);
            return img;
        } else {
            return null;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chess");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel2KeyReleased(evt);
            }
        });
        jPanel2.setLayout(new java.awt.GridLayout(8, 8));
        for(int i=0 ; i<8 ; i++){
            for(int j=0 ; j<8 ; j++){
                JLabel tile = new JLabel();
                tile.setPreferredSize(new Dimension(64,64));
                tile.setHorizontalAlignment(JLabel.CENTER);
                tile.setVerticalAlignment(JLabel.CENTER);
                tile.setOpaque(true);
                if((i+j)%2 == 0){
                    if(board.getBoard()[8-i-1][j] != null){
                        tile.setIcon(getPiece(8-i-1,j));
                    }
                    tile.setBackground(new Color(225,198,153));
                }else{
                    if(board.getBoard()[8-i-1][j] != null){
                        tile.setIcon(getPiece(8-i-1,j));
                    }
                    tile.setBackground(new Color(150,75,0));
                }
                jPanel2.add(tile);
            }
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.getAccessibleContext().setAccessibleName("");
        jPanel2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

    }//GEN-LAST:event_jPanel2MouseClicked
    public void refreshBoard() {
        refreshPieces();
        Component[] tiles = jPanel2.getComponents();
        for (int i = 0; i < tiles.length; i++) {
            if (i >= 0 && i <= 7) {
                if (i % 2 == 0) {
                    tiles[i].setBackground(new Color(225, 198, 153));//beige
                } else if (i % 2 != 0) {
                    tiles[i].setBackground(new Color(150, 75, 0));//brown
                }
            } else {
                if ((tiles[i].getBackground().equals(Color.CYAN) || tiles[i].getBackground().equals(Color.RED)) && tiles[i - 8].getBackground().equals(new Color(225, 198, 153))) {
                    tiles[i].setBackground(new Color(150, 75, 0));
                } else if ((tiles[i].getBackground().equals(Color.CYAN) || tiles[i].getBackground().equals(Color.RED)) && tiles[i - 8].getBackground().equals(new Color(150, 75, 0))) {
                    tiles[i].setBackground(new Color(225, 198, 153));
                }
            }
        }
    }
    
    public void refreshPieces() {
        Component[] tiles = jPanel2.getComponents();
        if (turn % 2 == 0) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (game.getBoard()[8 - i - 1][j] != null) {
                        ((JLabel) tiles[i * 8 + j]).setIcon(getPiece(8 - i - 1, j));
                    } else {
                        ((JLabel) tiles[i * 8 + j]).setIcon(null);
                    }
                    
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (game.getBoard()[i][j] != null) {
                        ((JLabel) tiles[i * 8 + j]).setIcon(getPiece(i, j));
                    } else {
                        ((JLabel) tiles[i * 8 + j]).setIcon(null);
                    }
                    
                }
            }
        }
    }
    

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged

    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        if (gameEnded) {
            return;
        }
        int mouseRow;
        if (turn % 2 == 0) {
            mouseRow = Math.abs((evt.getY() / 64) - 7);
        } else {
            mouseRow = evt.getY() / 64;
        }
        if (turn % 2 != 0 && toPiece(mouseRow, evt.getX() / 64) != null && toPiece(mouseRow, evt.getX() / 64).getColour().equals(Colour.WHITE)) {
            return;
        }
        if (turn % 2 == 0 && toPiece(mouseRow, evt.getX() / 64) != null && toPiece(mouseRow, evt.getX() / 64).getColour().equals(Colour.BLACK)) {
            return;
        }
        refreshBoard();
        if (toPiece(mouseRow, evt.getX() / 64) != null) {
            //System.out.println(toPiece(mouseRow, evt.getX() / 64).toString() + toPiece(mouseRow, evt.getX() / 64).getColour().toString());
            Square src = new Square(mouseRow, Column.getColumn(evt.getX() / 64), toPiece(mouseRow, evt.getX() / 64));
            currentPiece = src.getPiece();
            ArrayList<Move> validMoves = game.getAllValidMovesFromSquare(src);
            Component[] tiles = jPanel2.getComponents();
            Component clickedTile = jPanel2.getComponentAt(evt.getPoint());
            clickedTile.setBackground(Color.CYAN);
            for (int i = 0; i < validMoves.size(); i++) {
                int singleIndex = ((validMoves.get(i).getDestSquare().getSquareRow() * 8) + validMoves.get(i).getDestSquare().getSquareCol().colNumber);// convert from 2d index to 1d index 
                if (turn % 2 == 0) {
                    if (singleIndex <= 7) {
                        tiles[63 + singleIndex - 7].setBackground(Color.CYAN);
                    } else if (singleIndex > 7 && singleIndex <= 15) {
                        tiles[63 + singleIndex - 23].setBackground(Color.CYAN);
                    } else if (singleIndex > 15 && singleIndex <= 23) {
                        tiles[63 + singleIndex - 39].setBackground(Color.CYAN);
                    } else if (singleIndex > 23 && singleIndex <= 31) {
                        tiles[63 + singleIndex - 55].setBackground(Color.CYAN);
                    } else if (singleIndex > 31 && singleIndex <= 39) {
                        tiles[63 + singleIndex - 71].setBackground(Color.CYAN);
                    } else if (singleIndex > 39 && singleIndex <= 47) {
                        tiles[63 + singleIndex - 87].setBackground(Color.CYAN);
                    } else if (singleIndex > 47 && singleIndex <= 55) {
                        tiles[63 + singleIndex - 103].setBackground(Color.CYAN);
                    } else if (singleIndex > 55 && singleIndex <= 63) {
                        tiles[63 + singleIndex - 119].setBackground(Color.CYAN);
                    }
                } else {
                    tiles[singleIndex].setBackground(Color.CYAN);
                }
            }
            
        }
        if (game.isWhiteInCheck()) {
            Component[] tiles = jPanel2.getComponents();
            Piece[][] piecesArr = game.getBoard();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (piecesArr[i][j] instanceof King && piecesArr[i][j].getColour().equals(Colour.WHITE)) {
                        int singleIndex = i * 8 + j;//2d to 1d
                        if (turn % 2 == 0) {
                            if (singleIndex <= 7) {
                                tiles[63 + singleIndex - 7].setBackground(Color.RED);
                            } else if (singleIndex > 7 && singleIndex <= 15) {
                                tiles[63 + singleIndex - 23].setBackground(Color.RED);
                            } else if (singleIndex > 15 && singleIndex <= 23) {
                                tiles[63 + singleIndex - 39].setBackground(Color.RED);
                            } else if (singleIndex > 23 && singleIndex <= 31) {
                                tiles[63 + singleIndex - 55].setBackground(Color.RED);
                            } else if (singleIndex > 31 && singleIndex <= 39) {
                                tiles[63 + singleIndex - 71].setBackground(Color.RED);
                            } else if (singleIndex > 39 && singleIndex <= 47) {
                                tiles[63 + singleIndex - 87].setBackground(Color.RED);
                            } else if (singleIndex > 47 && singleIndex <= 55) {
                                tiles[63 + singleIndex - 103].setBackground(Color.RED);
                            } else if (singleIndex > 55 && singleIndex <= 63) {
                                tiles[63 + singleIndex - 119].setBackground(Color.RED);
                            }
                        } else {
                            tiles[singleIndex].setBackground(Color.RED);
                        }
                    }
                    
                }
            }
        }
        if (game.isBlackInCheck()) {
            Component[] tiles = jPanel2.getComponents();
            Piece[][] piecesArr = game.getBoard();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (piecesArr[i][j] instanceof King && piecesArr[i][j].getColour().equals(Colour.BLACK)) {
                        int singleIndex = i * 8 + j;
                        if (turn % 2 == 0) {
                            if (singleIndex <= 7) {
                                tiles[63 + singleIndex - 7].setBackground(Color.RED);
                            } else if (singleIndex > 7 && singleIndex <= 15) {
                                tiles[63 + singleIndex - 23].setBackground(Color.RED);
                            } else if (singleIndex > 15 && singleIndex <= 23) {
                                tiles[63 + singleIndex - 39].setBackground(Color.RED);
                            } else if (singleIndex > 23 && singleIndex <= 31) {
                                tiles[63 + singleIndex - 55].setBackground(Color.RED);
                            } else if (singleIndex > 31 && singleIndex <= 39) {
                                tiles[63 + singleIndex - 71].setBackground(Color.RED);
                            } else if (singleIndex > 39 && singleIndex <= 47) {
                                tiles[63 + singleIndex - 87].setBackground(Color.RED);
                            } else if (singleIndex > 47 && singleIndex <= 55) {
                                tiles[63 + singleIndex - 103].setBackground(Color.RED);
                            } else if (singleIndex > 55 && singleIndex <= 63) {
                                tiles[63 + singleIndex - 119].setBackground(Color.RED);
                            }
                        } else {
                            tiles[singleIndex].setBackground(Color.RED);
                        }
                    }
                    
                }
            }
        }
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseReleased
        if (gameEnded) {
            return;
        }
        int mouseRow;
        if (turn % 2 == 0) {
            mouseRow = Math.abs((evt.getY() / 64) - 7);
        } else {
            mouseRow = evt.getY() / 64;
        }
        refreshBoard();
        if (currentPiece != null) {
            Square src = new Square(currentPiece.getRow(), currentPiece.getCol(), currentPiece);
            Square dest = new Square(mouseRow, Column.getColumn(evt.getX() / 64), game.getBoard()[mouseRow][evt.getX() / 64]);
            //System.out.println(dest.toString());
            if (game.isValidMove(src, dest, turn)) {
                if (game.getCurrentMove().equals(MoveType.Move) || game.getCurrentMove().equals(MoveType.Take) || game.getCurrentMove().equals(MoveType.DoubleMove)) {
                    prevMoves.push(game.storePreviousState());
                    currentPiece.applyMove(dest, game.getBoard());
                    turn++;
                    refreshBoard();
                } else if (game.getCurrentMove().equals(MoveType.Castle)) {
                    prevMoves.push(game.storePreviousState());
                    ((King) currentPiece).applyCastling(dest, game.getBoard());
                    turn++;
                    refreshBoard();
                } else if (game.getCurrentMove().equals(MoveType.Enpassent)) {
                     prevMoves.push(game.storePreviousState());
                    ((Pawn) currentPiece).applyEnpassent(dest, game.getBoard());
                    turn++;
                    refreshBoard();
                } else if (game.getCurrentMove().equals(MoveType.Promotion) || game.getCurrentMove().equals(MoveType.PromotionTake)) {
                    PieceName[] promotionPieces = {PieceName.Bishop, PieceName.Knight, PieceName.Rook, PieceName.Queen};
                    int promoteTo = JOptionPane.showOptionDialog(null, "Promote Pawn To", "Pawn Promotion", 0, 3, null, promotionPieces, promotionPieces[0]);
                    if (promoteTo < 0 || promoteTo > 3) {
                        prevMoves.push(game.storePreviousState());
                        ((Pawn) currentPiece).applyPromotion(dest, promotionPieces[0], game.getBoard());
                        turn++;
                        refreshBoard();
                        
                    }
                    prevMoves.push(game.storePreviousState());
                    ((Pawn) currentPiece).applyPromotion(dest, promotionPieces[promoteTo], game.getBoard());
                    turn++;
                    refreshBoard();
                    
                }
            }
        }
        if (game.isWhiteInCheck()) {
            Component[] tiles = jPanel2.getComponents();
            Piece[][] piecesArr = game.getBoard();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (piecesArr[i][j] instanceof King && piecesArr[i][j].getColour().equals(Colour.WHITE)) {
                        int singleIndex = i * 8 + j;
                        if (turn % 2 == 0) {
                            if (singleIndex <= 7) {
                                tiles[63 + singleIndex - 7].setBackground(Color.RED);
                            } else if (singleIndex > 7 && singleIndex <= 15) {
                                tiles[63 + singleIndex - 23].setBackground(Color.RED);
                            } else if (singleIndex > 15 && singleIndex <= 23) {
                                tiles[63 + singleIndex - 39].setBackground(Color.RED);
                            } else if (singleIndex > 23 && singleIndex <= 31) {
                                tiles[63 + singleIndex - 55].setBackground(Color.RED);
                            } else if (singleIndex > 31 && singleIndex <= 39) {
                                tiles[63 + singleIndex - 71].setBackground(Color.RED);
                            } else if (singleIndex > 39 && singleIndex <= 47) {
                                tiles[63 + singleIndex - 87].setBackground(Color.RED);
                            } else if (singleIndex > 47 && singleIndex <= 55) {
                                tiles[63 + singleIndex - 103].setBackground(Color.RED);
                            } else if (singleIndex > 55 && singleIndex <= 63) {
                                tiles[63 + singleIndex - 119].setBackground(Color.RED);
                            }
                        } else {
                            tiles[singleIndex].setBackground(Color.RED);
                        }
                    }
                    
                }
            }
            if (game.whiteCheckmate()) {
                JOptionPane.showMessageDialog(null, "Black Won");
                gameEnded = true;
            }
        }
        if (game.isBlackInCheck()) {
            Component[] tiles = jPanel2.getComponents();
            Piece[][] piecesArr = game.getBoard();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (piecesArr[i][j] instanceof King && piecesArr[i][j].getColour().equals(Colour.BLACK)) {
                        int singleIndex = i * 8 + j;
                        if (turn % 2 == 0) {
                            if (singleIndex <= 7) {
                                tiles[63 + singleIndex - 7].setBackground(Color.RED);
                            } else if (singleIndex > 7 && singleIndex <= 15) {
                                tiles[63 + singleIndex - 23].setBackground(Color.RED);
                            } else if (singleIndex > 15 && singleIndex <= 23) {
                                tiles[63 + singleIndex - 39].setBackground(Color.RED);
                            } else if (singleIndex > 23 && singleIndex <= 31) {
                                tiles[63 + singleIndex - 55].setBackground(Color.RED);
                            } else if (singleIndex > 31 && singleIndex <= 39) {
                                tiles[63 + singleIndex - 71].setBackground(Color.RED);
                            } else if (singleIndex > 39 && singleIndex <= 47) {
                                tiles[63 + singleIndex - 87].setBackground(Color.RED);
                            } else if (singleIndex > 47 && singleIndex <= 55) {
                                tiles[63 + singleIndex - 103].setBackground(Color.RED);
                            } else if (singleIndex > 55 && singleIndex <= 63) {
                                tiles[63 + singleIndex - 119].setBackground(Color.RED);
                            }
                        } else {
                            tiles[singleIndex].setBackground(Color.RED);
                        }
                    }
                    
                }
            }
            if (game.blackCheckmate()) {
                JOptionPane.showMessageDialog(null, "White Won");
                gameEnded = true;
            }
        }
        if (game.insufficientMaterial()) {
            JOptionPane.showMessageDialog(null, "Insufficient Material");
            gameEnded = true;
        }
        if (game.whiteStalemate() || game.blackStalemate()) {
            JOptionPane.showMessageDialog(null, "Stalemate");
            gameEnded = true;
        }
    }//GEN-LAST:event_jPanel2MouseReleased

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
      
    }//GEN-LAST:event_jPanel2KeyPressed

    private void jPanel2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyReleased

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
      {
          if(!prevMoves.empty()){
          game.undoMove(prevMoves.pop());
          turn--;
          refreshBoard();
          }
      }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
