package catalog;

import place.*;

/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */
public class Furniture extends AbstractRoom
{
	private Style style;
	private String color;
	
	
	/**
	 * @param name
	 * @param dimension
	 * @param stackable
	 * @param category
	 */
	public Furniture(String name, Dimension dimension, boolean stackable, Category category) 
	{
		super("Furniture", name, dimension, stackable, category);
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
		return "Furniture [style=" + style + ", color=" + color + " " + super.toString() + "]\n";
	}
}
