/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7;

import ChessCore.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board chessBoard = new Board();
        ChessGame game = new ChessGame(chessBoard);
        Piece[][] board = game.getBoard();
        File chessGame = new File("ChessGame.txt");
        boolean gameEnded = false;
        try {
            Scanner sc = new Scanner(chessGame);
            int i = 0;//turn counter
            while (sc.hasNextLine()) {
                String moveStr = sc.nextLine();
                if (gameEnded) {
                    System.out.println("Game already ended");
                    continue;
                }
                String[] moveInfo = moveStr.split(",");
                if (moveInfo.length == 2) {
                    int sourceRow = (moveInfo[0].charAt(1) - '0') - 1;
                    Column sourceCol = Column.getColumn(moveInfo[0].charAt(0));
                    int destRow = (moveInfo[1].charAt(1) - '0') - 1;
                    Column destCol = Column.getColumn(moveInfo[1].charAt(0));
                    Square source = new Square(sourceRow, sourceCol, board[sourceRow][sourceCol.colNumber]);
                    Square dest = new Square(destRow, destCol, board[destRow][destCol.colNumber]);
                    if (game.isValidMove(source, dest, i)) {
                        if (game.getCurrentMove().equals(MoveType.Move) || game.getCurrentMove().equals(MoveType.DoubleMove)) {
                            board[source.getSquareRow()][source.getSquareCol().colNumber].applyMove(dest, board);
                            i++;
                            if (game.isWhiteInCheck()) {
                                if (game.whiteCheckmate()) {
                                    System.out.println("Black Won");
                                    gameEnded = true;
                                } else {
                                    System.out.println("White in check");
                                }
                            }
                            if (game.isBlackInCheck()) {
                                if (game.blackCheckmate()) {
                                    System.out.println("White Won");
                                    gameEnded = true;
                                } else {
                                    System.out.println("Black in check");
                                }
                            }
                            if (game.insufficientMaterial()) {
                                System.out.println("Insufficient Material");
                                gameEnded = true;
                            }
                            if (game.whiteStalemate() || game.blackStalemate()) {
                                System.out.println("Stalemate");
                                gameEnded = true;
                            }
                        } else if (game.getCurrentMove().equals(MoveType.Enpassent)) {
                            System.out.println("Enpassant");
                            System.out.println("Captured Pawn");
                            ((Pawn) board[source.getSquareRow()][source.getSquareCol().colNumber]).applyEnpassent(dest, board);
                            i++;
                            if (game.isWhiteInCheck()) {
                                if (game.whiteCheckmate()) {
                                    System.out.println("Black Won");
                                    gameEnded = true;
                                } else {
                                    System.out.println("White in check");
                                }
                            }
                            if (game.isBlackInCheck()) {
                                if (game.blackCheckmate()) {
                                    System.out.println("White Won");
                                    gameEnded = true;
                                } else {
                                    System.out.println("Black in check");
                                }
                            }
                            if (game.insufficientMaterial()) {
                                System.out.println("Insufficient Material");
                                gameEnded = true;
                            }
                            if (game.whiteStalemate() || game.blackStalemate()) {
                                System.out.println("Stalemate");
                                gameEnded = true;
                            }
                        } else if (game.getCurrentMove().equals(MoveType.Take)) {
                            String capturedPiece = board[dest.getSquareRow()][dest.getSquareCol().colNumber].getClass().getSimpleName();
                            System.out.println("Captured " + capturedPiece);
                            board[source.getSquareRow()][source.getSquareCol().colNumber].applyMove(dest, board);
                            i++;
                            if (game.isWhiteInCheck()) {
                                if (game.whiteCheckmate()) {
                                    System.out.println("Black Won");
                                    gameEnded = true;
                                } else {
                                    System.out.println("White in check");
                                }
                            }
                            if (game.isBlackInCheck()) {
                                if (game.blackCheckmate()) {
                                    System.out.println("White Won");
                                    gameEnded = true;
                                } else {
                                    System.out.println("Black in check");
                                }
                            }
                            if (game.insufficientMaterial()) {
                                System.out.println("Insufficient Material");
                                gameEnded = true;
                            }
                            if (game.whiteStalemate() || game.blackStalemate()) {
                                System.out.println("Stalemate");
                                gameEnded = true;
                            }
                        } else if (game.getCurrentMove().equals(MoveType.Castle)) {
                            System.out.println("Castle");
                            ((King) board[source.getSquareRow()][source.getSquareCol().colNumber]).applyCastling(dest, board);
                            i++;
                            if (game.isWhiteInCheck()) {
                                if (game.whiteCheckmate()) {
                                    System.out.println("Black Won");
                                    gameEnded = true;
                                } else {
                                    System.out.println("White in check");
                                }
                            }
                            if (game.isBlackInCheck()) {
                                if (game.blackCheckmate()) {
                                    System.out.println("White Won");
                                    gameEnded = true;
                                } else {
                                    System.out.println("Black in check");
                                }
                            }
                            if (game.insufficientMaterial()) {
                                System.out.println("Insufficient Material");
                                gameEnded = true;
                            }
                            if (game.whiteStalemate() || game.blackStalemate()) {
                                System.out.println("Stalemate");
                                gameEnded = true;
                            }
                        }
                    } else {
                        System.out.println("Invalid move");
                    }
                } else if (moveInfo.length == 3) {
                    int sourceRow = (moveInfo[0].charAt(1) - '0') - 1;
                    Column sourceCol = Column.getColumn(moveInfo[0].charAt(0));
                    int destRow = (moveInfo[1].charAt(1) - '0') - 1;
                    PieceName promotionPiece = PieceName.getPieceName(moveInfo[2].charAt(0));
                    Column destCol = Column.getColumn(moveInfo[1].charAt(0));
                    Square source = new Square(sourceRow, sourceCol, board[sourceRow][sourceCol.colNumber]);
                    Square dest = new Square(destRow, destCol, board[destRow][destCol.colNumber]);
                    if (game.isValidMove(source, dest, i)) {
                        if (game.getCurrentMove().equals(MoveType.Promotion)) {
                            ((Pawn) board[source.getSquareRow()][source.getSquareCol().colNumber]).applyPromotion(dest, promotionPiece, board);
                            i++;
                            if (game.isWhiteInCheck()) {
                                if (game.whiteCheckmate()) {
                                    System.out.println("Black Won");
                                    gameEnded = true;
                                } else {
                                    System.out.println("White in check");
                                }
                            }
                            if (game.isBlackInCheck()) {
                                if (game.blackCheckmate()) {
                                    System.out.println("White Won");
                                    gameEnded = true;
                                } else {
                                    System.out.println("Black in check");
                                }
                            }
                            if (game.insufficientMaterial()) {
                                System.out.println("Insufficient Material");
                                gameEnded = true;
                            }
                            if (game.whiteStalemate() || game.blackStalemate()) {
                                System.out.println("Stalemate");
                                gameEnded = true;
                            }
                        } else if (game.getCurrentMove().equals(MoveType.PromotionTake)) {
                            String capturedPiece = board[dest.getSquareRow()][dest.getSquareCol().colNumber].getClass().getSimpleName();
                            System.out.println("Captured " + capturedPiece);
                            ((Pawn) board[source.getSquareRow()][source.getSquareCol().colNumber]).applyPromotion(dest, promotionPiece, board);
                            i++;
                            if (game.isWhiteInCheck()) {
                                if (game.whiteCheckmate()) {
                                    System.out.println("Black Won");
                                    gameEnded = true;
                                } else {
                                    System.out.println("White in check");
                                }
                            }
                            if (game.isBlackInCheck()) {
                                if (game.blackCheckmate()) {
                                    System.out.println("White Won");
                                    gameEnded = true;
                                } else {
                                    System.out.println("Black in check");
                                }
                            }
                            if (game.insufficientMaterial()) {
                                System.out.println("Insufficient Material");
                                gameEnded = true;
                            }
                            if (game.whiteStalemate() || game.blackStalemate()) {
                                System.out.println("Stalemate");
                                gameEnded = true;
                            }
                        }
                    } else {
                        System.out.println("Invalid move");
                    }

                }
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found!");
        }

    }

}
