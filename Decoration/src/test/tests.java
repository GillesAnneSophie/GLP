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
		
		Category bathroomCategory = new Bathroom();
		Room bathroom = new Room("bathroom", 3, 3, bathroomCategory);
		
			//Add rooms
		if(apartment.addRoom(bedroom, 3, 3, grid))
		{
			System.out.println("Bedroom ajout�e");
		}
		else
		{
			System.out.println("Bedroom n'a pas pu �tre ajout�e");
		}
		
		if(apartment.addRoom(bathroom, 9, 3, grid))
		{
			System.out.println("bathroom ajout�e");
		}
		else
		{
			System.out.println("bathroom n'a pas pu �tre ajout�e");
		}
		
			//Add furniture to rooms
		//AbstractRoom furniture1 = catalog.getFurniture("single bed");
		//furniture1.furnitureOrientedNorth();
		//bedroom.addFurniture(furniture1, 4, 4, grid);
		
		//AbstractRoom furniture2 = catalog.getFurniture("carpet");
		//bedroom.addFurniture(furniture2, 5, 6, grid);
		
		//AbstractRoom furniture3 = catalog.getFurniture("carpet");
		//furniture3.furnitureOrientedWest();
		//bedroom.addFurniture(furniture3, 4, 6, grid); //6 3 || 2 5

			//Statistics
		//System.out.println("numberOfFurniture" + Statistics.numberOfFurniture(apartment.getRoomsList()));
		//System.out.println("numberOfRooms" + Statistics.numberOfRooms(apartment.getRoomsList()));
		
			//Delete
		//bedroom.removeFurniture(0, grid, apartment);
		//bedroom.removeFurniture("large door", grid, apartment.getRoomsList());
		//System.out.println("\n" + bedroom);
		
		//apartment.removeRoom("bedroom", grid);
		//System.out.println("\n" + apartment);
		
			//Automatic Decoration
		new AutomaticDecoration(null, null, catalog, apartment, grid);
	}
}
