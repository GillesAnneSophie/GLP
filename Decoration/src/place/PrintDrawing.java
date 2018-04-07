/**
 * 
 */
package place;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;

import javax.swing.*;

import catalog.Furniture;


/**
 * @author GILLES Anne-Sophie
 */


public class PrintDrawing 
{
	private static int caseSize = 50;
	
	/**
	 * Print the default grid (empty)
	 * @param gridPanel
	 * @param tabI
	 * @param tabJ
	 * @param tabGrid
	 */
	public static void printGrid(JPanel gridPanel, JLabel tabI[], JLabel tabJ[], JLabel tabGrid[][])
	{
		int counterI = 0;
		int counterJ = 0;
		int counterGridI = 0;
		int counterGridJ = 0;

		for(int i=1 ; i<=(caseSize*21) ; i+=caseSize+1)
		{
			for(int j=1 ; j<=(caseSize*21) ; j+=caseSize+1)
			{
				if(i==1 && j==1)
				{
					JLabel xy = new JLabel("Y\\/ X>");
					xy.setPreferredSize(new Dimension(caseSize, caseSize));
					xy.setBounds(i, j, caseSize, caseSize);
					gridPanel.add(xy);
				}
				else if(i==1)
				{
					JLabel tmp = new JLabel();
					tmp.setText(String.valueOf(counterI+1));
					tabI[counterI] = tmp;
					tabI[counterI].setPreferredSize(new Dimension(caseSize, caseSize));
					tabI[counterI].setBounds(i, j, caseSize, caseSize);
					gridPanel.add(tabI[counterI]);
					
					counterI++;
				}
				else if(j==1)
				{
					JLabel tmp = new JLabel();
					tmp.setText(String.valueOf(counterJ+1));
					tabJ[counterJ] = tmp;
					tabJ[counterJ].setPreferredSize(new Dimension(caseSize, caseSize));
					tabJ[counterJ].setBounds(i, j, caseSize, caseSize);
					gridPanel.add(tabJ[counterJ]);
					
					counterJ++;
				}
				else
				{
					ImageIcon imageIcon = new ImageIcon("./drawings/empty.png");
					Image image = imageIcon.getImage().getScaledInstance(caseSize, caseSize, Image.SCALE_DEFAULT);
					ImageIcon imageToSet = new ImageIcon(image);
					JLabel tmp = new JLabel(imageToSet);
					tabGrid[counterGridI][counterGridJ] = tmp;
					tabGrid[counterGridI][counterGridJ].setPreferredSize(new Dimension(caseSize, caseSize));
					tabGrid[counterGridI][counterGridJ].setBounds(i, j, caseSize, caseSize);
					gridPanel.add(tabGrid[counterGridI][counterGridJ]);
					
					counterGridJ++;
					if(counterGridJ>19)
					{
						counterGridJ = 0;
						counterGridI++;
					}
				}
			}
		}
	}
	
	/**
	 * Update the grid with rooms (floors, walls, void, empty)
	 * @param apartment
	 * @param grid
	 * @param gridPanel
	 * @param tabGrid
	 */
	public static void updateRooms(Apartment apartment, Grid grid, JPanel gridPanel, JLabel tabGrid[][])
	{
		int gridLength = grid.getGridDimension().getLength();
		int gridWidth = grid.getGridDimension().getWidth();
		
		for(int i=0 ; i<gridLength ; i++)
		{
			for(int j=0 ; j<gridWidth ; j++)
			{
				String character = grid.getGrid(i, j);
				
			/*If there is a # (Empty) at the current position*/
				if(character.equals("#"))
				{
					ImageIcon imageIcon = new ImageIcon("./drawings/empty.png");
					Image image = imageIcon.getImage().getScaledInstance(caseSize, caseSize, Image.SCALE_DEFAULT);
					ImageIcon imageToSet = new ImageIcon(image);
					tabGrid[j][i].setIcon(imageToSet);
					tabGrid[j][i].setToolTipText(null);
					tabGrid[j][i].setSize(caseSize, caseSize);
				}
			/*If there is a $ (Wall) at the current position*/
				else if(character.equals("$"))
				{
					ImageIcon imageIcon = new ImageIcon("./drawings/wall.png");
					Image image = imageIcon.getImage().getScaledInstance(caseSize, caseSize, Image.SCALE_DEFAULT);
					ImageIcon imageToSet = new ImageIcon(image);
					tabGrid[j][i].setIcon(imageToSet);
					tabGrid[j][i].setToolTipText(null);
					tabGrid[j][i].setSize(caseSize, caseSize);
				}
			/*If there is a letter (Floor) at the current position*/
				else if(character.matches("[a-z]"))
				{
					int roomIndex = -1;
					for(int l=0 ; l<character.length() ; l++)
					{
						char thisCharacter = character.charAt(l);
						int thisIndex = thisCharacter - 'a' + 1;
						roomIndex = roomIndex+thisIndex;
					}
					ImageIcon imageIcon = new ImageIcon("./drawings/floor.png");
					Image image = imageIcon.getImage().getScaledInstance(caseSize, caseSize, Image.SCALE_DEFAULT);
					ImageIcon imageToSet = new ImageIcon(image);
					tabGrid[j][i].setIcon(imageToSet);
					
					Room currentRoom = apartment.getRoom(roomIndex);
					String currentRoomName = currentRoom.getName();
					tabGrid[j][i].setToolTipText(roomIndex + " - " + currentRoomName);
					tabGrid[j][i].setSize(caseSize, caseSize);
				}
			/*If there is a * (Void) at the current position*/
				else if(character.equals("*"))
				{
					ImageIcon imageIcon = new ImageIcon("./drawings/void.png");
					Image image = imageIcon.getImage().getScaledInstance(caseSize, caseSize, Image.SCALE_DEFAULT);
					ImageIcon imageToSet = new ImageIcon(image);
					tabGrid[j][i].setIcon(imageToSet);
					tabGrid[j][i].setSize(caseSize, caseSize);
				}
			}
		}
	}
	
