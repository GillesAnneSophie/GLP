package place;

import java.util.HashMap;

import catalog.*;

/**
 * @author lauryanncoralie
 * @author GILLES Anne-Sophie
 */
public class Room extends AbstractRoom
{
	private HashMap<Integer, Furniture> furnituresOfTheRoom;

	
	/**
	 * @param name
	 * @param lenght
	 * @param width
	 * @param stackable
	 */
	public Room(String name, int lenght, int width, Category category) 
	{
		super(name, lenght, width, false, category);
		furnituresOfTheRoom = new HashMap<Integer, Furniture>();
	}
	

	/**
	 * @return the furnituresOfTheRoom
	 */
	public HashMap<Integer, Furniture> getFurnituresOfTheRoom() 
	{
		return furnituresOfTheRoom;
	}


	@Override
	public String toString() {
		return "Room [furnituresOfTheRoom=" + furnituresOfTheRoom + " " + super.toString() + "]";
	}


	
	
	/** Add a Furniture in the Room 
	 * @param furniture
	 * */
	public void addFurniture(Furniture furniture)
	{
		int counter = furnituresOfTheRoom.size();
		furnituresOfTheRoom.put(counter, furniture);
	}
	
	/** Remove a Furniture from the Room
	 * @param furnitureKey the HashMap Key to remove the selected Furniture
	 * */
	public void removeFurniture(int furnitureKey)
	{
		furnituresOfTheRoom.remove(furnitureKey);
	}
}
