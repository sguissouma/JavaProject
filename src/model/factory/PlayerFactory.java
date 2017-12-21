package model.factory;

import controller.LabyrinthController;
import controller.PlayerController;
import model.Player;
import view.PlayerSprite;

public class PlayerFactory {

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
