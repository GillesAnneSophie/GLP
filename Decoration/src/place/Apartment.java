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
	 * @param name of the room
	 * */
	public void removeRoom(String name)
	{
		for(int index=0 ; index<roomsList.size() ; index++)
		{
			if(roomsList.get(index).getName()==name)
			{
				roomsList.remove(index);
			}
		}
	}
}
