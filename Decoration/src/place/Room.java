package place;

import java.util.HashMap;

import catalog.Furniture;

/**
 * @author lauryanncoralie
 * @author GILLES Anne-Sophie
 */
public class Room 
{
	private String name;
	private HashMap<Integer, Furniture> furnituresOfTheRoom;
	private int counter;
	private Dimension dimension;
	private int[][] position;
	
	/**
	 * @param name
	 * @param furnituresOfTheRoom
	 * @param dimension
	 * @param position
	 */
	public Room(String name, HashMap<Integer, Furniture> furnituresOfTheRoom, Dimension dimension, int[][] position) 
	{
		this.name = name;
		this.furnituresOfTheRoom = new HashMap<Integer, Furniture>();
		this.dimension = dimension;
		this.position = position;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @return the furnituresOfTheRoom
	 */
	public HashMap<Integer, Furniture> getFurnituresOfTheRoom() 
	{
		return furnituresOfTheRoom;
	}

	/**
	 * @return the dimension
	 */
	public Dimension getDimension() 
	{
		return dimension;
	}

	/**
	 * @return the position
	 */
	public int[][] getPosition() 
	{
		return position;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * @param furnituresOfTheRoom the furnituresOfTheRoom to set
	 */
	public void setFurnituresOfTheRoom(HashMap<Integer, Furniture> furnituresOfTheRoom) 
	{
		this.furnituresOfTheRoom = furnituresOfTheRoom;
	}

	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(Dimension dimension) 
	{
		this.dimension = dimension;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int[][] position) 
	{
		this.position = position;
	}
	
	
	/** Add a Furniture in the Room */
	public void addFurniture()
	{
		counter++;
	}
	
	/** Remove a Furniture from the Room
	 * @param furnitureKey the HashMap Key to remove the selected Furniture
	 * */
	public void removeFurniture(int furnitureKey)
	{
		furnituresOfTheRoom.remove(furnitureKey);
		counter--;
	}
}
