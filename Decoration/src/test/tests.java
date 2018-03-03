/**
 * 
 */
package test;

import catalog.*;
import categories.*;
import place.*;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class tests 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
			//Create furnitures
		Catalog catalog = new Catalog();
		
			//Create Apartment
		Apartment apartment = new Apartment();
		//System.out.println("\n" + apartment);
		
			//Grid
		Dimension dimGrid = new Dimension(15, 15);
		Grid grid = new Grid(dimGrid);;
		
			//Create Rooms
		Category bedroomCategory = new BedroomOffice();
		Room bedroom = new Room("bedroom", 4, 5, bedroomCategory);
		
		Category kitchenCategory = new Kitchen();
		Room kitchen = new Room("kitchen", 1, 2, kitchenCategory);
		
		apartment.addRoom(bedroom);
		apartment.addRoom(kitchen);
		
			//Add rooms to the Grid
		bedroom.setPosition(3, 4, "1", grid, "room");//3 4
		kitchen.setPosition(5, 11, "2", grid, "room");// 5 11
		
			//Add furnitures to rooms
		AbstractRoom furniture1 = catalog.getFurniture("single Bed");
		bedroom.addFurniture(furniture1, 5, 7, grid);
		
		AbstractRoom furniture2 = catalog.getFurniture("carpet");
		bedroom.addFurniture(furniture2, 5, 6, grid);
		
		AbstractRoom furniture3 = catalog.getFurniture("small door");
		bedroom.addFurniture(furniture3, 4, 4, grid);

			//Deletion
		//bedroom.removeFurniture("bath");
		//System.out.println("\n" + bedroom);
		
		//apartment.removeRoom("bedroom");
		//System.out.println("\n" + apartment);
}
}
