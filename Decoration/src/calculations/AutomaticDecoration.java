/**
 * 
 */
package calculations;

import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.DesignGUI;
import GUI.PrintDrawing;
import catalog.*;
import place.Apartment;
import place.Grid;
import place.Room;


/**
 * @author GILLES Anne-Sophie
 */


public class AutomaticDecoration 
{
	private String[] minimumBathroomFurniture = {"toilet", "shower", "washbasin"};
	private String[] minimumBedroomOfficeFurniture = {"single bed", "desk"};
	private String[] minimumDiningRoomFurniture = {"small dining table"};
	private String[] minimumKitchenFurniture = {"fridge", "gas cooker", "sink"};
	private String[] minimumLivingRoomFurniture = {"small sofa", "coffee table"};
	
	private String[] moreBathroomFurniture = {"bath", "worktop"};
	private String[] moreBedroomOfficeFurniture = {"nightstand", "dresser", "wardrobe"};
	private String[] moreDiningRoomFurniture = {"buffet"};
	private String[] moreKitchenFurniture = {"kitchen worktop"};
	private String[] moreLivingRoomFurniture = {"small sofa"};
	
	
	/**
	 * Build an AutomaticDecoration
	 * @param quantity
	 * @param style
	 * @param catalog
	 * @param apartment
	 * @param grid
	 * @param gridPanel
	 * @param tabGrid
	 */
	public AutomaticDecoration(String quantity, String style, Catalog catalog, Apartment apartment, Grid grid, JPanel gridPanel, JLabel tabGrid[][])
	{
		minimumDecoration(style, catalog, apartment, grid, gridPanel, tabGrid);
		moreDecoration(quantity, style, catalog, apartment, grid, gridPanel, tabGrid);
	}
	

