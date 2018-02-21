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
	 * @param lenght
	 * @param width
	 * @param category
	 */
	public Room(String name, int lenght, int width, Category category) 
	{
		super(name, lenght, width, false, category);
		furnituresOfTheRoom = new HashMap<Integer, AbstractRoom>();
	}
	

	/**
	 * @return the furnituresOfTheRoom
	 */
	public HashMap<Integer, AbstractRoom> getFurnituresOfTheRoom() 
	{
		return furnituresOfTheRoom;
	}


	@Override
	public String toString() {
		return "Room [furnituresOfTheRoom=\n" + furnituresOfTheRoom + "\n" + super.toString() + "]";
	}

	
	/** Add a Furniture in the Room 
	 * @param furniture
	 * @param x
	 * @param y
	 * */
	public void addFurniture(AbstractRoom furniture, int x, int y)
	{
		int counter = furnituresOfTheRoom.size();
		furnituresOfTheRoom.put(counter, furniture);
		furniture.setPosition(x, y, "2");
	}
	
	/** Remove a Furniture from the Room
	 * @param name
	 * */
	public void removeFurniture(String name)
	{
		for(int index=0 ; index<furnituresOfTheRoom.size() ; index++)
		{
			if(furnituresOfTheRoom.get(index).getName()==name)
			{
				furnituresOfTheRoom.remove(index);
			}
		}
	}
}
