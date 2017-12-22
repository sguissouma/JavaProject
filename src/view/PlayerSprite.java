package view;

import java.util.Observable;
import java.util.Observer;

import controller.PlayerController;
import model.Player;

/**
 * Class that represents the view of player.
 * @author Carlos Villavicencio
 * @version 1.0
 */
public class PlayerSprite extends Sprite implements Observer{

	private PlayerController controller;
	private Player player;


	/**
	 * Set a Player type object to the player instance variable contained in PlayerSprite.
	 * 
	 * @param player Player object type that represents a player character in the game.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * A getter method that is responsible for returning an object of type Player.
	 * 
	 * @return A Player object type that represents a player character in the game.
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * Set a PlayerController type object to the controller instance variable contained in PlayerSprite.
	 * 
	 * @param controller PlayerController object type that represents the controller of Player
	 */
	public void setController(PlayerController controller) {
		this.controller = controller;
	}

	/**
	 * A getter method that is responsible for returning an object of type PlayerController.
	 * 
	 * @return A PlayerController object type that represents a controller of player.
	 */
	public PlayerController getController() {
		return this.controller;
	}

	/**
	 * Update the player sprite position with an event caused by the Observable
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.setPosition(player.getPosition().x, player.getPosition().y);
	}

}
