/**
 * 
 */
package place;

import java.util.HashMap;

import catalog.*;

/**
 * @author GILLES Anne-Sophie
 */
public class AutomaticDecoration 
{//TODO desk+office chair (?)
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
	
	public AutomaticDecoration(String quantity, String style, Catalog catalog, Apartment apartment, Grid grid)
	{
		minimumDecoration(style, catalog, apartment, grid);
		//moreDecoration(quantity, style, catalog, apartment, grid);
	}
	

	/**
	 * Set the strict minimum of furniture for each room
	 * @param style
	 * @param catalog
	 * @param apartment
	 * @param grid
	 */
	public void minimumDecoration(String style, Catalog catalog, Apartment apartment, Grid grid)
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

//Si on a bien récuperer la furniture ET qu'on a réussis à ajouter la furniture dans la pièce => On se décale d'une case pour pas coller les meubles et on passe au meuble suivant et case suivante
								if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
								{
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

								if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
								{
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
								
								if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
								{
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
												{
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

								if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
								{
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

								if(furnitureToAdd != null && currentRoom.addFurniture(furnitureToAdd, j, i, grid))
								{
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

//TODO AutoDeco : more
	/**
	 * 
	 * @param quantity
	 * @param style
	 * @param catalog
	 * @param apartment
	 * @param grid
	 */
	public void moreDecoration(String quantity, String style, Catalog catalog, Apartment apartment, Grid grid)
	{
		quantity = quantity.toLowerCase();
		HashMap<Integer, Room> roomsList = apartment.getRoomsList();
		
//En fonction de la quantité, mettre plus ou moins de meubles
		if(quantity.equals("basic"))
		{
			for(int index=0 ; index<roomsList.size() ; index++)
			{
				Room currentRoom = roomsList.get(index);
				int roomsWidth = currentRoom.getDimension().getWidth();
				int roomsLength = currentRoom.getDimension().getLength();
				int positionX = currentRoom.getPosition().getX();
				int positionY = currentRoom.getPosition().getY();
				String roomsCategory = currentRoom.getCategory();
//Parcourir le sol de la pièce
				for(int i=positionY+roomsLength ; i>positionY ; i--)
				{
					for(int j=positionX+roomsWidth ; j>positionX ; j--)
					{
						String currentPosition = grid.getGrid(i, j);
//Si on est sur un bord / contre un mur ET que la case est libre
						if(currentPosition.matches("[a-z]") && (j==positionX || i==positionY || j==positionX+roomsWidth-1 || i==positionY+roomsLength-1))
						{
//En fonction de la pièce, on pose les meubles correspondants
							if(roomsCategory.equals("Bathroom"))
							{
								
							}
							else if(roomsCategory.equals("BedroomOffice"))
							{
								
							}
							else if(roomsCategory.equals("DiningRoom"))
							{
								
							}
							else if(roomsCategory.equals("Kitchen"))
							{
								
							}
							else if(roomsCategory.equals("LivingRoom"))
							{
								
							}
						}
					}
				}
			}
		}
		else if(quantity.equals("maximalist"))
		{
			for(int index=0 ; index<roomsList.size() ; index++)
			{
				Room currentRoom = roomsList.get(index);
				int roomsWidth = currentRoom.getDimension().getWidth();
				int roomsLength = currentRoom.getDimension().getLength();
				int positionX = currentRoom.getPosition().getX();
				int positionY = currentRoom.getPosition().getY();
				String roomsCategory = currentRoom.getCategory();
//Parcourir le sol de la pièce
				for(int i=positionY+roomsLength ; i>positionY ; i--)
				{
					for(int j=positionX+roomsWidth ; j>positionX ; j--)
					{
						String currentPosition = grid.getGrid(i, j);
//Si on est sur un bord / contre un mur ET que la case est libre
						if(currentPosition.matches("[a-z]") && (j==positionX || i==positionY || j==positionX+roomsWidth-1 || i==positionY+roomsLength-1))
						{
//En fonction de la pièce, on pose les meubles correspondants
							if(roomsCategory.equals("Bathroom"))
							{
								
							}
							else if(roomsCategory.equals("BedroomOffice"))
							{
								
							}
							else if(roomsCategory.equals("DiningRoom"))
							{
								
							}
							else if(roomsCategory.equals("Kitchen"))
							{
								
							}
							else if(roomsCategory.equals("LivingRoom"))
							{
								
							}
						}
					}
				}
			}
		}
	}
}
