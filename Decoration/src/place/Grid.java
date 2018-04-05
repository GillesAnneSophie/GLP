package place;

import java.util.HashMap;


/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */


public class Grid 
{
	private Dimension gridDimension;
	private String charInDefaultGrid = "#";
	private String[][] grid;
	

	/**
	 * Build a Grid
	 * @param dimension
	 */
	public Grid(Dimension dimension) 
	{
		this.gridDimension = dimension;
		grid = new String[gridDimension.getWidth()][gridDimension.getLength()];
		
		for(int i=0 ; i<gridDimension.getLength() ; i++)
		{
			for(int j=0 ; j<gridDimension.getWidth() ; j++)
			{
				setGrid(i, j, charInDefaultGrid);
			}
		}
	}

	
	/**
	 * @return the gridDimension
	 */
	public Dimension getGridDimension() 
	{
		return gridDimension;
	}

	/**
	 * @param positionX
	 * @param positionY
	 * @return the value of the grid at the given position
	 */
	public String getGrid(int positionX, int positionY) 
	{
		return grid[positionX][positionY];
	}

	
	/**
	 * @param positionX
	 * @param positionY
	 * @param car
	 */
	public void setGrid(int positionX, int positionY, String car) 
	{
		this.grid[positionX][positionY]=car;
	}


