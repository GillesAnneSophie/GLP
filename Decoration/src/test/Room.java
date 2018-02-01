package test;

import java.util.HashMap;

/**
 * @author lauryanncoralie
 *
 */
public class Room {
	private HashMap <Integer, Furniture> furnituresOfTheRoom;
	private Dimension dimension;
	private int position;
	
	public Room (Dimension dimension, int position , HashMap <Integer, Furniture> furnituresOfTheRoom ) {
		furnituresOfTheRoom = new HashMap <Integer, Furniture> ();
		dimension = new Dimension ();
		this.position = position;
	}

	public HashMap <Integer, Furniture> getFurnituresOfTheRoom() {
		return furnituresOfTheRoom;
	}

	public void setFurnituresOfTheRoom(HashMap <Integer, Furniture> furnituresOfTheRoom) {
		this.furnituresOfTheRoom = furnituresOfTheRoom;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
