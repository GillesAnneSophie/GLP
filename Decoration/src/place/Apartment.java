package place;

import java.util.HashMap;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Apartment 
{
	private HashMap<Integer, Room> roomsList;
	

	public Apartment()
	{
		roomsList = new HashMap<Integer, Room>();
	}


	/** Add a room in the apartment
	 * @param room
	 * */
	public void addRoom(Room room)
	{
		int counter = roomsList.size();
		roomsList.put(counter, room);
	}
	
	/** Remove a room from the apartment
	 * @param name
	 * @param grid
	 * */
	public void removeRoom(String name, Grid grid)
	{
		for(int index=0 ; index<roomsList.size() ; index++)
		{
			if(roomsList.get(index).getName()==name)
			{
				grid.removeRoom(roomsList.get(index));
				roomsList.remove(index);
			}
		}
		grid.showGrid();
	}
	
	
	@Override
	public String toString() 
	{
		return "Apartment [roomsList=" + roomsList + "]";
	}
}
