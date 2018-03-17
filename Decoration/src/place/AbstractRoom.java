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
	/*Use to create all the Furniture*/
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
	
	
	/** 
	 * Set the position of the object in the grid. Return true if the object is placed, false if it can't be place.
	 * @param positionX
	 * @param positionY
	 * @param car
	 * @param grid
	 * @return true or false
	 */
	public boolean setPosition(int positionX, int positionY, String car, Grid grid) 
	{
		boolean isStackable = getIsStackable();
		String name = getName();
		Dimension dimension = getDimension();
		String type = getType();
		String category = getCategory();
		
		if(grid.canBePlace(isStackable, positionX, positionY, name, dimension, type, category))
		{
			this.position = new Position(positionX, positionY);
			int thisWidth = getDimension().getWidth();
			int thisLength = getDimension().getLength();
			
			for(int i=positionY ; i<positionY+thisLength ; i++)
			{
				for(int j=positionX ; j<positionX+thisWidth ; j++)
				{
					grid.setGrid(i, j, car);
				}
			}
			
			if(type=="Room")
			{
				for(int k=positionY-1 ; k<positionY+thisLength+1 ; k++)
				{
					for(int l=positionX-1 ; l<positionX+thisWidth+1 ; l++)
					{
						if(l==positionX-1 || k==positionY-1 || k==positionY+thisLength || l==positionX+thisWidth)
						{
							grid.setGrid(k, l, "$");
						}
					}
				}
			}
			else if(category=="Wall")
			{
				if(getName().contains("door"))
				{
					for(int m=positionY-1 ; m<positionY+thisLength+1 ; m++)
					{
						for(int n=positionX-1 ; n<positionX+thisWidth+1 ; n++)
						{
							if(thisWidth>1)
							{
								if(n==positionX)
								{
									if(grid.getGrid(m, n).matches("[a-z]"))
									{
										grid.setGrid(m, n, "*");
									}
								}
								else if(n==(positionX-1)+thisWidth)
								{
									if(grid.getGrid(m, n).matches("[a-z]"))
									{
										grid.setGrid(m, n, "*");
									}
								}
							}
							else if(thisLength>1)
							{
								if(m==positionY)
								{
									if(grid.getGrid(m, n).matches("[a-z]"))
									{
										grid.setGrid(m, n, "*");
									}
								}
								else if(m==(positionY-1)+thisLength)
								{
									if(grid.getGrid(m, n).matches("[a-z]"))
									{
										grid.setGrid(m, n, "*");
									}
								}
							}
							else
							{
								if(m==positionY || n==positionX)
								{
									if(grid.getGrid(m, n).matches("[a-z]"))
									{
										grid.setGrid(m, n, "*");
									}
								}
							}
						}
					}
				}
				PrintDrawing.printWallFurniture(name, positionX, positionY, grid);
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
	
//TODO + modif sens des images + Autre fichier.java ?
	/**
	 * North and South = default orientation
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
