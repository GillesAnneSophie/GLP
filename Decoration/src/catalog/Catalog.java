/**
 * 
 */
package catalog;

import java.util.ArrayList;

import categories.*;
import place.*;

/**
 * @author Gilles Anne-Sophie
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
		Furniture singleBed = new Furniture("single Bed", mediumRectangle, isNotStackable, bedroomOffice);
		Furniture doubleBed = new Furniture("double Bed", largeRectangle, isNotStackable, bedroomOffice);
		Furniture nightstand = new Furniture("nightstand", cube, isNotStackable, bedroomOffice);
		Furniture dresser = new Furniture("dresser", smallRectangle, isNotStackable, bedroomOffice);
		Furniture wardrobe = new Furniture("wardrobe", smallRectangle, isNotStackable, bedroomOffice);
		
		/*Office's Furniture*/
		Furniture chair = new Furniture("chair", cube, isNotStackable, bedroomOffice);
		Furniture desk = new Furniture("desk", smallRectangle, isNotStackable, bedroomOffice);
		
		/*DiningRoom's Furniture*/
		Furniture smallDiningTable = new Furniture("small Dining Table", smallRectangle, isNotStackable, diningRoom);
		Furniture largeDiningTable = new Furniture("large Dining Table", mediumRectangle, isNotStackable, diningRoom);
		Furniture buffet = new Furniture("buffet", mediumRectangle, isNotStackable, diningRoom);
		Furniture chair1 = new Furniture("chair", cube, isNotStackable, diningRoom);
		
		/*Kitchen's Furniture*/
		Furniture fridge = new Furniture("fridge", cube, isNotStackable, kitchen);
		Furniture gasCooker = new Furniture("gas cooker", cube, isNotStackable, kitchen);
		Furniture sink = new Furniture("sink", cube, isNotStackable, kitchen);
		Furniture kitchenWorktop = new Furniture("worktop", cube, isNotStackable, kitchen);
		
		/*LivingRoom's Furniture*/
		Furniture armchair = new Furniture("armchair", cube, isNotStackable, livingRoom);
		Furniture coffeeTable = new Furniture("coffee table", smallRectangle, isNotStackable, livingRoom);
		Furniture smallSofa = new Furniture("small sofa", smallRectangle, isNotStackable, livingRoom);
		Furniture largeSofa = new Furniture("large sofa", mediumRectangle, isNotStackable, livingRoom);
	
		/*Floor's Furniture*/
		Furniture carpet = new Furniture("carpet", smallRectangle, isStackable, floor);
	
		/*Wall's Furniture*/
		Furniture smallDoor = new Furniture("small door", cube, isNotStackable, wall);
		Furniture largeDoor = new Furniture("large door", smallRectangle, isNotStackable, wall);
		Furniture smallWindow = new Furniture("small Window", cube, isNotStackable, wall);
		Furniture largeWindow = new Furniture("large Window", smallRectangle, isNotStackable, wall);
		Furniture picture = new Furniture("picture", cube, isNotStackable, wall);
	
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
	public ArrayList<AbstractRoom> getAllTheFurniture() 
	{
		return inventory;
	}
	
//PAS FINI
/*	public AbstractRoom findFurniture(String name)
	{
		for(int index=0 ; index<inventory.size() ; index++)
		{
			AbstractRoom furniture = new Furniture();
			furniture = inventory.get(index);
			if(furniture.getName() == name)
			{
				return inventory.get(index);
			}
		}
	}
*/

	@Override
	public String toString() 
	{
		return "FurnitureBuilder [allTheFurniture=" + inventory + "]";
	}
}
