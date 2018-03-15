/**
 * 
 */
package place;


/**
 * @author GILLES Anne-Sophie
 *
 */
public class PrintDrawing 
{
	
	
	/** Print a Wall, Floor or Void image depending on the current character in the grid
	 * @param grid
	 * */
	public void printRooms(Grid grid)
	{
		int gridLength = grid.getGridDimension().getLength();
		int gridWidth = grid.getGridDimension().getWidth();
		
		for(int i=0 ; i<gridLength ; i++)
		{
			for(int j=0 ; j<gridWidth ; j++)
			{
				String character = grid.getGrid(i, j);
				
				/* If there is a # (Void) at the current position */
				if(character=="#")
				{
					// 
				}
				/* If there is a $ (Wall) at the current position */
				else if(character=="$")
				{
					// wall.png
				}
				/* If there is a letter (Floor) at the current position */
				else if(character.matches("[a-z]"))
				{
					// floor.png
				}
				/* If there is a * at the current position */
				else if(character=="*")
				{
					// void.png
				}
			}
		}
	}
	
	/**
	 * @param 
	 * */
	public void printWallFurniture()
	{
		
	}
}