	/**
	 * Set the strict minimum of furniture in each room
	 * @param style
	 * @param catalog
	 * @param apartment
	 * @param grid
	 * @param gridPanel
	 * @param tabGrid
	 */
	public void minimumDecoration(String style, Catalog catalog, Apartment apartment, Grid grid, JPanel gridPanel, JLabel tabGrid[][])
	{
		HashMap<Integer, Room> roomsList = apartment.getRoomsList();
		style = style.toLowerCase();
		
		int size = roomsList.size();
		int counter=0;
		int index=0;
		while(counter<size)
		{
			if(roomsList.get(index) != null)
			{
				Room currentRoom = roomsList.get(index);
				int roomsWidth = currentRoom.getDimension().getWidth();
				int roomsLength = currentRoom.getDimension().getLength();
				int positionX = currentRoom.getPosition().getX();
				int positionY = currentRoom.getPosition().getY();
				String roomsCategory = currentRoom.getCategory();
				int furnitureCounter = 0;

				for(int i=positionY ; i<positionY+roomsLength ; i++)
				{
					for(int j=positionX ; j<positionX+roomsWidth ; j++)
					{
						String currentPosition = grid.getGrid(i, j);
						String furnitureOrientation = null;

						if(j==positionX)
						{
							furnitureOrientation = "west";
						}
						else if(j==positionX+roomsWidth-1)
						{
							furnitureOrientation = "east";
						}
						else if(i==positionY)
						{
							furnitureOrientation = "north";
						}
						else if(i==positionY+roomsLength-1)
						{
							furnitureOrientation = "south";
						}
						
						if(currentPosition.matches("[a-z]") && (j==positionX || i==positionY || j==positionX+roomsWidth-1 || i==positionY+roomsLength-1))
						{
							if(roomsCategory.equals("Bathroom"))
							{
								for(int m=furnitureCounter ; m<minimumBathroomFurniture.length ; m++)
								{
									String currentFurniture = minimumBathroomFurniture[m];
									Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
									furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
									furnitureToAdd.setStyle(style);
									
									if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
									{
										PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
										DesignGUI.setStatistics();
										
										furnitureCounter++;
										j++;
										break;
									}
								}
							}
							else if(roomsCategory.equals("BedroomOffice"))
							{
								for(int m=furnitureCounter ; m<minimumBedroomOfficeFurniture.length ; m++)
								{
									String currentFurniture = minimumBedroomOfficeFurniture[m];
									Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
									furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
									furnitureToAdd.setStyle(style);
									
									if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
									{
										PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
										DesignGUI.setStatistics();
										
										furnitureCounter++;
										j++;
										break;
									}
								}
							}
							else if(roomsCategory.equals("DiningRoom"))
							{
								for(int m=furnitureCounter ; m<minimumDiningRoomFurniture.length ; m++)
								{
									String currentFurniture = minimumDiningRoomFurniture[m];
									Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
									furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
									furnitureToAdd.setStyle(style);
									
									if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
									{
										PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
										DesignGUI.setStatistics();
										
										if(furnitureToAdd.getName().contains("table"))
										{
											int furniturePositionX = furnitureToAdd.getPosition().getX();
											int furniturePositionY = furnitureToAdd.getPosition().getY();
											int furnitureLength = furnitureToAdd.getDimension().getLength();
											int furnitureWidth = furnitureToAdd.getDimension().getWidth();
											
											for(int p=furniturePositionY-1 ; p<=furniturePositionY+furnitureLength ; p++)
											{
												for(int q=furniturePositionX-1 ; q<=furniturePositionX+furnitureWidth ; q++)
												{
													if( !((p==furniturePositionY-1 && q==furniturePositionX-1) || (p==furniturePositionY-1 && q==furniturePositionX+furnitureWidth) || (p==furniturePositionY+furnitureLength && q==furniturePositionX-1) || (p==furniturePositionY+furnitureLength && q==furniturePositionX+furnitureWidth)) )
													{
														Furniture chair = catalog.getFurniture("chair");
														chair.setStyle(style);
														
														if(q==furniturePositionX-1)
														{
															furnitureOrientation = "west";
														}
														else if(q==furniturePositionX+furnitureWidth)
														{
															furnitureOrientation = "east";
														}
														else if(p==furniturePositionY-1)
														{
															furnitureOrientation = "north";
														}
														else if(p==furniturePositionY+furnitureLength)
														{
															furnitureOrientation = "south";
														}
														chair.changeFurnitureOrientation(furnitureOrientation);
														
														if(currentRoom.addFurniture(chair, q, p, grid))
														{
															PrintDrawing.printFurniture(chair, furnitureOrientation, gridPanel, tabGrid);
															DesignGUI.setStatistics();
														}
													}
												}
											}
										}
										
										furnitureCounter++;
										j++;
										break;
									}
								}
							}
							else if(roomsCategory.equals("Kitchen"))
							{
								for(int m=furnitureCounter ; m<minimumKitchenFurniture.length ; m++)
								{
									String currentFurniture = minimumKitchenFurniture[m];
									Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
									furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
									furnitureToAdd.setStyle(style);
									
									if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
									{
										PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
										DesignGUI.setStatistics();
										
										furnitureCounter++;
										j++;
										break;
									}
								}
							}
							else if(roomsCategory.equals("LivingRoom"))
							{
								for(int m=furnitureCounter ; m<minimumLivingRoomFurniture.length ; m++)
								{
									String currentFurniture = minimumLivingRoomFurniture[m];
									Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
									furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
									furnitureToAdd.setStyle(style);

									if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
									{
										PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
										DesignGUI.setStatistics();
										
										furnitureCounter++;
										j++;
										break;
									}
								}
							}
						}
					}
				}
				counter++;
			}
			index++;
		}

	}

