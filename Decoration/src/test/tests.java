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
		
		Category kitchenCategory = new Kitchen();
		Room kitchen = new Room("kitchen", 1, 2, kitchenCategory);
	
		//ADD
		//AbstractRoom furniture = catalog.getFurniture("bath");
		//System.out.println("\n" + furniture);
		
		//bedroom.addFurniture(catalog.getFurniture("toilet"));
		//System.out.println("\n" + bedroom);
		
		apartment.addRoom(bedroom);
		apartment.addRoom(kitchen);
		//bedroom.addFurniture(catalog.getFurniture("bath"));
		//System.out.println("\n" + apartment);
		
		//DELETE
		//bedroom.removeFurniture("bath");
		//System.out.println("\n" + bedroom);
		
		//apartment.removeRoom("bedroom");
		//System.out.println("\n" + apartment);
		
		//GRID
		Dimension dimGrid = new Dimension(15, 15);
		Grid grid = new Grid(dimGrid);;
		
		//OTHER
		bedroom.setPosition(3, 4, "1", grid, "room");//3 4
		kitchen.setPosition(5, 11, "2", grid, "room");// 5 11
		
/*		AbstractRoom furniture1 = catalog.getFurniture("single Bed");
		bedroom.addFurniture(furniture1, 5, 7, grid);
		
		AbstractRoom furniture2 = catalog.getFurniture("carpet");
		bedroom.addFurniture(furniture2, 5, 6, grid);
		
		AbstractRoom furniture3 = catalog.getFurniture("small door");
		bedroom.addFurniture(furniture3, 4, 4, grid);
*/
	}
}
