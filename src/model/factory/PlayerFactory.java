package model.factory;

import controller.LabyrinthController;
import controller.PlayerController;
import model.Player;
import view.PlayerSprite;

/**
 * Class that contains all necessary methods to build the objects which represent the Player in the game.
 * @author Carlos Villavicencio
 * @version 1.0
 *
 */

public class PlayerFactory {

	/**
	 * Method used to build necessary objects linked to the Player
	 * @return returns an object of type PlayerSprite that represents the view of the player.
	 */
	public static PlayerSprite createPlayer(){

		//Create View
		PlayerSprite playerView = new PlayerSprite();
		playerView.setImage("/images/player.png");
		
		//Player always starts at position 0,0
		playerView.setPosition(0, 0);

		//Create Model
		Player player = new Player(0,0);
		player.addObserver(playerView);

		LabyrinthController.getInstance().getLabyrinth().addElement(player);
		
		//Add element to sprite
		playerView.setPlayer(player);

		//Create Controller
		PlayerController pController = new PlayerController();
		pController.setPlayer(player);

		playerView.setController(pController);

		return playerView;
	}

}
