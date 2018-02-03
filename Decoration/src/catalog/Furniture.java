package catalog;

import java.util.ArrayList;
import java.util.Arrays;

import place.Dimension;

/**
 * @author lauryanncoralie
 * @author GILLES Anne-Sophie
 */
public class Furniture 
{
	private String name;
	private Dimension dimension;
	private Style style;
	private String color ;
	private boolean stackable;
	private ArrayList<Category> categories;
	private int[][] position;
	
	/**
	 * @param name
	 * @param dimension
	 * @param style
	 * @param color
	 * @param stackable
	 * @param categories
	 * @param position
	 */
	public Furniture(String name, Dimension dimension, Style style, String color, boolean stackable,
			ArrayList<Category> categories, int[][] position) {
		super();
		this.name = name;
		this.dimension = dimension;
		this.style = style;
		this.color = color;
		this.stackable = stackable;
		this.categories = categories;
		this.position = position;
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


	@Override
	public String toString() 
	{
		return "Furniture [name=" + name + ", dimension=" + dimension + ", style=" + style + ", color=" + color
				+ ", stackable=" + stackable + ", categories=" + categories + ", position=" + Arrays.toString(position)
				+ "]";
	}
}
