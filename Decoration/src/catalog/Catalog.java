/**
 * 
 */
package catalog;

import java.io.*;
import java.util.ArrayList;

import categories.*;
import place.*;

/**
 * @author GILLES Anne-Sophie
 */
public class Catalog 
{
	private ArrayList<Furniture> inventory;
	
	/*Create Dimensions*/
	private static Dimension cube = new Dimension(1, 1);
	private static Dimension smallRectangle = new Dimension(2, 1);
	private static Dimension mediumRectangle = new Dimension(3, 1);
	private static Dimension largeRectangle = new Dimension(2, 3);
	
	/*Create Categories*/
	private Category bathroom = new Bathroom();
	private Category bedroomOffice = new BedroomOffice();
	private Category diningRoom = new DiningRoom();
	private Category kitchen = new Kitchen();
	private Category livingRoom = new LivingRoom();
	private Category floor = new Floor();
	private Category wall = new Wall();
	
	
	public Catalog(String fileName)
	{
		inventory = new ArrayList<Furniture>();
		buildAllTheFurniture(fileName);
	}
	
	
	/** 
	 * Return the furniture which have the chosen name or null if there is no furniture with this name
	 * @param name
	 * @return the furniture or null
	 */
	public Furniture getFurniture(String name)
	{
		name=name.toLowerCase();
		for(int index=0 ; index<inventory.size() ; index++)
		{
			if(inventory.get(index).getName().equals(name))
			{
				return inventory.get(index);
			}
		}
		return null;
	}
	

	/** 
	 * Create all the Furniture and put them in the inventory
	 * @param fileName
	 */
	public void buildAllTheFurniture(String fileName)
	{
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) 
			{
				String[] thisLine = line.split(":");
				String furnitureName = thisLine[0];
				Dimension dimension = null;
				boolean stackable = false;
				Category category = null;
				
				switch (thisLine[1])
				{
					case "cube" : dimension=cube;
											break;
						
					case "smallRectangle" : dimension=smallRectangle;
											break;
						
					case "mediumRectangle" : dimension=mediumRectangle;
											break;
						
					case "largeRectangle" : dimension=largeRectangle;
											break;
				}
				if(thisLine[2].equals("isNotStackable"))
				{
					stackable = false;
				}
				else if(thisLine[2].equals("isStackable"))
				{
					stackable = true;
				}
				switch (thisLine[3])
				{
					case "bathroom" : category=bathroom;
											break;
						
					case "bedroomOffice" : category=bedroomOffice;
											break;
						
					case "diningRoom" : category=diningRoom;
											break;
						
					case "kitchen" : category=kitchen;
											break;
											
					case "livingRoom" : category=livingRoom;
											break;
					
					case "floor" : category=floor;
											break;
											
					case "wall" : category=wall;
											break;
				}
				inventory.add(new Furniture(furnitureName, dimension, stackable, category));
			}
			reader.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println(e.getMessage());
		} 
		catch (IOException e) 
		{
			System.err.println(e.getMessage());
		}
	}


	@Override
	public String toString() 
	{
		return "FurnitureBuilder [allTheFurniture=" + inventory + "]";
	}
}
