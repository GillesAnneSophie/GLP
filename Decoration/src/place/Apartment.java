package place;

import java.util.HashMap;

/**
 * @author GILLES Anne-Sophie
 *
 */

public class Apartment 
{
	private HashMap<Integer, Room> roomsList;
	
	/** Create an apartment */
	public Apartment()
	{
		roomsList = new HashMap<Integer, Room>();
	}
	
	
	@Override
	public String toString() 
	{
		return "Apartment [roomsList=" + roomsList + "]";
	}


	/** Add a room in the apartment
	 * @param name
	 * @param dimension
	 * @param categories
	 * @param position
	 * */
	public void addRoom(Room room)
	{
		int counter = roomsList.size();
		roomsList.put(counter, room);
	}
	
	/** Remove a room from the apartment
	 * @param roomKey the HashMap Key to delete the selected Room
	 * */
	public void deleteRoom(int roomKey)
	{
		roomsList.remove(roomKey);
	}
}
