package place;


/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */


public class Position 
{
	private int x;
	private int y;

	/**
	 * Build a Position
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
