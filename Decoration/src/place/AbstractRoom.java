/**
 * 
 */
package place;

/**
 * @author Gilles Anne-Sophie
 *
 */
public class AbstractRoom 
{
	private String name;
	private Dimension dimension;
	private boolean stackable;
	private Position position;
	
	/**
	 * @param name
	 * @param dimension
	 * @param stackable
	 * */
	public AbstractRoom(String name, Dimension dimension, boolean stackable) 
	{
		this.name = name;
		this.dimension = dimension;
		this.stackable = stackable;
	}

	/**
	 * @param name
	 * @param lenght
	 * @param width
	 * @param stackable
	 * */
	public AbstractRoom(String name, int lenght, int width, boolean stackable) 
	{
		this.name = name;
		dimension = new Dimension(lenght, width);
		this.stackable = stackable;
	}


	@Override
	public String toString() {
		return "AbstractRoom [name=" + name + ", dimension=" + dimension + ", stackable=" + stackable + ", position="
				+ position + "]";
	}
}
