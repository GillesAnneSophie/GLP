/**
 * 
 */
package test;

import java.util.ArrayList;

import catalog.Category;
import catalog.Furniture;
import catalog.Style;
import categories.*;
import styles.*;
import place.Apartment;
import place.Dimension;
import place.Room;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class tests 
{
	private static boolean isNotStackable = false;
	private static boolean isStackable = true;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/*Create Styles*/
		Style styleBasic = new Basic();
		Style styleModern = new Modern();
		Style styleRustic = new Rustic();
		Style styleVintage = new Vintage();
		
		
		/*Create Categories*/
		ArrayList<Category> catBedroom = new ArrayList<Category>();
		Category catOnlyBedroom = new BedroomOffice();
		catBedroom.add(catOnlyBedroom);
		
		ArrayList<Category> catBathroom = new ArrayList<Category>();
		Category catOnlyBathroom = new Bathroom();
		catBathroom.add(catOnlyBathroom);
		
		
		/*Create a bed*/
		Dimension dimBed1 = new Dimension(1, 3);
		int[][] posBed1 = {{2},{2}};
		Furniture bed1 = new Furniture("Bed", dimBed1, styleBasic, "Black", isNotStackable, catBedroom, posBed1);
	
		//TODO bug avec la position > ArrayList ?
		System.out.println(bed1);
		
		
		/*Create Bedroom*/
		Dimension dimBedroom1 = new Dimension(5, 5);
		int[][] posBebroom1 = {{1},{1}};
		Room bedroom1 = new Room("Bedroom", dimBedroom1, catBedroom, posBebroom1);
		
		System.out.println(bedroom1);
		
		
		/*Create an Apartment*/
		Apartment apartment = new Apartment();
		Dimension dimBathroom1 = new Dimension(3, 4);
		int[][] posBathroom1 = {{7},{7}};
		apartment.addRoom("Bathroom", dimBathroom1, catBathroom, posBathroom1);
		
		System.out.println(apartment);
		
		/*Create Bath*/
		Dimension dimBath1 = new Dimension(1, 2);
		int[][] posBath1 = {{8},{2}};
		
//TODO fonctionne pas NullPointerException (?)
		bedroom1.addFurniture("Bath", dimBath1, styleBasic, "White", isNotStackable, catBathroom, posBath1);
		System.out.println(bedroom1);
		
		/*Tests lambda*/
		apartment.addRoom("Bedroom", dimBedroom1, catBedroom, posBebroom1);
		System.out.println(apartment);
		
		apartment.deleteRoom(0);
		System.out.println(apartment);
	}
}
