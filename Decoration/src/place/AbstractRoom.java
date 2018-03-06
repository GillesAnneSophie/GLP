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
	private String type;
	private String name;
	private Dimension dimension;
	private boolean stackable;
	private Category category;
	private Position position;
	

	/**
	 * @param name
	 * @param dimension
	 * @param stackable
	 * @param category
	 * */
	public AbstractRoom(String type, String name, Dimension dimension, boolean stackable, Category category) 
	{
		this.type = type;
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
	public AbstractRoom(String type, String name, int lenght, int width, boolean stackable, Category category) 
	{
		this.type = type;
		this.name = name;
		dimension = new Dimension(lenght, width);
		this.stackable = stackable;
		this.category = category;
	}

	
	/**
	 * @return the type
	 * */
	public String getType() {
		return type;
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
	public String getCategory() {
		return category.toString();
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
	 * @param grid
	 */
	public void setPosition(int x, int y, String car, Grid grid) 
	{
		if(grid.canBePlace(isStackable(), x, y, getDimension(), getType(), getCategory()))
		{
			this.position = new Position(x, y);
			for(int i=getPosition().getX() ; i<getPosition().getX()+getDimension().getLenght() ; i++)
			{
				for(int j=getPosition().getY() ; j<getPosition().getY()+getDimension().getWidth() ; j++)
				{
					grid.setGrid(i, j, car);
				}
			}
			
			if(type=="Room")
			{
				for(int k=getPosition().getX()-1 ; k<getPosition().getX()+getDimension().getLenght()+1 ; k++)
				{
					for(int l=getPosition().getY()-1 ; l<getPosition().getY()+getDimension().getWidth()+1 ; l++)
					{
						if(k==getPosition().getX()-1 || l==getPosition().getY()-1 || l==getPosition().getY()+getDimension().getWidth() || k==getPosition().getX()+getDimension().getLenght())
						{
							/*9 = Wall / 1 = Room*/
							grid.setGrid(k, l, "9");
						}
					}
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
