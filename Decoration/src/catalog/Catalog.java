/**
 * 
 */
package catalog;

import java.util.HashMap;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Catalog 
{
	private HashMap<Integer, Furniture> inventory;

	//TODO création de tous les meubles pour les mettre dans la HashMap
	
	/**
	 * @return the inventory
	 */
	public HashMap<Integer, Furniture> getInventory() 
	{
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(HashMap<Integer, Furniture> inventory) 
	{
		this.inventory = inventory;
	}
}
