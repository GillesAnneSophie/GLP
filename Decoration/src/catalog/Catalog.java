/**
 * 
 */
package catalog;

import java.util.ArrayList;

import catalog.*;
import categories.*;
import place.*;

/**
 * @author Gilles Anne-Sophie
 *
 */
public class Catalog 
{
	private ArrayList<Furniture> inventory;
	
	private static boolean isNotStackable = false;
	private static boolean isStackable = true;
	
	/*Create Dimensions*/
	private static Dimension cube = new Dimension(1, 1);
	private static Dimension smallRectangle = new Dimension(1, 2);
	private static Dimension mediumRectangle = new Dimension(1, 3);
	private static Dimension largeRectangle = new Dimension(2, 3);
	
	public Catalog()
	{
		inventory = new ArrayList<Furniture>();
	}
	
	public void buildFurniture()
	{
		/*Bathroom's Furniture*/
		Furniture toilet = new Bathroom("toilet", cube, isNotStackable);
		Furniture bath = new Bathroom("bath", smallRectangle, isNotStackable);
		Furniture shower = new Bathroom("shower", cube, isNotStackable);
		Furniture washbasin = new Bathroom("washbasin", cube, isNotStackable);
		Furniture worktop = new Bathroom("worktop", cube, isNotStackable);
		
		/*Bedroom's Furniture*/
		Furniture singleBed = new BedroomOffice("single Bed", mediumRectangle, isNotStackable);
		Furniture doubleBed = new BedroomOffice("double Bed", largeRectangle, isNotStackable);
		Furniture nightstand = new BedroomOffice("nightstand", cube, isNotStackable);
		Furniture dresser = new BedroomOffice("dresser", smallRectangle, isNotStackable);
		Furniture wardrobe = new BedroomOffice("wardrobe", smallRectangle, isNotStackable);
		
		/*Office's Furniture*/
		Furniture chair = new BedroomOffice("chair", cube, isNotStackable);
		Furniture desk = new BedroomOffice("desk", smallRectangle, isNotStackable);
		
		/*DiningRoom's Furniture*/
		Furniture smallDiningTable = new DiningRoom("small Dining Table", smallRectangle, isNotStackable);
		Furniture largeDiningTable = new DiningRoom("large Dining Table", mediumRectangle, isNotStackable);
		Furniture buffet = new DiningRoom("buffet", mediumRectangle, isNotStackable);
		Furniture chair1 = new DiningRoom("chair", cube, isNotStackable);
		
		/*Kitchen's Furniture*/
		Furniture fridge = new Kitchen("fridge", cube, isNotStackable);
		Furniture gasCooker = new Kitchen("gas cooker", cube, isNotStackable);
		Furniture sink = new Kitchen("sink", cube, isNotStackable);
		Furniture kitchenWorktop = new Kitchen("worktop", cube, isNotStackable);
		
		/*LivingRoom's Furniture*/
		Furniture armchair = new LivingRoom("armchair", cube, isNotStackable);
		Furniture coffeeTable = new LivingRoom("coffee table", smallRectangle, isNotStackable);
		Furniture smallSofa = new LivingRoom("small sofa", smallRectangle, isNotStackable);
		Furniture largeSofa = new LivingRoom("large sofa", mediumRectangle, isNotStackable);
	
		/*Floor's Furniture*/
		Furniture carpet = new Floor("carpet", smallRectangle, isStackable);
	
		/*Wall's Furniture*/
		Furniture smallDoor = new Wall("small door", cube, isNotStackable);
		Furniture largeDoor = new Wall("large door", smallRectangle, isNotStackable);
		Furniture smallWindow = new Wall("small Window", cube, isNotStackable);
		Furniture largeWindow = new Wall("large Window", smallRectangle, isNotStackable);
		Furniture picture = new Wall("picture", cube, isNotStackable);
	
		/*Add all the furniture in the ArrayList*/
		inventory.add(toilet);
		inventory.add(bath);
		inventory.add(shower);
		inventory.add(washbasin);
		inventory.add(worktop);
		
		inventory.add(singleBed);
		inventory.add(doubleBed);
		inventory.add(nightstand);
		inventory.add(dresser);
		inventory.add(wardrobe);
		
		inventory.add(chair);
		inventory.add(desk);
		
		inventory.add(smallDiningTable);
		inventory.add(largeDiningTable);
		inventory.add(buffet);
		inventory.add(chair1);
		
		inventory.add(fridge);
		inventory.add(gasCooker);
		inventory.add(sink);
		inventory.add(kitchenWorktop);
		
		inventory.add(armchair);
		inventory.add(coffeeTable);
		inventory.add(smallSofa);
		inventory.add(largeSofa);
		
		inventory.add(carpet);
		
		inventory.add(smallDoor);
		inventory.add(largeDoor);
		inventory.add(smallWindow);
		inventory.add(largeWindow);
		inventory.add(picture);
	}

	
	/**
	 * @return the allTheFurniture
	 */
	public ArrayList<Furniture> getAllTheFurniture() 
	{
		return inventory;
	}


	@Override
	public String toString() 
	{
		return "FurnitureBuilder [allTheFurniture=" + inventory + "]";
	}
}
