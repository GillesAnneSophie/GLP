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

		for(int i=1 ; i<=735 ; i+=35)
		{
			for(int j=1 ; j<=735 ; j+=35)
			{
				if(i==1 && j==1)
				{
					JLabel xy = new JLabel("Y\\/ X>");
					xy.setBounds(i, j, 35, 35);
					xy.setPreferredSize(new Dimension(35, 35));
					gridPanel.add(xy);
				}
				else if(i==1)
				{
					JLabel tmp = new JLabel();
					tmp.setText(String.valueOf(counterI+1));
					tabI[counterI] = tmp;
					tabI[counterI].setBounds(i, j, 35, 35);
					tabI[counterI].setPreferredSize(new Dimension(35, 35));
					gridPanel.add(tabI[counterI]);
					
					counterI++;
				}
				else if(j==1)
				{
					JLabel tmp = new JLabel();
					tmp.setText(String.valueOf(counterJ+1));
					tabJ[counterJ] = tmp;
					tabJ[counterJ].setBounds(i, j, 35, 35);
					tabJ[counterJ].setPreferredSize(new Dimension(35, 35));
					gridPanel.add(tabJ[counterJ]);
					
					counterJ++;
				}
				else
				{
					ImageIcon imageIcon = new ImageIcon("./drawings/empty.png");
					Image image = imageIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
					ImageIcon imageToSet = new ImageIcon(image);
					JLabel tmp = new JLabel(imageToSet);
					tabGrid[counterGridI][counterGridJ] = tmp;
					tabGrid[counterGridI][counterGridJ].setBounds(i, j, 35, 35);
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
	 * @param grid
	 * @param gridPanel
	 * @param tabGrid
	 */
	public static void updateRooms(Grid grid, JPanel gridPanel, JLabel tabGrid[][])
	{
		int gridLength = grid.getGridDimension().getLength();
		int gridWidth = grid.getGridDimension().getWidth();
		
		for(int i=0 ; i<gridLength ; i++)
		{
			for(int j=0 ; j<gridWidth ; j++)
			{
				String character = grid.getGrid(i, j);
				
				// If there is a # (Void) at the current position 
				if(character.equals("#"))
				{
					ImageIcon imageIcon = new ImageIcon("./drawings/empty.png");
					Image image = imageIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
					ImageIcon imageToSet = new ImageIcon(image);
					tabGrid[i][j].setIcon(imageToSet);
				}
				// If there is a $ (Wall) at the current position 
				else if(character.equals("$"))
				{
					ImageIcon imageIcon = new ImageIcon("./drawings/wall.png");
					Image image = imageIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
					ImageIcon imageToSet = new ImageIcon(image);
					tabGrid[i][j].setIcon(imageToSet);
				}
				// If there is a letter (Floor) at the current position 
				else if(character.matches("[a-z]"))
				{
					ImageIcon imageIcon = new ImageIcon("./drawings/floor.png");
					Image image = imageIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
					ImageIcon imageToSet = new ImageIcon(image);
					tabGrid[i][j].setIcon(imageToSet);
				}
				// If there is a * at the current position 
				else if(character.equals("*"))
				{
					ImageIcon imageIcon = new ImageIcon("./drawings/void.png");
					Image image = imageIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
					ImageIcon imageToSet = new ImageIcon(image);
					tabGrid[i][j].setIcon(imageToSet);
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
		String furnitureStyle = furniture.getStyle();
		if(furnitureStyle != null)
		{
			furnitureStyle = furniture.getStyle().toLowerCase().replaceAll(" ", "");
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
//TODO Print : Fonctionne pas pour les meubles de taille + 1*1 >  1*2 / 1*3 / 2*3
			Image image = imageIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
			
			ImageIcon imageToSet = new ImageIcon(image);
			tabGrid[furniturePositionY][furniturePositionX].setIcon(imageToSet);
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
	
	
	
	/*
	ImageIcon image = new ImageIcon("./drawings/empty.png");
	Image image1 = image.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
	ImageIcon imageToSet = new ImageIcon(image1);
	JLabel test = new JLabel(imageToSet);
	test.setBounds(i, j, 35, 35);
	gridPanel.add(test);
	*/
	
	/*
	ImageIcon imageIcon = new ImageIcon("./drawings/toilet.png");
	Image image = imageIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
	ImageIcon imageIcon2 = new ImageIcon(image);
	tabGrid[1][1].setIcon(imageIcon2);
	*/
}