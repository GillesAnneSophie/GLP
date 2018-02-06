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
public class BedroomOffice extends Category
{
	public BedroomOffice(String name, Dimension dimension, boolean stackable) 
	{
		super(name, dimension, stackable);
	}

	@Override
	public String toString() 
	{
		return "BedroomOffice [" + super.toString() + "]\n";
	}
}
