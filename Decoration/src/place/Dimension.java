package place;

/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */
public class Dimension 
{
	private int lenght;
	private int width;

	
	/**
	 * @param width
	 * @param lenght
	 */
	public Dimension(int width, int lenght) 
	{
		this.lenght = lenght;
		this.width = width;
	}

	
	/**
	 * @return the lenght
	 */
	public int getLenght() 
	{
		return lenght;
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
		return "[lenght=" + lenght + ", width=" + width + "]";
	}
}
