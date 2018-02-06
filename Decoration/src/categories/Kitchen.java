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
public class Kitchen extends Category 
{
	public Kitchen(String name, Dimension dimension, boolean stackable) 
	{
		super(name, dimension, stackable);
	}
	
	@Override
	public String toString()
	{
		return "Kitchen [" + super.toString() + "]\n";
	}
}

