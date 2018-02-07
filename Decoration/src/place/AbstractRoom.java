/**
 * 
 */
package place;

import catalog.Category;

/**
 * @author Gilles Anne-Sophie
 *
 */
public class AbstractRoom 
{
	private String name;
	private Dimension dimension;
	private boolean stackable;
	private Category category;
	private Position position;
	
	
	public AbstractRoom()
	{
		
	}
	
	/**
	 * @param name
	 * @param dimension
	 * @param stackable
	 * */
	public AbstractRoom(String name, Dimension dimension, boolean stackable, Category category) 
	{
		this.name = name;
		this.dimension = dimension;
		this.stackable = stackable;
		this.category = category;
	}

	/**
	 * @param name
	 * @param lenght
	 * @param width
	 * @param stackable
	 * */
	public AbstractRoom(String name, int lenght, int width, boolean stackable, Category category) 
	{
		this.name = name;
		dimension = new Dimension(lenght, width);
		this.stackable = stackable;
		this.category = category;
	}

	
	
	public String getName() {
		return name;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public boolean isStackable() {
		return stackable;
	}

	public Category getCategory() {
		return category;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "AbstractRoom [name=" + name + ", dimension=" + dimension
				+ ", stackable=" + stackable + ", category=" + category
				+ ", position=" + position + "]\n";
	}


}
