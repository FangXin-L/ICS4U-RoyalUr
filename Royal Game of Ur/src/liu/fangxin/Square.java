package liu.fangxin;

public class Square {
	 boolean empty;
	 boolean isWhite;
	boolean isBlack;
	
	Square(char s){
		if(s=='e') {
		empty = true;
		isWhite = false;
		isBlack = false;
		}
		if(s=='w') {
			empty = false;
			isWhite = true;
			isBlack = false;
		}
		if(s=='b') {
			empty = false;
			isWhite = false;
			isBlack = true;
		}
		if(s=='2') {
			empty = false;
			isWhite = true;
			isBlack = true;
		}
		
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public boolean isWhite() {
		return isWhite;
	}
	
	public boolean isBlack() {
		return isBlack;
	}
	
	@Override
	public String toString() {
		if (isWhite==true && isBlack==true) {
			return "both";
		}
		else if(isBlack == true) {
			return "black";
		}
		else if(isWhite == true) {
			return "white";
		}
		else if (empty == true) {
			return "empty";
			}
		return "error";
	}

}
