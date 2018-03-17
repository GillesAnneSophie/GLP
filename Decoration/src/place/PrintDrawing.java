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
	
	
	/** 
	 * Print a Wall, Floor or Void image depending on the current character in the grid
	 * @param grid
	 * */
	public static void printRooms(Grid grid)
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
	 * Print wall furniture in the right direction
	 * @param name
	 * @param positionsX
	 * @param positionY
	 * @param grid
	 * */
	public static void printWallFurniture(String name, int positionX, int positionY, Grid grid)
	{
		if(grid.getGrid(positionY, positionX-1)=="*" || grid.getGrid(positionY, positionX-1).matches("[a-z]"))
		{
			//grid.setGrid(positionY, positionX-1, "L"); Orienté vers la gauche
//TODO etc avec l'image dans le sens voulu (large door / small window / large window / pictures
			if(name.equals("small door"))
			{
				
			}
		}
		else if(grid.getGrid(positionY, positionX+1)=="*" || grid.getGrid(positionY, positionX+1).matches("[a-z]"))
		{
			//grid.setGrid(positionY, positionX+1, "R"); Orienté vers la droite
		}
		else if(grid.getGrid(positionY-1, positionX)=="*" || grid.getGrid(positionY-1, positionX).matches("[a-z]"))
		{
			//grid.setGrid(positionY-1, positionX, "U"); Orienté vers le haut
		}
		else if(grid.getGrid(positionY+1, positionX)=="*" || grid.getGrid(positionY+1, positionX).matches("[a-z]"))
		{
			//grid.setGrid(positionY+1, positionX, "D");Orienté vers le bas
		}
	}
}
