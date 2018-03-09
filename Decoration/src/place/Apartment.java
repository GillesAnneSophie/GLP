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
	
	
	/**
	 * @param value
	 * @return char
	 * */
	public char intToString(int value)
	{
		return (char)(value+(int)'a'-1);
	}

	/** Add a room in the apartment
	 * @param room
	 * */
	public void addRoom(Room room, int x, int y, Grid grid)
	{
		int counter = roomsList.size();
		String nameInGrid = String.valueOf(intToString(counter));
		if(room.setPosition(x, y, nameInGrid, grid))
		{
			roomsList.put(counter, room);
		}
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
