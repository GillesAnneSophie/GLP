/**
 * 
 */
package place;

import catalog.Category;

/**
 * @author GILLES Anne-Sophie
 *
 */
public abstract class AbstractRoom 
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
	 * @param category
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
	 * @param category
	 * */
	public AbstractRoom(String name, int lenght, int width, boolean stackable, Category category) 
	{
		this.name = name;
		dimension = new Dimension(lenght, width);
		this.stackable = stackable;
		this.category = category;
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the dimension
	 */
	public Dimension getDimension() {
		return dimension;
	}

	/**
	 * @return stackable
	 */
	public boolean isStackable() {
		return stackable;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	
	/**
	 * @param x
	 * @param y
	 * @param car
	 */
	public void setPosition(int x, int y, String car, Grid grid) 
	{
		if(grid.canBePlace(isStackable(), x, y))
		{
			this.position = new Position(x, y);
			for(int i=getPosition().getX() ; i<getPosition().getX()+getDimension().getLenght() ; i++)
			{
				for(int j=getPosition().getY() ; j<getPosition().getY()+getDimension().getWidth() ; j++)
				{
					grid.setGrid(i, j, car);
				}
			}
		}
		grid.showGrid();
	}

	@Override
	public String toString() {
		return "name=" + name + ", dimension=" + dimension
				+ ", stackable=" + stackable + ", category=" + category
				+ ", position=" + position;
	}


}
