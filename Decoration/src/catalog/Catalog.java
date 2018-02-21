/**
 * 
 */
package catalog;

import java.util.ArrayList;

import categories.*;
import place.*;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Catalog 
{
	private ArrayList<AbstractRoom> inventory;
	
	private static boolean isNotStackable = false;
	private static boolean isStackable = true;
	
	/*Create Dimensions*/
	private static Dimension cube = new Dimension(1, 1);
	private static Dimension smallRectangle = new Dimension(1, 2);
	private static Dimension mediumRectangle = new Dimension(1, 3);
	private static Dimension largeRectangle = new Dimension(2, 3);
	
	
	public Catalog()
	{
		inventory = new ArrayList<AbstractRoom>();
	}
	
	/**
	 * Build 
	 */
	public void buildFurniture()
	{
		/*Create Categories*/
		Category bathroom = new Bathroom();
		Category bedroomOffice = new BedroomOffice();
		Category diningRoom = new DiningRoom();
		Category kitchen = new Kitchen();
		Category livingRoom = new LivingRoom();
		
		Category floor = new Floor();
		Category wall = new Wall();
		
		/*Bathroom's Furniture*/
		AbstractRoom toilet = new Furniture("toilet", cube, isNotStackable, bathroom);
		AbstractRoom bath = new Furniture("bath", smallRectangle, isNotStackable, bathroom);
		AbstractRoom shower = new Furniture("shower", cube, isNotStackable, bathroom);
		AbstractRoom washbasin = new Furniture("washbasin", cube, isNotStackable, bathroom);
		AbstractRoom worktop = new Furniture("worktop", cube, isNotStackable, bathroom);
		
		/*Bedroom's Furniture*/
		AbstractRoom singleBed = new Furniture("single Bed", mediumRectangle, isNotStackable, bedroomOffice);
		AbstractRoom doubleBed = new Furniture("double Bed", largeRectangle, isNotStackable, bedroomOffice);
		AbstractRoom nightstand = new Furniture("nightstand", cube, isNotStackable, bedroomOffice);
		AbstractRoom dresser = new Furniture("dresser", smallRectangle, isNotStackable, bedroomOffice);
		AbstractRoom wardrobe = new Furniture("wardrobe", smallRectangle, isNotStackable, bedroomOffice);
		
		/*Office's Furniture*/
		AbstractRoom officeChair = new Furniture("office Chair", cube, isNotStackable, bedroomOffice);
		AbstractRoom desk = new Furniture("desk", smallRectangle, isNotStackable, bedroomOffice);
		
		/*DiningRoom's Furniture*/
		AbstractRoom smallDiningTable = new Furniture("small Dining Table", smallRectangle, isNotStackable, diningRoom);
		AbstractRoom largeDiningTable = new Furniture("large Dining Table", mediumRectangle, isNotStackable, diningRoom);
		AbstractRoom buffet = new Furniture("buffet", mediumRectangle, isNotStackable, diningRoom);
		AbstractRoom chair = new Furniture("chair", cube, isNotStackable, diningRoom);
		
		/*Kitchen's Furniture*/
		AbstractRoom fridge = new Furniture("fridge", cube, isNotStackable, kitchen);
		AbstractRoom gasCooker = new Furniture("gas cooker", cube, isNotStackable, kitchen);
		AbstractRoom sink = new Furniture("sink", cube, isNotStackable, kitchen);
		AbstractRoom kitchenWorktop = new Furniture("worktop", cube, isNotStackable, kitchen);
		
		/*LivingRoom's Furniture*/
		AbstractRoom armchair = new Furniture("armchair", cube, isNotStackable, livingRoom);
		AbstractRoom coffeeTable = new Furniture("coffee table", smallRectangle, isNotStackable, livingRoom);
		AbstractRoom smallSofa = new Furniture("small sofa", smallRectangle, isNotStackable, livingRoom);
		AbstractRoom largeSofa = new Furniture("large sofa", mediumRectangle, isNotStackable, livingRoom);
	
		/*Floor's Furniture*/
		AbstractRoom carpet = new Furniture("carpet", smallRectangle, isStackable, floor);
	
		/*Wall's Furniture*/
		AbstractRoom smallDoor = new Furniture("small door", cube, isNotStackable, wall);
		AbstractRoom largeDoor = new Furniture("large door", smallRectangle, isNotStackable, wall);
		AbstractRoom smallWindow = new Furniture("small Window", cube, isNotStackable, wall);
		AbstractRoom largeWindow = new Furniture("large Window", smallRectangle, isNotStackable, wall);
		AbstractRoom picture = new Furniture("picture", cube, isNotStackable, wall);
	
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
		
		inventory.add(officeChair);
		inventory.add(desk);
		
		inventory.add(smallDiningTable);
		inventory.add(largeDiningTable);
		inventory.add(buffet);
		inventory.add(chair);
		
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
	 * @return inventory
	 */
	public ArrayList<AbstractRoom> getAllTheFurniture() 
	{
		return inventory;
	}
	

	/**
	 * @param name
	 * @return the furniture or null
	 */
	public AbstractRoom getFurniture(String name)
	{
		for(int index=0 ; index<inventory.size() ; index++)
		{
			if(inventory.get(index).getName()==name)
			{
				return inventory.get(index);
			}
		}
		return null;
	}


	@Override
	public String toString() 
	{
		return "FurnitureBuilder [allTheFurniture=" + inventory + "]";
	}
}
