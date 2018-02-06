/**
 * 
 */
package catalog;

import place.Dimension;

/**
 * @author GILLES Anne-Sophie
 *
 */
public abstract class Category extends Furniture
{

	public Category(String name, Dimension dimension, boolean stackable) 
	{
		super(name, dimension, stackable);
	}
	
}
