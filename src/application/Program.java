package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import boardgame.Board;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
	
	  static List<ChessPiece> captured = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board board = new Board(8, 8);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
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
		}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
				
			}
		}
	}

