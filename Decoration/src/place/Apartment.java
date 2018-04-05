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
	 * Return the room which have the given name
	 * @param name
	 * @return thisRoom or null
	 */
	public Room getRoom(String name)
	{
		for(int index=0 ; index<getRoomsList().size() ; index++)
		{
			Room thisRoom = getRoomsList().get(index);
			String thisRoomName = thisRoom.getName();
			
			if(thisRoomName==name)
			{
				return thisRoom;
			}
		}
		return null;
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
		int counter = roomsList.size();
		String nameInGrid = String.valueOf((char)(counter+(int)'a'));
		
		if(room.setPosition(positionX, positionY, nameInGrid, grid))
		{
			roomsList.put(counter, room);
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
		
		grid.showGrid();
	}
	
	
	@Override
	public String toString() 
	{
		return "Apartment [roomsList=" + roomsList + "]";
	}
}
