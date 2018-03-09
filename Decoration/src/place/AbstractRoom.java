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
	private boolean isStackable;
	private Category category;
	private Position position;
	

	/**
	 * @param type
	 * @param name
	 * @param dimension
	 * @param isStackable
	 * @param category
	 * */
	public AbstractRoom(String type, String name, Dimension dimension, boolean isStackable, Category category) 
	{
		this.type = type;
		this.name = name;
		this.dimension = dimension;
		this.isStackable = isStackable;
		this.category = category;
	}

	/**
	 * @param type
	 * @param name
	 * @param width
	 * @param lenght
	 * @param isStackable
	 * @param category
	 * */
	public AbstractRoom(String type, String name, int width, int lenght, boolean isStackable, Category category) 
	{
		this.type = type;
		this.name = name;
		dimension = new Dimension(width, lenght);
		this.isStackable = isStackable;
		this.category = category;
	}

	
	/**
	 * @return the type
	 * */
	public String getType() 
	{
		return type;
	}
	
	/**
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @return the dimension
	 */
	public Dimension getDimension() 
	{
		return dimension;
	}

	/**
	 * @return isStackable
	 */
	public boolean getIsStackable() 
	{
		return isStackable;
	}

	/**
	 * @return the category
	 */
	public String getCategory() 
	{
		return category.toString();
	}

	/**
	 * @return the position
	 */
	public Position getPosition() 
	{
		return position;
	}
	
	
	/** Set the position of the object in the grid. Return true if the object is placed, false if it can't be place.
	 * @param x
	 * @param y
	 * @param car
	 * @param grid
	 * @return true or false
	 */
	public boolean setPosition(int x, int y, String car, Grid grid) 
	{
		if(grid.canBePlace(getIsStackable(), x, y, getDimension(), getType(), getCategory()))
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
							grid.setGrid(k, l, "$");
						}
					}
				}
			}
			grid.showGrid();
			return true;
		}
		else
		{
			grid.showGrid();
			return false;
		}
	}
	
	/**
	 * @param dimension the dimension to set
	 * */
	public void setDimension(Dimension dimension) 
	{
		this.dimension=dimension;
	}
	
	//TODO + modif sens des images
	/**North and South = default orientation
	 * East and West = Change the orientation
	 * */
	public void furnitureOrientedNorth()
	{
		if(getType()=="Furniture")
		{
			
		}
	}
	
	public void furnitureOrientedSouth()
	{
		if(getType()=="Furniture")
		{
			
		}
	}
	
	public void furnitureOrientedEast()
	{
		if(getType()=="Furniture")
		{
			Dimension tmpDimension = new Dimension(getDimension().getLenght(), getDimension().getWidth());
			setDimension(tmpDimension);
		}
	}
	
	public void furnitureOrientedWest()
	{
		if(getType()=="Furniture")
		{
			Dimension tmpDimension = new Dimension(getDimension().getLenght(), getDimension().getWidth());
			setDimension(tmpDimension);
		}
	}

	
	@Override
	public String toString() {
		return "name=" + name + ", dimension=" + dimension
				+ ", stackable=" + isStackable + ", category=" + category
				+ ", position=" + position;
	}
}
