package place;

import java.util.HashMap;

/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */
public class Grid 
{
	private Dimension dimension;
	private String charInDefaultGrid = "#";
	private String[][] grid;
	

	public Grid(Dimension dimension) 
	{
		this.dimension = dimension;
		grid = new String[dimension.getLength()][dimension.getWidth()];
		for(int i=0 ; i<dimension.getLength() ; i++)
		{
			for(int j=0 ; j<dimension.getWidth() ; j++)
			{
				setGrid(i, j, charInDefaultGrid);
			}
		}
		/*grid = new String[][] { 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid}, 
			{charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid, charInDefaultGrid} 
				};*/
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


	/** Return true if the object can be place at the given position
	 * @param isStackable
	 * @param positionX
	 * @param positionY
	 * @param dimension
	 * @param type
	 * @param category
	 * @return true or false
	 * */
	public boolean canBePlace(boolean isStackable, int positionX, int positionY, Dimension dimension, String type, String category)
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
				for(int i=positionX ; i<positionX+dimension.getLength() ; i++)
				{
					for(int j=positionY ; j<positionY+dimension.getWidth() ; j++)
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
				for(int i=positionX-1 ; i<positionX+dimension.getLength()+1 ; i++)
				{
					for(int j=positionY-1 ; j<positionY+dimension.getWidth()+1 ; j++)
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
				for(int i=positionX ; i<positionX+dimension.getLength() ; i++)
				{
					for(int j=positionY ; j<positionY+dimension.getWidth() ; j++)
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
				for(int i=positionX ; i<positionX+dimension.getLength() ; i++)
				{
					for(int j=positionY ; j<positionY+dimension.getWidth() ; j++)
					{//TODO ne suffit pas si il y a une porte/fenêtre etc...
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
		int roomPositionX = room.getPosition().getX();
		int roomLength = room.getDimension().getWidth();
		int roomPositionY = room.getPosition().getY();
		int roomWidth = room.getDimension().getLength();
		
		for(int i=roomPositionX-1 ; i<roomPositionX+roomWidth+1 ; i++)
		{
			for(int j=roomPositionY-1 ; j<roomPositionY+roomLength+1 ; j++)
			{
				setGrid(i, j, "#");
			}
		}
	}
	
	/** Remove a Furniture from the Grid
	 * @param furniture
	 * @param allTheFurnitureOfTheRoom
	 * @param roomsList
	 * */
	public void removeFurniture(AbstractRoom furniture, HashMap<Integer, AbstractRoom> allTheFurnitureOfTheRoom, HashMap<Integer, Room> roomsList)
	{
		int furniturePositionX = furniture.getPosition().getX();
		int furnitureLength = furniture.getDimension().getWidth();
		int furniturePositionY = furniture.getPosition().getY();
		int furnitureWidth = furniture.getDimension().getLength();
		
		for(int i=furniturePositionX ; i<furniturePositionX+furnitureWidth ; i++)
		{
			for(int j=furniturePositionY ; j<furniturePositionY+furnitureLength ; j++)
			{
				/*If there is an other Furniture at the same place*/
				int furnitureToSet = whichFurnitureIsHere(allTheFurnitureOfTheRoom, i, j);
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
//TODO commentaires	1ere ligne
	/**
	 * @param allTheFurnitureOfTheRoom
	 * @param positionX
	 * @param positionY
	 * @return numberOfTheFurniture or -1
	 * */
	public int whichFurnitureIsHere(HashMap<Integer, AbstractRoom> allTheFurnitureOfTheRoom, int positionX, int positionY)
	{
		for(int numberOfTheFurniture=0 ; numberOfTheFurniture<allTheFurnitureOfTheRoom.size() ; numberOfTheFurniture++)
		{
			int furniturePositionX = allTheFurnitureOfTheRoom.get(numberOfTheFurniture).getPosition().getX();
			int furniturePositionY = allTheFurnitureOfTheRoom.get(numberOfTheFurniture).getPosition().getY();
			int furnitureLength = allTheFurnitureOfTheRoom.get(numberOfTheFurniture).getDimension().getWidth();
			int furnitureWidth = allTheFurnitureOfTheRoom.get(numberOfTheFurniture).getDimension().getLength();
			
			if(furniturePositionX==positionX && furniturePositionY==positionY)
			{
				return numberOfTheFurniture;
			}
			else
			{
				for(int k=furniturePositionX+1 ; k<furniturePositionX+furnitureWidth ; k++)
				{
					for(int l=furniturePositionY+1 ; l<furniturePositionY+furnitureLength ; l++)
					{
						if(k==positionX && l==positionY)
						{
							return numberOfTheFurniture;
						}
					}
				}
			}
		}
		return -1;
	}
	
	/**
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
			int roomLength = roomsList.get(i).getDimension().getWidth();
			int roomWidth = roomsList.get(i).getDimension().getLength();
			
			if(roomPositionX==positionX && roomPositionY==positionY)
			{
				String letterOfTheRoom = String.valueOf((char)(i+(int)'a'-1));
				return letterOfTheRoom;
			}
			else
			{
				for(int k=roomPositionX+1 ; k<roomPositionX+roomWidth ; k++)
				{
					for(int l=roomPositionY+1 ; l<roomPositionY+roomLength ; l++)
					{
						if(k==positionX && l==positionY)
						{
							String letterOfTheRoom = String.valueOf((char)(i+(int)'a'));
							return letterOfTheRoom;
						}
					}
				}
			}
		}
		return null;
	}
	
//TODO a enlever à la fin DEBUG ONLY
	/** Print the current grid */
	public void showGrid() 
	{
		System.out.println("\nGrid :\n");
		for(int i=0 ; i<dimension.getLength() ; i++)
		{
			for(int j=0 ; j<dimension.getWidth() ; j++)
			{
				System.out.print("|" + grid[i][j]);
			}
			System.out.print("|\n");
		}
	}
}