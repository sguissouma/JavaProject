package view;

import java.util.Observable;
import java.util.Observer;
import controller.BadBoyController;
import model.BadBoy;

/**
 * Class that represents the view of BadBoy.
 * @author Carlos Villavicencio
 * @version 1.0
 */
public class BadBoySprite extends Sprite implements Observer {

	private BadBoyController controller;
	private BadBoy badboy;

	
	/**
	 * Set a BadBoy type object to the player instance variable contained in BadBoySprite.
	 * 
	 * @param badboy BadBoy object type that represents a BadBoy character in the game.
	 */
	public void setBadBoy(BadBoy badboy) {
		this.badboy = badboy;
	}

	/**
	 * A getter method that is responsible for returning an object of type BadBoy.
	 * 
	 * @return A BadBoy object type that represents a player character in the game.
	 */
	public BadBoy getBadBoy() {
		return this.badboy;
	}
	
	/**
	 * Set a BadBoyController type object to the controller instance variable contained in BadBoySprite.
	 * 
	 * @param controller A BadBoyController object type that represents the controller of bad boy.
	 */
	public void setController(BadBoyController controller) {
		this.controller = controller;
	}

	/**
	 * A getter method that is responsible for returning an object of type BadBoyController.
	 * 
	 * @return A BadBoyController object type that represents a controller of bad boy.
	 */
	public BadBoyController getController() {
		return this.controller;
	}


	/**
	 * Update the bad boy sprite position with an event caused by the Observable
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.setPosition(badboy.getPosition().x, badboy.getPosition().y);
	}
}

