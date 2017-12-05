package controller;

import model.LabyrinthElementType;
import model.Player;
import view.Sprite;

public class PlayerController {

	private Player player;
	private Sprite playerView;
	
	public PlayerController(){
		this.player = new Player(0, 0, LabyrinthElementType.PLAYER, "player");
		this.playerView = new Sprite();
		this.playerView.setImage(this.player.getImageName()+".png");
        this.playerView.setPosition(10, 10);
	}
	
	public void move(int x, int y){
		this.player.setPosition(x, y);
	}
	
}
