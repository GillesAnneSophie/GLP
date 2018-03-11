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
	 * @param length
	 * @param isStackable
	 * @param category
	 * */
	public AbstractRoom(String type, String name, int width, int length, boolean isStackable, Category category) 
	{
		this.type = type;
		this.name = name;
		dimension = new Dimension(width, length);
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
	 * @param positionX
	 * @param positionY
	 * @param car
	 * @param grid
	 * @return true or false
	 */
	public boolean setPosition(int positionX, int positionY, String car, Grid grid) 
	{
		if(grid.canBePlace(getIsStackable(), positionX, positionY, getDimension(), getType(), getCategory()))
		{
			this.position = new Position(positionX, positionY);
			int thisLength = getDimension().getLength();
			int thisWidth = getDimension().getWidth();
			
			for(int i=positionX ; i<positionX+thisWidth ; i++)
			{
				for(int j=positionY ; j<positionY+thisLength ; j++)
				{
					grid.setGrid(i, j, car);
				}
			}
			
			if(type=="Room")
			{
				for(int k=positionX-1 ; k<positionX+thisWidth+1 ; k++)
				{
					for(int l=positionY-1 ; l<positionY+thisLength+1 ; l++)
					{
						if(k==positionX-1 || l==positionY-1 || k==positionX+thisWidth || l==positionY+thisLength)
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
			Dimension tmpDimension = new Dimension(getDimension().getLength(), getDimension().getWidth());
			setDimension(tmpDimension);
		}
	}
	
	public void furnitureOrientedWest()
	{
		if(getType()=="Furniture")
		{
			Dimension tmpDimension = new Dimension(getDimension().getLength(), getDimension().getWidth());
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
