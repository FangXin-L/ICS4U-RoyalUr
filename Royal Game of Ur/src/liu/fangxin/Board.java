package liu.fangxin;

import java.util.ArrayList;

public class Board {
	
	ArrayList<Square> board = new ArrayList<Square>();{
	//create empty board
	
	for (int i1=0; i1<14; i1++) {
		Square s = new Square('e');
		board.add(s);
	}
	
	int roll = 4;
	int position = 0;
	
	board.get(position+roll).isBlack = true;
	
	
	for (int i=0; i<board.size(); i++) {
		System.out.println(board.get(i));
	}
}
}

