/**
 * 
 */
package test;

import java.util.ArrayList;

import catalog.Category;
import catalog.Furniture;
import catalog.Catalog;
import catalog.Style;
import categories.*;
import styles.*;
import place.Apartment;
import place.Dimension;
import place.Position;
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
		Catalog allTheFurniture = new Catalog();
		allTheFurniture.buildFurniture();
		
		//Create an Apartment
		Apartment apartment = new Apartment();
		
		
		//Create rooms
//TODO		Room bedroom = new BedroomOffice("bedroom", 4, 5);
	
	
System.out.println(allTheFurniture);
	}
}
