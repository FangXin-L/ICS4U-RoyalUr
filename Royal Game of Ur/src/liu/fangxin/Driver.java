package liu.fangxin;

import java.util.ArrayList;
import java.util.Scanner;

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

		//displayPlayer(player1);
		//displayPlayer(player2);

		//Game parameters
		boolean gameDone = false;
		boolean whiteOverlap = false;
		boolean blackOverlap = false;
		int winner = 0;
		Scanner in = new Scanner(System.in);
		//4-sided die
		Die die = new Die(4);

		while (gameDone==false) {
			//Roll die
			int roll = die.roll();
			System.out.println("Roll = " + roll);

			//Select color & piece to move
			System.out.println("White(0) or black(1)? ");
			int colourSelect = in.nextInt();

			System.out.println("Move a piece(1-5)? ");
			int pieceSelect = in.nextInt();

			//Move piece
			if (colourSelect == 0 && roll>0) {
				for(Piece p:player1) {
					if (p.getPosition() == player1.get(pieceSelect-1).getPosition()+roll) {
						whiteOverlap  = true;
						System.out.println("Move blocked");
					}
				}
				if(!whiteOverlap) {
				player1.get(pieceSelect - 1).updatePosition(
						player1.get(pieceSelect-1).getPosition()+roll);
				}
			}
			
			else if (colourSelect == 1 && roll>0) {
				for(Piece p:player2) {
					if (p.getPosition() == player2.get(pieceSelect-1).getPosition()+roll) {
						blackOverlap  = true;
						System.out.println("Move blocked");
					}
				}
				if(!blackOverlap) {
				player2.get(pieceSelect - 1).updatePosition(
						player2.get(pieceSelect-1).getPosition()+roll);
				}
			}

			displayPlayer(player1);
			displayPlayer(player2);

			// System.out.println(colourSelect);
			// System.out.println(pieceSelect);
			
			
			//Check position of pieces
			int player1done = 0;
			for(Piece p:player1) {
				if(p.getPosition()>14) {
					player1done += 1;
				}
			}
			int player2done = 0;
			for(Piece p:player2) {
				if(p.getPosition()>14) {
					player2done += 1;
				}
			}
			//Game over if all pieces of same color are done
			if(player1done>4) {
				gameDone = true;
				winner = 1;
			}
			else if(player2done>4) {
				gameDone = true;
				winner = 2;
			}
		}
		
		//End message
		if(winner == 1) {
			System.out.println("White has won.");
		}
		else if(winner == 2) {
			System.out.println("Black has won.");
		}

		in.close();
	}

	public static void displayPlayer(ArrayList<Piece> pieces) {
		for (int i = 0; i < pieces.size(); i++) {
			System.out.println(pieces.get(i));
		}
	}

}
