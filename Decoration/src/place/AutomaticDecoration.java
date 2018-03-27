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
{
//TODO AutoDeco : ajouter chaises ?
	private String[] minimumBathroomFurniture = {"toilet", "shower", "washbasin"};
	private String[] minimumBedroomOfficeFurniture = {"single bed", "desk"};
	private String[] minimumDiningRoomFurniture = {"small dining table", ""};
	private String[] minimumKitchenFurniture = {"fridge", "gas cooker", "sink"};
	private String[] minimumLivingRoomFurniture = {"small sofa", "coffee table"};
	
	
	public AutomaticDecoration(String quantity, String style, Catalog catalog, Apartment apartment, Grid grid)
	{
		minimumDecoration(style, catalog, apartment, grid);
		//moreDecoration(quantity, style, catalog, apartment, grid);
	}
	
//TODO AutoDeco : à faire + doors/windows
	/**
	 * 
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
			String roomsCategory = currentRoom.getCategory();
//Parcourir le sol de la pièce
			for(int i=0 ; i<roomsLength ; i++)
			{
				for(int j=0 ; j<roomsWidth ; j++)
				{
					String currentPosition = grid.getGrid(i, j);
					int positionX = currentRoom.getPosition().getX();
					int positionY = currentRoom.getPosition().getY();
//Si on est sur un bord / contre un mur ET que la case est libre
					//TODO ça fonctionne pas ça x)
					if(currentPosition.matches("[a-z]") && (j==positionX || i==positionY || j==positionX+roomsWidth-1 || i==positionY+roomsLength-1))
					{
//En fonction de la pièce, on pose les meubles correspondants
						if(roomsCategory.equals("Bathroom"))
						{
//On parcours les furniture minimales à poser
							for(int m=0 ; m<minimumBathroomFurniture.length ; m++)
							{
								String currentFurniture = minimumBathroomFurniture[m];
								Furniture furnitureToAdd = catalog.getFurniture(currentFurniture);

//Si on a bien récuperer la furniture ET qu'on a réussis à ajouter la furniture dans la pièce
								if(furnitureToAdd != null && !currentRoom.addFurniture(furnitureToAdd, i, j, grid))
								{
									break;
								}
								else
								{
									i++;
									j++;
								}
							}
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
			
//En fonction de la quantité, mettre plus ou moins de meubles
		if(quantity.equals("minimalist"))
		{
			
		}
		else if(quantity.equals("basic"))
		{
			
		}
		else if(quantity.equals("maximalist"))
		{
			
		}
	}
}
