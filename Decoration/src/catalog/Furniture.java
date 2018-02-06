package catalog;

import java.util.ArrayList;
import java.util.Arrays;

import place.*;

/**
 * @author lauryanncoralie
 * @author GILLES Anne-Sophie
 */
public abstract class Furniture extends AbstractRoom
{
	private Style style;
	private String color;
	
	
	/**
	 * @param name
	 * @param dimension
	 * @param stackable
	 */
	public Furniture(String name, Dimension dimension, boolean stackable) 
	{
		super(name, dimension, stackable);
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
	 * @param style the style to set
	 */
	public void setStyle(Style style)
	{
		this.style = style;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) 
	{
		this.color = color;
	}


	@Override
	public String toString() {
		return "Furniture [style=" + style + ", color=" + color + " " + super.toString() + "]";
	}
}
