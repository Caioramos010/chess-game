package application;

import chessgame.chess.ChessException;
import chessgame.chess.ChessMatch;
import chessgame.chess.ChessPiece;
import chessgame.chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gameType = 0;
        int erro = 0;
        while (gameType == 0 || gameType > 1 || gameType < 0) {
            try {
                UI.clearScreen();
                System.out.println("ENTER THE NUMBER 1 FOR THE GAME: ");
                System.out.println();
                System.out.println("     --------------------");
                System.out.println("     |  1 CHESS GAME 1  |");
                System.out.println("     --------------------");
                System.out.println();
                System.out.println("                   BY CAIO RAMOS");
                System.out.print("GAME: ");
                gameType = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
            }
        }
        if (gameType == 1) {
            ChessMatch chessMatch = new ChessMatch();
            List<ChessPiece> captured = new ArrayList<>();
            while (!chessMatch.getCheckMate()) {
                try {
                    UI.clearScreen();
                    UI.printMatch(chessMatch, captured);
                    System.out.println();
                    System.out.print("Source: ");
                    ChessPosition source = UI.readChessPosition(sc);

                    boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getPieces(), possibleMoves);
                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(sc);

                    ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                    if (capturedPiece != null) {
                        captured.add(capturedPiece);
                    }

                    if (chessMatch.getPromoted() != null) {
                        System.out.print("Enter piece for promotion (B/N/R/Q): ");
                        String type = sc.nextLine().toUpperCase();
                        while (!type.equals("B") && !type.equals("N") && !type.equals("R") & !type.equals("Q")) {
                            System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
                            type = sc.nextLine().toUpperCase();
                        }
                        chessMatch.replacePromotedPiece(type);
                    }
                } catch (ChessException e) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
            }
            UI.clearScreen();
            UI.printMatch(chessMatch, captured);
        }

    }
}