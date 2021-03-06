package place;

import java.util.HashMap;

import catalog.*;


/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */


public class Room extends AbstractRoom
{
	private HashMap<Integer, AbstractRoom> allTheFurnitureOfTheRoom;

	
	/**
	 * Build a Room
	 * @param name
	 * @param width
	 * @param length
	 * @param category
	 */
	public Room(String name, int width, int length, Category category) 
	{
		super("Room", name, width, length, false, category);
		allTheFurnitureOfTheRoom = new HashMap<Integer, AbstractRoom>();
	}
	

	/**
	 * @return allTheFurnitureOfTheRoom
	 */
	public HashMap<Integer, AbstractRoom> getAllTheFurnitureOfTheRoom() 
	{
		return allTheFurnitureOfTheRoom;
	}
	

	/** 
	 * Return true if the furniture can be add to the room
	 * @param room
	 * @param furniture
	 * @return true or false
	 * */
	public boolean roomAcceptFurniture(Room room, AbstractRoom furniture)
	{
		String furnitureCategory = furniture.getCategory();
		String roomCategory = room.getCategory();
		
	/*If the Category of the furniture is Floor or Wall*/
		if(furnitureCategory=="Floor" || furnitureCategory=="Wall")
		{
			return true;
		}
	/*If the Category of the room is the same as the Catgory of the furniture*/
		else if(roomCategory==furnitureCategory)
		{
			return true;
		}
	/*If the Category of the furniture is DiningRoom and then, if the Category of the room is Kitchen or LivingRoom*/
		else if(furnitureCategory=="DiningRoom")
		{
			if(roomCategory=="Kitchen" || roomCategory=="LivingRoom")
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	/*If the Category of the furniture is LivingRoom and then, if the Category of the room is DiningRoom*/
		else if(furnitureCategory=="LivingRoom")
		{
			if(roomCategory=="DiningRoom")
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	/*If the Category of the furniture is BedroomOffice and then, if the Category of the room is LivingRoom*/
		else if(furnitureCategory=="BedroomOffice")
		{
			if(roomCategory=="LivingRoom")
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	

	/**
	 * Add a Furniture in the Room, return true if the furniture is add
	 * @param furniture
	 * @param positionX
	 * @param positionY
	 * @param grid
	 * @return true or false
	 */
	public boolean addFurniture(AbstractRoom furniture, int positionX, int positionY, Grid grid)
	{
		if(roomAcceptFurniture(this, furniture))
		{
			int counter = allTheFurnitureOfTheRoom.size();
			String nameInGrid = String.valueOf(counter);
			
			if(furniture.setPosition(positionX, positionY, nameInGrid, grid))
			{
				allTheFurnitureOfTheRoom.put(counter, furniture);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Remove a Furniture from the Room
	 * @param index
	 * @param grid
	 * @param apartment
	 */
	public void removeFurniture(int index, Grid grid, Apartment apartment)
	{
		grid.removeFurniture(getAllTheFurnitureOfTheRoom().get(index), getAllTheFurnitureOfTheRoom(), apartment.getRoomsList());
		allTheFurnitureOfTheRoom.remove(index);
	}
	
	
	@Override
	public String toString() {
		return "Room [allTheFurnitureOfTheRoom=\n" + allTheFurnitureOfTheRoom + "\n" + super.toString() + "]";
	}
}
