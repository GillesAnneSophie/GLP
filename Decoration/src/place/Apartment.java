package place;

import java.util.HashMap;

import catalog.Furniture;

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
	
	/** Add a room in the apartment
	 * @param name
	 * @param furnituresOfTheRoom
	 * @param dimension
	 * @param position
	 * */
	public void addRoom(String name, HashMap<Integer, Furniture> furnituresOfTheRoom, Dimension dimension, int[][] position)
	{
		Room room = new Room(name, furnituresOfTheRoom, dimension, position);
		roomsList.put(counter, room);
		counter++;
	}
	
	/** Remove a room from the apartment
	 * @param roomKey the HashMap Key to delete the selected Room
	 * */
	public void deleteRoom(int roomKey)
	{
		roomsList.remove(roomKey);
		counter--;
	}
}
