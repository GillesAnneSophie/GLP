package place;

import java.util.HashMap;

/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */
public class Grid 
{
	private Dimension dimension;
	private String[][] grid = new String[][] { {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"} , {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};
	
	
	/**
	 * @param dimension
	 */
	public Grid(Dimension dimension) 
	{
		this.dimension = dimension;
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


	/** Return true if the object can be place at the given position
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
						if(getGrid(i, j).matches("[a-z]"))
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
						else if(getGrid(i, j)=="#")
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
						if(getGrid(i, j)=="$" || getGrid(i, j)=="#")
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
						if(getGrid(i, j)=="$")
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
	
	/** Remove a Room from the Grid
	 * @param room
	 * */
	public void removeRoom(Room room)
	{
		for(int i=room.getPosition().getX()-1 ; i<room.getPosition().getX()+room.getDimension().getLenght()+1 ; i++)
		{
			for(int j=room.getPosition().getY()-1 ; j<room.getPosition().getY()+room.getDimension().getWidth()+1 ; j++)
			{
				setGrid(i, j, "#");
			}
		}
	}
	
	/** Remove a Furniture from the Grid
	 * @param furniture
	 * */
	public void removeFurniture(AbstractRoom furniture, HashMap<Integer, AbstractRoom> furnituresOfTheRoom)
	{
		for(int i=furniture.getPosition().getX() ; i<furniture.getPosition().getX()+furniture.getDimension().getLenght() ; i++)
		{
			for(int j=furniture.getPosition().getY() ; j<furniture.getPosition().getY()+furniture.getDimension().getWidth() ; j++)
			{
				/*If there is an other Furniture at the same place*/
				int furnitureToSet = whichFurnitureIsHere(furnituresOfTheRoom, i, j);
				if(furnitureToSet!=-1)
				{
					String number = String.valueOf(furnitureToSet);
					setGrid(i, j, number);
				}
				else
				{//TODO changer "1" > Caractère correspondant au numéro de la pièce
					setGrid(i, j, "1");
				}
			}
		}
	}
	
	public int whichFurnitureIsHere(HashMap<Integer, AbstractRoom> furnituresOfTheRoom, int i, int j)
	{
		for(int f=0 ; f<furnituresOfTheRoom.size() ; f++)
		{
			Position position = furnituresOfTheRoom.get(f).getPosition();
			AbstractRoom furniture = furnituresOfTheRoom.get(f);
			if(position.getX()==i && position.getY()==j)
			{
				return f;
			}
			else
			{
				for(int k=position.getX()+1 ; k<position.getX()+furniture.getDimension().getLenght() ; k++)
				{
					for(int l=position.getY()+1 ; l<position.getY()+furniture.getDimension().getWidth() ; l++)
					{
						if(k==i && l==j)
						{
							return f;
						}
					}
				}
			}
		}
		return -1;
	}
	
	
	/** Print the current grid */
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