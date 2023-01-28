package liu.fangxin;

import javafx.scene.control.Button;

/**
 * Button class 
 * Not in use currently
 * @author bird1
 *
 */
public class NewButton extends Button {
	private int row;
	private int col;

	public NewButton(int ro, int co) {
		super();
		row = ro;
		col = co;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public String toString() {
		return "[" + String.valueOf(getRow()) + "," + String.valueOf(getCol()) + "]";
	}

}
