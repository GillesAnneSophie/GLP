package test;

import java.util.ArrayList;

/**
 * @author lauryanncoralie
 *
 */
public abstract class Furniture {
	private String name;
	private Dimension dimension;
	private Style style;
	private String color ;
	private boolean stackable;
	private ArrayList <Category> categories;
	private int position [][];
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isStackable() {
		return stackable;
	}

	public void setStackable(boolean stackable) {
		this.stackable = stackable;
	}

	public ArrayList <Category> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList <Category> categories) {
		this.categories = categories;
	}

	public int[][] getPosition() {
		return position;
	}

	public void setPosition(int position[][]) {
		this.position = position;
	}
	
}
