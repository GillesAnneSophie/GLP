package place;

import java.util.ArrayList;
import java.util.HashMap;

import catalog.Category;

/**
 * @author GILLES Anne-Sophie
 *
 */

public class Apartment 
{
	private HashMap<Integer, Room> roomsList;
	private int counter;
	
	/** Create an apartment */
	public Apartment()
	{
		roomsList = new HashMap<Integer, Room>();
		counter = 0;
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
	public void addRoom(String name, Dimension dimension, ArrayList<Category> categories, Position position)
	{
		Room room = new Room(name, dimension, categories, position);
		roomsList.put(counter, room);
		counter++;
	}
	
	/** Remove a room from the apartment
	 * @param roomKey the HashMap Key to delete the selected Room
	 * */
	public void deleteRoom(int roomKey)
	{
		roomsList.remove(roomKey);
	}
}