	/**
	 * Return true if the object can be place at the given position
	 * @param isStackable
	 * @param positionX
	 * @param positionY
	 * @param name
	 * @param dimension
	 * @param type
	 * @param category
	 * @return true or false
	 */
	public boolean canBePlace(boolean isStackable, int positionX, int positionY, String name, Dimension dimension, String type, String category)
	{
		boolean placable=false;
		int dimensionLength = dimension.getLength();
		int dimensionWidth = dimension.getWidth();
		
	/* 
	 * The object is not stackable
	 * Can be place IN a room
	 * Can't be place ON another Furniture
	 * */
		if(!isStackable)
		{
			if(type=="Furniture")
			{
				for(int i=positionY ; i<positionY+dimensionLength ; i++)
				{
					for(int j=positionX ; j<positionX+dimensionWidth ; j++)
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
				for(int i=positionY-1 ; i<positionY+dimensionLength+1 ; i++)
				{
					for(int j=positionX-1 ; j<positionX+dimensionWidth+1 ; j++)
					{
						if(i<0)
						{
							return false;
						}
						else if(j<0)
						{
							return false;
						}
						else if(i>(gridDimension.getWidth()-1))
						{
							return false;
						}
						else if(j>(gridDimension.getLength()-1))
						{
							return false;
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
	 * Can be place ON another element which is stackable
	 * */
		else
		{
			if(category=="Floor")
			{
				for(int i=positionY ; i<positionY+dimensionLength ; i++)
				{
					for(int j=positionX ; j<positionX+dimensionWidth ; j++)
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
				for(int i=positionY ; i<positionY+dimensionLength ; i++)
				{
					for(int j=positionX ; j<positionX+dimensionWidth ; j++)
					{
						if(name.contains("door"))
						{
							placable = true;
							for(int m=positionY-1 ; m<positionY+dimensionLength+1 ; m++)
							{
								for(int n=positionX-1 ; n<positionX+dimensionWidth+1 ; n++)
								{
									if(dimensionWidth>1)
									{
										if(n==positionX)
										{
											if(getGrid(m, n).matches("[0-9]+"))
											{
												return false;
											}
										}
										else if(n==(positionX-1)+dimensionWidth)
										{
											if(getGrid(m, n).matches("[0-9]+"))
											{
												return false;
											}
										}
									}
									else if(dimensionLength>1)
									{
										if(m==positionY)
										{
											if(getGrid(m, n).matches("[0-9]+"))
											{
												return false;
											}
										}
										else if(m==(positionY-1)+dimensionLength)
										{
											if(getGrid(m, n).matches("[0-9]+"))
											{
												return false;
											}
										}
									}
									else
									{
										if(m==positionY || n==positionX)
										{
											if(getGrid(m, n).matches("[0-9]+"))
											{
												return false;
											}
										}
									}
								}
							}
						}
						else
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
		}	
		return placable;
	}
	
	/** 
	 * Remove a Room from the Grid
	 * @param room
	 * */
	public void removeRoom(Room room)
	{
		int roomPositionX = room.getPosition().getX();
		int roomLength = room.getDimension().getLength();
		int roomPositionY = room.getPosition().getY();
		int roomWidth = room.getDimension().getWidth();
		
		for(int i=roomPositionY-1 ; i<roomPositionY+roomLength+1 ; i++)
		{
			for(int j=roomPositionX-1 ; j<roomPositionX+roomWidth+1 ; j++)
			{
				setGrid(i, j, "#");
			}
		}
	}
	
	/**
	 * Remove a Furniture from the Grid
	 * @param furniture
	 * @param allTheFurnitureOfTheRoom
	 * @param roomsList
	 */
	public void removeFurniture(AbstractRoom furniture, HashMap<Integer, AbstractRoom> allTheFurnitureOfTheRoom, HashMap<Integer, Room> roomsList)
	{
		int furniturePositionX = furniture.getPosition().getX();
		int furnitureLength = furniture.getDimension().getLength();
		int furniturePositionY = furniture.getPosition().getY();
		int furnitureWidth = furniture.getDimension().getWidth();
		String furnitureCategory = furniture.getCategory();
		String furnitureName = furniture.getName();
		
		for(int i=furniturePositionY ; i<furniturePositionY+furnitureLength ; i++)
		{
			for(int j=furniturePositionX ; j<furniturePositionX+furnitureWidth ; j++)
			{
				if(furnitureCategory=="Wall")
				{
					setGrid(i, j, "$");
					if(furnitureName.contains("door"))
					{
						for(int m=furniturePositionY-1 ; m<furniturePositionY+furnitureLength+1 ; m++)
						{
							for(int n=furniturePositionX-1 ; n<furniturePositionX+furnitureWidth+1 ; n++)
							{
								if(getGrid(m, n)=="*")
								{
									String roomToSet = whichRoomIsHere(roomsList, m, n);
									if(roomToSet!=null)
									{
										setGrid(m, n, roomToSet);
									}
								}
							}
						}
					}
				}
				else
				{
					int furnitureToSet = whichFurnitureIsHere(allTheFurnitureOfTheRoom, furnitureName, i, j);
					if(furnitureToSet!=-1)
					{
						String number = String.valueOf(furnitureToSet);
						setGrid(i, j, number);
					}
					else
					{
						String roomToSet = whichRoomIsHere(roomsList, i, j);
						if(roomToSet!=null)
						{
							setGrid(i, j, roomToSet);
						}
					}
				}
			}
		}
	}

	/**
	 * Return the furniture to set at the given position
	 * @param allTheFurnitureOfTheRoom
	 * @param name
	 * @param positionX
	 * @param positionY
	 * @return numberOfTheFurniture or -1
	 */
	public int whichFurnitureIsHere(HashMap<Integer, AbstractRoom> allTheFurnitureOfTheRoom, String name, int positionX, int positionY)
	{
		for(int numberOfTheFurniture=0 ; numberOfTheFurniture<allTheFurnitureOfTheRoom.size() ; numberOfTheFurniture++)
		{
			int furniturePositionX = allTheFurnitureOfTheRoom.get(numberOfTheFurniture).getPosition().getX();
			int furniturePositionY = allTheFurnitureOfTheRoom.get(numberOfTheFurniture).getPosition().getY();
			int furnitureWidth = allTheFurnitureOfTheRoom.get(numberOfTheFurniture).getDimension().getWidth();
			int furnitureLength = allTheFurnitureOfTheRoom.get(numberOfTheFurniture).getDimension().getLength();
			String furnitureName = allTheFurnitureOfTheRoom.get(numberOfTheFurniture).getName();
			
			for(int k=furniturePositionY ; k<furniturePositionY+furnitureLength ; k++)
			{
				for(int l=furniturePositionX ; l<furniturePositionX+furnitureWidth ; l++)
				{
					if(k==positionX && l==positionY && furnitureName!=name)
					{
						return numberOfTheFurniture;
					}
				}
			}
		}
		return -1;
	}
	
	/** 
	 * Return the room to set at the given position
	 * @param roomsList
	 * @param positionX
	 * @param positionY
	 * @return letterOfTheRoom or null
	 * */
	public String whichRoomIsHere(HashMap<Integer, Room> roomsList, int positionX, int positionY)
	{
		for(int i=0 ; i<roomsList.size() ; i++)
		{
			int roomPositionX = roomsList.get(i).getPosition().getX();
			int roomPositionY = roomsList.get(i).getPosition().getY();
			int roomWidth = roomsList.get(i).getDimension().getWidth();
			int roomLength = roomsList.get(i).getDimension().getLength();
			
			for(int k=roomPositionY ; k<roomPositionY+roomLength ; k++)
			{
				for(int l=roomPositionX ; l<roomPositionX+roomWidth ; l++)
				{
					if(k==positionX && l==positionY)
					{
						String letterOfTheRoom = String.valueOf((char)(i+(int)'a'));
						return letterOfTheRoom;
					}
				}
			}
		}
		return null;
	}
	
//TODO Grid : DEBUG ONLY (a suppr)
	/** 
	 * Show the current grid (Console)
	 * */
	public void showGrid() 
	{
		System.out.println("\nGrid :\n");
		for(int i=0 ; i<gridDimension.getLength() ; i++)
		{
			for(int j=0 ; j<gridDimension.getWidth() ; j++)
			{
				System.out.print("|" + getGrid(i, j));
			}
			System.out.print("|\n");
		}
	}
}