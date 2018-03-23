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
		Catalog catalog = new Catalog("furniture_catalog.txt");
		
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
		if(apartment.addRoom(bedroom, 3, 3, grid))
		{
			System.out.println("Bedroom ajoutée");
		}
		else
		{
			System.out.println("Bedroom n'a pas pu être ajoutée");
		}
		if(apartment.addRoom(kitchen, 9, 3, grid))
		{
			System.out.println("kitchen ajoutée");
		}
		else
		{
			System.out.println("kitchen n'a pas pu être ajoutée");
		}
		
		
			//Add furniture to rooms
		AbstractRoom furniture1 = catalog.getFurniture("single bed");
		//furniture1.furnitureOrientedWest();
		bedroom.addFurniture(furniture1, 4, 4, grid);
		
		//AbstractRoom furniture2 = catalog.getFurniture("carpet");
		//bedroom.addFurniture(furniture2, 5, 6, grid);
		
		AbstractRoom furniture3 = catalog.getFurniture("small door");
		//furniture3.furnitureOrientedWest();
//TODO fonctionnent pas : meubles de Wall + carpet(?)
		bedroom.addFurniture(furniture3, 2, 5, grid); //6 3 || 2 5

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
