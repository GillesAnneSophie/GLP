package place;

import java.util.HashMap;


/**
 * @author GILLES Anne-Sophie
 */


public class Apartment 
{
	private HashMap<Integer, Room> roomsList;
	

	/**
	 * Build an Apartment
	 */
	public Apartment()
	{
		roomsList = new HashMap<Integer, Room>();
	}
	
	
	/**
	 * @return the roomsList
	 */
	public HashMap<Integer, Room> getRoomsList() 
	{
		return roomsList;
	}
	

	/**
	 * Return the room which have the given index
	 * @param index
	 * @return thisRoom
	 */
	public Room getRoom(int index)
	{
		Room thisRoom = getRoomsList().get(index);
		return thisRoom;
	}
	
	/**
	 * Add a room in the apartment, return true if the room is add
	 * @param room
	 * @param positionX
	 * @param positionY
	 * @param grid
	 * @return true or false
	 */
	public boolean addRoom(Room room, int positionX, int positionY, Grid grid)
	{
		int size = roomsList.size();
		int counter=0;
		int index=0;
		while(counter<size)
		{
			if(roomsList.get(index) != null)
			{
				counter++;
			}
			index++;
		}

		String nameInGrid = String.valueOf((char)(index+(int)'a'));
		
		if(room.setPosition(positionX, positionY, nameInGrid, grid))
		{
			roomsList.put(index, room);
			return true;
		}
		return false;
	}
	
	/**
	 * Remove a room from the apartment
	 * @param index
	 * @param grid
	 */
	public void removeRoom(int index, Grid grid)
	{
		grid.removeRoom(roomsList.get(index));
		roomsList.remove(index);
	}
	
	
	@Override
	public String toString() 
	{
		return "Apartment [roomsList=" + roomsList + "]";
	}
}
