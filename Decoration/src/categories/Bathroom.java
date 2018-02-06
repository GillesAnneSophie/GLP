/**
 * 
 */
package categories;

import catalog.Category;
import place.Dimension;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Bathroom extends Category
{
	public Bathroom(String name, Dimension dimension, boolean stackable) 
	{
		super(name, dimension, stackable);
	}
	
	@Override
	public String toString() {
		return "Bathroom [" + super.toString() + "]\n";
	}
}
