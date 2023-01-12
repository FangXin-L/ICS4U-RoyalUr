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

		displayPlayer(player1);
		displayPlayer(player2);
		
		boolean done = false;
		Scanner in  = new Scanner(System.in);
		Die die = new Die(4);
		while (!done) {
			int roll = die.roll();
			
			System.out.println("Move white(0) or black(1)? ");
			int colourSelect = in.nextInt();
			
			System.out.println("Move which piece(1-5)? ");
			int pieceSelect =  in.nextInt();
			
			if (colourSelect==0) {
				player1.get(pieceSelect-1).updatePosition(roll);
			}
			else {
				player2.get(pieceSelect-1).updatePosition(roll);
			}
			
			displayPlayer(player1);
			displayPlayer(player2);
			
			//System.out.println(colourSelect);
			//System.out.println(pieceSelect);
			System.out.println("Roll = " + roll);
			done = true;
		}
	}

	public static void displayPlayer(ArrayList<Piece> pieces) {
		for (int i = 0; i < pieces.size(); i++) {
			System.out.println(pieces.get(i));
		}
	}
	
}
