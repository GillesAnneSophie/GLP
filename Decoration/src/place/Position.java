package place;

/**
 * @author CORALIE Laury Ann
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
	

	@Override
	public String toString() 
	{
		return "Position [x=" + x + ", y=" + y + "]";
	}
}
