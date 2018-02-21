package place;

/**
 * @author CORALIE Laury Ann
 *
 */
public class Grid 
{
	private Apartment apartment;
	private Dimension dimension;
	private String[][] grid = new String[][] { {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};
	
	
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
	public void setGrid(int x, int y, String car) 
	{
		this.grid[x][y]=car;
	}


	/**
	 * Print the current grid
	 */
	public void showGrid() 
	{
		for(int i=0 ; i<grid.length ; i++)
		{
			for(int j=0 ; j<grid.length ; j++)
			{
				System.out.print("|" + grid[i][j]);
			}
			System.out.print("|\n");
		}
	}
}