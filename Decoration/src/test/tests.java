/**
 * 
 */
package test;

import catalog.*;
import categories.*;
import place.Apartment;
import place.Room;

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
		
		
		//Create rooms
		Category bedroomCategory = new BedroomOffice();
		Room bedroom = new Room("bedroom", 4, 5, bedroomCategory);
	
	
//A FINIR		bedroom.addFurniture(catalog.findFurniture("toilet"));
System.out.println(bedroom);
		
	}
}