	/**
	 * Print the given furniture
	 * @param furniture
	 * @param furnitureOrientation
	 * @param gridPanel
	 * @param tabGrid
	 */
	public static void printFurniture(Furniture furniture, String furnitureOrientation, JPanel gridPanel, JLabel tabGrid[][])
	{
		String furnitureName = furniture.getName().toLowerCase().replaceAll(" ", "");
		if(furnitureName.contains("worktop"))
		{
			furnitureName = "worktop";
		}
		
		String furnitureStyle = furniture.getStyle();
		if(furnitureStyle != null)
		{
			furnitureStyle = furnitureStyle.toLowerCase().replaceAll(" ", "");
		}
		
		int furniturePositionX = furniture.getPosition().getX();
		int furniturePositionY = furniture.getPosition().getY();
		int furnitureWidth = furniture.getDimension().getWidth();
		int furnitureLength = furniture.getDimension().getLength();
		furnitureOrientation = furnitureOrientation.toLowerCase();
		
		String path = findPathToFurnitureImage(furnitureName, furnitureStyle, furnitureOrientation);
		
		if(path != null)
		{
			ImageIcon imageIcon = new ImageIcon(path);
			Image image = imageIcon.getImage().getScaledInstance(caseSize*furnitureWidth, caseSize*furnitureLength, Image.SCALE_DEFAULT);	
			ImageIcon imageToSet = new ImageIcon(image);
			tabGrid[furniturePositionX][furniturePositionY].setSize(caseSize*furnitureWidth, caseSize*furnitureLength);
			tabGrid[furniturePositionX][furniturePositionY].setIcon(imageToSet);
			
//TODO chercher index de la furniture dans la pièce pour mettre dans le toolTip = RemoveFurnitureGUI need aprtment
			String currentToolTipText = tabGrid[furniturePositionX][furniturePositionY].getToolTipText();
			String name = furniture.getName();
			String newToolTipText = currentToolTipText +" / " + name;
			tabGrid[furniturePositionX][furniturePositionY].setToolTipText(newToolTipText);

			for(int i=furniturePositionY ; i<furniturePositionY+furnitureLength ; i++)
			{
				for(int j=furniturePositionX ; j<furniturePositionX+furnitureWidth ; j++)
				{
					if(!(j==furniturePositionX && i==furniturePositionY))
					{
						tabGrid[j][i].setIcon(null);
						tabGrid[j][i].setToolTipText(newToolTipText);
					}
				}
			}
		}
	}
	
	/**
	 * Find the path to the image of the given furniture, with the right orientation and style
	 * @param furnitureName
	 * @param furnitureStyle
	 * @param furnitureOrientation
	 * @return path
	 */
	public static String findPathToFurnitureImage(String furnitureName, String furnitureStyle, String furnitureOrientation)
	{
		String directoryPath = ".\\drawings";
		File directory = new File(directoryPath);
		File[] filesList = directory.listFiles();
		
		String path = null;
		boolean orientationFound = false;
		String basicPath = ".\\drawings\\" + furnitureName + ".png";
		
		String longestPath = "\\drawings\\" + furnitureName + "_" + furnitureOrientation + "_" + furnitureStyle + ".png";
		String stylePath = "\\drawings\\" + furnitureName + "_" + furnitureStyle + ".png";
		String orientationPath = "\\drawings\\" + furnitureName + "_" + furnitureOrientation + ".png";
		
		for(File currentFile : filesList)
		{
			String currentPath = currentFile.getAbsolutePath();

			if(currentPath.contains(longestPath))
			{
				path = directoryPath + "\\" + currentFile.getName();
				return path;
			}
			if(currentPath.contains(stylePath))
			{
				path = directoryPath + "\\" + currentFile.getName();
				return path;
			}
			if(currentPath.contains(orientationPath))
			{
				orientationFound = true;
			}
		}
		
		if(orientationFound==true)
		{
			path = "." + orientationPath;
		}
		else
		{
			path = basicPath;
		}
		return path;
	}
}