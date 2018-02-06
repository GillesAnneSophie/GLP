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
public class Wall extends Category  
{
	public Wall(String name, Dimension dimension, boolean stackable) 
	{
		super(name, dimension, stackable);
	}
	
	@Override
	public String toString() 
	{
		return "Wall [" + super.toString() + "]\n";
	}
}
