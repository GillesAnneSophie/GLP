package place;

/**
 * @author lauryanncoralie
 *
 */
public class Dimension 
{
	private int lenght;
	private int width;

	
	/**
	 * @param lenght
	 * @param width
	 */
	public Dimension(int lenght, int width) {
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

	
	/**
	 * @param lenght the lenght to set
	 */
	public void setLenght(int lenght) 
	{
		this.lenght = lenght;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) 
	{
		this.width = width;
	}


	@Override
	public String toString() 
	{
		return "[lenght=" + lenght + ", width=" + width + "]";
	}
}
