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
public class LivingRoom extends Category
{
	public LivingRoom(String name, Dimension dimension, boolean stackable) 
	{
		super(name, dimension, stackable);
	}
	
	@Override
	public String toString ()
	{	
		return "LivingRoom [" + super.toString() + "]\n";
	}
}
