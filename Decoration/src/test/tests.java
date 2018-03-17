package test;

import catalog.*;
import categories.*;
import place.*;

/**
 * @author GILLES Anne-Sophie
 */
public class tests 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
			//Create furniture
		Catalog catalog = new Catalog();
		
			//Create Apartment
		Apartment apartment = new Apartment();
		//System.out.println("\n" + apartment);
		
			//Grid
		Dimension dimGrid = new Dimension(20, 20);
		Grid grid = new Grid(dimGrid);
		
			//Create Rooms
		Category bedroomCategory = new BedroomOffice();
		Room bedroom = new Room("bedroom", 4, 5, bedroomCategory);
		
		Category kitchenCategory = new Kitchen();
		Room kitchen = new Room("kitchen", 1, 2, kitchenCategory);
		
			//Add rooms
		apartment.addRoom(bedroom, 3, 4, grid);
		apartment.addRoom(kitchen, 9, 3, grid);
		
			//Add furniture to rooms
		AbstractRoom furniture1 = catalog.getFurniture("single bed");
		//furniture1.furnitureOrientedWest();
		bedroom.addFurniture(furniture1, 4, 4, grid);
		
		//AbstractRoom furniture2 = catalog.getFurniture("carpet");
		//bedroom.addFurniture(furniture2, 5, 6, grid);
		
		AbstractRoom furniture3 = catalog.getFurniture("small door");
		//furniture3.furnitureOrientedWest();
		bedroom.addFurniture(furniture3, 5, 9, grid); //6 3 || 2 5

			//Statistics
		//System.out.println("numberOfFurniture" + Statistics.numberOfFurniture(apartment.getRoomsList()));
		//System.out.println("numberOfRooms" + Statistics.numberOfRooms(apartment.getRoomsList()));
		
			//Delete
		//bedroom.removeFurniture("large door", grid, apartment.getRoomsList());
		//System.out.println("\n" + bedroom);
		
		//apartment.removeRoom("bedroom", grid);
		//System.out.println("\n" + apartment);
	}
}
