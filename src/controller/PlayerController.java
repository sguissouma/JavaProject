package controller;

import model.Directions;
import model.Player;


/**
 * 
 * Controller class who controls a entity of type Player. 
 * All necessary methods to update the state of the entity and its position are present here.
 * 
 * @author Carlos Villavicencio
 * @version 1.0
 */

public class PlayerController {

	private Player player;

	/**
	 * Set a Player type object to the player instance variable contained in PlayerController.
	 * 
	 * @param player Player type object that represents a player character in the game.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * A getter method that is responsible for returning an object of type Player.
	 * 
	 * @return A Player type object that represents a player character in the game.
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * With this method the coordinate of the player entity will be changed.
	 * @param direction Direction that will affect the coordinate position of the player entity.
	 * @author Souha
	 */
	public void move(Directions direction){
		if (direction == Directions.WEST){
			this.player.setPosition(this.player.getPosition().x - 1, this.player.getPosition().y);
		}
		else if (direction == Directions.EAST){
			this.player.setPosition(this.player.getPosition().x + 1, this.player.getPosition().y);
		}
		else if (direction == Directions.NORTH){
			this.player.setPosition(this.player.getPosition().x, this.player.getPosition().y - 1);
		}
		else{
			this.player.setPosition(this.player.getPosition().x, this.player.getPosition().y + 1);
		}
	}

}
