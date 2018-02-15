package place;

/**
 * @author lauryanncoralie
 *
 */
public class Grid 
{
	private Apartment apartment;
	private Dimension dimension;
	private String[][] grid;
	
	/**
	 * @param apartment
	 * @param dimension
	 */
	public Grid(Apartment apartment, Dimension dimension) 
	{
		this.apartment = apartment;
		this.dimension = dimension;
	}
	
	/**
	 * @param dimension
	 */
	public Grid(Dimension dimension) 
	{
		this.dimension = dimension;
		grid = new String[dimension.getWidth()][dimension.getLenght()];
	}

	
	/**
	 * @return the apartment
	 */
	public Apartment getApartment() 
	{
		return apartment;
	}

	/**
	 * @return the dimension
	 */
	public Dimension getDimension() 
	{
		return dimension;
	}

	/**
	 * @return the grid
	 */
	public String[][] getGrid() 
	{
		return grid;
	}

	/**
	 * @param apartment the apartment to set
	 */
	public void setApartment(Apartment apartment) 
	{
		this.apartment = apartment;
	}

	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(Dimension dimension) 
	{
		this.dimension = dimension;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(String[][] grid) 
	{
		this.grid = grid;
	}

}