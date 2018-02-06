package place;

/**
 * @author lauryanncoralie
 *
 */
public class Position 
{
	private int x;
	private int y;

	/**
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}


	/**
	 * @return the x
	 */
	public int getX() 
	{
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() 
	{
		return y;
	}


	public void moveUp() 
	{
		y--;
	}

	public void moveDown() 
	{
		y++;
	}

	public void moveLeft() 
	{
		x--;
	}

	public void moveRight() 
	{
		x++;
	}


	@Override
	public String toString() 
	{
		return "Position [x=" + x + ", y=" + y + "]";
	}
}
