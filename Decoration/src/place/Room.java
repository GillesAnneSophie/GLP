package place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import catalog.Category;
import catalog.Furniture;
import catalog.Style;

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
	private ArrayList<Category> categories;
	private Position position;
	
	/**
	 * @param name
	 * @param furnituresOfTheRoom
	 * @param dimension
	 * @param position
	 */
	public Room(String name, HashMap<Integer, Furniture> furnituresOfTheRoom, Dimension dimension, Position position) 
	{
		this.name = name;
		furnituresOfTheRoom = new HashMap<Integer, Furniture>();
		counter = 0;
		this.dimension = dimension;
		this.position = position;
	}
	
	/**
	 * @param name
	 * @param dimension
	 * @param categories
	 * @param position
	 */
	public Room(String name, Dimension dimension, ArrayList<Category> categories, Position position) 
	{
		this.name = name;
		counter = 0;
		this.dimension = dimension;
		this.categories = categories;
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
	 * @return the categories
	 */
	public ArrayList<Category> getCategories() {
		return categories;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() 
	{
		return position;
	}
	
	
	@Override
	public String toString() {
		return "Room [name=" + name + ", furnituresOfTheRoom=" + furnituresOfTheRoom + ", counter=" + counter
				+ ", dimension=" + dimension + ", categories=" + categories + ", position=" + position + "]";
	}

	
	/** Add a Furniture in the Room 
	 * @param name
	 * @param dimension
	 * @param style
	 * @param color
	 * @param stackable
	 * @param categories
	 * @param position
	 * */
	public void addFurniture(String name, Dimension dimension, Style style, String color, boolean stackable,
			ArrayList<Category> categories, Position position)
	{
		Furniture furniture = new Furniture(name, dimension, style, color, stackable,
				categories, position);
		furnituresOfTheRoom.put(counter, furniture);
		counter++;
	}
	
	/** Remove a Furniture from the Room
	 * @param furnitureKey the HashMap Key to remove the selected Furniture
	 * */
	public void removeFurniture(int furnitureKey)
	{
		furnituresOfTheRoom.remove(furnitureKey);
	}
}
