package catalog;

import java.util.ArrayList;

import place.Dimension;

/**
 * @author lauryanncoralie
 * @author GILLES Anne-Sophie
 */
public abstract class Furniture 
{
	private String name;
	private Dimension dimension;
	private Style style;
	private String color ;
	private boolean stackable;
	private ArrayList<Category> categories;
	private int[][] position;
	
	/*TODO CONSTRUCTEUR*/
	
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
	 * @return the style
	 */
	public Style getStyle() 
	{
		return style;
	}
	
	/**
	 * @return the color
	 */
	public String getColor() 
	{
		return color;
	}
	
	/**
	 * @return the stackable
	 */
	public boolean isStackable() 
	{
		return stackable;
	}
	
	/**
	 * @return the categories
	 */
	public ArrayList<Category> getCategories() 
	{
		return categories;
	}
	
	/**
	 * @return the position
	 */
	public int[][] getPosition() 
	{
		return position;
	}
}
