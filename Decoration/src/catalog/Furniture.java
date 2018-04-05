package catalog;

import place.*;
import styles.*;


/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */


public class Furniture extends AbstractRoom
{
	private Style style;
	private String color;
	
	
	/**
	 * Build a Furniture
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
	public String getStyle() 
	{
		return style.toString();
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
	public void setStyle(String style)
	{
		style = style.toLowerCase();
		if(style.equals("basic"))
		{
			this.style = new Basic();
		}
		else if(style.equals("modern"))
		{
			this.style = new Modern();
		}
		else if(style.equals("rustic"))
		{
			this.style = new Rustic();
		}
		else if(style.equals("vintage"))
		{
			this.style = new Vintage();
		}
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