	/**
	 * Set more furniture in each room
	 * @param quantity
	 * @param style
	 * @param catalog
	 * @param apartment
	 * @param grid
	 * @param gridPanel
	 * @param tabGrid
	 */
	public void moreDecoration(String quantity, String style, Catalog catalog, Apartment apartment, Grid grid, JPanel gridPanel, JLabel tabGrid[][])
	{
		if(quantity != null && quantity != "Minimalist")
		{
			quantity = quantity.toLowerCase();
			HashMap<Integer, Room> roomsList = apartment.getRoomsList();
			
			int size = roomsList.size();
			int counter=0;
			int index=0;
			while(counter<size)
			{
				if(roomsList.get(index) != null)
				{
					Room currentRoom = roomsList.get(index);
					int roomsWidth = currentRoom.getDimension().getWidth();
					int roomsLength = currentRoom.getDimension().getLength();
					int positionX = currentRoom.getPosition().getX();
					int positionY = currentRoom.getPosition().getY();
					String roomsCategory = currentRoom.getCategory();
					int furnitureCounter = 0;
					int maxCounter = 0;

					for(int i=positionY+roomsLength ; i>positionY ; i--)
					{
						for(int j=positionX+roomsWidth ; j>positionX ; j--)
						{
							String currentPosition = grid.getGrid(i, j);
							String furnitureOrientation = null;

							if(j==positionX)
							{
								furnitureOrientation = "west";
							}
							else if(j==positionX+roomsWidth-1)
							{
								furnitureOrientation = "east";
							}
							else if(i==positionY)
							{
								furnitureOrientation = "north";
							}
							else if(i==positionY+roomsLength-1)
							{
								furnitureOrientation = "south";
							}
							
							if(currentPosition.matches("[a-z]") && (j==positionX || i==positionY || j==positionX+roomsWidth-1 || i==positionY+roomsLength-1))
							{
								if(roomsCategory.equals("Bathroom"))
								{
									for(int m=furnitureCounter ; m<moreBathroomFurniture.length ; m++)
									{
										String currentFurniture = moreBathroomFurniture[m];
										Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
										furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
										furnitureToAdd.setStyle(style);
										
										if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
										{
											PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
											DesignGUI.setStatistics();
											
											if(quantity.equals("maximalist") && currentFurniture.contains("worktop"))
											{
												for(int f=0 ; f<1 ; f++)
												{
													j--;
													currentRoom.addFurniture(furnitureToAdd, j, i, grid);
													
													PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
													DesignGUI.setStatistics();
												}
											}
											furnitureCounter++;
											j--;
											break;
										}
									}
								}
								else if(roomsCategory.equals("BedroomOffice"))
								{
									for(int m=furnitureCounter ; m<moreBedroomOfficeFurniture.length ; m++)
									{
										String currentFurniture = moreBedroomOfficeFurniture[m];
										Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
										furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
										furnitureToAdd.setStyle(style);
										
										if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
										{
											PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
											DesignGUI.setStatistics();
											
											furnitureCounter++;
											j--;
											break;
										}
									}
								}
								else if(roomsCategory.equals("DiningRoom"))
								{
									for(int m=furnitureCounter ; m<moreDiningRoomFurniture.length ; m++)
									{
										String currentFurniture = moreDiningRoomFurniture[m];
										Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
										furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
										furnitureToAdd.setStyle(style);
										
										if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
										{
											PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
											DesignGUI.setStatistics();
											
											furnitureCounter++;
											j--;
											break;
										}
									}
								}
								else if(roomsCategory.equals("Kitchen"))
								{
									for(int m=furnitureCounter ; m<moreKitchenFurniture.length ; m++)
									{
										String currentFurniture = moreKitchenFurniture[m];
										Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
										furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
										furnitureToAdd.setStyle(style);
										
										if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
										{
											PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
											DesignGUI.setStatistics();
											
											if(quantity.equals("maximalist") && currentFurniture.contains("worktop"))
											{
												for(int f=0 ; f<2 ; f++)
												{
													j--;
													currentRoom.addFurniture(furnitureToAdd, j, i, grid);
													
													PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
													DesignGUI.setStatistics();
												}
											}
											furnitureCounter++;
											j--;
											break;
										}
									}
								}
								else if(roomsCategory.equals("LivingRoom"))
								{
									for(int m=furnitureCounter ; m<moreLivingRoomFurniture.length ; m++)
									{
										String currentFurniture = moreLivingRoomFurniture[m];
										Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
										furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
										furnitureToAdd.setStyle(style);
										
										if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
										{
											PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
											DesignGUI.setStatistics();
											
											if(quantity.equals("maximalist"))
											{
												Furniture armchair = catalog.getFurniture("armchair");
												for(int f=0 ; f<2 ; f++)
												{
													j--;
													currentRoom.addFurniture(armchair, j, i, grid);
													
													PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
													DesignGUI.setStatistics();
												}
											}
											furnitureCounter++;
											j--;
											break;
										}
									}
									if(quantity.equals("maximalist") && maxCounter<=2)
									{
										Furniture armchair = catalog.getFurniture("armchair");
										armchair.setStyle(style);
										currentRoom.addFurniture(armchair, j, i, grid);
										
										PrintDrawing.printFurniture(armchair, furnitureOrientation, gridPanel, tabGrid);
										DesignGUI.setStatistics();
										
										maxCounter++;
									}
								}
							}
						}
					}
					counter++;
				}
				index++;
			}
		}
	}
}
