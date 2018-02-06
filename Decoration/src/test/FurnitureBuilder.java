/**
 * 
 */
package test;

import catalog.*;
import categories.*;
import styles.*;
import place.*;

/**
 * @author Gilles Anne-Sophie
 *
 */
public class FurnitureBuilder 
{
	private static boolean isNotStackable = false;
	
	/*Create Dimensions*/
	private static Dimension Cube = new Dimension(1, 1);
	private static Dimension smallRectangle = new Dimension(1, 2);
	private static Dimension mediumRectangle = new Dimension(1, 3);
	private static Dimension largeRectangle = new Dimension(2, 3);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/*Bathroom's Furniture*/
		Furniture toilet = new Bathroom("toilet", Cube, isNotStackable);
		Furniture bath = new Bathroom("bath", smallRectangle, isNotStackable);
		Furniture shower = new Bathroom("shower", Cube, isNotStackable);
		Furniture washbasin = new Bathroom("washbasin", Cube, isNotStackable);
		Furniture worktop = new Bathroom("worktop", Cube, isNotStackable);
		
		/*Bedroom's Furniture*/
		Furniture singleBed = new BedroomOffice("single Bed", mediumRectangle, isNotStackable);
		Furniture doubleBed = new BedroomOffice("double Bed", largeRectangle, isNotStackable);
		Furniture nightstand = new BedroomOffice("nightstand", Cube, isNotStackable);
		Furniture dresser = new BedroomOffice("dresser", smallRectangle, isNotStackable);
		Furniture wardrobe = new BedroomOffice("wardrobe", smallRectangle, isNotStackable);
		
		/*Office's Furniture*/
		Furniture chair = new BedroomOffice("chair", Cube, isNotStackable);
		Furniture desk = new BedroomOffice("desk", smallRectangle, isNotStackable);
		
		/*DiningRoom's Furniture*/
		Furniture smallDiningTable = new DiningRoom("small Dining Table", smallRectangle, isNotStackable);
		Furniture largeDiningTable = new DiningRoom("large Dining Table", mediumRectangle, isNotStackable);
		Furniture buffet = new DiningRoom("buffet", mediumRectangle, isNotStackable);
		Furniture chair1 = new DiningRoom("chair", Cube, isNotStackable);
		
		/*Kitchen's Furniture*/
		Furniture fridge = new Kitchen("fridge", Cube, isNotStackable);
		Furniture gasCooker = new Kitchen("gas cooker", Cube, isNotStackable);
		Furniture sink = new Kitchen("sink", Cube, isNotStackable);
		Furniture kitchenWorktop = new Kitchen("worktop", Cube, isNotStackable);
		
		/*LivingRoom's Furniture*/
		Furniture armchair = new LivingRoom("armchair", Cube, isNotStackable);
		Furniture coffeeTable = new LivingRoom("coffee table", smallRectangle, isNotStackable);
		Furniture smallSofa = new LivingRoom("small sofa", smallRectangle, isNotStackable);
		Furniture largeSofa = new LivingRoom("large sofa", mediumRectangle, isNotStackable);
	}
}
