/**
 * 
 */
package place;

import java.util.HashMap;


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
		int counter = 0;
		for(int i=0 ; i<roomsList.size() ; i++)
		{
			counter += roomsList.get(i).getAllTheFurnitureOfTheRoom().size();
		}
		return counter;
	}
}
