/**
 * 
 */
package categories;

import catalog.Category;
import place.Dimension;

/**
 * @author Chabane
 *
 */
public class DiningRoom extends Category 
{
	public DiningRoom(String name, Dimension dimension, boolean stackable) 
	{
		super(name, dimension, stackable);
	}
	
	@Override
	public String toString() 
	{
		return "DiningRoom";
	}
}
