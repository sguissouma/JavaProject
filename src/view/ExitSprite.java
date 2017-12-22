package view;

import model.ExitDoor;

/**
 * Class that represents the view of the Exit Door.
 * @author Carlos Villavicencio
 * @version 1.0
 */
public class ExitSprite extends Sprite{

	private ExitDoor exitDoor;

	/**
	 * Set a ExitDoor type object to the player instance variable contained in ExitSprite.
	 * 
	 * @param exitSprite An ExitDoor object type that represents a exit door in the game.
	 */
	public void setExit(ExitDoor exitSprite) {
		this.exitDoor = exitSprite;
	}
	
	/**
	 * A getter method that is responsible for returning an object of type ExitDoor.
	 * 
	 * @return A ExitDoor object type that represents a exit door in the game.
	 */
	public ExitDoor getExit() {
		return this.exitDoor;
	}

}
