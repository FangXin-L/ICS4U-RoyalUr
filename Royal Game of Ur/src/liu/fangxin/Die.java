package liu.fangxin;

import java.util.Random;

/**
 * Die with zero
 * 
 * @author Fangxin
 *
 */
public class Die {
	private int value;
	private int numSides;

	Die(int num) {
		numSides = num;
	}

	public int roll() {
		Random random = new Random();
		value = random.nextInt(Integer.valueOf(numSides) + 1);
		return value;
	}
}
