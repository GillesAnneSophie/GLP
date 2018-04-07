/**
 * 
 */
package calculations;

import java.util.HashMap;

import place.Room;


/**
 * @author GILLES Anne-Sophie
 */


public class Statistics 
{
	/** 
	 * Return the number of rooms in the apartment
	 * @param roomsList
	 * @return counter
	 * */
	public static int numberOfRooms(HashMap<Integer, Room> roomsList)
	{
		int counter = roomsList.size();
		return counter;
	}
	
	/** 
	 * Return the number of furniture in the apartment
	 * @param roomsList
	 * @return counter
	 * */
	public static int numberOfFurniture(HashMap<Integer, Room> roomsList)
	{
		int furnitureCounter = 0;
		int size = roomsList.size();
		int counter=0;
		int index=0;
		while(counter<size)
		{
			if(roomsList.get(index) != null)
			{
				furnitureCounter+=roomsList.get(index).getAllTheFurnitureOfTheRoom().size();
				counter++;
			}
			index++;
		}
		return furnitureCounter;
	}
}
