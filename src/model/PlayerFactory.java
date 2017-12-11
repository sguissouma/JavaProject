package model;

import controller.PlayerController;
import view.PlayerSprite;

public class PlayerFactory {
	
	public static PlayerSprite getPlayerView(){
		
		//Create View
		PlayerSprite playerView = new PlayerSprite();
		
		//Create Model
		Player player = new Player(0,0);
		player.addObserver(playerView);
		
		playerView.setPlayer(player);
		
		//Create Controller
		PlayerController pController = new PlayerController();
		pController.setPlayer(player);
		
		playerView.setController(pController);
		
		return playerView;
	}

}
