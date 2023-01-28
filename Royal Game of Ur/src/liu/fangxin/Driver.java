package liu.fangxin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Text based driver 
 * Two players 
 * Five pieces per player 
 * Most logic is functional
 * Manual input required
 * 
 * @author bird1
 *
 */
public class Driver {

	public static void main(String[] args) {
		// Pieces for white
		ArrayList<Piece> player1 = new ArrayList<Piece>();
		for (int i = 0; i < 5; i++) {
			Piece piece = new Piece(0, 0);
			player1.add(piece);
		}

		// Pieces for black
		ArrayList<Piece> player2 = new ArrayList<Piece>();
		for (int i = 0; i < 5; i++) {
			Piece piece = new Piece(1, 0);
			player2.add(piece);
		}

		// Game parameters
		boolean gameDone = false;
		int[] safeSquare = { 4, 8, 14 };
		int colourSelect = 0;
		int pieceSelect = 0;
		int whiteOverlap = 0;
		int blackOverlap = 0;
		int winner = 0;
		Scanner in = new Scanner(System.in);
		// 4-sided die
		Die die = new Die(4);

		while (gameDone == false) {
			// Roll die
			int roll = die.roll();
			System.out.println("Roll = " + roll);

			// Roll of zero = skip turn
			if (roll == 0) {
				System.out.println("Rolled zero");
			}
			// Ask user to select color and piece
			else {
				System.out.println("White(0) or black(1)? ");
				colourSelect = in.nextInt();

				System.out.println("Move a piece(1-5): ");
				boolean inValid = false;
				while (!inValid) {
					pieceSelect = in.nextInt();
					if (pieceSelect > 0 && pieceSelect < 6) {
						inValid = true;
					}
				}
			}

			// Move white piece
			if (colourSelect == 0 && roll > 0) {
				// Check for overlap with your own pieces
				for (Piece p : player1) {
					if (p.getPosition() == player1.get(pieceSelect - 1).getPosition() + roll) {
						whiteOverlap += 1;
					}
				}
				// Check if center rosette is occupied by opponent
				for (Piece p : player2) {
					if (p.getPosition() == player1.get(pieceSelect - 1).getPosition() + roll) {
						if (p.getPosition() == 8) {
							whiteOverlap += 1;
						}
					}
				}
				// Clear to move piece
				if (whiteOverlap == 0) {
					player1.get(pieceSelect - 1).updatePosition(player1.get(pieceSelect - 1).getPosition() + roll);
				}
				// Try a different piece
				else if (whiteOverlap < 4) {
					System.out.println("Move blocked, try again");
				}
				// Skip turn
				else if (whiteOverlap == 4) {
					System.out.println("All moves are blocked");
				}
			}

			// Move black piece
			else if (colourSelect == 1 && roll > 0) {
				// Check for overlap with your own pieces
				for (Piece p : player2) {
					if (p.getPosition() == player2.get(pieceSelect - 1).getPosition() + roll) {
						blackOverlap += 1;
					}
				}
				// Check if center rosette is occupied by opponent
				for (Piece p : player1) {
					if (p.getPosition() == player2.get(pieceSelect - 1).getPosition() + roll) {
						if (p.getPosition() == 8) {
							blackOverlap += 1;
						}
					}
				}
				// Clear to move piece
				if (blackOverlap == 0) {
					player2.get(pieceSelect - 1).updatePosition(player2.get(pieceSelect - 1).getPosition() + roll);

				} else if (blackOverlap < 4) {
					System.out.println("Move blocked");
				} else if (blackOverlap == 4) {
					System.out.println("All moves are blocked");
				}
			}

			// Print position of pieces
			displayPlayer(player1);
			displayPlayer(player2);

			// Reset overlap counter
			whiteOverlap = 0;
			blackOverlap = 0;

			// System.out.println(colourSelect);
			// System.out.println(pieceSelect);

			// Check if pieces are done
			int player1done = 0;
			for (Piece p : player1) {
				if (p.getPosition() > 14) {
					player1done += 1;
				}
			}
			int player2done = 0;
			for (Piece p : player2) {
				if (p.getPosition() > 14) {
					player2done += 1;
				}
			}
			// Game over if all pieces of same colour are done
			if (player1done > 4) {
				gameDone = true;
				winner = 1;
			} else if (player2done > 4) {
				gameDone = true;
				winner = 2;
			}
		}

		// End message
		if (winner == 1) {
			System.out.println("White has won.");
		} else if (winner == 2) {
			System.out.println("Black has won.");
		}

		in.close();
	}

	public static void displayPlayer(ArrayList<Piece> pieces) {
		for (int i = 0; i < pieces.size(); i++) {
			System.out.println(pieces.get(i));
		}
		System.out.println();
	}

}
