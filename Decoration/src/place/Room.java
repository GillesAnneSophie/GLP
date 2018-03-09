package place;

import java.util.HashMap;

import catalog.*;

/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */
public class Room extends AbstractRoom
{
	private HashMap<Integer, AbstractRoom> furnituresOfTheRoom;

	
	/**
	 * @param name
	 * @param width
	 * @param lenght
	 * @param category
	 */
	public Room(String name, int width, int lenght, Category category) 
	{
		super("Room", name, width, lenght, false, category);
		furnituresOfTheRoom = new HashMap<Integer, AbstractRoom>();
	}
	

	/**
	 * @return the furnituresOfTheRoom
	 */
	public HashMap<Integer, AbstractRoom> getFurnituresOfTheRoom() 
	{
		return furnituresOfTheRoom;
	}
	
	
	/** Return true if the furniture can be place in the room
	 * @param room
	 * @param furniture
	 * @return true or false
	 * */
	public boolean roomAcceptFurniture(Room room, AbstractRoom furniture)
	{
		/*If the Category of the furniture is Floor or Wall*/
		if(furniture.getCategory()=="Floor" || furniture.getCategory()=="Wall")
		{
			return true;
		}
		/*If the Category of the room is the same as the Catgory of the furniture*/
		else if(room.getCategory()==furniture.getCategory())
		{
			return true;
		}
		/*If the Category of the furniture is DiningRoom and then, if the Category of the room is Kitchen or LivingRoom*/
		else if(furniture.getCategory()=="DiningRoom")
		{
			if(room.getCategory()=="Kitchen" || room.getCategory()=="LivingRoom")
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		/*If the Category of the furniture is LivingRoom and then, if the Category of the room is DiningRoom*/
		else if(furniture.getCategory()=="LivingRoom")
		{
			if(room.getCategory()=="DiningRoom")
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		/*If the Category of the furniture is BedroomOffice and then, if the Category of the room is LivingRoom*/
		else if(furniture.getCategory()=="BedroomOffice")
		{
			if(room.getCategory()=="LivingRoom")
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
	
//ADD Boolean + erreur impossible d'ajouter ?	
	/** Add a Furniture in the Room 
	 * @param furniture
	 * @param x
	 * @param y
	 * @param grid
	 * */
	public void addFurniture(AbstractRoom furniture, int x, int y, Grid grid)
	{
		if(roomAcceptFurniture(this, furniture))
		{
			int counter = furnituresOfTheRoom.size();
			String nameInGrid = String.valueOf(counter);
			if(furniture.setPosition(x, y, nameInGrid, grid))
			{
				furnituresOfTheRoom.put(counter, furniture);
			}
		}
	}
	
	/** Remove a Furniture from the Room
	 * @param name
	 * @param grid
	 * */
	public void removeFurniture(String name, Grid grid, HashMap<Integer, Room> roomsList)
	{
		for(int index=0 ; index<furnituresOfTheRoom.size() ; index++)
		{
			if(furnituresOfTheRoom.get(index).getName()==name)
			{
				grid.removeFurniture(furnituresOfTheRoom.get(index), getFurnituresOfTheRoom(), roomsList);
				furnituresOfTheRoom.remove(index);
			}
		}
		grid.showGrid();
	}
	
	
	@Override
	public String toString() {
		return "Room [furnituresOfTheRoom=\n" + furnituresOfTheRoom + "\n" + super.toString() + "]";
	}
}
