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
	public String getGrid(int x, int y) 
	{
		return grid[x][y];
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
	 * @param isStackable
	 * @param x
	 * @param y
	 * @param dimension
	 * @param type
	 * @param category
	 * @return true or false
	 * */
	public boolean canBePlace(boolean isStackable, int x, int y, Dimension dimension, String type, String category)
	{
		boolean placable=false;
		/* The object is not stackable
		 * Can be place IN a room
		 * Can't be place ON another Furniture
		 * */
		if(!isStackable)
		{
			if(type=="Furniture")
			{
				for(int i=x ; i<x+dimension.getLenght() ; i++)
				{
					for(int j=y ; j<y+dimension.getWidth() ; j++)
					{
						if(getGrid(i, j)=="1")
						{
							placable = true;
						}
						else
						{
							return false;
						}
					}
				}
			}
			else if(type=="Room")
			{
				for(int i=x-1 ; i<x+dimension.getWidth()+1 ; i++)
				{
					for(int j=y-1 ; j<y+dimension.getLenght()+1 ; j++)
					{
						if(i<0)
						{
							i++;
						}
						else if(j<0)
						{
							j++;
						}
						else if(i>14)
						{
							break;
						}
						else if(getGrid(i, j)=="0")
						{
							placable = true;
						}
						else
						{
							return false;
						}
					}
				}
			}
		}
		/* The object is stackable
		 * Can be place IN a room
		 * Can be place ON another objet which is stackable
		 * */
		else
		{		
			if(category=="Floor")
			{
				for(int i=x ; i<x+dimension.getWidth() ; i++)
				{
					for(int j=y ; j<y+dimension.getLenght() ; j++)
					{
						if(getGrid(i, j)=="9" || getGrid(i, j)=="0")
						{
							return false;
						}
						else
						{
							placable = true;
						}
					}
				}
			}
			else if(category=="Wall")
			{
				for(int i=x ; i<x+dimension.getWidth() ; i++)
				{
					for(int j=y ; j<y+dimension.getLenght() ; j++)
					{
						if(getGrid(i, j)=="9")
						{
							placable = true;
						}
						else
						{
							return false;
						}
					}
				}
			}
		}	
		return placable;
	}
	
	/**
	 * Print the current grid
	 */
	public void showGrid() 
	{
		System.out.println("\nGrid :\n");
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