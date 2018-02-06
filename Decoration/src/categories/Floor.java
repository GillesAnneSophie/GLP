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
public class Floor extends Category 
{
	public Floor(String name, Dimension dimension, boolean stackable) 
	{
		super(name, dimension, stackable);
	}
	
	@Override
	public String toString () 
	{
		return "Floor [" + super.toString() + "]\n";
	}
}
