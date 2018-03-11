package place;

/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */
public class Dimension 
{
	private int length;
	private int width;

	
	/**
	 * @param width
	 * @param length
	 */
	public Dimension(int width, int length) 
	{
		this.length = length;
		this.width = width;
	}

	
	/**
	 * @return the length
	 */
	public int getLength() 
	{
		return length;
	}

	/**
	 * @return the width
	 */
	public int getWidth() 
	{
		return width;
	}


	@Override
	public String toString() 
	{
		return "[length=" + length + ", width=" + width + "]";
	}
}
