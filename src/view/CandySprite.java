package view;

import model.Candy;

/**
 * Class that represents the view of a Candy.
 * @author Carlos Villavicencio
 * @version 1.0
 */

public class CandySprite extends Sprite {

	private Candy candy;

	/**
	 * Set a Candy type object to the player instance variable contained in CandySprite.
	 * 
	 * @param candy An ExitDoor object type that represents a candy in the game.
	 */
	public void setCandy(Candy candy) {
		this.candy = candy;
	}
	
	/**
	 * A getter method that is responsible for returning an object of type Candy.
	 * 
	 * @return A Candy object type that represents a candy in the game.
	 */
	public Candy getCandy(){
		return this.candy;
	}

}
