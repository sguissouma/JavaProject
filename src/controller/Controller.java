package controller;

import model.Directions;
import model.Labyrinth;

public class Controller {
	
	private static Controller instance = null;
	private static Labyrinth model;
	
	private PlayerController playerController;
	
	public Controller() {
		model = new Labyrinth();
	}
	
	public static Controller getInstance() {
		if(instance==null)
			instance = new Controller();
		return instance;
	}

	public void setPlayerController(PlayerController playerController) {
		this.playerController = playerController;
	}
	
	public void movePlayer(Directions direction){
		// TODO
		//verify with Labyrinth model if player could move
		//if yes then move player
		this.playerController.move(direction);
	}
	
}
