/**
 * 
 */
package place;

import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import catalog.*;
import test.DesignGUI;

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
	 * 
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
		
//Parcourir toutes les pièces 1 par 1
		for(int index=0 ; index<roomsList.size() ; index++)
		{
			Room currentRoom = roomsList.get(index);
			int roomsWidth = currentRoom.getDimension().getWidth();
			int roomsLength = currentRoom.getDimension().getLength();
			int positionX = currentRoom.getPosition().getX();
			int positionY = currentRoom.getPosition().getY();
			String roomsCategory = currentRoom.getCategory();
			int furnitureCounter = 0;
//Parcourir le sol de la pièce
			for(int i=positionY ; i<positionY+roomsLength ; i++)
			{
				for(int j=positionX ; j<positionX+roomsWidth ; j++)
				{
					String currentPosition = grid.getGrid(i, j);
					String furnitureOrientation = null;

					if(j==1)
					{
						furnitureOrientation = "west";
					}
					else if(j==roomsWidth)
					{
						furnitureOrientation = "east";
					}
					else if(i==1)
					{
						furnitureOrientation = "north";
					}
					else if(i==roomsLength)
					{
						furnitureOrientation = "south";
					}
					
//Si on est sur un bord / contre un mur ET que la case est libre
					if(currentPosition.matches("[a-z]") && (j==positionX || i==positionY || j==positionX+roomsWidth-1 || i==positionY+roomsLength-1))
					{
//En fonction de la pièce, on pose les meubles correspondants
						if(roomsCategory.equals("Bathroom"))
						{
//On parcours les furniture minimales à poser
							for(int m=furnitureCounter ; m<minimumBathroomFurniture.length ; m++)
							{
								String currentFurniture = minimumBathroomFurniture[m];
								Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
								furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
								
//Si on a bien récuperer la furniture ET qu'on a réussis à ajouter la furniture dans la pièce => On se décale d'une case pour pas coller les meubles et on passe au meuble suivant et case suivante
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
								
								if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
								{
									PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
									DesignGUI.setStatistics();
//Si c'est une table, il faut poser des chaises autour
									if(currentFurniture.contains("table"))
									{
										int furnitureLength = furnitureToAdd.getDimension().getLength();
										int furnitureWidth = furnitureToAdd.getDimension().getWidth();
										
										for(int p=j-1 ; p<=j+furnitureLength ; p++)
										{
											for(int q=i-1 ; q<=i+furnitureWidth ; q++)
											{
//On pose la chaise seulement si on est pas dans un coin de la table
												if( !((p==j-1 && q==i-1) || (p==j-1 && q==i+furnitureWidth) || (p==j+furnitureLength && q==i-1) || (p==j+furnitureLength && q==i+furnitureWidth)) )
												{//TODO orientation ?
													Furniture chair = catalog.getFurniture("chair");
													currentRoom.addFurniture(chair, q, p, grid);
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
		if(quantity != null)
		{
			quantity = quantity.toLowerCase();
			HashMap<Integer, Room> roomsList = apartment.getRoomsList();
			
	//En fonction de la quantité, mettre plus ou moins de meubles
			for(int index=0 ; index<roomsList.size() ; index++)
			{
				Room currentRoom = roomsList.get(index);
				int roomsWidth = currentRoom.getDimension().getWidth();
				int roomsLength = currentRoom.getDimension().getLength();
				int positionX = currentRoom.getPosition().getX();
				int positionY = currentRoom.getPosition().getY();
				String roomsCategory = currentRoom.getCategory();
				int furnitureCounter = 0;
				int maxCounter = 0;
//Parcourir le sol de la pièce
				for(int i=positionY+roomsLength ; i>positionY ; i--)
				{
					for(int j=positionX+roomsWidth ; j>positionX ; j--)
					{
						String currentPosition = grid.getGrid(i, j);
						String furnitureOrientation = null;

						if(j==1)
						{
							furnitureOrientation = "west";
						}
						else if(j==roomsWidth)
						{
							furnitureOrientation = "east";
						}
						else if(i==1)
						{
							furnitureOrientation = "north";
						}
						else if(i==roomsLength)
						{
							furnitureOrientation = "south";
						}
						
//Si on est sur un bord / contre un mur ET que la case est libre
						if(currentPosition.matches("[a-z]") && (j==positionX || i==positionY || j==positionX+roomsWidth-1 || i==positionY+roomsLength-1))
						{
//En fonction de la pièce, on pose les meubles correspondants
							if(roomsCategory.equals("Bathroom"))
							{
//On parcours les furniture en plus à poser
								for(int m=furnitureCounter ; m<moreBathroomFurniture.length ; m++)
								{
									String currentFurniture = moreBathroomFurniture[m];
									Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
									furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
									
//Si on a bien récuperer la furniture ET qu'on a réussis à ajouter la furniture dans la pièce => On se décale d'une case pour pas coller les meubles et on passe au meuble suivant et case suivante
									if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
									{
										PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
										DesignGUI.setStatistics();
										
//Si la quantité est maximalist et que c'est un worktop, on en rajoute 1 à côté
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
//On parcours les furniture en plus à poser
								for(int m=furnitureCounter ; m<moreBedroomOfficeFurniture.length ; m++)
								{
									String currentFurniture = moreBedroomOfficeFurniture[m];
									Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
									furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
									
//Si on a bien récuperer la furniture ET qu'on a réussis à ajouter la furniture dans la pièce => On se décale d'une case pour pas coller les meubles et on passe au meuble suivant et case suivante
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
//On parcours les furniture en plus à poser
								for(int m=furnitureCounter ; m<moreDiningRoomFurniture.length ; m++)
								{
									String currentFurniture = moreDiningRoomFurniture[m];
									Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
									furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
									
//Si on a bien récuperer la furniture ET qu'on a réussis à ajouter la furniture dans la pièce => On se décale d'une case pour pas coller les meubles et on passe au meuble suivant et case suivante
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
//On parcours les furniture en plus à poser
								for(int m=furnitureCounter ; m<moreKitchenFurniture.length ; m++)
								{
									String currentFurniture = moreKitchenFurniture[m];
									Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
									furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
									
//Si on a bien récuperer la furniture ET qu'on a réussis à ajouter la furniture dans la pièce => On se décale d'une case pour pas coller les meubles et on passe au meuble suivant et case suivante
									if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
									{
										PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
										DesignGUI.setStatistics();
										
//Si la quantité est maximalist et que c'est un worktop, on en rajoute 2 côte à côte
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
//On parcours les furniture en plus à poser
								for(int m=furnitureCounter ; m<moreLivingRoomFurniture.length ; m++)
								{
									String currentFurniture = moreLivingRoomFurniture[m];
									Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);
									furnitureToAdd.changeFurnitureOrientation(furnitureOrientation);
									
//Si on a bien récuperer la furniture ET qu'on a réussis à ajouter la furniture dans la pièce => On se décale d'une case pour pas coller les meubles et on passe au meuble suivant et case suivante
									if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
									{
										PrintDrawing.printFurniture(furnitureToAdd, furnitureOrientation, gridPanel, tabGrid);
										DesignGUI.setStatistics();
										
//Si la quantité est maximalist, on ajoute 2 armchair
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
//Si la quantitée voulue est maximalist => on pose plus de meubles
								if(quantity.equals("maximalist") && maxCounter<=2)
								{
									Furniture armchair = catalog.getFurniture("armchair");
									currentRoom.addFurniture(armchair, j, i, grid);
									
									PrintDrawing.printFurniture(armchair, furnitureOrientation, gridPanel, tabGrid);
									DesignGUI.setStatistics();
									
									maxCounter++;
								}
							}
						}
					}
				}
			}
		}
	}
}
