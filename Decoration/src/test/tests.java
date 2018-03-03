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
		//Create all the furniture
		Catalog catalog = new Catalog();
		catalog.buildFurniture();
		
		//Create an Apartment
		Apartment apartment = new Apartment();
		//System.out.println("\n" + apartment);
		
		//Create room
		Category bedroomCategory = new BedroomOffice();
		Room bedroom = new Room("bedroom", 4, 5, bedroomCategory);
	
		//ADD
		//AbstractRoom furniture = catalog.getFurniture("bath");
		//System.out.println("\n" + furniture);
		
		//bedroom.addFurniture(catalog.getFurniture("toilet"));
		//System.out.println("\n" + bedroom);
		
		apartment.addRoom(bedroom);
		//bedroom.addFurniture(catalog.getFurniture("bath"));
		//System.out.println("\n" + apartment);
		
		//DELETE
		bedroom.removeFurniture("bath");
		//System.out.println("\n" + bedroom);
		
		apartment.removeRoom("bedroom");
		//System.out.println("\n" + apartment);
		
		//GRID
		Dimension dimGrid = new Dimension(15, 15);
		Grid grid = new Grid(dimGrid);;
		
		bedroom.setPosition(3, 5, "1", grid, "room");
		AbstractRoom furniture1 = catalog.getFurniture("single Bed");
		bedroom.addFurniture(furniture1, 5, 7, grid);
		
		AbstractRoom furniture2 = catalog.getFurniture("carpet");
		bedroom.addFurniture(furniture2, 5, 6, grid);
		
		AbstractRoom furniture3 = catalog.getFurniture("small door");
		bedroom.addFurniture(furniture3, 4, 4, grid);
	}
}
