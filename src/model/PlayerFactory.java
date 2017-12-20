package model;

import controller.Controller;
import controller.PlayerController;
import view.PlayerSprite;

public class PlayerFactory {

	public static PlayerSprite getPlayerView(){

		//Create View
		PlayerSprite playerView = new PlayerSprite();
		playerView.setImage("/images/player.png");
		playerView.setPosition(0, 0);

		//Create Model
		Player player = new Player(0,0);
		player.addObserver(playerView);

		Controller.getInstance().getLabyrinth().addElement(player);
		
		//Add element to sprite
		playerView.setPlayer(player);

		//Create Controller
		PlayerController pController = new PlayerController();
		pController.setPlayer(player);

		playerView.setController(pController);

		return playerView;
	}

}
