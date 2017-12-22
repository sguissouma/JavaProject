package view;

import model.Button;

/**
 * Class that represents the view of a Button.
 * @author Carlos Villavicencio
 * @version 1.0
 */

public class ButtonSprite extends Sprite {

	private Button button;

	/**
	 * Set a Button type object to the player instance variable contained in ButtonSprite.
	 * 
	 * @param button An ExitDoor object type that represents a candy in the game.
	 */
	public void setButton(Button button) {
		this.button = button;
	}
	
	/**
	 * A getter method that is responsible for returning an object of type Button.
	 * 
	 * @return A Button object type that represents a button in the game.
	 */
	public Button getButton() {
		return this.button;
	}


}
