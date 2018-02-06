package place;

/**
 * @author lauryanncoralie
 *
 */
public class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getPositionX() {
		return x; 
	}

	public int getPositionY() {
		return y; 
	}

	public void moveUp() {
		y--;
	}

	public void moveDown() {
		y++;
	}

	public void moveLeft() {
		x--;
	}

	public void moveRight() {
		x++;
	}
}
