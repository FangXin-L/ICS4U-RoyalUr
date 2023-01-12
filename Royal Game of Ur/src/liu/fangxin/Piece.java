package liu.fangxin;

public class Piece {
	private int colour; //0=white, 1=black
	private int position; //0=not on board, >14=finished
	private boolean done;
	
	Piece(int c, int p){
		this.colour = c;
		this.position = p;
		this.done = false;
	}
	
	public int getColour() {
		return colour;
	}
	
	public int getPosition() {
		return position;
	}
	
	public String toString() {
		if(colour==0) {
			return String.format("white %d", position);
		}
		return String.format("black %d", position);
	}
	
	public void updateColour(int c) {
		this.colour = c;
	}
	
	public void updatePosition(int p) {
		this.position = p;
	}
	
	public void updateDone(boolean d) {
		this.done = d;
	}

}
