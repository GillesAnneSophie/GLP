package place;


/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */


public class Dimension 
{
	private int width;
	private int length;

	
	/**
	 * @param width
	 * @param length
	 */
	public Dimension(int width, int length) 
	{
		this.width = width;
		this.length = length;
	}

	
	/**
	 * @return the width
	 */
	public int getWidth() 
	{
		return width;
	}

	/**
	 * @return the length
	 */
	public int getLength() 
	{
		return length;
	}


	@Override
	public String toString() 
	{
		return "[width=" + width + ", length=" + length + "]";
	}
}
